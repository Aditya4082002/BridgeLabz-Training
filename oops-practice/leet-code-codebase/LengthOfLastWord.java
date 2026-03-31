public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        return array[array.length-1].length();
    }

    public static void main(String[] args) {
        String s ="Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}

