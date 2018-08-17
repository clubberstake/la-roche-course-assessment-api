package laroche.chem.assessment.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@Embeddable
public class SectionOne {
	
	private String newSLOs;
	private String upgrades;
	private String enhancements;
	private String modifications;
	private String other;
	
	public SectionOne() {}
}
