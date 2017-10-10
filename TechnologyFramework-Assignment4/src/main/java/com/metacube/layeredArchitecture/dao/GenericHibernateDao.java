package main.java.com.metacube.layeredArchitecture.dao;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.BaseModel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDao <T extends BaseModel> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> modelClass;
	
	public GenericHibernateDao() { }
	
	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getModelClass() {
		return modelClass;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		return criteria.list();	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getById(int primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		criteria =  criteria.add(Restrictions.eq("id", primaryKey));
		return (T) criteria.uniqueResult();
	}

	@Override
	public Status create(T t) {
		Session session = getSessionFactory().getCurrentSession();
		if(session.save(t) == null){
			return Status.FAILURE;
		}
		else{
			return Status.SUCCESS;
		}
	}

	public Status update(T t, int primaryKey) {
		Session session = getSessionFactory().getCurrentSession();
		session.update(t);
		return Status.SUCCESS;
	}
}