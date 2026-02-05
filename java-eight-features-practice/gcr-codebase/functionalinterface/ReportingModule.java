package functionalinterface;

interface DataExporter {

    void exportToCSV();

    void exportToPDF();

    default void exportToJSON() {
        System.out.println("Exporting data to JSON using default implementation");
    }
}


class ReportExporter implements DataExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Data exported to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Data exported to PDF");
    }
}


class AdvancedReportExporter implements DataExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Advanced CSV export");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Advanced PDF export");
    }

    @Override
    public void exportToJSON() {
        System.out.println("Advanced JSON export");
    }
}


public class ReportingModule {

    public static void main(String[] args) {

        DataExporter basic = new ReportExporter();
        DataExporter advanced = new AdvancedReportExporter();

        basic.exportToCSV();
        basic.exportToPDF();
        basic.exportToJSON();

        System.out.println();

        advanced.exportToCSV();
        advanced.exportToPDF();
        advanced.exportToJSON();
    }
}

