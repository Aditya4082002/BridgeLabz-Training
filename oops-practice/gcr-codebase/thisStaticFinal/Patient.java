package thisStaticFinal;

public class Patient {

	//static variable 
	static String hospitalName = "City Hospital"; 
	static int totalPatient = 0;
		
	//instance variables
	private String name;
	private int age;
	private String aliment;
	private final String patientId; //can not be changed
		
	//static methods
	public static void displayHospitalName() {
		System.out.println("Hospital Name : "  + hospitalName);
	}
	
	public static void displayTotalPatient() {
		System.out.println("Total Patient Admitted : "  + totalPatient);
	}
		
	//constructor
	public Patient(String patientId,String name,int age, String aliment){
		this.name = name;
		this.age = age;
		this.patientId = patientId;
		this.aliment = aliment;
		totalPatient++;
	}
		
	//method to display details
	public void displayDetails() {
		if(this instanceof Patient) {
			displayHospitalName();
			System.out.println("Patient Id : " + patientId);
			System.out.println("Name : " + name);
			System.out.println("Age: " + age);
			System.out.println("Aliment : " + aliment);
		}else {
			System.out.println("Invalid Object");
		}
	}
		
	//main method 
	public static void main(String[] args) {
		Patient patient1 = new Patient("P001","Lathika",30,"Flu");
		Patient patient2 = new Patient("P002","Lidiya",45,"Fracture");
		displayTotalPatient();
		patient1.displayDetails();
		patient2.displayDetails();
	}
}
