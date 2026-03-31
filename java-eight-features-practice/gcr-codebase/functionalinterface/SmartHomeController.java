package functionalinterface;

interface SmartDevice {

    void turnOn();

    void turnOff();
}


class Light implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Light is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}


class AirConditioner implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is turned OFF");
    }
}


class Television implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Television is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Television is turned OFF");
    }
}


public class SmartHomeController {

    public static void main(String[] args) {

        SmartDevice[] devices = {
            new Light(),
            new AirConditioner(),
            new Television()
        };

        for (SmartDevice device : devices) {
            device.turnOn();
            device.turnOff();
            System.out.println();
        }
    }
}

