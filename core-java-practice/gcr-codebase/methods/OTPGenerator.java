public class OTPGenerator {

    public static void main(String[] args) {

        int[] otps = new int[10];

        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        System.out.print("Generated OTPs: ");
        for (int otp : otps) {
            System.out.print(otp + " ");
        }

        System.out.println("\nAre all OTPs unique: " + areOTPsUnique(otps));
    }

    static int generateOTP() {

        return 100000 + (int)(Math.random() * 900000);
    }

    static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
