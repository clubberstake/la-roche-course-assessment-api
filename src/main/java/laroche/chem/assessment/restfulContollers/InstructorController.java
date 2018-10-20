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

import laroche.chem.assessment.dataModel.Instructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InstructorController {

	@Autowired
	private InstructorRepository instructorRepository;

	@GetMapping("/instructor/{emailAddress}")
	public Instructor getInstructor(@PathVariable String emailAddress) {
		Optional<Instructor> instructor = instructorRepository.findByEmailAddress(emailAddress);
		if (instructor.isPresent()) {
			return instructor.get();
		}
		return null;
	}

	@DeleteMapping("/instructor/{id}")
	public boolean deleteInstructor(@PathVariable long id) {
		Optional<Instructor> instructor = instructorRepository.findById(id);
		if (instructor.isPresent()) {
			instructorRepository.delete(instructor.get());
			return true;
		}
		return false;
	}

	@PutMapping("/instructor")
	public long updateInstructor(@RequestBody Instructor instructor) {

		long instructorId = -1;

		if (instructor.getId() == 0) {
			instructorRepository.save(instructor);
			instructorId = instructor.getId();
		} else {
			Optional<Instructor> editable = instructorRepository.findById(instructor.getId());
			if (editable.isPresent()) {
				editable.get().setEmailAddress(instructor.getEmailAddress());
				editable.get().setName(instructor.getName());
				instructorRepository.save(editable.get());
				instructorId = editable.get().getId();
			}
		}

		return instructorId;
	}
}
