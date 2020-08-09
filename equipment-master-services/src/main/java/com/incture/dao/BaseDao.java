package com.incture.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.incture.dto.BaseDto;
import com.incture.entities.BaseData;

public abstract class BaseDao<E extends BaseData, D extends BaseDto> {

	
	@Autowired
	private SessionFactory sessionFactory;



	// Connection
	public Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	public StatelessSession getStatelessSession() {
		return sessionFactory.openStatelessSession();
	}
	
	protected abstract E importDto(D fromDto);

	//protected abstract D exportDto(E entity);


}

