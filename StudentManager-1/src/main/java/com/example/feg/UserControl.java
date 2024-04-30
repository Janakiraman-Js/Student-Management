package com.example.feg;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserControl {
	@Autowired
	UserDao ky;
	@GetMapping("/")
	public String ab() {
		return"vel";
		
	}
	@GetMapping("sss")
	public String av(@ModelAttribute Student student, Model model) {
		ky.save(student);
		return"vel";
	}
	@GetMapping("rel")
	public ModelAndView ac(@RequestParam int id) {
		ModelAndView mav=new  ModelAndView("see");
		Student student=ky.findById(id).orElse(null);
		mav.addObject("student",student);
		return mav;
	}
	@GetMapping("re")
	public ModelAndView ac1(@RequestParam int id) {
		ModelAndView mav=new  ModelAndView("Del");
		Student student=ky.findById(id).orElse(null);
		mav.addObject("student",student);
		ky.deleteById(id);
		return mav;
	}
	@GetMapping("rs")
	public ModelAndView ac2(Student student) {
		ModelAndView mav=new  ModelAndView("up");
		 student=ky.findById(student.getId()).orElse(null);
		 ky.deleteById(student.getId());
		mav.addObject("student",student);
		return mav;
	}

}
