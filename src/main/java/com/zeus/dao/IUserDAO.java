package com.zeus.dao;

import java.util.List;

import com.zeus.bean.User;

public interface IUserDAO
{
//	@Query("select * from sm_user where sm_user.user_code=:user_code")
     public List<User> findByuser_code( String user_code);
//	@Query("select * from sm_user where sm_user.user_name=:user_name")
     public List<User> findByuser_name( String user_name);
     
     public List<User> findAll();
     
     public void updatePWD(String usercode,String pwd);
	
     
     
     
}
