import java.util.ArrayList;

/**
 * A Store class which was 
 * specifically developed to demonstrate the use of 
 * an ArrayList of Product.
 * 
 * @author Siobhan Drohan
 * @version 1.0
 */
public class Store
{
    private String storeLocation;
    private ArrayList<Product> products;

    /**
     * Constructor for objects of class Store
     * @param storeLocation The city where the specific store is located
     */
    public Store(String istoreLocation)
    {
        storeLocation = istoreLocation;
        products = new ArrayList<Product>();
    }

    public String getStoreLocation()
    {
        return storeLocation;
    }
    
    public ArrayList<Product> getProducts()
    {
        return products;
    }
    
    public void setStoreLocation(String storeLocation)
    {
        this.storeLocation = storeLocation;
    }
    
    public void setProducts(ArrayList<Product> products)
    {
        this.products = products;
    }
    
    public void add(Product product)
    {
        products.add(product); 
    }

    public String listProducts()
    {
        String listOfProducts = "";
        for (int index = 0; index < products.size(); index++)
        {
            listOfProducts = listOfProducts + index + ": " + products.get(index).toString() + "\n";
        }
        if (listOfProducts.equals(""))
        {
            return "No products";
        }
        else
        {
            return listOfProducts;
        }    
    }

    public int size()
    {
        return products.size();
    }
    
    public void remove(int index)
    {
        if ((index >= 0) && (index < products.size()))
        {
            products.remove(index);
        }
    }

    public Product get(int index)
    {
        if ((index >= 0) && (index < products.size()))
        {
            return products.get(index);
        }
        return null;
    }

    public String cheapestProduct()
    {
        if (products.size() > 0)
        {
            Product cheapestProduct = products.get(0);
            for (Product product : products)
            { 
                if (product.getUnitCost() < cheapestProduct.getUnitCost() )  
                    cheapestProduct = product;
            }
            return cheapestProduct.getProductName();
        }
        else 
            return "No Products";
    }  
    
    public String toString()
    {
         return ( "Store location: " + storeLocation 
               + ".\nList of products in the store:\n"
               + listProducts());
    }
}
