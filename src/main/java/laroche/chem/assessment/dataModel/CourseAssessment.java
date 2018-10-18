package laroche.chem.assessment.dataModel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class CourseAssessment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private CourseInformation courseInformation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseSLOs_id")
	private CourseSLOs courseSLOs;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cafs1Info_id")
	private Cafs1Info cafs1Info;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cafs2Info_id")
	private Cafs2Info cafs2Info;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cafs3Info_id")
	private Cafs3Info cafs3Info;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cafs6Info_id")
	private Cafs6Info cafs6Info;

	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "midSemesterReview_id")
	private Set <SemesterReview> midSemesterReview;

	@OneToMany(cascade = CascadeType.ALL)
	private Set <SemesterReview> endSemesterReview;

	private CourseSLOs getCourseSLOs() {
		return courseSLOs;
	}

	private void setCourseSLOs(CourseSLOs courseSLOs) {
		this.courseSLOs = courseSLOs;
	}

	private CourseInformation getCourseInformation() {
		return courseInformation;
	}

	private void setCourseInformation(CourseInformation courseInformation) {
		this.courseInformation = courseInformation;
	}

	public Cafs1Info getCafs1Info() {
		return cafs1Info;
	}

	public void setCafs1Info(Cafs1Info cafs1Info) {
		this.cafs1Info = cafs1Info;
	}

	public Cafs2Info getCafs2Info() {
		return cafs2Info;
	}

	public void setCafs2Info(Cafs2Info cafs2Info) {
		this.cafs2Info = cafs2Info;
	}

	private Cafs3Info getCafs3Info() {
		return cafs3Info;
	}

	private void setCafs3Info(Cafs3Info cafs3Info) {
		this.cafs3Info = cafs3Info;
	}

	public Set<SemesterReview> getMidSemesterReview() {
		return midSemesterReview;
	}

	public void setMidSemesterReview(Set<SemesterReview> midSemesterReview) {
		this.midSemesterReview = midSemesterReview;
	}

	public Set<SemesterReview> getEndSemesterReview() {
		return endSemesterReview;
	}

	public void setEndSemesterReview(Set<SemesterReview> endSemesterReview) {
		this.endSemesterReview = endSemesterReview;
	}

//	public courseInformation: CourseInformation, public courseSLOs: CourseSLOs, public cafs1Info: Cafs1Info, public cafs2Info: Cafs2Info,
//    public cafs3Info: Cafs3Info, public cafs6Info: Cafs6Info,
//    public midSemesterReviews: Array<SemesterReview>, public endSemesterReviews: Array<SemesterReview>

}
