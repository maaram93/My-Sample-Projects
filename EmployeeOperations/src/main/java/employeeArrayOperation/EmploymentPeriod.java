package employeeArrayOperation;

import java.util.Calendar;


public class EmploymentPeriod {
	
	Calendar startdate;
	Calendar enddate;
	
	public EmploymentPeriod() {
		
	}
	
	
	public EmploymentPeriod(Calendar startdate, Calendar enddate) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public Calendar getStartdate() {
		return startdate;
	}
	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}
	public Calendar getEnddate() {
		return enddate;
	}
	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}

}
