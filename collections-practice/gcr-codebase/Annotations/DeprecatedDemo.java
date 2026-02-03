package Annotations;

class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature is deprecated. Avoid using it.");
    }

    public void newFeature() {
        System.out.println("New feature is recommended.");
    }
}


public class DeprecatedDemo {

    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   //Compiler warning
        api.newFeature();   //Recommended method
    }
}

