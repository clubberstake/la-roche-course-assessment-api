package laroche.chem.assessment.dataModel;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class SemesterReview {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id")
	private CourseInformation courseInformation;
	
	@Embedded
	private SemesterLearningIssues semesterLearningIssues;
	
	private String semesterInstructorInteractions;
	private String semesterInstructorNotes;
	private String grade;

	public String getSemesterInstructorInteractions() {
		return semesterInstructorInteractions;
	}

	public void setSemesterInstructorInteractions(String semesterInstructorInteractions) {
		this.semesterInstructorInteractions = semesterInstructorInteractions;
	}

	public String getSemesterInstructorNotes() {
		return semesterInstructorNotes;
	}

	public void setSemesterInstructorNotes(String semesterInstructorNotes) {
		this.semesterInstructorNotes = semesterInstructorNotes;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SemesterLearningIssues getSemesterLearningIssues() {
		return semesterLearningIssues;
	}

	public void setSemesterLearningIssues(SemesterLearningIssues semesterLearningIssues) {
		this.semesterLearningIssues = semesterLearningIssues;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CourseInformation getCourseInformation() {
		return courseInformation;
	}

	public void setCourseInformation(CourseInformation courseInformation) {
		this.courseInformation = courseInformation;
	}

}
