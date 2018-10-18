package laroche.chem.assessment.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Cafs1Info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String newSLOs;
	private String upgrades;
	private String enhancements;
	private String modifications;
	private String other;

	public String getNewSLOs() {
		return newSLOs;
	}

	public void setNewSLOs(String newSLOs) {
		this.newSLOs = newSLOs;
	}

	public String getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(String upgrades) {
		this.upgrades = upgrades;
	}

	public String getEnhancements() {
		return enhancements;
	}

	public void setEnhancements(String enhancements) {
		this.enhancements = enhancements;
	}

	public String getModifications() {
		return modifications;
	}

	public void setModifications(String modifications) {
		this.modifications = modifications;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
