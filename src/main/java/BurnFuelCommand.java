public class BurnFuelCommand implements ICommand{

    private FuelBurnable fuelBurnable;

    public BurnFuelCommand(FuelBurnable fuelBurnable) {
        this.fuelBurnable = fuelBurnable;
    }


    @Override
    public void execute() {
        fuelBurnable.burnFuel(fuelBurnable.getFuelLevel(), fuelBurnable.getFuelConsumptionSpeed());
    }
}
