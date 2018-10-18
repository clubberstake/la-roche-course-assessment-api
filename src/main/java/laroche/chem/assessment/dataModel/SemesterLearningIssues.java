package laroche.chem.assessment.dataModel;

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
	
	public boolean isCoursePace() {
		return coursePace;
	}
	public void setCoursePace(boolean coursePace) {
		this.coursePace = coursePace;
	}
	public boolean isLackOfMindset() {
		return lackOfMindset;
	}
	public void setLackOfMindset(boolean lackOfMindset) {
		this.lackOfMindset = lackOfMindset;
	}
	public boolean isLackOfCuriosity() {
		return lackOfCuriosity;
	}
	public void setLackOfCuriosity(boolean lackOfCuriosity) {
		this.lackOfCuriosity = lackOfCuriosity;
	}
	public boolean isLackOfEffortOrFocus() {
		return lackOfEffortOrFocus;
	}
	public void setLackOfEffortOrFocus(boolean lackOfEffortOrFocus) {
		this.lackOfEffortOrFocus = lackOfEffortOrFocus;
	}
	public boolean isPoorTimeManagement() {
		return poorTimeManagement;
	}
	public void setPoorTimeManagement(boolean poorTimeManagement) {
		this.poorTimeManagement = poorTimeManagement;
	}
	public boolean isHealthIssues() {
		return healthIssues;
	}
	public void setHealthIssues(boolean healthIssues) {
		this.healthIssues = healthIssues;
	}
	public boolean isComplacence() {
		return complacence;
	}
	public void setComplacence(boolean complacence) {
		this.complacence = complacence;
	}
	public boolean isEmploymentHours() {
		return employmentHours;
	}
	public void setEmploymentHours(boolean employmentHours) {
		this.employmentHours = employmentHours;
	}
	public boolean isOther() {
		return other;
	}
	public void setOther(boolean other) {
		this.other = other;
	}

}
