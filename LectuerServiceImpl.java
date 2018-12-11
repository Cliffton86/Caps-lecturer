package sg.iss.caps.services;

import java.util.ArrayList;

import sg.iss.caps.model.Lecturer;
import sg.iss.caps.model.Student;
import sg.iss.caps.model.Studentcourse;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.caps.repo.LecturerRepository;

@Service
public class LectuerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepo;


	@Override
	public Lecturer updateStudentGrade(Lecturer L) {
		
		return lrepo.save(L);
	}

	@Override
	public Lecturer findStudentbyID(String StudentID) {
		
		return lrepo.findById(StudentID).get();
	}

	@Override
	public Lecturer viewTimetable(Lecturer L) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Studentcourse> findSCByLID(String lid) {
		return lrepo.findSCByLID(lid);
	}
	

	

}
