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
	private Set<SemesterReview> midSemesterReviews;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<SemesterReview> endSemesterReviews;

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

	public Set<SemesterReview> getMidSemesterReviews() {
		return midSemesterReviews;
	}

	public void setMidSemesterReviews(Set<SemesterReview> midSemesterReview) {
		this.midSemesterReviews = midSemesterReview;
	}

	public Set<SemesterReview> getEndSemesterReviews() {
		return endSemesterReviews;
	}

	public void setEndSemesterReviews(Set<SemesterReview> endSemesterReview) {
		this.endSemesterReviews = endSemesterReview;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cafs6Info getCafs6Info() {
		return cafs6Info;
	}

	public void setCafs6Info(Cafs6Info cafs6Info) {
		this.cafs6Info = cafs6Info;
	}

	public Cafs3Info getCafs3Info() {
		return cafs3Info;
	}

	public void setCafs3Info(Cafs3Info cafs3Info) {
		this.cafs3Info = cafs3Info;
	}

	public CourseInformation getCourseInformation() {
		return courseInformation;
	}

	public void setCourseInformation(CourseInformation courseInformation) {
		this.courseInformation = courseInformation;
	}

	public CourseSLOs getCourseSLOs() {
		return courseSLOs;
	}

	public void setCourseSLOs(CourseSLOs courseSLOs) {
		this.courseSLOs = courseSLOs;
	}
}
