package main.java.com.metacube.layeredArchitecture.dao.product;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("hibernateProductDao")
public class HibernateProductDao extends GenericHibernateDao<Product> implements ProductDao{
	public HibernateProductDao() {
		super(Product.class);
	}

	@Override
	public Status deleteById(int primaryKey) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		Product product = (Product) criteria.add(Restrictions.eq("id", primaryKey)).uniqueResult();
		session.delete(product);
		return Status.SUCCESS;
	}
	

}