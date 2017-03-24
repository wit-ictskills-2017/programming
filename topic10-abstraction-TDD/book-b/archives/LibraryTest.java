import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

	private Library library, populatedLibrary;
	private DVD dvd1, dvd2, dvd3;
	private ArrayList<DVD> emptyDVDs, populatedDVDs;

	@Before
	public void setUp() throws Exception {
	   
	   library = new Library();
	   emptyDVDs = new ArrayList<DVD>();
	   
	   populatedDVDs = new ArrayList<DVD>();
	   dvd1 = new DVD("The Hobbit(Director)");  //title with 20 characters
       dvd2 = new DVD("The Steve Jobs Film");   //title with 19 characters
       dvd3 = new DVD("Avatar: Directors Cut"); //title with 21 characters
       populatedDVDs.add(dvd1);
       populatedDVDs.add(dvd2);
       populatedDVDs.add(dvd3);
       populatedLibrary = new Library();
       populatedLibrary.setDVDs(populatedDVDs);	   
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
         assertEquals(0, library.getDVDs().size());
    }
	
    @Test
	public void testAdd()
 	{
    	//Testing the ArrayList is Empty
 		assertEquals(0, library.getDVDs().size());
  	    
 		//Testing the adding of the first dvd
 		library.add(dvd1);
  	    assertEquals(1, library.getDVDs().size());
	    assertEquals("The Hobbit(Director)", library.getDVDs().get(0).getTitle());
	    		
 		//Testing the adding of the second dvd
  	    library.add(new DVD("Peppa Pig"));
	    assertEquals(2, library.getDVDs().size());
	    assertEquals("Peppa Pig", library.getDVDs().get(1).getTitle());
 	}
    
    @Test
    public void testGetDVDs()
    {
       	//The new library object returns an empty ArrayList of DVD
        assertEquals(0, library.getDVDs().size());
        assertEquals(emptyDVDs, library.getDVDs());
        
        //The populated library object returns an ArrayList with three items
        assertEquals(3, populatedLibrary.getDVDs().size());
        assertEquals(populatedDVDs, populatedLibrary.getDVDs());
    }
    
    @Test
    public void testListDVDs()
    {
       	//The new library object returns an empty String
        assertEquals("No DVDs.", library.listDVDs());
        
        //The populated library object returns an String listing three items
        assertEquals("0:DVD Title is: The Hobbit(Director)\n"
        		   + "1:DVD Title is: The Steve Jobs Film\n"
        		   + "2:DVD Title is: Avatar: Directors Cu\n", 
        		   populatedLibrary.listDVDs());
    }

    @Test
    public void testSaveAndLoad() throws Exception
    {
    	//TESTING AN EMPTY ARRAYLIST
    	//--------------------------
       	//Saving a new library object with an empty ArrayList of DVD
        assertEquals(0, library.getDVDs().size());
        assertEquals(emptyDVDs, library.getDVDs());
    	library.save();
    	//Load the file into another library object and compare it to emptyDVDs
    	Library library2 = new Library();
    	library2.load();
    	assertEquals(library2.getDVDs().size(), library.getDVDs().size());
    	
    	//TESTING A POPULATED ARRAYLIST
    	//-----------------------------
       	//Saving a library object with a populated ArrayList of DVD
        assertEquals(3, populatedLibrary.getDVDs().size());
        assertEquals(populatedDVDs, populatedLibrary.getDVDs());
    	populatedLibrary.save();
    	//Load the file into another library object and compare it to populatedLibrary
    	Library library3 = new Library();
    	library3.load();
    	assertEquals(library3.getDVDs().size(), populatedLibrary.getDVDs().size());
    	assertEquals(library3.getDVDs().get(1).getTitle(), populatedLibrary.getDVDs().get(1).getTitle());
    	assertEquals(library3.getDVDs().get(2).getTitle(), populatedLibrary.getDVDs().get(2).getTitle());
    }
    
    @Test
    public void testIsValidIndex() {
       	//Boundary testing the library object, which has an empty ArrayList of DVDs.
        assertEquals(0, library.getDVDs().size());
    	assertEquals(false, library.isValidIndex(-1));
        assertEquals(false, library.isValidIndex(0));
        assertEquals(false, library.isValidIndex(1));
        
        //Boundary testing the library object which has an ArrayList of three DVDs.
        //lower boundary tests / fence post error testing
        assertEquals(3, populatedLibrary.getDVDs().size());
        assertEquals(false, populatedLibrary.isValidIndex(-1));
        assertEquals(true, populatedLibrary.isValidIndex(0));
        assertEquals(true, populatedLibrary.isValidIndex(1));
        //upper boundary tests / fence post error testing
        assertEquals(true, populatedLibrary.isValidIndex(2));
        assertEquals(false, populatedLibrary.isValidIndex(3));
    }
}
