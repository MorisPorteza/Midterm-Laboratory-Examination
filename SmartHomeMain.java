public class SmartHomeSystem {

static class Device {
protected String deviceName;
protected String status;
protected String location;
protected static int deviceCount = 0;

public Device() {
this.deviceName = "";
this.status = "OFF";
this.location = "";
deviceCount++;
}

public Device(String deviceName, String status, String location) {
this.deviceName = deviceName;
this.status = status;
this.location = location;
deviceCount++;
}

public void turnOn() {
status = "ON";
}

public void turnOff() {
status = "OFF";
}

public void displayInfo() {
System.out.println("Device Name: " + deviceName);
System.out.println("Status: " + status);
System.out.println("Location: " + location);
}

public static void showDeviceCount() {
System.out.println("Total number of devices: " + deviceCount);
}}

static class LightBulb extends Device {
private int brightnessLevel;
private String color;

public LightBulb(String deviceName, String status, String location, int brightnessLevel, String color) {
super(deviceName, status, location);
this.brightnessLevel = brightnessLevel;
this.color = color;
}

public LightBulb(String deviceName, String location) {
super(deviceName, "OFF", location);
this.brightnessLevel = 50;
this.color = "Warm White";
}

public void adjustBrightness(int level) {
brightnessLevel = level;
}

@Override
public void displayInfo() {
super.displayInfo();
System.out.println("Brightness Level: " + brightnessLevel);
System.out.println("Color: " + color);
}}

static class Thermostat extends Device {
private double temperature;
private String mode;

public Thermostat(String deviceName, String status, String location, double temperature, String mode) {
super(deviceName, status, location);
this.temperature = temperature;
this.mode = mode;
}

public void setTemperature(double temp) {
this.temperature = temp;
}

public void setTemperature(double temp, String mode) {
this.temperature = temp;
this.mode = mode;
}

@Override
public void displayInfo() {
super.displayInfo();
System.out.println("Temperature: " + temperature + "°C");
System.out.println("Mode: " + mode);
}}

static class SmartHomeController {
private Device[] devices;
public SmartHomeController(Device[] devices) {
this.devices = devices;
}

public void turnAllOn() {
for (Device d : devices) {
d.turnOn();
}}

public void turnAllOff() {
for (Device d : devices) {
d.turnOff();
}}}

public static void main(String[] args) {
LightBulb b1 = new LightBulb("Porteza Bulb", "OFF", "Winter Hallway", 75, "Cool White");
Thermostat th1 = new Thermostat("Gumiran Thermostat", "OFF", "Cabbage Room", 24.5, "Cooling");
Thermostat th2 = new Thermostat("Montabon Thermostat", "OFF", "Kernel Room", 26.0, "Heating");

Device[] devices = { b1, th1, th2 };

SmartHomeController controller = new SmartHomeController(devices);
controller.turnAllOn();

for (Device d : devices) {
d.displayInfo();
System.out.println();
}

Device.showDeviceCount();
}
}


