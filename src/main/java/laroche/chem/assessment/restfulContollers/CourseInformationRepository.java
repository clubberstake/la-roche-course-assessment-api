package laroche.chem.assessment.restfulContollers;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import laroche.chem.assessment.dataModel.CourseInformation;

public interface CourseInformationRepository extends JpaRepository<CourseInformation, Long> {

	List<CourseInformation> findByCourseNumberSection(String courseNumberAndSection);

}
