/**
 * A class that maintains information on a USBDrive.
 *
 * @author (Siobhan Drohan)
 * @version (24/01/2017)
 */
class USBDrive
{
    // The instance fields for a USBDrive object
    private String make;  
    private int capacity;   //measured in MB
    private String colour;
    private int usedSpace;
    
    /**
     * Set the fields to a default value when a USBDrive object
     * is constructed.
     */
    public USBDrive()
    {
        this.make = "unknown";
        this.capacity = 2000;
        this.colour = "unknown";
        this.usedSpace = 0;
    }

    /**
     * Set the make, capacity, colour fields when this object
     * is constructed.
     * 
     * @param make      The make of the USB Drive
     * @param capacity  The capacity, measured in MB, of the USB Drive
     * @param colour    The colour of the USB Drive
     */
    public USBDrive(String make, int capacity, String colour)
    {
        this.make = make;
        this.colour = colour;
        this.usedSpace = 0;
        
        if (capacity > 0)
        {
           this.capacity = capacity;
        }
        else
        {
          System.out.println ("Capacity must be greater than zero.  Defaulting to 2000 MB");
          this.capacity = 2000;
        }
    }
    
    /**
     *  The getter method for the instance field, make.
     *  
     *  @return the make of the USBDrive
     */
    public String getMake()
    {
        return make;
    }

    /**
     *  The getter method for the instance field, colour.
     *  
     *  @return the colour of the USBDrive
     */
    public String getColour()
    {
        return colour;
    }
    
    /**
     *  The getter method for the instance field, capacity.
     *  
     *  @return the capacity of the USBDrive
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /**
     *  The getter method for the instance field, usedSpace.
     *  
     *  @return the usedSpace of the USBDrive
     */
    public int getUsedSpace()
    {
        return usedSpace;
    }
    
    /**
     *  The setter method for the instance field, usedSpace.
     *  
     *  @param usedSpace The new value for the usedSpace field of the USBDrive; it must be greater than zero.
     */
    public void setUsedSpace(int usedSpace)
    {
        if (usedSpace > 0)
        {
          this.usedSpace = usedSpace;
        }
        else
        {
          System.out.println ("Used space must be greater than zero.  You entered: " + usedSpace);
        }        
    }
}