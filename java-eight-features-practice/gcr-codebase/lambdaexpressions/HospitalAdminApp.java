package lambdaexpressions;
import java.util.*;

class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

public class HospitalAdminApp {

    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
            new Patient(101, "Ravi"),
            new Patient(102, "Anita"),
            new Patient(103, "Suresh")
        );

        // 🔹 Print patient IDs using method reference
        patients.stream()
                .map(Patient::getId)
                .forEach(System.out::println);
    }
}
