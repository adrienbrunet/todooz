package fr.todooz.service;

import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.todooz.domain.Task;
import fr.todooz.service.ServiceTask;
import fr.todooz.service.TaskServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TaskServiceTest {

	@Inject
	private SessionFactory sessionFactory;
	
	@Inject
	private ServiceTask taskService;

	@After
	public void cleanDb() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.createQuery("delete from Task").executeUpdate();
		transaction.commit();
		session.close();
	}

	@Test
	public void save() {
		ServiceTask taskService = new TaskServiceImpl();
		taskService.setSessionFactory(sessionFactory);
		taskService.save(task());
	}

	@Test
	public void delete() {
		Task task = task();

		taskService.save(task);

		taskService.delete(task.getId());

		Session session = sessionFactory.openSession();

		Assert.assertEquals(0, session.createQuery("from Task").list().size());

		session.close();
	}

	@Test
	public void findAll() {
		ServiceTask taskService = new TaskServiceImpl();
		taskService.setSessionFactory(sessionFactory);

		taskService.save(task());
		taskService.save(task());

		Assert.assertEquals(2, taskService.findAll().size());
	}

	@Test
	public void findByQuery() {
		ServiceTask taskService = new TaskServiceImpl();
		taskService.setSessionFactory(sessionFactory);

		taskService.save(task());
		taskService.save(task());

		Assert.assertEquals(2, taskService.findByQuery("read").size());
		Assert.assertEquals(2, taskService.findByQuery("java").size());
		Assert.assertEquals(0, taskService.findByQuery("driven").size());
	}

	@Test
	public void count() {
		ServiceTask taskService = new TaskServiceImpl();
		taskService.setSessionFactory(sessionFactory);

		taskService.save(task());
		taskService.save(task());

		Assert.assertEquals(2, taskService.count());
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
