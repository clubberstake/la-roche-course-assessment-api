package laroche.chem.assessment.restfulContollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/course")
	public List<CourseInformation> getCourseId() {
		List<CourseInformation> courses = courseInformationRepository.findAll();
		if (courses.isEmpty()) {
			return generateFakeData();
		}
		return courses;
	}

	@PostMapping("/course")
	public ResponseEntity<Void> addCourse(@RequestBody CourseInformation courseInformation) {
		courseInformationRepository.save(courseInformation);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/course")
	public ResponseEntity<Void> updateCourse(@RequestBody CourseInformation courseInformation) {

		Optional<CourseInformation> editable = courseInformationRepository.findById(courseInformation.getId());
		if (editable.isPresent()) {
			editable.get().setcourseNumberAndSection(courseInformation.getcourseNumberAndSection());
			editable.get().setCourseTitle(courseInformation.getCourseTitle());
			editable.get().setSemester(courseInformation.getSemester());
			editable.get().setSyllabus(courseInformation.getSyllabus());
			editable.get().setInstructor(courseInformation.getInstructor());

			courseInformationRepository.save(editable.get());
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping("/instructor")
	public ResponseEntity<Void> addInstructor(@RequestBody Instructor instructor) {
		instructorRepository.save(instructor);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/instructor")
	public ResponseEntity<Void> updateInstructor(@RequestBody Instructor instructor) {

		try {
			updateInstructorInDB(instructor);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	private Instructor updateInstructorInDB(Instructor instructor) {
		Optional<Instructor> editable = instructorRepository.findById(instructor.getId());
		if (editable.isPresent()) {
			editable.get().setName(instructor.getName());
			instructorRepository.save(editable.get());
		}

		return editable.get();
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