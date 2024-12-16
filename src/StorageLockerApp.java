//import java utilities - scanner, random (for locker pin)
import java.util.Scanner;


public class StorageLockerApp {
    // Define variables/arrays
    // Establish variable for 10 lockers
    public static int totalAvailableLockers = 10;
    public static String[] lockerID = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static String[] lockerPin = {"0001", "0002", "0003", "0004", "0005", "0006", "0007", "0008", "0009", "0010"};
    public static boolean[] lockerAvailable = {true, true, true, true, true, true, true, true, true, true};
    // Set up Scanner for input

    public static void main(String[] args) {

        while(true) {
            displayMainMenu();
            int menuChoice = getChoice();

            switch(menuChoice) {
                case 1:
                    rentLocker();
                    break;
                case 2:
                    accessLocker();
                    break;
                case 3: releaseLocker();
                default:
                    System.out.println("Exiting program");
                    System.exit(0);

            }
        }

    }

    // Methods
     public static void displayMainMenu() {
         System.out.println("What would you like to do next?");
            if(getAvailableLocker() != -1)  {
                System.out.println("1. Rent a Locker ");
            }
         System.out.println("2. Access a Locker \n3. Release a Locker \n--- \nAny other key to exit");
     }

    // getChoice()
    public static int getChoice() {
        Scanner console = new Scanner(System.in);
        return Integer.parseInt(console.nextLine());
    }
    // rentLocker()
    public static void rentLocker() {
        int firstAvailableLocker = getAvailableLocker();
        if(firstAvailableLocker == -1 ) {
            System.out.println("All lockers are unavailable.");
            return;
        }
        System.out.println("Locker " + lockerID[firstAvailableLocker] +"\nPin Number: " + lockerPin[firstAvailableLocker] + "\nThank you for renting.");
        lockerAvailable[firstAvailableLocker] = false;

    }
    public static void accessLocker() {
        int lockerIndex = getLockerNumber();
        if(lockerIndex == -1) {
            System.out.println("Invalid locker ID");
            return;
        }
        if(lockerAvailable[lockerIndex]) {
        System.out.println("Locker " + lockerID[lockerIndex] + " is available");
        }
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a pin number");
        String userPin = console.nextLine();
        if(lockerPin[lockerIndex].equals(userPin)) {
            System.out.println("Success, locker opened");
        } else {
            System.out.println("Incorrect pin");
        }
    }
    public static int releaseLocker() {
        int releaseLockerIndex = getLockerNumber();
        if(releaseLockerIndex != -1) {
            for(int i = 0; i < lockerAvailable.length; i++) {
                System.out.println("Locker released and is available to rent");
                lockerAvailable[releaseLockerIndex] = true;
                break;
            }
        }
        return releaseLockerIndex;
    }
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
    public static int getLockerNumber() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the locker number");
        String userLockerNum = console.nextLine();
        return isTheLockerNumberValid(userLockerNum);
    }
    public static int isTheLockerNumberValid(String userLockerNum) {
        int noLockerMatch = - 1;
        for(int i = 0; i < lockerID.length; i++) {
            if (lockerID[i].equals(userLockerNum)) {
                return i;
            }
        }
        return noLockerMatch;
    }
//    public static void openLocker() {
//        System.out.println("Success! ");
//    }

}