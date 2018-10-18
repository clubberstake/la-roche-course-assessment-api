package laroche.chem.assessment.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Cafs6Info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String depReview;
	private String depReviewer;
	private String newActPlan;
	private String newBudgItem;
	private String divChairReview;
	private String divChairSig;
	private String divChairRevDate;

	public String getDepReview() {
		return depReview;
	}

	public void setDepReview(String depReview) {
		this.depReview = depReview;
	}

	public String getDepReviewer() {
		return depReviewer;
	}

	public void setDepReviewer(String depReviewer) {
		this.depReviewer = depReviewer;
	}

	public String getNewActPlan() {
		return newActPlan;
	}

	public void setNewActPlan(String newActPlan) {
		this.newActPlan = newActPlan;
	}

	public String getNewBudgItem() {
		return newBudgItem;
	}

	public void setNewBudgItem(String newBudgItem) {
		this.newBudgItem = newBudgItem;
	}

	public String getDivChairReview() {
		return divChairReview;
	}

	public void setDivChairReview(String divChairReview) {
		this.divChairReview = divChairReview;
	}

	public String getDivChairSig() {
		return divChairSig;
	}

	public void setDivChairSig(String divChairSig) {
		this.divChairSig = divChairSig;
	}

	public String getDivChairRevDate() {
		return divChairRevDate;
	}

	public void setDivChairRevDate(String divChairRevDate) {
		this.divChairRevDate = divChairRevDate;
	}

}
