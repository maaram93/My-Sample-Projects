package imcs.JSON.POJOS;

import java.util.List;

public class Marks {

	
    private List<String> subject;
    private List<Float> marks;
    private float maxMarks;
	public Marks(List<String> subject, List<Float> marks, float maxMarks) {
		super();
		this.subject = subject;
		this.marks = marks;
		this.maxMarks = maxMarks;
	}
	public Marks() {
		super();
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	public List<Float> getMarks() {
		return marks;
	}
	public void setMarks(List<Float> marks) {
		this.marks = marks;
	}
	public float getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(float maxMarks) {
		this.maxMarks = maxMarks;
	}
	@Override
	public String toString() {
		return "Marks [subject=" + subject + ", marks=" + marks + ", maxMarks=" + maxMarks + "]";
	}
    
    
}
