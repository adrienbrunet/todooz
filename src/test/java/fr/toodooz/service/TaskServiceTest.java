package fr.toodooz.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.todooz.domain.Task;

public class TaskServiceTest {

	private SessionFactory sessionFactory;

	@Before
	public void createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect",
				"org.hibernate.dialect.DerbyDialect");
		configuration.setProperty("hibernate.connection.url",
				"jdbc:derby:target/testdb;create=true");
		configuration.setProperty("hibernate.connection.driver_class",
				"org.apache.derby.jdbc.EmbeddedDriver");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		configuration.addAnnotatedClass(Task.class);

		sessionFactory = configuration.buildSessionFactory();
	}

	@After
	public void cleanDb() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.createQuery("delete from Task").executeUpdate();
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void save() {

	}

	private Task task() {
	      Task task = new Task();
	      task.setDate(new Date());
	      task.setTitle("Read Effective Java");
	      task.setText("Read Effective Java before it's too late");
	      task.setTags("java,java");
	      return task;
	   }
}
