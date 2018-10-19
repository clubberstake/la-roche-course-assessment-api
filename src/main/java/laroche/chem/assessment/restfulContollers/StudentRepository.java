package laroche.chem.assessment.restfulContollers;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByEmailAddress(String emailAddress);
}
