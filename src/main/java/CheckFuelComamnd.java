public class CheckFuelComamnd implements ICommand {

    private FuelCheckable fuelCheckable;

    public CheckFuelComamnd(FuelCheckable fuelCheckable) {
        this.fuelCheckable = fuelCheckable;
    }

    @Override
    public void execute(){
        try {
            fuelCheckable.checkFuel();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("CommandException");
        }
    }
}
