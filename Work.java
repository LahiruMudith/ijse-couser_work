import java.util.Arrays;
import java.util.Scanner;

public class Work {
    public static Scanner scan  = new Scanner(System.in);
    public static String[][] loginDetails = {{"Lahiru", "1212"}};
    public static String[][] supplierDetails = new String[0][0];

    public static void main(String[] args) {
//        loginPage();
        welcomMenu();
    }
    public static void loginPage() {
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|                               Login Page                                     |");
        System.out.println("+------------------------------------------------------------------------------+");

        L1: while (true){
            System.out.print("Enter username : ");
            String username = scan.next();

            if (username.equals(loginDetails[0][0])){
                L2: while (true){
                    System.out.print("Enter password : ");
                    String password = scan.next();
                    if (password.equals(loginDetails[0][1])){
                        System.out.println("Login success!");
                        welcomMenu();
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
    public static void welcomMenu() {
        while (true){
            clearConsole();
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|               WELCOME TO IJSE STOCK MANAGEMENT SYSTEM               |");
            System.out.println("+---------------------------------------------------------------------+\n");

            System.out.println( "[1] Change the Credentials                                    [2] Supplier Manage\n" +
                                "[3] Stock Manage                                              [4] Log out\n" +
                                "[5] Exit the system\n");
            while (true){
                System.out.print("Enter an option to continue > ");
                int optionNum = scan.nextInt();

                switch (optionNum){
                    case 1: {
                        credentialsManage();
                        break;
                    }
                    case 2: {
                        supplierManage();
                        break;
                    }
                    case 3: {
                        System.out.println(optionNum);
                        break;
                    }
                    case 4: {
                        logoutMenu();
                        break;
                    }
                    case 5: {
                        exitMenu();
                        break;
                    }
                }
            }
        }
    }
    public static void credentialsManage() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                          CREDENTIAL MANAGE                          |");
        System.out.println("+---------------------------------------------------------------------+\n");


        L1: while (true){
            System.out.print("please enter username to verify it's you: ");
            String enterUsername = scan.next();

            if (loginDetails[0][0].equals(enterUsername)){
                System.out.println("Hey " + enterUsername + ",");
                L2: while (true){
                    System.out.print("Enter your current password: ");
                    String currentPassword = scan.next();

                    if (currentPassword.equals(loginDetails[0][1])){
                        System.out.print("Enter your new password: ");
                        String newPassword = scan.next();
                        loginDetails[0][1]=newPassword;

                        System.out.print("password change successfully! Do you go to home page (Y/N): ");
                        char goToHomePage = scan.next().charAt(0);

                        switch (goToHomePage) {
                            case 'Y' : {
                                welcomMenu();
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
    public static void logoutMenu() {
        clearConsole();
        loginPage();
    }
    public static void exitMenu() {
        System.exit(0);
    }
    public static void supplierManage() {
        while (true){
            while (true){
                clearConsole();
                System.out.println("+---------------------------------------------------------------------+");
                System.out.println("|                           SUPPLIER MANAGE                           |");
                System.out.println("+---------------------------------------------------------------------+\n");

                System.out.println( "[1] Add Supplier                                [2] Update Supplier\n" +
                                    "[3] Delete Supplier                             [4] View Supplier\n" +
                                    "[5] Search Supplier                             [6] Home Page\n");

                System.out.print("Enter an option to continue > ");
                int optionNum = scan.nextInt();

                switch (optionNum){
                    case 1: {
                        addSupplier();
                        break;
                    }
                    case 2: {
                        updateSupplier();
                        break;
                    }
                    case 3: {
                        deleteSupplier();
                        break;
                    }
                    case 4: {
                        viewSupplier();
                        break;
                    }
                    case 5: {

                    }
                    case 6: {

                    }
                }
            }
        }
    }
    public static void addSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                             ADD SUPPLIER                            |");
        System.out.println("+---------------------------------------------------------------------+\n");


        L1: while (true) {
            System.out.print("Supplier id    :");
            String id = scan.next();

            L2: for (int i = 0; i <supplierDetails.length; i++) {
                for (int j = 0; j <supplierDetails[i].length; j++) {
                    if (supplierDetails[i][j].equals(id)){
                        System.out.println("Supplier id already exists. please try again!");
                        continue L1;
                    }
                }
            }

            boolean condition = true;
            if(condition){
                grow();
                System.out.print("Supplier name  :");
                supplierDetails[supplierDetails.length-1][1] = scan.next();
                supplierDetails[supplierDetails.length-1][0] = id;

                System.out.print("added successfully! Do you want to add another supplier? (Y/N)? ");
                String supplierAdd = scan.next();

                switch (supplierAdd){
                    case "Y": {
                        break;
                    }
                    case "N": {
                        return;
                    }
                }
            }
        }
    }
    public static void updateSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                           UPDATE SUPPLIER                           |");
        System.out.println("+---------------------------------------------------------------------+\n");

        while (true){
            System.out.print("Supplier id    :");
            String id = scan.next();

            boolean condition = false;
            int index = -1;
                for (int i = 0; i <supplierDetails.length; i++) {
                        if (supplierDetails[i][0].equals(id)){
                            condition = true;
                            index = i;
                            break;
                        }
                }

                if (condition){
                    System.out.println("Supplier Name  :" + supplierDetails[index][1]);

                    System.out.print("Enter the new supplier name : ");
                    String newName = scan.next();
                    supplierDetails[index][1]=newName;

                    System.out.print("Update successfully! Do you want to update another supplier? (Y/N)? ");
                    String supplierUpdate = scan.next();
                    switch (supplierUpdate){
                        case "Y": {
                            break;
                        }
                        case "N": {
                            return;
                        }
                    }
                }else {
                    System.out.println("can't find supplier id. please try again!");
                }
        }
    }
    public static void deleteSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                           DELETE SUPPLIER                           |");
        System.out.println("+---------------------------------------------------------------------+\n");

        while (true) {
            System.out.print("Supplier id    :");
            String id = scan.next();

            boolean condition = false;
            int index = -1;
            for (int i = 0; i < supplierDetails.length; i++) {
                if (supplierDetails[i][0].equals(id)) {
                    condition = true;
                    index = i;
                    break;
                }
            }

            if (condition){
                supplierDetails[index][0] = "null";
                remove();

                System.out.print("delete successfully! Do you want to delete another supplier? (Y/N)? ");
                String supplierDelete = scan.next();
                switch (supplierDelete){
                    case "Y": {
                        break;
                    }
                    case "N": {
                        return;
                    }
                }
            }
        }
    }

    public static void viewSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                            VIEW SUPPLIER                            |");
        System.out.println("+---------------------------------------------------------------------+\n");

        System.out.println("+-----------------------+-----------------------------+");
        System.out.printf("|   %S  |    %S    |%n","supplier id","supplier name");
        System.out.println("+-----------------------+-----------------------------+");

        for (int i = 0; i <supplierDetails.length; i++) {
            System.out.printf("|\t%s\t\t|\t\t%s    \t\t|%n",supplierDetails[i][0],supplierDetails[i][1]);        }
        System.out.println("+-----------------------+----------+");

        System.out.println("Do you go to supplier manage page(Y/N)? ");
        char yesOrNo = scan.next().charAt(0);
        switch (yesOrNo){
            case 'Y': {
                break;
            }
        }

    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    public static void grow() {
        String[][] temp = new String[supplierDetails.length+1][2];
        for (int i = 0; i < supplierDetails.length; i++) {
            for (int j = 0; j < supplierDetails[i].length; j++) {
                temp[i][j] = supplierDetails[i][j];
            }
        }
        supplierDetails = temp;
    }
    public static void remove() {
        String[][] temp = new String[supplierDetails.length-1][2];
        for (int i = 0, k=0; i < temp.length; i++) {
            if (supplierDetails[i][0].equals("null")) {
                k++;
            }
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = supplierDetails[i+k][j];
            }
        }
        supplierDetails = temp;
    }

}
