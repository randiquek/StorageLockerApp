//import java utilities - scanner, random (for locker pin)
import java.util.Scanner;


public class StorageLockerApp {
    // Define variables/arrays
    // Establish variable for 10 lockers
    public static int totalAvailableLockers = 10;
    public static String[] lockerID = {"1", "2", "3"};
    public static String[] lockerPin = {"0001", "0002", "0003"};
    public static boolean[] lockerAvailable = {true, true, true};
    // Set up Scanner for input

    public static void main(String[] args) {

        while(true) {
            displayMainMenu();
            int menuChoice = getChoice();
            if (menuChoice == 1) {
                rentLocker();
            }
            //getAvailableLocker();
        }
    /*

    1. Display Main Menu
        a. Rent
        b. Access
        c. Release
        d. Exit
    2. User Rents a Locker
        a. Find available locker
        b. Provide pin # (make random once everything works)
        c. Print a thank-you with locker# and pin

    3. User Accesses a Locker
        a. Enter locker#
        b. If locker is rented, ask for pin.
        c. Enter locker pin#
        d. If pin is correct, open locker and print success msg
        e. If pin is incorrect ask for pin # again
        f. Display the main menu
    4. User Releases Locker
        a. Access the locker
        b. Confirm user is sure
        c. If cannot confirm, return to start menu
    5. User Exits
        a. Exit application
     */


    }

    // Methods
     public static void displayMainMenu() {
         System.out.println("What would you like to do next?");
            if(getAvailableLocker() != -1)  {
                System.out.println("1. Rent a Locker ");
            }
         System.out.println("2. Access a Locker \n3. Release a Locker \n--- \nAny other key to exit");
     }
        /*
        - What would you like to do next?
        - If locker is available, print: 1. Rent a Locker
        - 2. Access a Locker
        - 3. Release a Locker
        ---
        - Any other key to Exit


         */
    // getChoice()
    public static int getChoice() {
        Scanner console = new Scanner(System.in);
        return Integer.parseInt(console.nextLine());
    }
    // rentLocker()
    public static void rentLocker() {
        int firstAvailableLocker = getAvailableLocker();
        System.out.println("Locker " + lockerID[firstAvailableLocker] +"\nPin Number: " + lockerPin[firstAvailableLocker] + "\nThank you for renting.");
        lockerAvailable[firstAvailableLocker] = false;
    }
//     2. User Rents a Locker
//    a. Find available locker
//    b. Provide pin # (make random once everything works)
//    c. Print a thank-you with locker# and pin
    // accessLocker()
    // releaseLocker()


    public static int getAvailableLocker() {
        int firstAvailableLocker = -1;
            for(int i = 0; i < lockerAvailable.length; i++){
                if(lockerAvailable[i]) {
                    return i;
                }
            }
            return firstAvailableLocker;
        }

    // generatePin()
    // printReceipt()
    // getLockerNumber()
    // isTheLockerNumberValid()
    // openLocker()
    // releaseLocker()

}