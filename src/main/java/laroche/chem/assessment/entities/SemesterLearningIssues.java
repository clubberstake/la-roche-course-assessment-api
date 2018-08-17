package laroche.chem.assessment.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class SemesterLearningIssues {

	private boolean coursePace;
	private boolean lackOfMindset;
	private boolean lackOfCuriosity;
	private boolean lackOfEffortOrFocus;
	private boolean poorTimeManagement;
	private boolean healthIssues;
	private boolean complacence;
	private boolean employmentHours;
	private boolean other;

}
