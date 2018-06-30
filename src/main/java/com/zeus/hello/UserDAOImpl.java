package com.zeus.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.zeus.bean.User;
import com.zeus.dao.IUserDAO;
@Repository
public class UserDAOImpl implements IUserDAO {
	public UserDAOImpl() {
		
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> findByuser_code(String user_code) {
		List<User> res = jdbcTemplate.query("select * from sm_user where user_code='"+user_code+"' ",
				new BeanPropertyRowMapper<>(User.class));
		if(res!=null&&res.size()>=0) {
			return res;
		}
		return null;
	}

	@Override
	public List<User> findByuser_name(String user_name) {
		List<User> res = jdbcTemplate.query("select * from sm_user where user_name='"+user_name+"' ",
				new BeanPropertyRowMapper<>(User.class));
		if(res!=null&&res.size()>=0) {
			return res;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> res = jdbcTemplate.query("select * from sm_user  ",
				new BeanPropertyRowMapper<>(User.class));
		if(res!=null&&res.size()>=0) {
			return res;
		}
		return null;
	}

	@Override
	public void updatePWD(String usercode, String pwd) {
		if(StringUtils.isEmpty(usercode)||StringUtils.isEmpty(pwd)) {
			return;
		}
		String sql = "update sm_user sm set sm.user_password='U_U++--V'||LOWER( RAWTOHEX( UTL_RAW.CAST_TO_RAW( sys.dbms_obfuscation_toolkit.md5(input_string =>  sm.cuserid||'"
				+pwd
				+ "'/**要设置的密码*/) ) ) ) " + 
				" where sm.user_code_q ='"
				+ usercode.trim().toUpperCase()
				+ "';";
		System.out.println(sql);
		jdbcTemplate.execute(sql);
		
	}

}
