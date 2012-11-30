package fr.todooz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.todooz.DummyData;



@Controller
public class IndexController {
	@RequestMapping({"/", "/index"})
   public String index(Model model) {
      model.addAttribute("tasks", DummyData.tasks());
      
      return "index";
   }
}