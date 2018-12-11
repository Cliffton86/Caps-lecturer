package sg.iss.caps.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.caps.model.Lecturer;
import sg.iss.caps.model.Student;
import sg.iss.caps.model.Studentcourse;

public interface LecturerRepository extends JpaRepository<Lecturer, String>, JpaSpecificationExecutor<Lecturer>  {

	
	@Query("select  studentcourse.Student_StudentID, studentcourse.CAGrade, studentcourse.ExamGrade\r\n" + 
			"from studentcourse, course, lecturercourse\r\n" + 
			"where studentcourse.CourseIndex = course.courseindex\r\n" + 
			"AND lecturercourse.courseindex = course.courseindex\r\n" + 
			"AND lecturercourse.LecturerID= :lid;")
	ArrayList<Studentcourse> findSCByLID(@Param("lid") String lid);



	 
	
}
