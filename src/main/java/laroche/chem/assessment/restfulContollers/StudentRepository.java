package laroche.chem.assessment.restfulContollers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByEmailAddress(String emailAddress);
}
