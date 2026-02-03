package Annotations;

import java.util.ArrayList;

public class SuppressWarningDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();   // Raw type

        list.add("Java");
        list.add(100);

        String value = (String) list.get(0);
        System.out.println(value);
    }
}

