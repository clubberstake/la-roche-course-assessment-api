package laroche.chem.assessment.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Cafs3Info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String coursePreReq;
	private String textbooks;
	private String studentAsse;
	private String pedagogy;
	private String faculty;
	private String minorCapitalEq;
	private String other;

	public String getCoursePreReq() {
		return coursePreReq;
	}

	public void setCoursePreReq(String coursePreReq) {
		this.coursePreReq = coursePreReq;
	}

	public String getTextbooks() {
		return textbooks;
	}

	public void setTextbooks(String textbooks) {
		this.textbooks = textbooks;
	}

	public String getPedagogy() {
		return pedagogy;
	}

	public void setPedagogy(String pedagogy) {
		this.pedagogy = pedagogy;
	}

	public String getStudentAsse() {
		return studentAsse;
	}

	public void setStudentAsse(String studentAsse) {
		this.studentAsse = studentAsse;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getMinorCapitalEq() {
		return minorCapitalEq;
	}

	public void setMinorCapitalEq(String minorCapitalEq) {
		this.minorCapitalEq = minorCapitalEq;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
