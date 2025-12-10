public class Smartphone {
    private Battery battery;
    private Display display;
    private Processor processor;
    private String brand;
    private String model;
    public Smartphone(String brand, String model, Battery battery, Display display, Processor processor) {
        this.brand = brand;
        this.model = model;
        this.battery = battery;
        this.display = display;
        this.processor = processor;
    }
    public Smartphone(String brand, String model, int batteryCapacity, double displaySize, String resolution, String processorModel, double processorSpeed) {
        this.brand = brand;
        this.model = model;
        Battery battery = new Battery(batteryCapacity);
        Display display = new Display(displaySize, resolution);
        Processor processor = new Processor(processorModel, processorSpeed);
        this.battery = battery;
        this.display = display;
        this.processor = processor;
    }
    public String powerOn() {
        if (!battery.isCharged()) {
            return "Cannot power on: Battery depleted";
        }
        display.setState(true);
        return "Powering on" + this.brand + " " + this.model;
    }
    public String powerOff() {
        display.setState(false);
        return "Powering off" + this.brand + " " + this.model;
    }
    public void chargeBattery() {
        battery.charge();
    }
    public String runApp(String appName) {
        if (!display.getState()) {
            return "Phone is off. Cannot run " + appName;
        }
        return appName + " running.";
    }
    public void upgradeComponent(Battery newBattery) {
        this.battery = newBattery;
    }
    public void upgradeComponent(Display newDisplay) {
        this.display = newDisplay;
    }
    public void upgradeComponent(Processor newProcessor) {
        this.processor = newProcessor;
    }
    @Override
    public String toString() {
        return this.brand + " " + this.model + " Smartphone\n" + battery.toString() + "\n" + display.toString() + "\n" + processor.toString();
    }
}
