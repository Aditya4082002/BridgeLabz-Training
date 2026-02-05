package lambdaexpressions;

@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHomeLighting {

    public static void main(String[] args) {

        // Motion detected → turn on bright white lights
        LightAction motionTrigger = () ->System.out.println("Motion detected: Bright white lights ON");

        // Evening time → warm dim lights
        LightAction eveningTrigger = () ->System.out.println("Evening mode: Warm dim lights ON");

        // Voice command → party mode
        LightAction voiceTrigger = () ->System.out.println("Voice command received: Party lights ON");

        // Activate triggers
        motionTrigger.activate();
        eveningTrigger.activate();
        voiceTrigger.activate();
    }
}
