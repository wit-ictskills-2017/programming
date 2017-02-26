
/**
 * This class is responsible for maintaining information relating to a DVD.
 * 
 * @author Siobhan Drohan and Mairead Meagher.
 * @version V2.0
 */
public class DVD
{
    private String title;

    /**
     * Constructor for objects of class DVD
     */
    public DVD(String title)
    {
        this.title = title;
    }
    
    /**
     * This mutator method sets the title of the DVD to 
     * the value passed.
     * 
     * @param  title   the new title of the DVD
    */
    public void setTitle(String title)
    {
      this.title = title;
    }

    /**
     * This mutator method returns the title of the DVD.
     * 
     * @return     the title of the DVD entered by the user
    */
    public String getTitle()
    {
      return title;
    }

    /**
     * This method prints the title of the DVD.
     * 
     * @return     the title of the DVD entered by the user
    */
    public String toString()
    {
      return title;
    }
}