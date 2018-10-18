package laroche.chem.assessment.restfulContollers;

import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.CourseInformation;

public interface CourseInformationRepository extends JpaRepository<CourseInformation, Long> {

}
