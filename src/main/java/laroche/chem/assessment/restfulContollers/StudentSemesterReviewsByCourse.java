package laroche.chem.assessment.restfulContollers;

import java.util.List;

import laroche.chem.assessment.dataModel.CourseInformation;
import laroche.chem.assessment.dataModel.SemesterReview;

public class StudentSemesterReviewsByCourse {
	
	private CourseInformation courseInformation;
	private List<SemesterReview> semesterReviews;

	public CourseInformation getCourseInformation() {
		return courseInformation;
	}

	public void setCourseInformation(CourseInformation courseInformation) {
		this.courseInformation = courseInformation;
	}

	public List<SemesterReview> getSemesterReviews() {
		return semesterReviews;
	}

	public void setSemesterReviews(List<SemesterReview> semesterReviews) {
		this.semesterReviews = semesterReviews;
	}
	

}
