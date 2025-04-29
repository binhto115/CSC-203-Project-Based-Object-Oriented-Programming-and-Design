/**
 * A class that represents a smartphone with a screen and an operating system
 * */
public class SmartPhone extends Screen{
    private final String operatingSystem;

    public SmartPhone(String operatingSystem, double width, double height, int dpi, boolean isOn) {
        super(width, height, dpi, isOn);
        this.operatingSystem = operatingSystem;
    }

    /** Overriding the display method from the Screen class to display
     * the number of screen pixels
     * */
    @Override
    public String display() {
        if (getIsOn()) {
            return operatingSystem;
        }
        return null;
    }

    /**
     * This method returns 'ringringring' if the SmartPhone's inherited isOn
     * is true. Otherwise, it returns null*/
    public String call() {
        if (getIsOn()) {
            return "ringringring";
        }
        return null;
    }
}
