package person.hibernate;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdbc.Person;

class HibernatePersonDaoTest {

	private SessionFactory factory;
	private Session session;
	private Query query;
	
	@BeforeEach
	public void setUp() {
		factory = createMock(SessionFactory.class);
		session = createMock(Session.class);
		query = createMock(Query.class);
	}
	
	@Test
	public void testFindByLastname() throws Exception {
		String hql = "from Person p where p.lastname = :lastname";
		String name = "Smith";
		List<Person> theSmiths = new ArrayList<Person>();
		theSmiths.add(new Person("Alice", name));
		theSmiths.add(new Person("Billy", name));
		theSmiths.add(new Person("Clark", name));
		
		expect(factory.getCurrentSession()).andReturn(session);
		expect(session.createQuery(hql)).andReturn(query);
		expect(query.setParameter("lastname", name)).andReturn(query);
		expect(query.list()).andReturn(theSmiths);
		replay(factory, session, query);
		
		HibernatePersonDao dao = new HibernatePersonDao();
		dao.setSessionFactory(factory);
		List<Person> persons = dao.findByLastname(name);
		for (int i=0; i<persons.size(); i++) {
			assertEquals(persons.get(0).getFirstName(), theSmiths.get(0).getFirstName());
			assertEquals(persons.get(0).getLastName(), theSmiths.get(0).getLastName());
		}
		verify(factory, session, query);
	}
	
	@Test
	public void testFindByLastnameReturnsEmptyListUponException() throws Exception {
		String hql = "from Person p where p.lastname = :lastname";
		String name = "Smith";
		HibernateException hibernateError = new HibernateException("");
		
		expect(factory.getCurrentSession()).andReturn(session);
		expect(session.createQuery(hql)).andReturn(query);
		expect(query.setParameter("lastname", name)).andReturn(query);
		expect(query.list()).andThrow(hibernateError);
		replay(factory, session, query);
		
		HibernatePersonDao dao = new HibernatePersonDao();
		dao.setSessionFactory(factory);
		try {
			dao.findByLastname(name);
			fail("should have thrown an exception");
		} catch (RuntimeException e) {
			assertSame(hibernateError, e.getCause());
		}
		verify(factory, session, query);
	}

}
