class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n*(n+1)/2;
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        return total-sum;
    }
    public static void main(String[] args) {
        int[] nums = {9,5,8,6,3,0,1,2,7};
        System.out.println(missingNumber(nums));
    }
}