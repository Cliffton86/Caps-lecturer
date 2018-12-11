package sg.iss.caps.services;

import java.util.ArrayList;


import sg.iss.caps.model.Lecturer;
import sg.iss.caps.model.Student;
import sg.iss.caps.model.Studentcourse;;

public interface LecturerService {


	ArrayList<Studentcourse> findSCByLID(String lid);
	
	Lecturer updateStudentGrade(Lecturer L);

	Lecturer findStudentbyID(String StudentID);

	Lecturer viewTimetable(Lecturer L);
	
	
}
