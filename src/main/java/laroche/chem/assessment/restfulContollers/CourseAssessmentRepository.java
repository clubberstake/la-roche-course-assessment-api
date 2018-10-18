package laroche.chem.assessment.restfulContollers;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.CourseAssessment;

public interface CourseAssessmentRepository  extends JpaRepository<CourseAssessment, Long> {

}
