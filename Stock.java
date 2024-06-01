import java.util.*;

public class Stock extends Investment{

	//All the variables from class are set Private so they cannot be accessed outside the class

    private String share_symbol;       //variablle to store symbol of share
	private String share_name;         //variable to store name of share
	private int num_shares;            //variable to store number of shares
	private double share_price;         //variable to store price of one share
	private double share_book_value;    //variable to store book value of stock
	private double gain = 0;            //variable to store gain from a stock
	private char investment_type;


    /**
     * @param localgain represents the type of investment that is  stock
	*/
	//method sets variable investment_type equal to localtype
	public void set_investment_type(char localtype)
	{
		investment_type = localtype;
	}
    
    /**
     * @return returns the type of the investment that is stock
    */
    //method returns the type of investment that is stock
	public char get_investment_type()
	{
		return investment_type;
	}

	/**
     * @param localgain represents gain to be added
	*/
	//method adds localgain to varaible gain
	public void add_gain(Double localgain)
	{
		gain = gain + localgain;
	}

	/**
     * @param localgain represents the gain from stock
	*/
	//method sets variable gain eual to localgain
	public void set_gain(Double localgain)
	{
		gain = localgain;
	}
    
    /**
     * @return returns the gain from the stock
    */
    //method returns the gain from stock
	public double get_gain()
	{
		return gain;
	}

	//Constructors used to create a object of Stock without any initializing values
	public Stock(){

	}

	/**
     * @param symbol share symbol passed as parameter
	*/
	public Stock(String symbol)
	{
		share_symbol = symbol;  //Stores variable symbol into share_symbol and create object of class Stock
	}

	/**
     * @param symbol Share symbol passed as parameter
     * @param name share name passes as a parameter
	*/
	//Creates a object of Stock and initialize values of share_symbol and share_name respectively
	public Stock(String symbol, String name)
	{
		share_symbol = symbol;
		share_name = name;
	}
    
    /**
     * @param symbol Share symbol passed as parameter
     * @param name share name passed as a parameter
     * @param num_shares number of share passed as a parameter
    */
    //Create a object of class stock and initialize values of share_symbol, share_name and num_shares
	public Stock(String symbol, String name, int num_shares)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;       //Uses this keyword to refer to the num_shares at class level
	}
    
    /**
     * @param symbol Share symbol passed as parameter
     * @param name share name passed as a parameter
     * @param num_shares number of share passed as a parameter
     * @param share_price price of share passed as parameter
    */
    //creates a object of class stock and initialize values of share_symbol, share_name,share_price and num_shares
	public Stock(String symbol, String name, int num_shares, double share_price)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;             //Uses this keyword to refer to the num_shares at class level
		this.share_price = share_price;           //Uses this keyword to refer to the share_price at class level
	}
    
    /**
     * @param symbol Share symbol passed as parameter
     * @param name share name passed as a parameter
     * @param num_shares number of share passed as a parameter
     * @param share_price price of share passed as parameter
     * @param share_book_value book value of particular share passed as parameter
    */
    //creates a object of class stock and initialize values of share_symbol, share_name,share_price,share_book_value and num_shares
	public Stock(String symbol, String name, int num_shares, double share_price, double share_book_value)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;             //Uses this keyword to refer to the num_shares at class level
		this.share_price = share_price;           //Uses this keyword to refer to the share_price at class level
		this.share_book_value = share_book_value; //Uses this keyword to refer to the share_book_value at class level
	}
}