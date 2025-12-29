class Solution {
    public static void main(String[] args){
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        } 
        else{
            long reverseNumber=0;
            int copyNumber=x;
            while(copyNumber>0){
                int digit=copyNumber%10;
                copyNumber = copyNumber/10;
                reverseNumber = reverseNumber*10 + digit;
            }
            if(reverseNumber==x){
                return true;
            }
            else{
                return false;
            }
        }
    }
}