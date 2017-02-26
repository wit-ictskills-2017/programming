import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class maintains a list of DVDs.
 * 
 * @author Siobhan Drohan and Mairead Meagher.
 * @version 1.0
 */
public class Library {

	private ArrayList<DVD> dvds;

	/**
	 * Constructor for the Library class.  
	 */
	public Library()
	{
		dvds = new ArrayList<DVD>();
	}

	/** 
	 * Adds a DVD to the list of DVDs
	 * 
	 * @param dvd The DVD to be added to the list.
	 */
	public void add(DVD dvd)
	{
		dvds.add(dvd);
	}


	public ArrayList<DVD> getDVDs()
	{
		return dvds;
	}

	/**
	 * Determine if a passed index is valid or not.
	 * 
	 * @param index  the index that needs to be validated
	 * @return Whether the passed index is valid or not
	 */
	public boolean isValidIndex(int index)
	{
		return ( (index >= 0) && (index < dvds.size()) );
	}

	/**
	 * Returns a String containing the index number and the 
	 * title of each element in the dvds ArrayList to the console.  
	 * 
	 * @return Returns a String containing the index number and the 
	 * title of each element in the dvds ArrayList to the console.  If there are no 
	 * DVDs in the list, "No DVDs" is returned.
	 */
	public String listDVDs()
	{
		if (dvds.size() == 0)
		{
			return "No DVDs.";
		}
		else
		{
			String listDVDs = "";
			for (int i = 0; i < dvds.size(); i++)
			{
				listDVDs = listDVDs + (i + ":" + dvds.get(i)) + "\n";
			}
			return listDVDs;
		}

	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream
				(new FileReader("dvds.xml"));
		dvds = (ArrayList<DVD>) is.readObject();
		is.close();
	}

	public void save() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream
				(new FileWriter("dvds.xml"));
		out.writeObject(dvds);
		out.close();    
	}

}