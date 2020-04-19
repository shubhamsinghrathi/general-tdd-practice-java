package jdbc;

import javax.sql.*;
import java.sql.*;
import java.util.*;

public class JdbcPersonDao implements PersonDao {

	private DataSource datasource;
	
	@Override
	public Person find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		
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
			Connection conn = datasource.getConnection();
			String sql = "SELECT * FROM people WHERE last_name = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastname);
			ResultSet rset = stmt.executeQuery();
			List<Person> persons = new ArrayList<Person>();
			while(rset.next()) {
				String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
				persons.add(new Person(firstName, lastName));
			}
			rset.close();
			stmt.close();
			conn.close();
			return persons;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}
