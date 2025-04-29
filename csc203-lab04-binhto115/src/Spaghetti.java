/* This class represents a Spaghetti dish with specified noodle diameter and the type of sauce*/
public class Spaghetti implements Stringifiable {
    private final double noodleDiameter;
    private final String sauce;

    /** This constructor creates a new Spaghetti dish with the user's preferred noodle diameter and type of sauce.
     * @param noodleDiameter The 'thickness' of the noodle
     * @param sauce The sauce of your spaghetti*/
    public Spaghetti(double noodleDiameter, String sauce) {
        this.noodleDiameter = noodleDiameter;
        this.sauce = sauce;
    }

    /** This method returns a string represents the Spaghetti dish. */
    public String stringify() {
        return String.format("%s, %s", noodleDiameter, sauce);
    }


    /** This string method returns a string representation of the Spaghetti dish in the String.format format.*/
    @Override
    public String toString(){
        return String.format("%s, %s", noodleDiameter, sauce);
    };


    /** this boolean method compares if the two noodle diameters and sauce are the same.
    * Return true if and only if the specified object is equal to that of the Spaghetti object.
     * Return false otherwise. */
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != getClass()) return false;

        Spaghetti s = (Spaghetti) other;
        return Double.compare(s.noodleDiameter, noodleDiameter) == 0
                && s.sauce.equals(sauce);
    };


    /** This method returns the hash code of the Spaghetti object.
     * if noodleDiameter or sauce is null, this functions return a hash code of 0
     * The hash code is calculated using the formula:
     * 31 * hash * fieldHash*/
    @Override
    public int hashCode(){
        int hash = 1;

        hash = 31 * hash + Double.hashCode(noodleDiameter);

        hash = 31 * hash + ((sauce == null) ? 0 : sauce.hashCode());

        return hash;
    };
}
