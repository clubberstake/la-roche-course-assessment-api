package laroche.chem.assessment.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@Embeddable
public class SectionTwo {

	private String chemConcept;
	private String objectivesContent;
	private String generalComments;
	private String percentA;
	private String percentB;
	private String percentC;
	private String percentD;
	private String percentF;
}
