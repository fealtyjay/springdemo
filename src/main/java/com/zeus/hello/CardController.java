package com.zeus.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.bean.Card;
import com.zeus.bean.Dep;
import com.zeus.dao.ICardDAO;

@RestController
@RequestMapping(value="/card")
public class CardController {
	@Autowired
	private ICardDAO dao;
	@RequestMapping(value="/listcard",method=RequestMethod.GET)
	public List<Card> getAllCard() throws Exception{
		return dao.findall();
	}
	@RequestMapping(value="/dep",method=RequestMethod.GET)
	public List<Dep> getAllDep() throws Exception{
		return dao.findDep();
	}

}
