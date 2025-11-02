// Superclass Device
class Device {

// Attributes
protected String deviceName;
    
protected String status;

protected String location;

protected static int deviceCount = 0;

// Constructors
// Default Constructor
public Device() {
deviceCount++;
}

// Parameterized Constructor to Set all Attributes
public Device(String deviceName, String status, String location) {
this.deviceName = deviceName;
this.status = status;
this.location = location;
deviceCount++;
}

// Methods
// turnOn() method
public void turnOn() {
status = "ON";
}
  
// turnOff() method
public void turnOff() {
status = "OFF";
}
  
// displayInfo() method
public void displayInfo() {
System.out.println("Device Name: " + deviceName);
System.out.println("Status: " + status);
System.out.println("Location: " + location);
System.out.println();
}

// showDeviceCount() method
public static void showDeviceCount() {
System.out.println("Total Number of Devices: " + deviceCount);
}}


// LightBulb Subclass 
class LightBulb extends Device {

// Additional Attributes
private int brightnessLevel;

private String color;

// Constructors
// Constructor with Full Parameters
public LightBulb(String deviceName, String status, String location, int brightnessLevel, String color) {
super(deviceName, status, location);
this.brightnessLevel = brightnessLevel;
this.color = color;
}

// Constructor with just the deviceName and location
public LightBulb(String deviceName, String location) {
super(deviceName, "OFF", location); // The lightbulb starts OFF but keeps a default brightnessLevel and color.
this.brightnessLevel = 50; 
this.color = "Warm White";
}

// Methods
// Overriding displayInfo() method to include brightness and color
@Override
public void displayInfo() {
System.out.println("Device Name: " + deviceName);
System.out.println("Status: " + status);
System.out.println("Location: " + location);
System.out.println("Brightness Level: " + brightnessLevel);
System.out.println("Color: " + color);
System.out.println();
}

// adjustBrightness(int level) method
public void adjustBrightness(int level) {
if (level >= 0 && level <= 100) {
brightnessLevel = level;
} else {
System.out.println("Invalid input. The brightness level must be within the range 0 to 100.");
}}}


// Thermostat Subclass
class Thermostat extends Device {

// Additional Attributes
private double temperature;

private String mode;

// Constructor
public Thermostat(String deviceName, String status, String location, double temperature, String mode) {
super(deviceName, status, location);
this.temperature = temperature;
this.mode = mode;
}

// Methods
// Overriding displayInfo() method to include current temperature and mode
@Override
public void displayInfo() {
System.out.println("Device Name: " + deviceName);
System.out.println("Status: " + status);
System.out.println("Location: " + location);
System.out.println("Temperature: " + temperature + "°C");
System.out.println("Mode: " + mode);
System.out.println();
}

// setTemperature (accepts double temp)
public void setTemperature(double temp) {
this.temperature = temp;
}

// setTemperature (accepts both double temp and String mode)
public void setTemperature(double temp, String mode) {
this.temperature = temp;
this.mode = mode;
}}


// SmartHomeController Class
class SmartHomeController {

private Device[] devices;

// Constructor that Accepts any Created Device Array as a Parameter
public SmartHomeController(Device[] devices) {
this.devices = devices;
}

// Methods
// Method that can Turn all Devices ON
public void turnAllOn() {
for (Device d : devices) {
d.turnOn();
}}

// Method that can Turn all Devices OFF
public void turnAllOff() {
for (Device d : devices) {
d.turnOff();
}}}


// Main Class
public class SmartHomeMain {

public static void main(String[] args) {
        
// 1 Instance of LightBulb and 2 Instances of Thermostat
LightBulb b1 = new LightBulb("Porteza Light Bulb", "OFF", "Bedroom", 68, "Cool White");

Thermostat th1 = new Thermostat("Gumiran Thermostat", "OFF", "Kitchen", 25.3, "Cooling");

Thermostat th2 = new Thermostat("Montabon Thermostat", "OFF", "Hallway", 23.2, "Heating");

// Array of Devices added in the Program
Device[] devices = { b1, th1, th2 };

// SmartHomeController object used to Manage All Devices
SmartHomeController controller = new SmartHomeController(devices); 
// Turning All Devices ON in order to demonstrate the use of the turnAllOn() method
controller.turnAllOn();
// Added for demonstration only. We wanted to show that the SmartHomeController class and methods work properly.

// Display Information of All Devices
for (Device d : devices) {
d.displayInfo();
}

// Display the Total Number of Devices using the showDeviceCount() method
Device.showDeviceCount(); // Added for demonstration only. We wanted to show that the showDeviceCount() method works properly.
}}
