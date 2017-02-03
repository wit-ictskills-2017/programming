import java.util.Scanner;

/**
 * This class runs the application and handles the Store with its Products.
 *  
 * @author Siobhan Drohan
 */
public class MenuController{

    private Scanner input;
    private Store store;

    public MenuController(){
        input = new Scanner(System.in);

        //read in the details....
        System.out.print("Please enter the store location: ");
        String location = input.nextLine();

        store = new Store(location);
        runMenu();
    }

    /*
     * mainMenu() - This method displays the menu for the application, 
     * reads the menu option that the user entered and returns it.
     * 
     * @return     the users menu choice
     */
    private int mainMenu()
    { 
        System.out.println("\fShop Menu");
        System.out.println("---------");     
        System.out.println("  1) Add a Product");    
        System.out.println("  2) Remove Product (by index)");        
        System.out.println("  3) List the Products");    
        System.out.println("  4) List the cheapest product");        
        System.out.println("---------");     
        System.out.println("  5) View store details"); 
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }

    /*
     * This is the method that controls the loop.
     */
    private void runMenu(){
        int option = mainMenu();
        while (option != 0){  
            switch (option){
                case 1:    addProduct();
                break;
                case 2:    System.out.println(store.listProducts());
                if (store.size() > 0){
                    System.out.print("Please enter the index for the product you wish to delete: ");
                    int index = input.nextInt();
                    store.remove(index);
                }
                break;
                case 3:    System.out.println(store.listProducts());
                break;
                case 4:    System.out.println(store.cheapestProduct());
                break;
                case 5:    System.out.println(store.toString());
                break;
                default:    System.out.println("Invalid option entered: " + option);
                break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = mainMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    //gather the product data from the user and create a new product.
    private void addProduct(){  
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.println("Enter the Product details...");
        System.out.print("\tName:  ");
        String productName = input.nextLine();
        System.out.print("\tCode (between 1000 and 9999):  ");
        int productCode = input.nextInt();
        System.out.print("\tUnit Cost:  ");
        double unitCost = input.nextDouble();
        System.out.print("\tIs this product in your current line (y/n): ");
        char currentProduct = input.next().charAt(0);
        boolean inCurrentProductLine = false;
        if ((currentProduct == 'y') || (currentProduct == 'Y'))
            inCurrentProductLine = true;

        store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
    }

}