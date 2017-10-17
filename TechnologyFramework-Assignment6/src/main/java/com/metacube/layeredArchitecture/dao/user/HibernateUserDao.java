package main.java.com.metacube.layeredArchitecture.dao.user;

import java.util.Iterator;

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

@Repository("hibernateUserDao")
public class HibernateUserDao extends GenericHibernateDao<User, String>
		implements UserDao {

	public HibernateUserDao() {
		super(User.class);
	}

	@Override
	public String create(User user) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(user);
		return user.getEmail();
	}

	@Override
	public Status update(User user) {
		return null;
	}

	@Override
	public String getPrimaryKeyColumn() {
		return "email";
	}

	@Override
	public int getCurrentCartID(User currentUser) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("userMailId", currentUser.getEmail()));
		if (criteria.list().size() != 0) {
			Orders order = (Orders) criteria
					.add(Restrictions.eq("status", "C")).uniqueResult();
			if (order != null) {
				return order.getOrderId();
			}
		}
		return 0;
	}

	@Override
	public int getNumOfProductsInCart(User user) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("userMailId", user.getEmail()));
		if (criteria.list().size() != 0) {
			Orders order = (Orders) criteria
					.add(Restrictions.eq("status", "C")).uniqueResult();
			if (order != null) {
				criteria = session.createCriteria(OrderDetails.class);
				criteria.add(Restrictions.eq("orderId", order.getOrderId()));
				return criteria.list().size();
			}
		}
		return 0;
	}

	@Override
	public float getAmountOfCart(User user) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("userMailId", user.getEmail()));
		if (criteria.list().size() != 0) {
			Orders order = (Orders) criteria
					.add(Restrictions.eq("status", "C")).uniqueResult();
			if (order != null) {
				criteria = session.createCriteria(OrderDetails.class);
				criteria.add(Restrictions.eq("orderId", order.getOrderId()));
				@SuppressWarnings("unchecked")
				Iterator<OrderDetails> iter = criteria.list().iterator();
				float amount = 0;
				while (iter.hasNext()) {
					criteria = session.createCriteria(Product.class);
					criteria.add(
							Restrictions.eq("id", iter.next().getProductId()))
							.uniqueResult();
					amount += ((Product) criteria.list().get(0)).getPrice();
				}
				return amount;
			}
		}
		return 0;
	}
}