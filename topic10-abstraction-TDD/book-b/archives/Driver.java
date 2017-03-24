import java.util.Scanner;

/**
 * The Driver class is a menu driven application where the user can choose to 
 * enter DVD titles (which are then stored as Strings in the ArrayList dvds) 
 * or display a list of all the DVD titles stored in the ArrayList dvds.  
 * 
 * @author Siobhan Drohan and Mairead Meagher.
 * @version 2.0
 */
public class Driver 
{
	private Scanner input;
	Library library;

	/**
	 * Constructor for objects of class MyDVDs
	 */
	public Driver()
	{
		input = new Scanner(System.in);
		library = new Library ();
	}


	public static void main(String args[])
	{
		Driver app = new Driver();
		app.run();
	}


	/*
	 * mainMenu() - This method displays the menu for the application, 
	 * reads the menu option that the user entered and returns it.
	 * 
	 * @return     the users menu choice
	 */

	private int mainMenu()
	{
		System.out.println("My DVD Library");
		System.out.println("  1) Add a DVD");
		System.out.println("  2) List all DVDs");
		System.out.println("  3) Update a DVD");
		System.out.println("  4) Delete a DVD");
        System.out.println("---------");     
        System.out.println("  5) Save dvds (XML)"); 
        System.out.println("  6) Load dvds (XML)"); 
		System.out.println("  0) Exit");
		System.out.print("==>>");
		int option = input.nextInt();
		return option;
	}

	/*
	 * run() - This method displays the menu and processes the user's menu choice.  
	 */
	private void run()
	{
		int option = mainMenu();
		while (option != 0)
		{
			switch (option)
			{
			case 1:
					addDVD();
					break;
			case 2:
					System.out.println(library.listDVDs());
					break;
			case 3:
					updateDVD();
					break;
			case 4:
					deleteDVD();
					break;			
            case 5: try {
            			library.save();
  		   			}
  		   			catch (Exception e) {
  		   				System.err.println("Error writing to file: " + e);
  		   			}
  	       			break;
            case 6: try {
            			library.load();
   			   		}
   			   		catch (Exception e) {
   			   			System.err.println("Error reading from file: " + e);
   			   		}
  	       			break;				
				
			default:
				System.out.println("Invalid option selected.");
				break;
			}

			//display the main menu again
			System.out.println("");
			option = mainMenu();
		}
		System.out.println("Exiting... bye");
	}

	private void addDVD()
	{
		System.out.print("DVD title: ");
		String dvdTitle = input.nextLine();
		dvdTitle = input.nextLine();
		library.add(new DVD(dvdTitle));
	}


	private void updateDVD()
	{
		//list the DVDs and ask the user to choose the dvd to edit
		int index = getIndex();
		if (library.isValidIndex(index)){	
			//if the index number exists in the ArrayList, delete it from the ArrayList
			System.out.print("\tEnter a new dvd title: ");
			input.nextLine();
			String desc = input.nextLine();
			//retrieve the DVD from the ArrayList and update the details with the user input
			DVD dvd = library.getDVDs().get(index);
			dvd.setTitle(desc);
		}
	} 

	private void deleteDVD()
	{
		//list the DVDs and ask the user to choose the dvd to delete
		int index = getIndex();
		if (library.isValidIndex(index)){	
			//if the index number exists in the ArrayList, delete it from the ArrayList
			library.getDVDs().remove(index);
			System.out.println("DVD deleted.");
		}
	} 

	private int getIndex()
	{
		System.out.println(library.listDVDs());
		if (!library.getDVDs().isEmpty()){	
			//only process if DVDs exist in the ArrayList
			System.out.print("Enter the index of DVD ==> ");
			int index = input.nextInt();
			if ((index >= 0) && (index < library.getDVDs().size()))
			{
				return index;  //valid index
			}
			else
			{
				System.out.println("Invalid index entered: " + index);
				return -1;  //error code - invalid index entered
			}
		}
		else
		{
				return -2;  //error code - empty array list
		}
	}
	
}