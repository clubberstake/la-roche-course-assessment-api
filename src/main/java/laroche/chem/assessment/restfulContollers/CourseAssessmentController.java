package laroche.chem.assessment.restfulContollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import laroche.chem.assessment.dataModel.CourseAssessment;
import laroche.chem.assessment.dataModel.CourseInformation;
import laroche.chem.assessment.dataModel.SemesterReview;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseAssessmentController {

	@Autowired
	private CourseAssessmentRepository courseAssessmentRepository;

	@Autowired
	private CourseInformationRepository courseInformationRepository;

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/courseAssessment/{courseId}")
	public CourseAssessment getCourseAssessment(@PathVariable long courseId) {
		Optional<CourseInformation> courseInformation = courseInformationRepository.findById(courseId);
		if (courseInformation.isPresent()) {
			Optional<CourseAssessment> courseAssessment = courseAssessmentRepository
					.findByCourseInformation(courseInformation.get());
			if (courseAssessment.isPresent()) {
				return courseAssessment.get();
			}
		}
		return null;
	}

	@PutMapping("/courseAssessment")
	public long updateCourseAssessment(@RequestBody CourseAssessment courseAssessment) {

		if (courseAssessment.getId() <= 0) {
			Optional<CourseInformation> courseInformation = courseInformationRepository
					.findById(courseAssessment.getCourseInformation().getId());
			if (courseInformation.isPresent()) {
				courseAssessment.setCourseInformation(courseInformation.get());
			}

			for (SemesterReview review : courseAssessment.getEndSemesterReviews()) {
				review.setStudent(studentRepository.findById(review.getStudent().getId()).get());
				review.setCourseInformation(courseAssessment.getCourseInformation());
			}

			for (SemesterReview review : courseAssessment.getMidSemesterReviews()) {
				review.setStudent(studentRepository.findById(review.getStudent().getId()).get());
				review.setCourseInformation(courseAssessment.getCourseInformation());
			}

			courseAssessment = courseAssessmentRepository.save(courseAssessment);
			return courseAssessment.getId();
		}

		Optional<CourseAssessment> editable = courseAssessmentRepository.findById(courseAssessment.getId());
		if (editable.isPresent()) {
			Optional<CourseInformation> courseInformation = courseInformationRepository
					.findById(courseAssessment.getCourseInformation().getId());
			if (courseInformation.isPresent()) {
				editable.get().setCourseInformation(courseInformation.get());
			}
			editable.get().setCafs1Info(courseAssessment.getCafs1Info());
			editable.get().setCafs2Info(courseAssessment.getCafs2Info());
			editable.get().setCafs3Info(courseAssessment.getCafs3Info());
			editable.get().setCafs6Info(courseAssessment.getCafs6Info());
			editable.get().setCourseInformation(courseAssessment.getCourseInformation());
			editable.get().setCourseSLOs(courseAssessment.getCourseSLOs());
			editable.get().setEndSemesterReviews(courseAssessment.getEndSemesterReviews());
			editable.get().setMidSemesterReviews(courseAssessment.getMidSemesterReviews());

			CourseAssessment assessment = courseAssessmentRepository.save(editable.get());
			return assessment.getId();
		} else {
			return -1;
		}
	}

//	@PutMapping("/endSemesterReview/{courseAssessmentId}")
//	public ResponseEntity<Void> updateEndSemeterReview(@PathVariable long courseAssessmentId,
//			@RequestBody SemesterReview semesterReview) {
//
//		Optional<CourseAssessment> editable = courseAssessmentRepository.findById(courseAssessmentId);
//
//		if (semesterReview.getId() == 0) {
//			semesterReview.setStudent(studentRepository.findById(semesterReview.getStudent().getId()).get());
//			semesterReview.setCourseInformation(
//					courseInformationRepository.findById(editable.get().getCourseInformation().getId()).get());
//			editable.get().getEndSemesterReviews().add(semesterReview);
//		} else {
//			for (SemesterReview review : editable.get().getEndSemesterReviews()) {
//				if (semesterReview.getId() == review.getId()) {
//					review.setGrade(semesterReview.getGrade());
//					review.setSemesterInstructorInteractions(semesterReview.getSemesterInstructorInteractions());
//					review.setSemesterInstructorNotes(semesterReview.getSemesterInstructorNotes());
//					review.setSemesterLearningIssues(semesterReview.getSemesterLearningIssues());
//
//					review.setStudent(studentRepository.findById(semesterReview.getStudent().getId()).get());
//					review.setCourseInformation(
//							courseInformationRepository.findById(semesterReview.getCourseInformation().getId()).get());
//					break;
//				}
//			}
//		}
//		courseAssessmentRepository.save(editable.get());
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
//
//	@PutMapping("/midSemesterReview/{courseAssessmentId}")
//	public ResponseEntity<Void> updateMidSemeterReview(@PathVariable long courseAssessmentId,
//			@RequestBody SemesterReview semesterReview) {
//
//		Optional<CourseAssessment> editable = courseAssessmentRepository.findById(courseAssessmentId);
//
//		if (semesterReview.getId() <= 0) {
//			semesterReview.setStudent(studentRepository.findById(semesterReview.getStudent().getId()).get());
//			semesterReview.setCourseInformation(
//					courseInformationRepository.findById(editable.get().getCourseInformation().getId()).get());
//			editable.get().getMidSemesterReviews().add(semesterReview);
//		} else {
//			for (SemesterReview review : editable.get().getMidSemesterReviews()) {
//				if (semesterReview.getId() == review.getId()) {
//					review.setSemesterInstructorInteractions(semesterReview.getSemesterInstructorInteractions());
//					review.setSemesterInstructorNotes(semesterReview.getSemesterInstructorNotes());
//					review.setSemesterLearningIssues(semesterReview.getSemesterLearningIssues());
//
//					review.setStudent(studentRepository.findById(semesterReview.getStudent().getId()).get());
//					review.setCourseInformation(
//							courseInformationRepository.findById(semesterReview.getCourseInformation().getId()).get());
//					break;
//				}
//			}
//		}
//		courseAssessmentRepository.save(editable.get());
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
}
