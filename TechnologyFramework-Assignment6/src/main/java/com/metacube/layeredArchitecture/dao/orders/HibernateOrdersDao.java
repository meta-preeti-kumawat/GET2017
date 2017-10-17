package main.java.com.metacube.layeredArchitecture.dao.orders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.OrderDetails;
import main.java.com.metacube.layeredArchitecture.model.Orders;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;

@Repository("hibernateOrdersDao")
public class HibernateOrdersDao extends GenericHibernateDao<Orders, Integer>
		implements OrdersDao {
	public HibernateOrdersDao() {
		super(Orders.class);
	}

	@Override
	public Integer create(Orders order) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(order);
		return order.getOrderId();
	}

	@Override
	public Status update(Orders order) {
		Session session = getSessionFactory().getCurrentSession();
		session.update(order);
		return Status.SUCCESS;
	}

	@Override
	public String getPrimaryKeyColumn() {
		return "orderId";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getCurrentOrderProductList(User currentUser) {
		List<Product> productList = new ArrayList<Product>();
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("userMailId", currentUser.getEmail()));
		if (criteria.list().size() != 0) {
			Orders order = (Orders) criteria
					.add(Restrictions.eq("status", "C")).uniqueResult();
			if (order != null) {
				criteria = session.createCriteria(OrderDetails.class);
				criteria.add(Restrictions.eq("orderId", order.getOrderId()));
				productList = new ArrayList<>();
				Iterator<OrderDetails> iter = criteria.list().iterator();
				while (iter.hasNext()) {
					criteria = session.createCriteria(Product.class);
					productList.add((Product) criteria.add(
							Restrictions.eq("id", iter.next().getProductId()))
							.uniqueResult());
				}
			}
		}
		return productList;
	}

	@Override
	public Status placeOrder(int currentCartID) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		Orders order = (Orders) criteria.add(
				Restrictions.eq("orderId", currentCartID)).uniqueResult();
		order.setStatus("P");
		return update(order);
	}

	@Override
	public float getTotalAmountOfOrder(int orderID) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(OrderDetails.class);
		criteria.add(Restrictions.eq("orderId", orderID));
		@SuppressWarnings("unchecked")
		Iterator<OrderDetails> iter = criteria.list().iterator();
		float amount = 0;
		while (iter.hasNext()) {
			criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("id", iter.next().getProductId()))
					.uniqueResult();
			amount += ((Product) criteria.list().get(0)).getPrice();
		}
		return amount;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Orders> getPreviousOrdersByUserName(User currentUser) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("userMailId", currentUser.getEmail()));
		criteria.add(Restrictions.eq("status", "P"));
		return criteria.list();
	}
}