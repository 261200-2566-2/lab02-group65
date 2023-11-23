import java.util.Scanner;

public class Lab02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AirPurifier myAirPurifier = AirPurifier.createAirPurifier(scanner);
        int aqi = AirPurifier.getAqiInput(scanner);

        // Turn on the air purifier
        myAirPurifier.checkAQI(aqi);
        System.out.println(" ");
        myAirPurifier.turnOn();

        // Run the air purifier (simulating its operation)
        myAirPurifier.run();

        // Check filter status
        myAirPurifier.checkFilterStatus();

        // Replace the filter
        myAirPurifier.replaceFilter(scanner);

        // Turn off the air purifier
        myAirPurifier.turnOff();
    }
}

class AirPurifierInfo {
    private String serialNumber = "56845735734";
}

class AirPurifier {
    public String brand;
    private boolean isOn;
    private Filter filter;
    Scanner scanner = new Scanner(System.in);

    private AirPurifier(String brand, Filter filter) {
        this.brand = brand;
        this.filter = filter;
        this.isOn = false;
    }

    public static AirPurifier createAirPurifier(Scanner scanner) {
        System.out.print("Input air purifier brand: ");
        String brand = scanner.nextLine();

        System.out.print("Input filter type: ");
        String filterType = scanner.nextLine();
        System.out.print("Input filter life: ");
        int filterLife = scanner.nextInt();
        Filter hepaFilter = new Filter(filterType, filterLife);

        return new AirPurifier(brand, hepaFilter);
    }

    public void turnOn() {
        isOn = true;
        System.out.println(brand + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + " is now OFF.");
    }

    public void checkAQI(int aqi) {
        double filteredAQI = aqi - (0.99 * aqi);
        if (aqi >= 200) {
            System.out.println("Previous AQI was " + aqi + ". After being filtered with MAX_SPEED_FAN is " + filteredAQI);
        } else if (aqi >= 120 && aqi <= 199) {
            System.out.println("Previous AQI was " + aqi + ". After being filtered with MEDIUM_SPEED_FAN is " + filteredAQI);
        } else if (aqi >= 60 && aqi <= 119) {
            System.out.println("Previous AQI was " + aqi + ". After being filtered with MIN_SPEED_FAN is " + filteredAQI);
        } else {
            System.out.println("Air quality is within acceptable limits");
        }
    }

    public void checkFilterStatus() {
        System.out.println("Filter type: " + filter.getType());
        System.out.println("Filter life remaining: " + filter.getFilterLife() + " hour(s)");
    }

    public void run() {
        if (isOn) {
            System.out.println("Air purifier is running. Purifying the air.");
            filterLifeDecrement();
        } else {
            System.out.println("Air purifier is not running. Turn it on to start purifying the air.");
        }
    }

    private void filterLifeDecrement() {
    filter.decrementFilterLife();
}

    public void replaceFilter(Scanner scanner) {
        System.out.println(" ");
        System.out.print("Input new filter life: ");
        int newFilterLife = scanner.nextInt();
        filter.replaceFilter(newFilterLife);
    }

    public static int getAqiInput(Scanner scanner) {
        System.out.print("Input AQI: ");
        return scanner.nextInt();
    }
}

class Filter {
    private String type;
    private int filterLife; // in hours

    public Filter(String type, int filterLife) {
        this.type = type;
        this.filterLife = filterLife;
    }

    public String getType() {
        return type;
    }

    public int getFilterLife() {
        return filterLife;
    }

    public void replaceFilter(int newFilterLife) {
        System.out.println("Replacing the " + type + " filter.");
        filterLife = newFilterLife; // Reset filter life to the new value after replacement
        decrementFilterLife();
    }

    public void decrementFilterLife() {
        if (filterLife > 0) {
            filterLife--;
        } else {
            System.out.println("Filter life is exhausted. Please replace the filter.");
        }
    }
}
