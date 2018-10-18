package laroche.chem.assessment.dataModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class CourseInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id")
	private FileStorage syllabus;

	private String semester;
	private String courseNumberAndSection;
	private String courseTitle;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FileStorage getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(FileStorage syllabus) {
		this.syllabus = syllabus;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getcourseNumberAndSection() {
		return courseNumberAndSection;
	}

	public void setcourseNumberAndSection(String courseNumberAndSection) {
		this.courseNumberAndSection = courseNumberAndSection;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
