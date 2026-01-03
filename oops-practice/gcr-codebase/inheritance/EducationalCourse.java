package inheritance;

//class definition 
class Course{
	//attributes
	protected String courseName;
	protected String duration;
	
	//constructor
	Course(String courseName,String duration){
		this.courseName = courseName;
		this.duration=duration;
	}
	
	public void displayInfo() {
		System.out.println("Course Name : " + courseName);
		System.out.println("duration : " + duration);
	}
}

//class definition 
class OnlineCourse extends Course{
	//attributes
	protected String platform;
	protected boolean isRecorded;
	
	//constructor
	OnlineCourse(String courseName,String duration,String platform,boolean isRecorded){
		super(courseName,duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Platform : " + platform);
		System.out.println("isRecorded : " + isRecorded);
	}
}

//class definition 
class PaidOnlineCourse extends OnlineCourse{
	//attributes
	protected int fee;
	protected int discount;
	PaidOnlineCourse(String courseName,String duration,String platform,boolean isRecorded,int fee,int discount){
		super(courseName,duration,platform,isRecorded);
		this.fee = fee;
		this.discount = discount;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Fee : " + fee);
		System.out.println("discount : " + discount);
	}
}

public class EducationalCourse {

	public static void main(String[] args) {
		PaidOnlineCourse paidOnlineCourse1 = new PaidOnlineCourse("MCA","2 years","zoom",true,2500000,10);
		paidOnlineCourse1.displayInfo();
	}

}
