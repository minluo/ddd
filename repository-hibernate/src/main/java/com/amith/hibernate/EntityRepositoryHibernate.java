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

	@Override
	protected Session getSession() {
		SessionFactory sessionFactory = InstanceFactory.getInstance(SessionFactory.class);
		return sessionFactory.getCurrentSession();
	}

}
