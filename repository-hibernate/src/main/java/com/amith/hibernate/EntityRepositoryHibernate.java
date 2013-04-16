package com.amith.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amith.domain.InstanceFactory;

/**
 * 提供session给父类及作为外部注册仓储的实现类
 * @author amith
 *
 */
public class EntityRepositoryHibernate extends AbstractEntityRepository {

	private SessionFactory sessionFactory;
	
	public EntityRepositoryHibernate() {
	}

	public EntityRepositoryHibernate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = InstanceFactory.getInstance(SessionFactory.class);
		}
		return sessionFactory;
	}
	
	@Override
	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

}
