package sg.iss.caps.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.caps.model.Studentcourse;
import sg.iss.caps.services.LecturerService;


@RequestMapping(value="/lecturer")
@RestController
@Controller
public class LecturerController {
	
	@Autowired
	LecturerService lservice;

	/*@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("Stdlist");
		ArrayList<Studentcourse> a = lservice.findAllStudentsByLecturer(@pathv);
		mav.addObject("students", Studentcourse);
		return mav;
	}*/
	
	@RequestMapping(value = "/list/{lectureID}", method = RequestMethod.GET)
	public ModelAndView listStudentPage(@PathVariable String lid) {
		ModelAndView mav = new ModelAndView("Stdlist");
		List<Studentcourse> sc = lservice.findSCByLID(lid);
		mav.addObject("stud", sc);
		
		return mav;
	}

	
}
