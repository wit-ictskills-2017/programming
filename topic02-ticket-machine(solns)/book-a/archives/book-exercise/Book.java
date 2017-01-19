/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (TO DO: Insert your name here.)
 * @version (TO DO: Insert today's date here.)
 */
class Book
{
    // The fields
    private String author;
    private String title;
    // COMPLETE:  Add a field to store the ISBN
    private String ISBN;
    // COMPLETE:  Add a field to store the cost of the book
    private double cost;
    
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String author, String title)
    {
        //COMPLETE: set the author and title fields to the contents of 
        //          the passed parameters.
        this.author = author;
        this.title = title;
    }

    /**
     * Set the author, title, ISBN and cost fields when this object
     * is constructed.
     */
    //COMPELTE: write a second constructor that has four parameters and use
    //          the data in these parameters to update the instance fields
    //          Make sure that the cost of the book is greater than zero.
    public Book(String author, String title, String ISBN, double cost)
    {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        if (cost > 0)
        {
          this.cost = cost;
        }
        else
        {
          System.out.println ("Cost must be greater than zero.  You entered: " + cost);
        }
    }
    
    
    // COMPLETE: Add a getter method for each instance field (i.e. you 
    //           will write four methods here.
    public String getAuthor()
    {
        return author;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getISBN()
    {
        return ISBN;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    //  COMPLETE: Add a setter method for each instance field (i.e. you 
    //            will write four methods here.
    //            When writing the setter for the cost field, only update the cost fields
    //            if the value entered is greater than zero.
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }
    
    public void setCost(double cost)
    {
        if (cost > 0)
        {
          this.cost = cost;
        }
        else
        {
          System.out.println ("Cost must be greater than zero.  You entered: " + cost);
        }        
    }
}
