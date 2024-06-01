import java.util.*;

public class Investment{

	//All the variables from class are set Private so they cannot be accessed outside the class

	private String share_symbol;                //variablle to store symbol of share
	private String share_name;                  //variable to store name of share
	private int num_shares;                     //variable to store number of shares
	private double share_price;                 //variable to store price of one share
	private double share_book_value;            //variable to store book value of stock
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
     * @param book_value represents amount of value to be added
	*/
	//method adds book_value to the existing share_book_value
	public void add_book_value(double book_value)
	{
		share_book_value = share_book_value + book_value;
	}

	/**
     * @param shares represents number of shares to be added
	*/
	//Method adds shares to existing num_shares to update the value of shares
	public void add_num_shares(int shares)
	{
		num_shares = num_shares + shares;
	}

	 /**
     * @return returns price of a stock
    */
    //method returns price of a stock
	public double get_share_price()
	{
		return share_price;
	}

        /**
     * @param price represents price of one share
	*/
	//method sets variable share_price ot price
    public void set_share_price(double price)
	{
		share_price = price;
	}

	/**
     * @return returns book_value of stock
    */
    //method to used to get book value of a certain stock
	public double get_book_value()
	{
		return share_book_value;
	}

	/**
     * @param book_value represents book_value of stock
    */
    //method sets varaible share_book_value to book_value
	public void set_book_value(double book_value)
	{
        share_book_value = book_value;
	}
	
	 /**
     * @return return symbol of stock
    */
    //method returns symbol of stock
	public String get_share_symbol()
	{
		return share_symbol;
	}

	/**
      * @param symbol represents the symbol of a stock
    */
    //method sets variable share_symbol to symbol
	public void set_share_symbol(String symbol)
	{
		share_symbol = symbol;
	}

	/**
      * @return returns name of stock
    */
    //method returns name of stock
	public String get_share_name()
	{
		return share_name;
	}
    
    /**
     * @param name represents name of stock 
    */
    //method sets variable share_name to name
	public void set_share_name(String name)
	{
		share_name = name;
	}

	/**
     * @return returns number of shares of particular investment
	*/
	//Method returns numbers of shares of a particular investment
	public int get_num_shares()
	{
		return num_shares;
	}

	/**
     * @param shares represents number of shares 
    */
    //Method sets variable num_shares to shares 
	public void set_num_shares(int shares)
	{
		num_shares = shares;
	}

	//Constructors used to create a object of Search without any initializing values
	public Investment(){

	}

	/**
     * @param symbol share symbol passed as parameter
	*/
	public Investment(String symbol)
	{
		share_symbol = symbol;     //Stores variable symbol into share_symbol and create object of class MutualFund
	}

	/**
     * @param symbol Share symbol passed as parameter
     * @param name share name passes as a parameter
	*/
	//Creates a object of Search and initialize values of share_symbol and share_name respectively
	public Investment(String symbol, String name)
	{
		share_symbol = symbol;
		share_name = name;
	}

	/**
     * @param symbol Share symbol passed as parameter
     * @param name share name passed as a parameter
     * @param num_shares number of share passed as a parameter
    */
    //Create a object of class Search and initialize values of share_symbol, share_name and num_shares
	public Investment(String symbol, String name, int num_shares)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;              //Uses this keyword to refer to the num_shares at class level
	}

	/**
     * @param symbol Share symbol passed as parameter
     * @param name share name passed as a parameter
     * @param num_shares number of share passed as a parameter
     * @param share_price price of share passed as parameter
    */
    //creates a object of class Search and initialize values of share_symbol, share_name,share_price and num_shares
	public Investment(String symbol, String name, int num_shares, double share_price)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;         //Uses this keyword to refer to the num_shares at class level
		this.share_price = share_price;       //Uses this keyword to refer to the share_price at class level
	}

	/**
     * @param symbol Share symbol passed as parameter
     * @param name share name passed as a parameter
     * @param num_shares number of share passed as a parameter
     * @param share_price price of share passed as parameter
     * @param share_book_value book value of particular share passed as parameter
    */
    //creates a object of class Search and initialize values of share_symbol, share_name,share_price,share_book_value and num_shares
	public Investment(String symbol, String name, int num_shares, double share_price, double share_book_value)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;                   //Uses this keyword to refer to the num_shares at class level
		this.share_price = share_price;                 //Uses this keyword to refer to the share_price at class level
		this.share_book_value = share_book_value;       //Uses this keyword to refer to the share_book_value at class level
	}

}
