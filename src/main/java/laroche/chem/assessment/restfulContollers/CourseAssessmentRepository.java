package laroche.chem.assessment.restfulContollers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.CourseAssessment;
import laroche.chem.assessment.dataModel.CourseInformation;

public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment, Long> {

	Optional<CourseAssessment> findByCourseInformation(CourseInformation courseInformation);

}
