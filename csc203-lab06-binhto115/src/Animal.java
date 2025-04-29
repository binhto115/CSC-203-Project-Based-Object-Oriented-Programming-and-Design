public abstract class Animal {

    private final String scientificName;

    public Animal(String scientificName) {this.scientificName = scientificName;}

    public abstract String vocalize();

    public abstract  String move();

    public String getScientificName() {return this.scientificName;}
}
