package com.zeus.dao;

import java.util.List;

import com.zeus.bean.Card;
import com.zeus.bean.Dep;

public interface ICardDAO {
	
	Card findbyName(String name) throws Exception;
	Card findbyCode(String code)throws Exception;
	Card findCard(String asset_code)throws Exception;
	List<Card> findall() throws Exception;
	List<Dep> findDep()throws Exception;
	
	
	
	

}
