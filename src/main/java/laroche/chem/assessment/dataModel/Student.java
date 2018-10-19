package laroche.chem.assessment.dataModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_photo_id")
	private FileStorage file;

	private String studentName;
	private String studentMajor;
	private String studentYear;
	private String studentSemester;
	private String studentMathGrade;
	private String studentAthletics;
	private String studentHousingStatus;
	private String studentHonors;
	private String internationalStudent;

	@Column(unique = true)
	private String emailAddress;

	private String time;
	private String author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMajor() {
		return studentMajor;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	public String getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(String studentYear) {
		this.studentYear = studentYear;
	}

	public String getStudentSemester() {
		return studentSemester;
	}

	public void setStudentSemester(String studentSemester) {
		this.studentSemester = studentSemester;
	}

	public String getStudentMathGrade() {
		return studentMathGrade;
	}

	public void setStudentMathGrade(String studentMathGrade) {
		this.studentMathGrade = studentMathGrade;
	}

	public String getStudentAthletics() {
		return studentAthletics;
	}

	public void setStudentAthletics(String studentAthletics) {
		this.studentAthletics = studentAthletics;
	}

	public String getStudentHousingStatus() {
		return studentHousingStatus;
	}

	public void setStudentHousingStatus(String studentHousingStatus) {
		this.studentHousingStatus = studentHousingStatus;
	}

	public String getStudentHonors() {
		return studentHonors;
	}

	public void setStudentHonors(String studentHonors) {
		this.studentHonors = studentHonors;
	}

	public String getInternationalStudent() {
		return internationalStudent;
	}

	public void setInternationalStudent(String internationalStudent) {
		this.internationalStudent = internationalStudent;
	}

	public FileStorage getFile() {
		return file;
	}

	public void setFile(FileStorage file) {
		this.file = file;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
