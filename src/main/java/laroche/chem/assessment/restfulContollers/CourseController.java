package laroche.chem.assessment.restfulContollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import laroche.chem.assessment.dataModel.CourseInformation;
import laroche.chem.assessment.dataModel.Instructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	private CourseInformationRepository courseInformationRepository;

	@GetMapping("/course")
	public List<CourseInformation> getCourseId() {
		List<CourseInformation> courses = courseInformationRepository.findAll();
		if (courses.isEmpty()) {
			return generateFakeData();
		}
		return courses;
	}

	private List<CourseInformation> generateFakeData() {
		List<CourseInformation> courses = new ArrayList<CourseInformation>();
		CourseInformation course = new CourseInformation();
		course.setcourseNumberAndSection("CHEM2016");
		course.setCourseTitle("Organic Chemistry II Lecture");
		course.setSemester("Fall 2018");
		Instructor instructor = new Instructor();
		instructor.setName("Dr. D.T. Fujito, Professor/Chair of Chemistry");
		course.setInstructor(instructor);
		courses.add(course);

		course = new CourseInformation();
		course.setcourseNumberAndSection("CSCI4096");
		course.setCourseTitle("Capstone I");
		course.setSemester("Fall 2018");
		instructor = new Instructor();
		instructor.setName("Mr. Jeffery Perdue");
		course.setInstructor(instructor);
		courses.add(course);

		courseInformationRepository.saveAll(courses);

		return courses;
	}
}