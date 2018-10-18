package laroche.chem.assessment.restfulContollers;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
