package oopsPillars;

// interface
interface MedicalRecord {

    void addRecord(String diagnosis);

    void viewRecords();
}

// abstract class
abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    public abstract double calculateBill();

    public void setDetails(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientDetails() {
        return "Patient Id: " + patientId +
               ", Name: " + name +
               ", Age: " + age;
    }
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {

    private String diagnosis;
    private int daysAdmitted;
    private double dailyCharge;

    public void setAdmissionDetails(int daysAdmitted, double dailyCharge) {
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {

    private String diagnosis;
    private double consultationFee;

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }
}

// main class
public class HospitalPatientManagement {

    public static void processPatients(Patient[] patients) {

        for (Patient patient : patients) {

            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill: " + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Patient patient1 = new InPatient();
        Patient patient2 = new OutPatient();

        patient1.setDetails(101, "Aditya", 25);
        patient2.setDetails(202, "Rohit", 30);

        ((InPatient) patient1).setAdmissionDetails(5, 3000);
        ((InPatient) patient1).addRecord("Fracture treatment");

        ((OutPatient) patient2).setConsultationFee(800);
        ((OutPatient) patient2).addRecord("General checkup");

        Patient[] patients = { patient1, patient2 };

        processPatients(patients);
    }
}
