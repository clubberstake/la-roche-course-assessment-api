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
public class CourseAssessmentForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String courseNumber;
	private String courseName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id")
	private Classes classes;
	
	@Embedded
	private SectionOne sectionOne;
	
	@Embedded
	private SectionTwo sectionTwo;
	
}
