package laroche.chem.assessment.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Cafs2Info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String chemConcept;
	private String objectivesContent;
	private String generalComments;
	private int percentA;
	private int percentB;
	private int percentC;
	private int percentD;
	private int percentF;

	public String getChemConcept() {
		return chemConcept;
	}

	public void setChemConcept(String chemConcept) {
		this.chemConcept = chemConcept;
	}

	public String getObjectivesContent() {
		return objectivesContent;
	}

	public void setObjectivesContent(String objectivesContent) {
		this.objectivesContent = objectivesContent;
	}

	public String getGeneralComments() {
		return generalComments;
	}

	public void setGeneralComments(String generalComments) {
		this.generalComments = generalComments;
	}

	public int getPercentA() {
		return percentA;
	}

	public void setPercentA(int percentA) {
		this.percentA = percentA;
	}

	public int getPercentB() {
		return percentB;
	}

	public void setPercentB(int percentB) {
		this.percentB = percentB;
	}

	public int getPercentC() {
		return percentC;
	}

	public void setPercentC(int percentC) {
		this.percentC = percentC;
	}

	public int getPercentD() {
		return percentD;
	}

	public void setPercentD(int percentD) {
		this.percentD = percentD;
	}

	public int getPercentF() {
		return percentF;
	}

	public void setPercentF(int percentF) {
		this.percentF = percentF;
	}

}
