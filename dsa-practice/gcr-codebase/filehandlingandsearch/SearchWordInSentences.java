package filehandlingandsearch;

class SearchWordInSentences {

    public static String findSentence(String[] sentences, String word) {

        for (int i = 0; i < sentences.length; i++) {

            // Check if the sentence contains the word
            if (sentences[i].toLowerCase().contains(word.toLowerCase())) {
                return sentences[i];
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {"Java is easy to learn","I love programming","Data structures are important","Searching is a useful concept"};

        String word = "data";

        String result = findSentence(sentences, word);

        System.out.println("Result: " + result);
    }
}

