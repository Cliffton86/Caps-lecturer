package sg.iss.caps.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.caps.services.StudentCourseService;
import sg.iss.caps.services.StudentService;
import sg.iss.caps.validator.StudentValidator;
import sg.iss.caps.exception.StudentNotFound;
import sg.iss.caps.model.Course;
import sg.iss.caps.model.Student;
import sg.iss.caps.model.Studentcourse;

@RequestMapping(value = "/lecturer")
@RestController
@Controller
public class LecturerController {

	@RequestMapping(value = "/index")
	public String index() {

		return "Hello there!";
	}
	
	@Autowired
	StudentCourseService scservice;
	
	@RequestMapping(value = "/course/{courseindex}", method = RequestMethod.GET)
	public ModelAndView viewscbyindexpg(@PathVariable String courseindex) {
		ModelAndView mav = new ModelAndView("StudentbyCourseIndex");
		mav.addObject("studentcourse", scservice.Viewcoursebycourseindex(courseindex));
		return mav;
	}
	
	@RequestMapping(value = "/course/edit/{studentid}", method = RequestMethod.GET)
	public ModelAndView editstudentgradePage(@PathVariable String studentid) {
		Studentcourse studentcoursedetails = scservice.findStudentcoursebyID(studentid);
		ModelAndView mav = new ModelAndView("StudentGradeEdit", "studentcoursedetails", studentcoursedetails);
		return mav;
	}
	
	@RequestMapping(value="/course/edit/{studentid}", method = RequestMethod.POST)
	public ModelAndView editStudGradePage(@PathVariable String studentid, @ModelAttribute Studentcourse studentcoursedetails ) {
		scservice.updateGrade(studentcoursedetails);
		ArrayList<Studentcourse> sc = scservice.findall();
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("sc", sc);
		return mav;
	}
	
}
