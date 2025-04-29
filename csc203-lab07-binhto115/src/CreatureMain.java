public class CreatureMain {
    public static void main(String[] args) {
        // Change to constructor calls
        GrassDinosaur dinosaur = new GrassDinosaur("rose");
        PhotosynthesizingCreature lizard = new FireLizard(600.0);
        WaterTurtle turtle = new WaterTurtle();

        dinosaur.doAction();
        lizard.doAction();
        turtle.doAction();

        dinosaur.protect(); // Typecast as needed
        //lizard.protect(); // Comment out
        turtle.protect(); // Typecast as needed

        dinosaur.photosynthesize(); // Typecast as needed
        lizard.photosynthesize(); // Typecast as needed
        //turtle.photosynthesize(); // Comment out
    }
}
