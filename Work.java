import java.util.Arrays;
import java.util.Scanner;

public class Work {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String correctUsername = "Lahiru";
        String correctPassword = "1212";


        //loginPage(scan, correctUsername, correctPassword);
        welcomeMenu(scan, correctUsername, correctPassword);
    }

    public static void updateSupplier(Scanner scan, String[] supplierId, String[] supplierName) {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                           UPDATE SUPPLIER                           |");
        System.out.println("+---------------------------------------------------------------------+\n");

        boolean whileContinue = true;
        while (whileContinue) {
            System.out.println(supplierName.length);
            System.out.print("Supplier id   : ");
            String getSupplierId = scan.next();

            boolean condition = false;
            int j = 0;
            for (int i = 0; i <supplierId.length; i++) {
                if (supplierId[i].equals(getSupplierId)) {
                    condition = true;
                    j = i;
                }else {
                    condition = false;
                }
            }
            if (condition == false) {
                System.out.println("can't find the supplier id.try again!");
            }else {
                System.out.print("Supplier Name   : " + supplierName[j]);
                String getSupplierName = scan.next();
            }
        }
    }
    public static String[] addSupplier(Scanner scan, String[] supplierDetails) {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                             ADD SUPPLIER                            |");
        System.out.println("+---------------------------------------------------------------------+\n");

        int i = 0;

        boolean condition = true;
        L1: while (condition){
            condition = false;
            supplierDetails = growId(supplierDetails);
            supplierName = growName(supplierName);
            System.out.println(supplierId.length);
            System.out.println(supplierName.length);

            System.out.print("Supplier id   : ");
            String getSupplierId = scan.next();

            boolean condition2 = true;
            for (String sId : supplierId) {
                if (getSupplierId.equals(sId)) {
                    System.out.println("already exists. try another supplier id!");
                    condition2 =false;
                    break;
                }
            }
            if (condition2){
                System.out.print("Supplier name :");
                supplierName[i] = scan.next();
                supplierId[i] = getSupplierId;
                System.out.print("added successfully! Do you want to add another supplier(Y/N)? ");
                char nextSupplierAdd = scan.next().charAt(0);

                switch (nextSupplierAdd){
                    case 'N': {
                        clearConsole();
                        break ;
                    }
                    case 'Y' : {
                        condition = true;
                        i++;
                    }
                }
            }else {
                condition = true;
            }
        }
        return supplierId;
    }

    public static String[][] growId(String[][] supplierDetails) {
        String[][] temp = new String[supplierDetails.length+1][supplierDetails[0].length];

        for (int i = 0; i <supplierDetails.length; i++) {
            temp[i][0] = supplierDetails[i][0];
            temp[i][1] = supplierDetails[i][1];
        }
        return supplierDetails;
    }
    public static void supplierManage(Scanner scan) {
        String[][] supplierDetails = new String[0][2];
        String[] supplierId = new String[0];

        boolean condition = true;
        while (condition){

            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                           SUPPLIER MANAGE                           |");
            System.out.println("+---------------------------------------------------------------------+\n");

            System.out.println("[1] Add Supplier                                [2] Update Supplier\n" +
                    "[3] Delete Supplier                             [4] View Supplier\n" +
                    "[5] Search Supplier                             [6] Home Page");
            System.out.print("Enter an option to continue > ");
            int optionNum = scan.nextInt();

            switch (optionNum){
                case 1 : {
                    clearConsole();
                    supplierId = addSupplier(scan, supplierDetails);
                    break;
                }
                case 2 : {
                    clearConsole();
                    System.out.println(supplierId.length);
                    updateSupplier(scan, supplierDetails);
                }
                case 3 : {
//                clearConsole();
//                updateSupplier(scan, supplierId, supplierDetails);
                }
                case 4 : {
//                clearConsole();
//                updateSupplier(scan, supplierId, supplierDetails);
                }
                case 5 : {
//                clearConsole();
//                updateSupplier(scan, supplierId, supplierDetails);
                }
                case 6 : {
//                clearConsole();
//                updateSupplier(scan, supplierId, supplierDetails);
                }
            }
        }
    }
    public static void exitMenu(Scanner scan, String correctUsername, String correctPassword) {
        System.exit(0);
    }
    public static void logoutMenu(Scanner scan, String correctUsername, String correctPassword) {
        loginPage(scan,correctUsername, correctPassword);
    }
    public static void credentialsManage(Scanner scan, String correctUsername, String correctPassword) {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                          CREDENTIAL MANAGE                          |");
        System.out.println("+---------------------------------------------------------------------+\n");

        boolean condition =  true;
        L1: while (condition){
            System.out.print("please enter username to verify it's you: ");
            String enterUsername = scan.next();

            if (correctUsername.equals(enterUsername)){
                System.out.println("Hey " + enterUsername + ",");
                L2: while (true){
                    System.out.print("Enter your current password: ");
                    String currentPassword = scan.next();

                    if (currentPassword.equals(correctPassword)){
                        System.out.print("Enter your new password: ");
                        String newPassword = scan.next();
                        correctPassword=newPassword;

                        System.out.print("password change successfully! Do you go to home page (Y/N): ");
                        char goToHomePage = scan.next().charAt(0);

                        switch (goToHomePage) {
                            case 'Y' : {
                                clearConsole();
                                welcomeMenu(scan, correctUsername, correctPassword);
                            }
                            case 'N' : {
                                break L1;
                            }
                        }
                    }else{
                        System.out.println("Incorrect password. please try again!");
                    }
                }
            }else {
                System.out.println("Invalid username. please try again!");
            }
        }
    }
    public static void welcomeMenu(Scanner scan, String correctUsername, String correctPassword) {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|               WELCOME TO IJSE STOCK MANAGEMENT SYSTEM               |");
        System.out.println("+---------------------------------------------------------------------+\n");

        System.out.println("[1] Change the Credentials                                    [2] Supplier Manage\n" +
                "[3] Stock Manage                                              [4] Log out\n" +
                "[5] Exit the system\n");

        System.out.print("Enter option to continue > ");
        int number = scan.nextInt();

        switch (number){
            case 1 : {
                credentialsManage(scan,correctUsername, correctPassword);
                clearConsole();
                break;
            }
            case 2 : {
                clearConsole();
                supplierManage(scan);
                break;
            }
            case 3 : {
                clearConsole();
                System.out.println(number);
                break;
            }
            case 4 : {
                clearConsole();
                logoutMenu(scan,correctUsername, correctPassword);
                break;
            }
            case 5 : {
                clearConsole();
                exitMenu(scan,correctUsername, correctPassword);
                break;
            }
        }
    }
    public static void loginPage(Scanner scan, String correctUsername, String correctPassword) {
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|                               Login Page                                     |");
        System.out.println("+------------------------------------------------------------------------------+");

        String username ="";
        String password ="";

       L1: while (username!=correctUsername || password!=correctPassword){
           System.out.print("Enter username : ");
           username = scan.next();

           if (username.equals(correctUsername)){
               L2: while (password!=correctUsername){
                   System.out.print("Enter password : ");
                   password = scan.next();
                   if (password.equals(correctPassword)){
                       System.out.println("Login success!");
                       clearConsole();
                       welcomeMenu(scan, correctUsername, correctPassword);
                       break L1;
                   }else {
                       System.out.println("password is invalid. please try again!");
                   }
               }
           }else {
               System.out.println("Username is invalid. please try again!");
           }
       }
    }
    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
//handle the exception
            System.err.println(e.getMessage());
        }
    }
}
