public class FireLizard extends PhotosynthesizingCreature {
    public double fireTemperatureInCelsius;
    public FireLizard(double fireTemperatureInCelsius) {
        this.fireTemperatureInCelsius = fireTemperatureInCelsius;
    }

    @Override
    public void doAction() {
        System.out.printf("The lizard breathed a %.1f\u00B0C fire!%n", fireTemperatureInCelsius);
    }
}
