package repository;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entities.Flight;
import hibernateUtil.HibernateUtils;

public class FlightDaoImplementation implements FlightDao {
	SessionFactory sf;

	public FlightDaoImplementation() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean create(Flight flight) throws SQLException {
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(flight);
		} catch (Exception e) {
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public Flight read(int id) throws SQLException {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Flight flight = (Flight) session.get(Flight.class, id);
		session.getTransaction().commit();
		session.close();
		return flight;
	}

	@Override
	public boolean update(Flight flight) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(flight);
		} catch (Exception e) {
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(int id2) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete Employee where id = :id";
		try {
			Query query = session.createQuery(hql).setParameter("id", id2);
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		transaction.commit();
		session.close();
		return true;

	}

}
