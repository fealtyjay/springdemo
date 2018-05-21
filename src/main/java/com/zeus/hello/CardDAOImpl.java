package com.zeus.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.zeus.bean.Card;
import com.zeus.bean.Dep;
import com.zeus.dao.ICardDAO;

@Repository
public class CardDAOImpl implements ICardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Card findbyName(String name) throws Exception {
		if (StringUtils.isEmpty(name)) {
			throw new Exception("资产名称为空");
		}
		List<Card> list = jdbcTemplate.query(" select * from fa_card where name='" + name + "' ",

				new BeanPropertyRowMapper<Card>(Card.class));
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Card findbyCode(String code) throws Exception {
		if (StringUtils.isEmpty(code)) {
			throw new Exception("资产编码为空");
		}
		List<Card> list = jdbcTemplate.query(" select * from fa_card where code='" + code + "' ",
				new BeanPropertyRowMapper<Card>(Card.class));
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Card findCard(String asset_code) throws Exception {
		if (StringUtils.isEmpty(asset_code)) {
			throw new Exception("资产编码为空");
		}
		List<Card> list = jdbcTemplate.query(" select * from fa_card where asset_code='" + asset_code + "' ",
				new BeanPropertyRowMapper<Card>(Card.class));
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Card> findall() throws Exception {
		List<Card> list = jdbcTemplate.query(" select * from fa_card  ", new BeanPropertyRowMapper<Card>(Card.class));
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list;
	}

	@Override
	public List<Dep> findDep() throws Exception {
		List<Dep> res = jdbcTemplate.query("select * from fa_depgathersheet where nvl(dr,0)=0 ",
				new BeanPropertyRowMapper<Dep>(Dep.class));
		if(res==null||res.size()<=0) {
			return null;
		}
		return res;
	}

}
