package laroche.chem.assessment.restfulContollers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.SemesterReview;
import laroche.chem.assessment.dataModel.Student;

public interface SemesterReviewRepository extends JpaRepository<SemesterReview, Long> {

	List<SemesterReview> findAllByStudent(Student student);

}
