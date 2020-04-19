package person.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import jdbc.Person;
import jdbc.PersonDao;

public class HibernatePersonDao implements PersonDao {

	private SessionFactory factory;

	@Override
	public Person find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Person person) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findByLastname(String lastname) {
		try {
			Session session = factory.getCurrentSession();
			Query query = session.createQuery("from Person p where p.lastname = :lastname");
			query.setParameter("lastname", lastname);
			List<Person> persons = query.list();
			return persons;
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
	}

	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
