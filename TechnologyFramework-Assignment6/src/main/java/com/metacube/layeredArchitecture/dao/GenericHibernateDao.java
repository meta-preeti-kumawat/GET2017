/**
 * The class GenericHiberateDao is an abstract class and implements BaseDao interface.
 * It defines general methods related to all the DAO operations 
 */
package main.java.com.metacube.layeredArchitecture.dao;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.BaseModel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDao<T extends BaseModel, ID> implements
		BaseDao<T, ID> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> modelClass;

	public abstract String getPrimaryKeyColumn();

	public GenericHibernateDao() {
	}

	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * This method returns the session factory.
	 * 
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Setter method for sessionFactory.
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Getter method for model class.
	 * 
	 * @return modelClass
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * This method returns List of all rows of the table in database.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		return criteria.list();
	}

	/**
	 * This method returns row of specific id.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T getById(ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		criteria.add(Restrictions.eq(getPrimaryKeyColumn(), primaryKey));
		if (criteria.list().size() == 0) {
			return null;
		} else {
			return (T) criteria.list().get(0);
		}
	}

	/**
	 * Delete method
	 */
	@Override
	public void delete(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(t);
	}

	/**
	 * Performs delete by id operation on table.
	 */
	@Override
	public Status deleteById(ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		session.delete(criteria.add(
				Restrictions.eq(getPrimaryKeyColumn(), primaryKey))
				.uniqueResult());
		return Status.SUCCESS;
	}
}