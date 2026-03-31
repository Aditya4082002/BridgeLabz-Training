class DefangIP {
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
    public static void main(String[] args) {
        String ip = "255.100.50.0";
        System.out.println(defangIPaddr(ip));
    }
}

