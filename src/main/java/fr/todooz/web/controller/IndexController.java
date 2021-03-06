package fr.todooz.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.todooz.domain.Task;
import fr.todooz.service.TagCloudService;
import fr.todooz.service.TaskService;
import fr.todooz.util.IntervalUtils;
import fr.todooz.util.TagCloud;

@Controller
public class IndexController {
	@Inject
	private TaskService taskService;

	@Inject
	private TagCloudService tagCloudService;

	@ModelAttribute
	public TagCloud tagCloud() {
		return tagCloudService.buildTagCloud();
	}

	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		return page(model, taskService.findAll());
	}

	@RequestMapping("/search")
	public String search(String query, Model model) {
		return page(model, taskService.findByQuery(query));
	}

	@RequestMapping("/tag/{tag}")
	public String tag(@PathVariable String tag, Model model) {
		return page(model, taskService.findByTag(tag));
	}

	@RequestMapping("/today")
	public String today(Model model) {
		return page(model, taskService.findByInterval(IntervalUtils.todayInterval()));
	}

	@RequestMapping("/tomorrow")
	public String tomorrow(Model model) {
		return page(model, taskService.findByInterval(IntervalUtils.tomorrowInterval()));
	}

	public String page(Model model, List<Task> tasks) {
		model.addAttribute("tasks", tasks);

		return "index";
	}


	@PostConstruct
	public void bootstrap() {
		for (Task task : taskService.findAll()) {
			taskService.delete(task.getId());
		}

		if (taskService.count() == 0) {
			Task task1 = new Task();
			task1.setDate(new Date());
			task1.setTitle("premier test");
			task1.setTags("tag0");

			taskService.save(task1);

			Task task2 = new Task();
			task2.setDate(new Date());
			task2.setTitle("deuxieme test");
			task2.setTags("tag1,tag2");

			taskService.save(task2);

			Task task3 = new Task();
			task3.setDate(new Date("12/01/2012"));
			task3.setTitle("troisieme test");
			task3.setTags("tag0,truc");

			taskService.save(task3);
		}
	}
}