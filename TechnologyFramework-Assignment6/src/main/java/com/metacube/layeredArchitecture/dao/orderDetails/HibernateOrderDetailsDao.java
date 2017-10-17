package main.java.com.metacube.layeredArchitecture.dao.orderDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.OrderDetails;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("hibernateOrderDetailsDao")
public class HibernateOrderDetailsDao extends
		GenericHibernateDao<OrderDetails, Integer> implements OrderDetailsDao {

	public HibernateOrderDetailsDao() {
		super(OrderDetails.class);
	}

	@Override
	public Integer create(OrderDetails orderDetails) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(orderDetails);
		return 0;
	}

	@Override
	public Status update(OrderDetails orderDetails) {
		return null;
	}

	@Override
	public String getPrimaryKeyColumn() {
		return null;
	}

	@Override
	public Status deleteProductFromCart(int currentCartID, int productID) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(OrderDetails.class);
		criteria.add(Restrictions.eq("orderId", currentCartID));
		session.delete(criteria.add(Restrictions.eq("productId", productID))
				.uniqueResult());
		return Status.SUCCESS;
	}

	@Override
	public Status addProductById(int currentCartID, int productId) {
		OrderDetails orderDetails = new OrderDetails(currentCartID, productId);
		if (!getAll().contains(orderDetails)) {
			create(orderDetails);
			return Status.SUCCESS;
		}
		orderDetails = null;
		return Status.FAILURE;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllByOrderId(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(OrderDetails.class);
		criteria.add(Restrictions.eq("orderId", id));
		Iterator<OrderDetails> iter = criteria.list().iterator();
		List<Product> productsInOrder = new ArrayList<>();
		while (iter.hasNext()) {
			criteria = session.createCriteria(Product.class);
			productsInOrder.add((Product) criteria.add(
					Restrictions.eq("id", iter.next().getProductId()))
					.uniqueResult());
		}

		return productsInOrder;
	}
}