package fr.todooz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.todooz.domain.Task;

public class DummyData {
	private static final int TASK_COUNT = 10;
	
	  public static List<Task> tasks() {

	    List<Task> tasks = new ArrayList<Task>();

	    for (int i = 0; i < TASK_COUNT; i++) {
	        tasks.add(task());
	    }

	    return tasks;
	  }

	  private static Task task() {
	    Task task = new Task();

	    task.setDate(new Date());
	    task.setTitle("Dummmmyyyyyy");
	    task.setText("gnŽŽŽŽ");
	    task.setTags("pouet, pouet");

	    return task;
	  }
	}