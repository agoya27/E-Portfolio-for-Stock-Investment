import java.util.*;

public class Search extends Investment{

	//All the variables from class are set Private so they cannot be accessed outside the class

	private String share_symbol;                //variablle to store symbol of share
	private String share_name;                  //variable to store name of share
	private int num_shares;                     //variable to store number of shares
	private double share_price;                 //variable to store price of one share
	private double share_book_value;            //variable to store book value of stock

	//Constructors used to create a object of Search without any initializing values
	public Search(){

	}

	/**
     * @param symbol share symbol passed as parameter
	*/
	public Search(String symbol)
	{
		share_symbol = symbol;     //Stores variable symbol into share_symbol and create object of class MutualFund
	}

	/**
     * @param symbol Share symbol passed as parameter
     * @param name share name passes as a parameter
	*/
	//Creates a object of Search and initialize values of share_symbol and share_name respectively
	public Search(String symbol, String name)
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
	public Search(String symbol, String name, int num_shares)
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
	public Search(String symbol, String name, int num_shares, double share_price)
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
	public Search(String symbol, String name, int num_shares, double share_price, double share_book_value)
	{
		share_symbol = symbol;
		share_name = name;
		this.num_shares = num_shares;                   //Uses this keyword to refer to the num_shares at class level
		this.share_price = share_price;                 //Uses this keyword to refer to the share_price at class level
		this.share_book_value = share_book_value;       //Uses this keyword to refer to the share_book_value at class level
	}

}
