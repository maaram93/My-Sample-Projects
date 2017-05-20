package imcs.trng.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import imcs.trng.HibernateUtil.HibernateUtils;
import imcs.trng.HibernateUtil.SalaryCountResultTransformer;
import imcs.trng.beans.SalaryCount;
import trng.imcs.hibernate.pojo.Employee;
import trng.imcs.hibernate.pojo.Gender;

public class EmployeeDaoImplementation implements EmployeeDao {
	SessionFactory sf;

	public EmployeeDaoImplementation() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean create(Employee employee) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(employee);
		} catch (Exception e) {
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public Employee read(int id) throws SQLException {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	@Override
	public boolean update(Employee employee) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(employee);
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

	@Override
	public double hra(int id3) throws SQLException {
		Employee rs = read(id3);
		return rs.getSalary();
	}

	@Override
	public double grossSalary(int id4) throws SQLException {
		Employee rs = read(id4);
		return rs.getSalary();
	}

	@Override
	public List<Employee> displayAll() throws SQLException {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		session.close();
		return employees;

	}

	public List<SalaryCount> DisplayEmployeeSalaryWiseCount() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select e.salary, count(salary) from Employee as e group by e.salary";
		List<SalaryCount> salaryCount;
		try {
			Query query = session.createQuery(hql);
			query.setResultTransformer(new SalaryCountResultTransformer());

			salaryCount = query.list();

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		transaction.commit();
		session.close();
		return salaryCount;

	}

	public List<Employee> displayUniqueEmployeeNames() {
		List<Employee> employee = null;
		try {
			employee = displayAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;

	}

	public List<Employee> sortEmployeeByLastname() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// String hql = "FROM Employee e ORDER BY "+ criteria;
		List<Employee> employees;
		try {
			employees = session.createCriteria(Employee.class).addOrder(Order.desc("first_name")).list();

		} catch (Exception e) {
			return null;
		}
		transaction.commit();
		session.close();
		return employees;

	}

	public List<Employee> sortEmployeeBySalary() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// String hql = "FROM Employee e ORDER BY "+ criteria;
		List<Employee> employees;
		try {
			employees = session.createCriteria(Employee.class).addOrder(Order.desc("salary")).list();

		} catch (Exception e) {
			return null;
		}
		transaction.commit();
		session.close();
		return employees;

	}

}
