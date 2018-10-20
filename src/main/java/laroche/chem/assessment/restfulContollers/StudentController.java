package laroche.chem.assessment.restfulContollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import laroche.chem.assessment.dataModel.Student;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/student/{emailAddress}")
	public Student getStudent(@PathVariable String emailAddress) {
		Optional<Student> student = studentRepository.findByEmailAddress(emailAddress);
		if (student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@DeleteMapping("/student/{id}")
	public boolean deleteStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			studentRepository.delete(student.get());
			return true;
		}
		return false;
	}

	@PutMapping("/student")
	public long updateStudent(@RequestBody Student student) {

		long studentId = -1;

		if (student.getId() == 0) {
			studentRepository.save(student);
			studentId = student.getId();
		} else {
			Optional<Student> editable = studentRepository.findById(student.getId());
			if (editable.isPresent()) {
				editable.get().setAuthor(student.getAuthor());
				editable.get().setEmailAddress(student.getEmailAddress());
				editable.get().setFile(student.getFile());
				editable.get().setInternationalStudent(student.getInternationalStudent());
				editable.get().setStudentAthletics(student.getStudentAthletics());
				editable.get().setStudentHonors(student.getStudentHonors());
				editable.get().setStudentHousingStatus(student.getStudentHousingStatus());
				editable.get().setStudentMajor(student.getStudentMajor());
				editable.get().setStudentMathGrade(student.getStudentMathGrade());
				editable.get().setStudentName(student.getStudentName());
				editable.get().setStudentSemester(student.getStudentSemester());
				editable.get().setStudentYear(student.getStudentYear());
				editable.get().setTime(student.getTime());
				studentRepository.save(editable.get());
				studentId = editable.get().getId();
			}
		}

		return studentId;
	}
}
