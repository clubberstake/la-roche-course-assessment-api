package laroche.chem.assessment.restfulContollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import laroche.chem.assessment.dataModel.CourseInformation;
import laroche.chem.assessment.dataModel.Instructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseInformationController {

	@Autowired
	private CourseInformationRepository courseInformationRepository;

	@Autowired
	private InstructorRepository instructorRepository;

	@GetMapping("/courseInformation")
	public List<CourseInformation> getCourses() {
		List<CourseInformation> courses = courseInformationRepository.findAll();
		if (courses.isEmpty()) {
			return generateFakeData();
		}
		return courses;
	}

	@GetMapping("/courseInformation/{courseNumberAndSection}/{semester}/{year}")
	public CourseInformation getCourse(@PathVariable String courseNumberAndSection, @PathVariable String semester,
			@PathVariable String year) {

		List<CourseInformation> courses = courseInformationRepository.findByCourseNumberSection(courseNumberAndSection);
		if (!courses.isEmpty()) {
			for (CourseInformation course : courses) {
				if (course.getSemester().equals(semester) && course.getYear().equals(year)) {
					return course;
				}
			}
		}
		return null;
	}

	@PutMapping("/courseInformation")
	public ResponseEntity<Void> updateCourse(@RequestBody CourseInformation courseInformation) {

		Optional<CourseInformation> editable = courseInformationRepository.findById(courseInformation.getId());
		if (editable.isPresent()) {
			editable.get().setCourseNumberSection(courseInformation.getCourseNumberSection());
			editable.get().setCourseTitle(courseInformation.getCourseTitle());
			editable.get().setSemester(courseInformation.getSemester());
			editable.get().setYear(courseInformation.getYear());
			editable.get().setSyllabus(courseInformation.getSyllabus());

			Optional<Instructor> instructor = instructorRepository.findById(courseInformation.getInstructor().getId());
			editable.get().setInstructor(instructor.get());

			courseInformationRepository.save(editable.get());
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			Optional<Instructor> instructor = instructorRepository.findById(courseInformation.getInstructor().getId());
			courseInformation.setInstructor(instructor.get());
			courseInformationRepository.save(courseInformation);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}

	@DeleteMapping("/courseInformation/{id}")
	public boolean deleteCourseInformation(@PathVariable long id) {

		Optional<CourseInformation> course = courseInformationRepository.findById(id);
		if (course.isPresent()) {
			courseInformationRepository.delete(course.get());
			return true;
		}

		return false;
	}

	private List<CourseInformation> generateFakeData() {
		List<CourseInformation> courses = new ArrayList<CourseInformation>();
		CourseInformation course = new CourseInformation();
		course.setCourseNumberSection("CHEM2016");
		course.setCourseTitle("Organic Chemistry II Lecture");
		course.setSemester("Fall");
		course.setYear("2018");
		Instructor instructor = new Instructor();
		instructor.setEmailAddress("don.fujito@laroche.edu");
		instructor.setName("Dr. D.T. Fujito, Professor/Chair of Chemistry");
		course.setInstructor(instructor);
		courses.add(course);

		course = new CourseInformation();
		course.setCourseNumberSection("CSCI4096");
		course.setCourseTitle("Capstone I");
		course.setSemester("Fall");
		course.setYear("2018");
		instructor = new Instructor();
		instructor.setEmailAddress("jeff.perdue@laroche.edu");
		instructor.setName("Mr. Jeffery Perdue");
		course.setInstructor(instructor);
		courses.add(course);

		courseInformationRepository.saveAll(courses);

		return courses;
	}
}