//a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade
class StudentScoreCard {
    public static void main(String[] args) {

        int numberOfStudents = 5; 

        int[][] pcmScores = generatePCMScores(numberOfStudents);
        double[][] calculations = calculateTotalAveragePercentage(pcmScores);
        String[][] grades = calculateGrades(calculations);

        displayScoreCard(pcmScores, calculations, grades);
    }

    // Method to generate random 2-digit PCM scores
    static int[][] generatePCMScores(int n) {

        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10; // Physics
            scores[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }
        return scores;
    }

    // Method to calculate total, average and percentage
    static double[][] calculateTotalAveragePercentage(int[][] scores) {

        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = average;

            // Round off to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // Method to calculate grade based on percentage
    static String[][] calculateGrades(double[][] calculations) {

        String[][] gradeData = new String[calculations.length][1];

        for (int i = 0; i < calculations.length; i++) {

            double percentage = calculations[i][2];

            if (percentage >= 80) {
                gradeData[i][0] = "A";
            } else if (percentage >= 70) {
                gradeData[i][0] = "B";
            } else if (percentage >= 60) {
                gradeData[i][0] = "C";
            } else if (percentage >= 50) {
                gradeData[i][0] = "D";
            } else if (percentage >= 40) {
                gradeData[i][0] = "E";
            } else {
                gradeData[i][0] = "R";
            }
        }
        return gradeData;
    }

    // Method to display scorecard
    static void displayScoreCard(int[][] scores, double[][] calculations, String[][] grades) {

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAverage\t\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" +
                calculations[i][0] + "\t" + calculations[i][1] + "\t\t" + calculations[i][2] + "\t\t" + grades[i][0] );
        }

        System.out.println("--------------------------------------------------------------------------");
    }
}