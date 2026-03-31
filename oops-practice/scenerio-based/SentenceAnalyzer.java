package scenrioBase;
public class SentenceAnalyzer {

    public static int countWords(String paragraph) {
        paragraph = paragraph.trim();
        if (paragraph.isEmpty()) {
            return 0;
        }
        String[] words = paragraph.split("\\s+");
        return words.length;
    }

    public static String findLongestWord(String paragraph) {
        paragraph = paragraph.trim();
        if (paragraph.isEmpty()) {
            return "";
        }

        String[] words = paragraph.split("\\s+");
        String longest = words[0];

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static String replaceWord(String paragraph, String oldWord, String newWord) {
        if (paragraph.trim().isEmpty()) {
            return paragraph;
        }
        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {

        String paragraph = "   Java is powerful and Java is widely used   ";

        if (paragraph.trim().isEmpty()) {
            System.out.println("The paragraph is empty.");
            return;
        }

        int wordCount = countWords(paragraph);
        String longestWord = findLongestWord(paragraph);
        String updatedParagraph = replaceWord(paragraph, "java", "Python");

        System.out.println("Original Paragraph:");
        System.out.println(paragraph);

        System.out.println();
        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);

        System.out.println();
        System.out.println("Updated Paragraph:");
        System.out.println(updatedParagraph);
    }
}
