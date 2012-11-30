package fr.todooz.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.todooz.domain.Task;

public class TaskService {
	private SessionFactory sessionFactory;

	public void save(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(task);
	}

	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();

		session.delete(session.get(Task.class, id));
	}

	public List<Task> findAll() {
		return criteria().list();
	}

	public List<Task> findByQuery(String query) {
		return criteria().add(Restrictions.ilike("title", query, MatchMode.ANYWHERE)).list();
	}

	public int count() {
		return 0;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub

	}
}
