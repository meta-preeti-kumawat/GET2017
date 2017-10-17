package main.java.com.metacube.layeredArchitecture.dao.product;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("hibernateProductDao")
public class HibernateProductDao extends GenericHibernateDao<Product, Integer>
		implements ProductDao {
	public HibernateProductDao() {
		super(Product.class);
	}

	@Override
	public Status update(Product product) {
		Session session = getSessionFactory().getCurrentSession();
		session.update(product);
		return Status.SUCCESS;
	}

	@Override
	public Integer create(Product product) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(product);
		return product.getId();
	}

	@Override
	public String getPrimaryKeyColumn() {
		return "id";
	}
}