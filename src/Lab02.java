// ข้อ 1
//Instance Variables
// -brand (String)
// -model (String)
// -isOn (boolean)
// -filter (Filter)
// -serialNumber (String)
// -scanner (Scanner)

// Instance Methods:
// -createAirPurifier (Static Method):
// -turnOn (Method):
// -turnOff (Method):
// -checkAQI (Method):
// -checkFilterStatus (Method):
// -run (Method):
// -filterLifeDecrement (Method):
// -replaceFilter (Method):
// -getAqiInput (Static Method):

// Class Variables:
// -numberOfModelsManufactured (Static int)
// -mostPopularModel (Static String)

// Class Methods:
// -getNumberOfModelsManufactured (Static Method)
// -getMostPopularModel (Static Method)

// ข้อ 2
// 1. AirPurifier (Constructor):
//    - Overview: กำหนดค่าตัวแปรของอินสแตนซ์, สร้างหมายเลขซีเรียลที่ไม่ซ้ำกัน, เพิ่มจำนวนโมเดลที่ผลิต, และตั้งค่าโมเดลยอดนิยม.
//    - Inputs: แบรนด์, โมเดล, และอินสแตนซ์ของฟิลเตอร์.
//    - Returned:ไม่มีการคืนผลลัพธ์ชัดเจน.

// 2. createAirPurifier (เมทอดแบบ Static):
//    - Overview: ให้ผู้ใช้ป้อนข้อมูลเพื่อสร้างอินสแตนซ์ของ `AirPurifier` ที่ระบุแบรนด์, โมเดล ("pro"), ประเภทของฟิลเตอร์, และอายุของฟิลเตอร์.
//    - Inputs: สแกนเนอร์สำหรับข้อมูลจากผู้ใช้.
//    - Returned: อินสแตนซ์ของ `AirPurifier`.

// 3. turnOn (เมทอด):
//    - Overview: เปิดเครื่องฟองอากาศและพิมพ์ข้อความแสดงว่าตอนนี้เปิด.

// 4. turnOff (เมทอด):
//    - Overview: ปิดเครื่องฟองอากาศ, พิมพ์ข้อความแสดงว่าตอนนี้ปิด, และแสดงหมายเลขซีเรียล.

// 5. checkAQI (เมทอด):
//    - Overview: กำหนดผลกระทบของเครื่องฟองอากาศต่อดัชนีคุณภาพอากาศ (AQI) โดยพิจารณาเงื่อนไขที่ระบุและพิมพ์ผลลัพธ์.
//    - Inputs: ค่า AQI (จำนวนเต็ม).
//    - Returned: ไม่มีการคืนผลลัพธ์ชัดเจน.

// 6. checkFilterStatus (เมทอด):
//    - Overview: พิมพ์ประเภทของฟิลเตอร์และเวลาที่เหลือของฟิลเตอร์ในหน่วยชั่วโมง.
//    - Inputs: ไม่มี.
//    - Returned: ไม่มีการคืนผลลัพธ์ชัดเจน.

// 7. run (เมทอด):
//    - Overview: จำลองการทำงานของเครื่องฟองอากาศด้วยการตรวจสอบว่าเปิดหรือไม่ และทำการฟองอากาศ พิมพ์ข้อความที่เกี่ยวข้อง.
//    - Inputs: ไม่มี.
//    - Returned: ไม่มีการคืนผลลัพธ์ชัดเจน.

// 8. filterLifeDecrement (เมทอด):
//    - Overview: ลดอายุของฟิลเตอร์ของเครื่องฟองอากาศ.
//    - Inputs: ไม่มี.
//    - Returned: ไม่มีการคืนผลลัพธ์ชัดเจน.

// 9. replaceFilter (เมทอด):
//    - Overview: ให้ผู้ใช้ป้อนข้อมูลเพื่อแทนที่ฟิลเตอร์ด้วยอายุใหม่.
//    - Inputs: สแกนเนอร์สำหรับข้อมูลจากผู้ใช้.
//    - Returned: ไม่มีการคืนผลลัพธ์ชัดเจน.

// 10. getAqiInput (เมทอดแบบ Static):
//     - Overview: ให้ผู้ใช้ป้อนข้อมูลเพื่อรับค่า AQI.
//     - Inputs: สแกนเนอร์สำหรับการป้อนข้อมูลของผู้ใช้
//     - Returned: จำนวนเต็ม
// 11. generateSerialNumber (Private Method):
//     - Overview: สร้างหมายเลขซีเรียลที่สุ่มสร้างสำหรับเครื่องฟอกอากาศ
//     - Returned: สตริงที่แทนหมายเลขซีเรียลที่สร้างขึ้น
// 12. getNumberOfModelsManufactured (Static Method):
//     - Overview: ส่งคืนจำนวนรวมของโมเดลเครื่องฟอกอากาศ
//     - Returned: จำนวนเต็มที่แทนจำนวนโมเดลที่ผลิตขึ้น
// 13. getMostPopularModel (Static Method):
//     -Overview: ส่งคืนแบรนด์และโมเดลของเครื่องฟอกอากาศที่ได้รับความนิยมสูงสุด
//     -Returned: สตริงที่แทนแบรนด์และโมเดลที่ได้รับความนิยมสูงสุด


import java.util.Scanner;
import java.util.Random;

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

        // Display the number of models manufactured and the most popular model
        System.out.println("Number of models manufactured: " + AirPurifier.getNumberOfModelsManufactured());
        System.out.println("Most popular model: " + AirPurifier.getMostPopularModel());
    }
}




class AirPurifier {
    private String brand;
    private String model;
    private boolean isOn;
    private Filter filter;
    private String serialNumber;
    Scanner scanner = new Scanner(System.in);

    private static int numberOfModelsManufactured = 0;
    private static String mostPopularModel;

    private AirPurifier(String brand, String model, Filter filter) {
        this.brand = brand;
        this.model = model;
        this.filter = filter;
        this.isOn = false;
        this.serialNumber = generateSerialNumber();
        // Increment the number of models manufactured when a new instance is created
        numberOfModelsManufactured++;

        // Set the most popular model when the first instance is created
        if (numberOfModelsManufactured == 1) {
            mostPopularModel = brand + " " + model;
        } else {
            // Check if the current model is more popular than the existing one
            if (!(brand + " " + model).equals(mostPopularModel)) {
                mostPopularModel = brand + " " + model;
            }
        }
    }

    public static AirPurifier createAirPurifier(Scanner scanner) {
        System.out.print("Input air purifier brand: ");
        String brand = scanner.nextLine();

        // Set the model as "pro"
        String model = "pro";

        System.out.print("Input filter type: ");
        String filterType = scanner.nextLine();
        System.out.print("Input filter life: ");
        int filterLife = scanner.nextInt();
        Filter hepaFilter = new Filter(filterType, filterLife);

        return new AirPurifier(brand, model, hepaFilter);
    }

    public void turnOn() {
        isOn = true;
        System.out.println(brand + " " + model + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + " " + model + " is now OFF.");
        System.out.println("Serial Number: " + serialNumber);
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
            System.out.println(brand + " " + model + " is running. Purifying the air.");
            filterLifeDecrement();
        } else {
            System.out.println(brand + " " + model + " is not running. Turn it on to start purifying the air.");
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

    public static int getNumberOfModelsManufactured() {
        return numberOfModelsManufactured;
    }

    public static String getMostPopularModel() {
        return mostPopularModel;
    }

    private String generateSerialNumber(){
        Random rand = new Random();
        int randNumber = rand.nextInt(1000000000);
        return String.format("%09d", randNumber);
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
