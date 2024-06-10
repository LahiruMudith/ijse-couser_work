import java.util.*;

public class Work {
    public static Scanner scan  = new Scanner(System.in);
    public static String[][] loginDetails = {{"Lahiru", "1212"}};
    public static String[][] supplierDetails = new String[0][0];
    public static String[] category = new String[0];
    public static String[][] items = new String[0][0];

    public static void main(String[] args) {
       loginPage();
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
                        stockManage();
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
                        searchSupplier();
                        break;
                    }
                    case 6: {
                        welcomMenu();
                        break;
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
                    case "Y", "y": {
                        break;
                    }
                    case "N", "n": {
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
            }else {
                System.out.println("can't find supplier id.please try again!");
            }
        }
    }
    public static void viewSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                            VIEW SUPPLIER                            |");
        System.out.println("+---------------------------------------------------------------------+\n");

        System.out.println("+-----------------------+-----------------------------+");
        System.out.printf("|   %S  |    %S    \t\t\t\t  |%n","supplier id","supplier name");
        System.out.println("+-----------------------+-----------------------------+");

        for (int i = 0; i <supplierDetails.length; i++) {
            System.out.printf("|\t\t%s\t\t |\t\t%s    \t\t|%n",supplierDetails[i][0],supplierDetails[i][1]);        }
        System.out.println("+-----------------------+---------------+");

        System.out.println("Do you go to supplier manage page(Y/N)? ");
        char yesOrNo = scan.next().charAt(0);
        switch (yesOrNo){
            case 'Y': {
                break;
            }
        }
    }
    public static void searchSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                            SEARCH SUPPLIER                          |");
        System.out.println("+---------------------------------------------------------------------+\n");

        boolean whileCondition = true;
        L1: while (whileCondition) {
            System.out.print("Supplier ID    : ");
            String sId = scan.next();
            int index = -1;
            boolean condition = false;

            for (int i = 0; i <supplierDetails.length; i++) {
                if (supplierDetails[i][0].equals(sId)) {
                    index = i;
                    condition = true;
                    break;
                }
            }

            if (condition==false){
                System.out.println("can't find supplier id. please try again!");
            }else {
                while (condition){
                    whileCondition = false;

                    System.out.println("Supplier Id    : " + supplierDetails[index][0]);
                    System.out.println("Supplier Name  : " + supplierDetails[index][1]);

                    System.out.print("supplier search successfully!Do you want to search another supplier? (Y/N)? ");
                    char supSearch = scan.next().charAt(0);

                    switch (supSearch){
                        case 'Y': {
                            whileCondition = true;
                            break;
                        }
                        case 'N': {
                            break L1;
                        }
                        case 'y': {
                            whileCondition = true;
                            break;
                        }
                        case 'n': {
                            break L1;
                        }
                        default: {
                            System.out.println("please enter a valid character.");
                        }
                    }
                }
            }
        }
    }
    public static void stockManage() {
        while (true){
            clearConsole();
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                            STOCK MANAGEMENT                         |");
            System.out.println("+---------------------------------------------------------------------+\n");

            System.out.println( "[1] Manage Item Categories                                    [2] Add Item\n" +
                                "[3] Get Items Supplier Wish                                   [4] View Item\n" +
                                "[5] Rank Items Per Unit Price                                 [6] Home Page\n");

                System.out.print("Enter an option to continue > ");
                int optionNum = scan.nextInt();

                switch (optionNum){
                    case 1: {
                        manageItemCategories();
                        break;
                    }
                    case 2: {
                        addItem();
                        break;
                    }
                    case 3: {
                        searchSupplierAndItem();
                        break;
                    }
                    case 4: {
                        viewItem();
                        break;
                    }
                    case 5: {
                        sortItem();
                        break;
                    }
                    case 6: {
                        welcomMenu();
                        break;
                    }
                }
        }
    }
    public static void manageItemCategories() {
        while (true) {
            clearConsole();
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("|                         MANAGE ITEM CATEGORIES                      |");
            System.out.println("+---------------------------------------------------------------------+\n");

            System.out.println( "[1] Add New Item Categories                                   [2] Delete Item Category\n" +
                                "[3] Update Item Category                                      [4] Stock Management\n");

                System.out.print("Enter an option to continue > ");
                int optionNum = scan.nextInt();

                switch (optionNum){
                    case 1: {
                        addItemCategory();
                        break;
                    }
                    case 2: {
                        deleteItemCategory();
                        break;
                    }
                    case 3: {
                        updateItemCategory();
                        break;
                    }
                    case 4: {
                        stockManage();
                    }
                }
        }
    }
    public static void addItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                           ADD ITEM CATEGORIES                       |");
        System.out.println("+---------------------------------------------------------------------+\n");

        boolean whileCondition = true;
        L1: while (whileCondition){
            whileCondition = false;
            growCategory();

            System.out.print("Enter the new item category: ");
            category[category.length -1] = scan.next();

            System.out.print("added successfully!Do you want to add another category? (Y/N)? ");
            char supAddCategory = scan.next().charAt(0);

            switch (supAddCategory){
                case 'Y': {
                    whileCondition = true;
                    break;
                }
                case 'y': {
                    whileCondition = true;
                    break;
                }
                case 'N': {
                    break L1;
                }

                case 'n': {
                    break L1;
                }
            }
        }
    }
    public static void updateItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                         UPDATE ITEM CATEGORIES                      |");
        System.out.println("+---------------------------------------------------------------------+\n");

        L1: while (true){
            System.out.print("Enter the update item category name: ");
            String categoryName = scan.next();

            boolean equal = false;
            int index = -1;

            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(categoryName)) {
                    equal = true;
                    index = i;
                }
            }
            if (equal) {
                System.out.print("Enter the new item category name: ");
                String newCategoryName = scan.next();

                category[index] = newCategoryName;

                System.out.print("update successfully!Do you want to update another item category? (Y/N)? ");
                char supUpdateCategory = scan.next().charAt(0);

                switch (supUpdateCategory){
                    case 'Y': {
                        break;
                    }
                    case 'y': {
                        break;
                    }
                    case 'N': {
                        break L1;
                    }

                    case 'n': {
                        break L1;
                    }
                    default: {
                        System.out.println("please enter a valid character!");
                    }
                }
            }else{
                System.out.println("can't find category name.please try again");
            }
        }
    }
    public static void deleteItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                         DELETE ITEM CATEGORIES                      |");
        System.out.println("+---------------------------------------------------------------------+\n");

        L1: while (true){
            System.out.print("Enter the delete item category name: ");
            String categoryName = scan.next();

            boolean equal = false;
            int index = -1;

            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(categoryName)) {
                    equal = true;
                    index = i;
                    break;
                }
            }

            if (equal) {
                category[index] = "null";
                removeCategory();

                System.out.print("delete successfully! Do you want to delete another category? (Y/N)? ");
                String categoryDelete = scan.next();
                switch (categoryDelete){
                    case "Y": {
                        break;
                    }
                    case "N": {
                        return;
                    }
                }
            }else {
                System.out.println("can't find category id.please try again!");
            }
        }
    }
    public static void addItem() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                                ADD ITEM                             |");
        System.out.println("+---------------------------------------------------------------------+\n");

        boolean whileCondition = true;
        while (whileCondition) {
            whileCondition = false;
            growItem();

            if (category.length==0) {
                System.out.println("OOPS! It seems  that you don't have any item category in the system.");
                System.out.print("Do you want to add a new item category? (Y/N): ");
                char supAddCategory = scan.next().charAt(0);

                switch (supAddCategory) {
                    case 'Y', 'y': {
                        addItemCategory();
                        return;
                    }
                    case 'N', 'n': {
                        System.exit(0);
                    }
                }
            }
            if (supplierDetails.length==0) {
                System.out.println("OOPS! It seems  that you don't have any suppliers in the system.");
                System.out.print("Do you want to add a new supplier? (Y/N): ");
                char supAddCategory = scan.next().charAt(0);

                switch (supAddCategory) {
                    case 'Y', 'y': {
                        addSupplier();
                        return;
                    }
                    case 'N', 'n': {
                        System.exit(0);
                    }
            }
            }else {
                System.out.print("Item Code: ");
                items[items.length-1][0] = scan.next();

                System.out.println("+---------------+-----------------------+---------------------------------------+");
                System.out.println("|       #       |      SUPPLIER ID      |              SUPPLIER NAME            |");
                System.out.println("+---------------+-----------------------+---------------------------------------+");
                for (int i = 0; i < supplierDetails.length; i++){
                    System.out.printf("|\t%d\t|\t%s\t\t|\t\t%s    \t\t|%n",(i+1),supplierDetails[i][0],supplierDetails[i][1]);
                }
                System.out.println("+---------------+-----------------------+---------------------------------------+");

                while(true){
                    System.out.print("Enter supplier number > ");
                    int supplierNumber = scan.nextInt();
                    if (supplierNumber<=supplierDetails.length){
                        items[items.length-1][1]=supplierDetails[supplierNumber-1][0];
                        break;
                    }
                    System.out.println("Enter valid number ! ");
                }

                System.out.println("Item Categories:");
                System.out.println("+---------------+---------------------------------------+");
                System.out.println("|      #        |              CATEGORY NAME            |");
                System.out.println("+---------------+---------------------------------------+");
                for (int i = 0; i < category.length; i++){
                    System.out.printf("|\t%d\t|\t\t%s    \t\t|%n",(i+1),category[i]);
                }
                System.out.println("+---------------+---------------------------------------+");

                while(true){
                    System.out.print("Enter the category number > ");
                    int categoryNumber = scan.nextInt();
                    if (categoryNumber<=category.length){
                        items[items.length-1][2]=category[categoryNumber-1];
                        break;
                    }
                    System.out.println("Enter valid number ! ");
                }

                System.out.print("Description : ");
                items[items.length-1][3] = scan.next();
                System.out.print("Unit Price  : ");
                items[items.length-1][4] = scan.next();
                System.out.print("Qty on hand : ");
                items[items.length-1][5] = scan.next();
                System.out.print("successfully added!Do you want to add another item? (Y/N)? ");
                char supAddCategory = scan.next().charAt(0);

                switch (supAddCategory){
                    case 'Y','y' : {
                        whileCondition = true;
                    }
                    case 'N','n': {
                        break;
                    }
                }
            }
        }
    }
    public static void searchSupplierAndItem() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                            SEARCH SUPPLIER                          |");
        System.out.println("+---------------------------------------------------------------------+\n");

        while (true) {
            System.out.print("Enter Supplier Id: ");
            String supplierId = scan.next();
            System.out.print("Supplier Name: ");
            String supplierName = scan.next();

            boolean condition = false;
            for (int i = 0; i <supplierDetails.length ; i++) {
                if (supplierId.equals(supplierDetails[i][0]) && supplierName.equals(supplierDetails[i][1])) {
                    condition = true;
                }
            }
            if (condition) {
                System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
                System.out.println("|     ITEM CODE     |      DESCRIPTION         |    UNIT PRICE    |  QTY ON HAND  |    CATEGORY    |");
                System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
                for (int i = 0; i < items.length; i++){
                        System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |\n",items[i][0],items[i][3],items[i][4],items[i][5],items[i][2]);
                }
                System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
                L1: while(true) {
                    System.out.print("Search successful!Do you want to  another search ? (Y/N)");
                    char option = scan.next().charAt(0);

                    switch (option){
                        case 'Y', 'y': {
                            break L1;
                        }
                        case 'N', 'n': {
                          return;
                        }
                    }
                }
            }else {
                System.out.println("Invalid Supplier Id or Supplier Name!Please try again.");
            }
        }
    }
    public static void viewItem(){
        clearConsole();
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                               VIEW ITEMS                                |");
        System.out.println("+-------------------------------------------------------------------------+\n");

        for (int i = 0; i < category.length; i++){
            System.out.println(category[i]+" : ");
            System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
            System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |");
            System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
            for (int j = 0; j < items.length; j++){
                if (items[j][2].equals(category[i])){
                    System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |\n",items[j][1],items[j][0],items[j][3],items[j][4],items[j][5]);
                }
            }
            System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+\n\n");
        }
        while(true){
            System.out.print("Do you want to go stock management page(Y/N) ? ");
            char option = scan.next().charAt(0);
            switch (option){
                case 'Y', 'y': {
                    return;
                }
                case 'N', 'n': {
                    System.exit(0);
                } default: {
                    System.out.println("Please enter correct character !!");
                }
            }
        }
    }
    public static void sortItem(){
        double[] sortedAr=new double[items.length];
        for (int i = 0; i < items.length; i++)
            sortedAr[i]=Double.parseDouble(items[i][4]);

        for (int i = 0; i < sortedAr.length; i++){
            for (int j = 0; j < sortedAr.length-1; j++){
                if (sortedAr[j]>sortedAr[j+1]){
                    double x = sortedAr[j];
                    sortedAr[j]=sortedAr[j+1];
                    sortedAr[j+1]=x;
                }
            }
        }
        clearConsole();
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                            RANKED UNIT PRICE                            |");
        System.out.println("+-------------------------------------------------------------------------+\n");
        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
        System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |       CAT      |");
        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
        for (int i = 0; i < sortedAr.length; i++){
            for (int j = 0; j < items.length; j++){
                if( Double.parseDouble(items[j][4])==sortedAr[i]){
                    System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n",items[j][1],items[j][0],items[j][3],items[j][4],items[j][5],items[j][2]);
                }
            }
        }
        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");

        while(true){
            System.out.print("Do you want to go stock management page(Y/N) ? ");
            char option = scan.next().charAt(0);
            if(option=='Y' || option=='y'){
                return;
            }else if(option=='N' || option=='n'){
                System.exit(0);
            }else{
                System.out.println("Please enter correct character !!");
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
    public static void growCategory() {
        String[] temp = new String[category.length + 1];
        for (int i = 0; i < category.length; i++) {
                temp[i] = category[i];
        }
        category = temp;
    }
    public static void growItem() {
        String[][] temp = new String[items.length + 1][6];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
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
    public static void removeCategory() {
        String[] temp = new String[category.length-1];
        for (int i = 0, k=0; i < temp.length; i++) {
            if (category[i].equals("null")) {
                k++;
            }
            temp[i] = category[i+k];
        }
        category = temp;
    }
}
