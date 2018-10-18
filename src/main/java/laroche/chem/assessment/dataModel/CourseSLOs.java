package laroche.chem.assessment.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class CourseSLOs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private boolean slo1;
	private boolean slo2;
	private boolean slo3;
	private boolean slo4;
	private boolean slo5;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getSlo1() {
		return slo1;
	}

	public void setSlo1(boolean slo1) {
		this.slo1 = slo1;
	}

	public boolean getSlo2() {
		return slo2;
	}

	public void setSlo2(boolean slo2) {
		this.slo2 = slo2;
	}

	public boolean getSlo3() {
		return slo3;
	}

	public void setSlo3(boolean slo3) {
		this.slo3 = slo3;
	}

	public boolean getSlo4() {
		return slo4;
	}

	public void setSlo4(boolean slo4) {
		this.slo4 = slo4;
	}

	public boolean getSlo5() {
		return slo5;
	}

	public void setSlo5(boolean slo5) {
		this.slo5 = slo5;
	}
	
}
