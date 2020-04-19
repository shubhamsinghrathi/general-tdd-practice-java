package person.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.jupiter.api.Test;

import jdbc.Person;

class HibernatePersonDaoIntegrationTest {

	@Test
	public void persistedObjectExistsInDatabase() throws Exception {
		SessionFactory sf = getSessionFactory();
		HibernatePersonDao dao = new HibernatePersonDao();
		dao.setSessionFactory(sf);

		Person person = new Person("John", "Doe");
		dao.save(person);
		assertNotNull(person.getId());

		Session s = sf.openSession();
		Object copy = s.get(Person.class, person.getId());
		Person copyPerson = (Person) copy;
		assertEquals(person.getFirstName(), copyPerson.getFirstName());
		assertEquals(person.getLastName(), copyPerson.getLastName());
		assertEquals(person.getId(), copyPerson.getId());
	}

	private SessionFactory getSessionFactory() throws Exception {
		return createConfiguration().buildSessionFactory();
	}

	private Configuration createConfiguration() throws Exception {
		Configuration cfg = loadProductionConfiguration();
		loadTestConfigInto(cfg, "/hibernate.test.properties");
		return cfg;
	}

	private Configuration loadProductionConfiguration() {
		return new Configuration().configure();
	}

	private void loadTestConfigInto(Configuration cfg, String path) throws Exception {
		Properties properties = loadPropertiesFrom(path);
		Enumeration keys = properties.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = properties.getProperty(key);
			cfg.setProperty(key, value);
		}
	}

	private Properties loadPropertiesFrom(String path) throws Exception {
		InputStream stream = getClass().getResourceAsStream(path);
		assertNotNull("Resource not found: " + path, stream);
		Properties props = new Properties();
		props.load(stream);
		stream.close();
		return props;
	}

}
