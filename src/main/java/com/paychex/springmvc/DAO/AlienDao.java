package com.paychex.springmvc.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paychex.springmvc.model.Alien;
@Component
public class AlienDao {
	@Autowired
	private SessionFactory factory;
	@Transactional
	public List<Alien> getAlien() {		
		Session session = factory.getCurrentSession();
		List<Alien> alien = session.createQuery("from Alien",Alien.class).list();
		return alien;
	}
	@Transactional
	public void addAlien(Alien a) {
		System.out.println("in dao add method");
		Session session = factory.getCurrentSession();
		session.save(a);
		
	}
	@Transactional
	public Alien fetchAlien(int aid) {
		
		Session session = factory.getCurrentSession();
		Alien a = session.get(Alien.class, aid);
		return a;
	}
}
