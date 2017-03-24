import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DVDTest {

	private DVD dvd1, dvd2, dvd3;
	
    @Before
    public void setUp(){
		dvd1 = new DVD("The Hobbit(Director)");  //title with 20 characters 
		dvd2 = new DVD("The Steve Jobs Film");   //title with 19 characters
		dvd3 = new DVD("Avatar: Directors Cut"); //title with 21 characters
	}
    
    @After
    public void tearDown(){
    }

    @Test
	public void testConstructors(){
		assertEquals("The Hobbit(Director)", dvd1.getTitle());
		assertEquals("The Steve Jobs Film", dvd2.getTitle());
		assertEquals("Avatar: Directors Cu", dvd3.getTitle());
	}

    @Test
	public void testGetTitle(){
    	assertEquals("The Hobbit(Director)", dvd1.getTitle());
		assertEquals("The Steve Jobs Film", dvd2.getTitle());
		assertEquals("Avatar: Directors Cu", dvd3.getTitle());
	}

    @Test
	public void testSetTitle(){    	
		dvd1.setTitle("The Hobbit");  
    	assertEquals ("The Hobbit", dvd1.getTitle());
		dvd1.setTitle("The Hobbit (Director)");  //attempting to set title to 21 characters  
    	assertEquals ("The Hobbit (Director", dvd1.getTitle());
		dvd1.setTitle("The Hobbit(Director)");  //attempting to set title to 20 characters  
    	assertEquals ("The Hobbit(Director)", dvd1.getTitle());
    	dvd1.setTitle("The Hobbit:Director");  //attempting to set title to 20 characters  
    	assertEquals ("The Hobbit:Director", dvd1.getTitle());
	}
    
    @Test
	public void testToString(){
		assertEquals("DVD Title is: The Hobbit(Director)", dvd1.toString());
        assertEquals("DVD Title is: The Steve Jobs Film", dvd2.toString());
	    assertEquals("DVD Title is: Avatar: Directors Cu", dvd3.toString());
	}

}

