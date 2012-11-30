package fr.todooz.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.todooz.domain.Task;


public class TaskServiceImpl implements ServiceTask {
	
	@Inject
	private SessionFactory sessionFactory;


	@Override
	public void save(Task task) {
		Session session = sessionFactory.getCurrentSession();

	    session.save(task);
	}


	@Override
	public void delete(Long id) {
		Session sessionDelete = sessionFactory.openSession();
        Transaction tx = sessionDelete.beginTransaction();
 
		// Loading object
           Task taskToDelete = (Task) sessionDelete.get(Task.class, task.getId());
           // Deleting object
           sessionDelete.delete(taskToDelete);
           tx.commit();
           sessionDelete.close();
	}


	@Override
	public List<Task> findAll() {
		return criteria().list();
	}

	@Override
	public List<Task> findByQuery(String query) {
		return criteria().add(Restrictions.ilike("title", query, MatchMode.ANYWHERE)).list();
	}


	@Override
	public int count() {
		return 0;
	}

	
}
