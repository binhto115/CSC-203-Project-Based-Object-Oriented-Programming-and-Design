/**
 * A class that represents a screen with width, height, dpi, and on/off state
 * */
public class Screen {
    private final double width;
    private final double height;
    private final int dpi;
    private boolean isOn;

    /** This contructor represents the screen size of a phone
     * @param width The width of the screen
     * @param height The height of the screen
     * @param dpi The number of dots per inch
     * @param isOn Is the phone on?
     **/
    public Screen(double width, double height, int dpi, boolean isOn) {
        this.width = width;
        this.height = height;
        this.dpi = dpi;
        this.isOn = isOn;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public void setIsOn (boolean isOn){
        this.isOn = isOn;
    }

    /**
     * This method calculates the number of screen pixels of a phone
     **/
    public double numberOfPixels() {
        return height * width * Math.pow(dpi, 2);
    }


    /**
     * This method returns the number of screen pixels if the screen is on. Otherwise, it returns null
     * if the screen is off*/
    public String display () {
        if (isOn) {
            return "The Number of Screen Pixels is " + numberOfPixels();
        }
        return null;
    }
}
