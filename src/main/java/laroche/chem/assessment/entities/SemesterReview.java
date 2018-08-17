package laroche.chem.assessment.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	private Classes classes;
	
	@Embedded
	private SemesterLearningIssues semesterLearningIssues;
	
	private SemesterPartition semesterPartiton;
	private String semesterInstructorInteractions;
	private String semesterInstructorNotes;

	public SemesterReview() {
	}

}
