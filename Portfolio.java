import java.util.*;
import java.io.*;

/*The main class for the program containing main method
  This class consists of main method which has multiple functionalities mentioned in the comments in main method
*/
public class Portfolio{
    
    /**
     * @param args[] Stores the command line arguments from the terminal
	*/
    /*Main method: This method will run and control the entire program
      The Method contains a various function calls to create Arraylist and manage it
      The Method contains functions calls to create and manage Hashmap
      The Method contains a while loop which runs over to ask user input until user ends the program
    */
	public static void main (String args[]){

        /*
          Arraylist investment_array is a arraylist of type Investment
          investment_array is used to store all the objects of Investment class
        */
        ArrayList <Investment> investment_array = new ArrayList<Investment>();
        int investment_count = 0;

        /*
          Hashmap index is used to keep record of all Name keys in a Key value pair
          The Keys of Hashmap will store the words in name of certain investment
          The value will store a Arraylist corresponding to the name word 
        */
        HashMap<String,ArrayList<Integer>> index = new HashMap<String,ArrayList<Integer>>();

        //The if statemment checks if user entered a command line arguments 
        //User will be notifies that they did not mention any file name if there are no arguments
        //Else block will call the function take_input_from_file if there is a command line argument
        //After taking input from file, Hashmap ndex will be updated with all the name words
        if(args.length == 0)
        {
            System.out.println("You did not mention any input file, your portfolio is empty for now");
            System.out.println("-------------------------------------");
        }
        else
        {
            investment_count = take_input_from_file(investment_array,investment_count,args[0]);
            add_indexes_to_map(investment_array,index);
        }
        //Prints welcome message for the user
		System.out.println("Welcome the the program!! Please select a option from menu below:");                                                  //user can select 6 if they want to end the program

		//Creates a object of scanner class to scan the data that user inputs
		Scanner input = new Scanner(System.in);

		//The while loop runs until the user wishes to end the program, selcting option 6 will break the loop
		while(true)
		{
			System.out.println("-------------------------------------");
            System.out.println("Buy a new investment or add more quantity to existing investment ->1 ");  //User can select 1 if they want to buy 
            System.out.println("Sell an investment  -> 2");                                               //user can select 2 if they want to sell
            System.out.println("update prices of all existing investments -> 3");                         //user can selct 3 if they want to update prices
            System.out.println("Compute total gain of the portfolio-> 4");                                //user can select 4 if they want to get the total gain 
            System.out.println("Search for a specific investment -> 5");                                  //user can select 5 if they want to searh for a investment
            System.out.println("End the program -> 6");                                         //user can select option 6 if they want to finish the program
            System.out.println("Please choose a number");

			//variable choicenumber stores the userinput 
			//choicenumber will be used to check the option that user selected
			int choicenumber = input.nextInt();
            //choicenumber = 1 will allow the user to buy investment
            //Method buy_investment will be called to add Investment to Arraylist
            //Method add_indexes_to_map will be called to update the name words in Hashmap
            if(choicenumber == 1)
            {
                 investment_count = buy_investment(investment_array,investment_count);
                 add_indexes_to_map(investment_array,index);
            }

            //choicenumber = 2 will allow the user to sell investment
            //Method sell_investment will be called to sell certain investment
            else if(choicenumber == 2)
            {
            	investment_count = sell_investment(investment_array,investment_count,index);
            }

            //choicenumber = 3 will allow the user to update the price of every investment investment
            //Method update_investment_price will be called to update the price of each investment
            else if(choicenumber == 3)
            {
                update_investment_price(investment_array);
            }

            //choicenumber =4 will allow user to get the total gain of their profile
            //Method compute_total_gain will be called to calculate and print the total gain of portfolio
            else if(choicenumber == 4)
            {
                compute_total_gain(investment_array);
            }

            //choicenumber = 5 ill allow user to search for a particular investment
            //Method search_investment will be called to search a particular investment
            else if(choicenumber == 5)
            {
                search_investment(investment_array,index);
            }
            //choicenumber =6 will allow the user to finish the program
            else if(choicenumber == 6)
            {
            	break;
            }

            //else condition print a message if user select invalid option
            else
            {
            	System.out.println("Please make a valid choice");
            }
		}
        
        //we will store/update the file data before finishing our program if input was taken from file
        //Method write_output_to_file will be called to write output back to the file
        if(args.length != 0){
            write_output_to_file(investment_array,args[0]);
        }
        System.out.println("Program Finish");

	}

	/**
     * @param localarray Stores all the investment in an Arraylist
     * @param localindex Stores all the Map keywords and values 
	*/
	/*
       Method is used to search for a specific investment that exists in a Portfolio
       Method will ask user for inputs such as Price range,Symbol and Name Keywords to search Investment
	*/
	public static void search_investment(ArrayList<Investment> localarray,HashMap<String,ArrayList<Integer>> localindex)
    {
         System.out.println("Type the symbol of investment or leave it empty and just press enter ");
         Scanner myscan = new Scanner(System.in);
         String search_symbol = myscan.nextLine();                 //variable search_symbol stores the symbol of investment to be searched
         System.out.println("Please enter the keywords for search or just leave it empty and just press enter");
         String search_keywords = myscan.nextLine();               //varaible search search_keywords stores the keywordds to be searched in name of investment
         System.out.println("Please enter the price range for search or just leave it empty and just press enter");
         String search_pricerange = myscan.nextLine();          //Variable search_pricerange stores the price range for the investment 
         int search_pricerange_exist;
         int search_symbol_exist;         //The 3 int variables are to check if the respective criteria of the search input exists
         int search_keywords_exist;
         //A new arraylist of class Search objects is created to search all the investments in the portfolio
         ArrayList<Investment> search_array = new ArrayList<Investment>();

         if(search_pricerange.isEmpty())     //if statement checks if the pricerange exist in the search format or not 
         {
              search_pricerange_exist = 0;       //variable search_pricerange_exist is set to 0 if pricerange does not exists
         }
         else
         {
              search_pricerange_exist = 1;      //variable search_pricerange_exist is set to 1 if pricerange exists
         }

         if(search_keywords.isEmpty())     //if statement checks if the search_keywords exist in the search format or not
         {
              search_keywords_exist = 0;       //variable search_keywords_exist is set to 0 if keywords does not exists
         }
         else
         {
              search_keywords_exist = 1;      //variable search_keywords_exist is set to 1 if kerwords exists
         }

         if(search_symbol.isEmpty())       //if statement checks if the search_symbol exist in the search format or not
         {
              search_symbol_exist = 0;       //variable search_symbol_exist is set to 0 if search_symbol does not exists
         }
         else
         {
              search_symbol_exist = 1;      //variable search_symbol_exist is set to 1 if search_symbol exists
         }

         if(search_keywords_exist == 1) //if statement checks if the search keywords exist or not
         {
             String words[] = search_keywords.split("[ ]+");   //the string entered by user into broken into array of strings using split function 
             int num_added = 0;
             ArrayList <Integer> temp_array = new ArrayList<Integer>(); 
              if(words.length > 0)
              {
                  //Word is converted to lower case to check case insensitivity
                  String word = words[0].toLowerCase();
                  if(localindex.containsKey(word))
                  {
                      for(int j=0;j<localindex.get(word).size();j++)
                      {
                           int num_in_list = localindex.get(word).get(j);      //All the number is value list will be stored in num_in_list one at a time
                           int numberofshare = localarray.get(num_in_list).get_num_shares();
                           double bookvalue = localarray.get(num_in_list).get_book_value();
                           double shareprice = localarray.get(num_in_list).get_share_price();
                           String sharename = localarray.get(num_in_list).get_share_name();
                           String sharesymbol = localarray.get(num_in_list).get_share_symbol();
                           temp_array.add(num_in_list);
                           search_array.add(num_added,new Search());  //new object created and added to search_array
                           search_array.get(num_added).set_num_shares(numberofshare);
                           search_array.get(num_added).set_book_value(bookvalue);
                           search_array.get(num_added).set_share_price(shareprice);
                           search_array.get(num_added).set_share_name(sharename);
                           search_array.get(num_added).set_share_symbol(sharesymbol);
                           num_added++;  //num_added will be incremented after adding a new object to our search array
                      }
                  }

              }
              if(words.length > 1)
              {
                  if(search_array.size() == 0)
                  {

                  }
                  else
                  {
                       for(int i=1;i<words.length;i++)
                       {
                           String word = words[i].toLowerCase();
                           if(localindex.containsKey(word))
                           {
                           	   for(int j=0;j<temp_array.size();j++)
                           	   {
                           	   	   if(localindex.get(word).contains(temp_array.get(j)))
                           	   	   {

                           	   	   }
                           	   	   else
                           	   	   {
                           	   	   	    search_array.remove(j);
                           	   	   }
                           	   }
                           }
                       }
                  }	 
              }
             
        }
        else
        {   
            //If keywords does not exist in certain search request then all the Investment will be stored to our Searh_array 
            for(int i=0; i<localarray.size();i++)
            {
                 //The for loops calculate the various Investment properties for each Investment 
            	//A new search object is created and all the investment properties are updates for the object
                 int numberofshare = localarray.get(i).get_num_shares();
                 double bookvalue = localarray.get(i).get_book_value();
                 double shareprice = localarray.get(i).get_share_price();
                 String sharename = localarray.get(i).get_share_name();
                 String sharesymbol = localarray.get(i).get_share_symbol();
                 search_array.add(i,new Search());  //new object created and added to search_array
                 search_array.get(i).set_num_shares(numberofshare);
                 search_array.get(i).set_book_value(bookvalue);
                 search_array.get(i).set_share_price(shareprice);
                 search_array.get(i).set_share_name(sharename);
                 search_array.get(i).set_share_symbol(sharesymbol);
            }
        }

        if(search_symbol_exist == 1)  //if statement checks if the search symbol exist or not
        {
        //the for loop goes through all the search_array objects and match its share_symbol with the symbol being searched for
            for(int i=0;i<search_array.size();i++)
            {
                String sharesymbol = search_array.get(i).get_share_symbol();
                if(search_symbol.equals(sharesymbol) == false)       //if statement to check if the search_symbol equals sharesymbol
                {
                    search_array.remove(i);     //the object is removed from the search array if the symbol does not matches
                    i = i-1;
                }
            }
        }
        if(search_pricerange_exist == 1)  //if statement checks if the search pricerange exists or not
        {
            //this is to check if the price range is a range of numbers or just a number itself
            if(search_pricerange.contains("-") == false)   //if statement checks if the pric range contains character "-" or not
            {
                if(search_pricerange.contains(" "))
                {
                	System.out.println("The price range you gave was invalid");
                }
                else
                {
                    double price = Double.parseDouble(search_pricerange);
                    //the for loop goes thorugh all objects in search_array and checks if price of share is equal to price entered by user or not
                    for(int i=0;i<search_array.size();i++)     
                    {
                        Double shareprice = search_array.get(i).get_share_price();
                        if(shareprice != price)   //if statement to check wheter shareprice is equal to price or not
                        {
                            search_array.remove(i);      //the object is removed from search_array if the shareprice and price are not equal
                            i=i-1;
                        }
                    }
                }
            }

            else //else bracket if the practice range contains "-" in it
            {
                String words[] = search_pricerange.split("[-]+"); //the pricerange string in split into array of strings and stored in words array
                //the length of words will be equal to 1 if the range is of type number-
                //in that case we will search for all shares with share price greater than or equal to number
                if(words.length == 1)    //if statement checks the length of words array
                {
                    double price = Double.parseDouble(words[0]);
                    //the for loop goes thorugh all objects in search_array and checks if price of share is greater than or equal to price entered by user or not
                    for(int i=0;i<search_array.size();i++)
                    {
                        double shareprice = search_array.get(i).get_share_price();
                        if(shareprice < price)  //if statement to check if shareprice is less than price entered by user
                        {
                            search_array.remove(i);     //the object is removed from search_array if shareprice is small than price
                            i = i-1;
                        }
                    }
                }

                else
                {
                    //if the sreach range is of type -number than the words[0] string will be a empty string
                    //in this case we will search for all shares with share price less than or equal to number
                    if(words[0].isEmpty())  //if statement to check if the string at words[0] position is empty string or not
                    {
                        double price = Double.parseDouble(words[1]);
                        //the for loop goes thorugh all objects in search_array and checks if price of share is smaller than or equal to price entered by user or not
                        for(int i=0;i<search_array.size();i++)
                        {
                            double shareprice = search_array.get(i).get_share_price();
                            if(shareprice > price)        //if statement to check if shareprice is more than price entered or not
                            {
                                search_array.remove(i);      //the object is removed from search_array if shareprice is bigger than price
                                i = i-1;
                            }
                        }
                    }


                    else //else statement if the price range is to type number-othernumber
                    //for this case we will search for all shares with share price higher than or equal to lowprice and lower than or equal to highprice
                    {
                        double lowprice = Double.parseDouble(words[0]);
                        double highprice = Double.parseDouble(words[1]);
                        for(int i=0;i<search_array.size();i++)
                        {
                            double shareprice = search_array.get(i).get_share_price();
                            if(shareprice < lowprice || shareprice > highprice)    //if statemen to check if shareprice is in range or not
                            {
                                search_array.remove(i);        //the object is removed from search_array if shareprice is nt in the range 
                                i = i-1;
                            }
                        }
                    }
                              
                }  
            }
        }

        for(int i=0;i<search_array.size();i++)  //the for loop prints all the objects in search_array after going through the search algorithm
        {
            System.out.println("my symbol: " + search_array.get(i).get_share_symbol());
            System.out.println("my name:" + search_array.get(i).get_share_name());
            System.out.println("my shares:" + search_array.get(i).get_num_shares());
            System.out.println("my price :" + search_array.get(i).get_share_price());
            System.out.println("my book value:" + search_array.get(i).get_book_value());
        }
    }

    /**
     * @param localarray Stores all the investment in an Arraylist
     * @param localindex Stores all the Map keywords and values 
     * @param localposition Stores the position of investmen to be deleted
	*/
	//The method Deletes from Hashmap, the details of Investment to be deleted
	//The method will also delete any key value pair if the Arraylist gets empty during 1st requirement
	//The method also reduces all values of investment greater than localpositon by one
    public static void delete_indexes_from_map(ArrayList<Investment> localarray,HashMap<String,ArrayList<Integer>> localindex,int localposition)
    {
        String name = localarray.get(localposition).get_share_name(); //Name of Investment to be deleted is stored in name
        int position_reqd = 0;
        String words[] = name.split("[ ]+");  //name is broken into array of strings using the split function
        for(int i=0;i<words.length;i++)
        {
            String word = words[i].toLowerCase();   //Lower case method is used to maintain case insensitivity in the map
            if(localindex.containsKey(word))        //checks if the Hashmap contains a certain keyword in its Keyset
            {
                //The for loop is used to loop through all list objects related to certain key in the Hashmap
                for(int j=0;j<localindex.get(word).size();j++)
                {
                    //If the Arraylist stores the position of Investment to deleted than that list position is stored
                    if(localindex.get(word).get(j) == localposition)
                    {
                        position_reqd = j;
                    }
                }
                //we will remove the value at list position found above in the loop
                localindex.get(word).remove(position_reqd);
            }
        }

        //The for loop is used to decrement all the values greater than localposition
        for(int i=0;i<localarray.size();i++)
        {
            String name_ = localarray.get(i).get_share_name();
            String name_words[] = name_.split("[ ]+");  //All the name keywords are stored in an array of string
            for(int j=0;j<name_words.length;j++)
            {
                String my_word = name_words[j].toLowerCase();
                //A temporary arraylist is declared to store the value arraylist and decrement the values in it
                ArrayList <Integer> temp_array = new ArrayList<Integer>();
                int size_of_list = localindex.get(my_word).size();
                for(int l=0;l<size_of_list;l++)
                {
                     temp_array.add(localindex.get(my_word).get(l)); //All the arraylist values are stored in our temp list
                }
                for(int l=0;l<temp_array.size();l++)
                {
                     if(temp_array.get(l)>localposition) //If statement checks if value stored in greater than localposition
                     {
                          int num = temp_array.get(l);
                          num = num - 1;
                          temp_array.remove(l);  //List object with value greater than localposition will be removed
                          temp_array.add(l,num); //New list object with decrementd value will be added at same position
                     }
                }
                localindex.put(my_word,temp_array); //The updated temp list is stored in the Hashmap to update values

             }
        }

        //The for loops checks if certain value list is empty and thus removes it from Hashmap
        for(int i=0;i<localarray.size();i++)
        {
            String name_ = localarray.get(i).get_share_name();
            String name_words[] = name_.split("[ ]+");
            for(int j=0;j<name_words.length;j++)
            {
                String my_word = name_words[j].toLowerCase();
                if(localindex.containsKey(my_word))  
                {
                    if(localindex.get(my_word).isEmpty()) //The if statement checks if the list is empty
                    {
                        localindex.remove(my_word);  //Key is removed from Hashmap if list is empty
                    }
                }
            }
        }
    }

    /**
     * @param localarray Stores all the investment in an Arraylist
     * @param localindex Stores all the Map keywords and values 
	*/
    //Method is used to add Objects to Haspmap and Update the hashmap after buying new Investments
    public static void add_indexes_to_map(ArrayList<Investment> localarray,HashMap<String,ArrayList<Integer>> localindex)
    {
        for(int i=0;i<localarray.size();i++)
        {
            String name = localarray.get(i).get_share_name();  //String name stores the name of particular investment
            String name_words[] = name.split("[ ]+");
            for(int j=0;j<name_words.length;j++)
            {
                String my_word = name_words[j].toLowerCase();
                if(localindex.containsKey(my_word))     //if statement checks if certain keywords already exist in Hashmap
                {
                     if(localindex.get(my_word).contains(i))  //Check if certain investment number already exists in the list
                     {

                     }
                     else
                     {
                        localindex.get(my_word).add(i);  //If not then the investment number is added to the list
                     }
                     
                }
                else
                {
                     //If the keyword does not exist then new Key-value pair will be created and stored 
                     localindex.put(my_word,new ArrayList<Integer>());
                     localindex.get(my_word).add(i);
                }
            }
        }

    }

    /**
     * @param localarray Stores all the investment in an Arraylist
     * @param file_name Stores the name of the file 
	*/
    //The method is use to write back data into file once user chooses to end the program
    public static void write_output_to_file(ArrayList<Investment> localarray,String file_name)
    {
        System.out.println("Writing the data to the file");
        try
        {
             //write_to_file object will open file in write mode to enter information to file
             PrintWriter write_to_file = new PrintWriter(file_name,"UTF-8");
             for(int i=0;i<localarray.size();i++)
             {
                //if condition checks if investment type is of Stock or Mutual Fund
                if(localarray.get(i).get_investment_type() == 'a' || localarray.get(i).get_investment_type() == 'A')
                {
                    write_to_file.println("type = \"stock\"");  //print the investment type in file
                }
                else
                {
                    write_to_file.println("type = \"MutualFund\"");
                }
                   //the following lines are all used to write various investment information to the file
                    write_to_file.println("symbol = \"" + localarray.get(i).get_share_symbol() + "\"");
                    write_to_file.println("name = \"" + localarray.get(i).get_share_name() + "\"");
                    write_to_file.println("quantity = \"" + localarray.get(i).get_num_shares() + "\"");
                    write_to_file.println("price= \"" + localarray.get(i).get_share_price() + "\"");
                    write_to_file.println("bookvalue = \"" + localarray.get(i).get_book_value() + "\"");
                    write_to_file.println("\n");
             }
             //once the file is updated, we can close to file to make sure that all information is stored in the file
             write_to_file.close();
        }
        catch(Exception e) //catch block handle error if the file could not be opened 
        {
            System.out.println("Could not write the data back to the file");
        }
    }

    /**
     * @param localarray Stores all the investment in an Arraylist
     * @param localcount Stores the number of investment present
     * @param file_name Stores the name of the file
     * @return Returns the number of investments taken from the file
	*/
    //The method is used to take input from a file and store it into Arraylist of our investments
    //The method returns localcount which is the number of investment stored in the arraylist
    public static int take_input_from_file(ArrayList<Investment> localarray, int localcount, String file_name)
    {
        try           //We are using a try and catch block to handle errors if the file given by user cannot be opened
        {
            int line_number = 0;
            File my_file = new File(file_name);            //creates a new file object called my_file 
            Scanner scan_file = new Scanner(my_file);      //scan_file is a object to read the data in the file
            while(scan_file.hasNextLine())                 //The while loop checks if there is more data in the file
            {
                 String line = scan_file.nextLine();       //The data in the file is read one line at a time by variable line 
                 char investment_char;             
                 if(line.length() > 0)        //the if statement checks that line is not empty
                 {
                    //The following line creates a substring from the String line based on taking taking characters after "
                    //the new substring in stored/overwritten in the same line variable 
                    line = line.substring(line.indexOf("\"") + 1);   
                    //first line of any investment contains infromation about the investment type as given in file description
                    //The String invest_type stores which type of investment are we reading 
                    String investment_type = line.substring(0, line.indexOf("\""));
                    //the if-else condition check the investmenttype to test if its a Stock or not
                    if(investment_type.equalsIgnoreCase("Stock"))
                    {
                         investment_char = 'a';   //if the investment is a Stock then the investment_char will be set to a
                    }
                    else
                    {
                        //if investment is not Stock then it should be Mutual Fund because we have only 2 types of investment
                        investment_char = 'b';   //If investment is Mutual fund then invest_char will be set to b
                    }
                    line = scan_file.nextLine();  //Now line will read the next line from the file
                    line = line.substring(line.indexOf("\"")+1); //Again we will create a substring as above and store it in line
                    String symbol = line.substring(0,line.indexOf("\""));//2nd line of investment stores the symbol 
                    line = scan_file.nextLine();
                    line = line.substring(line.indexOf("\"")+1);
                    String name = line.substring(0,line.indexOf("\""));  //Line 3 of investment stores the name of investment
                    line = scan_file.nextLine();
                    line = line.substring(line.indexOf("\"")+1);
                    String quantity_str = line.substring(0,line.indexOf("\"")); //Line 4 of investment stores the quantity of shares
                    int quantity = Integer.parseInt(quantity_str);   // String quantity_str is converted to int using parseInt
                    line = scan_file.nextLine();
                    line = line.substring(line.indexOf("\"")+1);
                    String price_str = line.substring(0,line.indexOf("\"")); //Line 5 of investment stores price of each share
                    double price = Double.parseDouble(price_str);       //String price_str is converted to double using parseDouble
                    line = scan_file.nextLine();
                    line = line.substring(line.indexOf("\"")+1);
                    String bookvalue_str = line.substring(0,line.indexOf("\""));   //line 6 stores bookvalue of investment
                    double bookvalue = Double.parseDouble(bookvalue_str);    //book_value str is converted to Double
                    localarray.add(localcount,new Investment());           //A new investment object create and stored in arraylsit
                    localarray.get(localcount).set_share_symbol(symbol);
                    localarray.get(localcount).set_share_name(name);      //We use various set functions to set values of investment
                    localarray.get(localcount).set_num_shares(quantity);
                    localarray.get(localcount).set_share_price(price);
                    localarray.get(localcount).set_book_value(bookvalue);
                    localarray.get(localcount).set_investment_type(investment_char);
                    localcount++;   //Localcount is incremented after reading each investment
                 }
            }
        }
        catch(Exception e){  //Catch block catches error so that our program does not crash 
        
            System.out.println("Could not open the file " + file_name);
        }

        System.out.println("File input completed ");
        return localcount;  //localcount is returned to the main function
    }
    
    /**
     * @param localarray Stores all the investment in an Arraylist
	*/
	//Method calculates and prints the total gain of the Portfolio
    public static void compute_total_gain(ArrayList<Investment> localarray)
    {
        double total_gain = 0;     //variable total_gain will store the gain of the portfolio
        //the for loop goes through all the Investment objects and calculates the gain from each object and add it to total_gain
        for(int i=0;i<localarray.size();i++)
        {
            double book_val = localarray.get(i).get_book_value();        //varible book_val stores the book value of object
            double share_price = localarray.get(i).get_share_price();    //variable share_price stores the price of each share
            int share_num = localarray.get(i).get_num_shares();          //variable share_num gets the total number of shares
            char investment_type = localarray.get(i).get_investment_type(); //variable stores the type of investment that is being considered
            if(investment_type == 'a' || investment_type == 'A')
            {
                total_gain = total_gain + (share_num*share_price) - 9.99 - book_val;     //gain from each object is added to local_gain
            }
            else
            {
                total_gain = total_gain + (share_num*share_price) - 45 - book_val;  //gain from each object is added to local_gain
            }
        }

        System.out.println("The total gain from portfolio is: " + String.format("%.3f",total_gain));
    }
    
    /**
     * @param localarray Stores all the investment in an Arraylist 
	*/
	//The method updates the price of every investment in the portfolio
    public static void update_investment_price(ArrayList<Investment> localarray)
    {
        System.out.println("Please update the new price values of every investment one by one");
        //The for loop goes through all the Investment objects and asks the user for new price and updates the price of Investment
        for(int i=0;i<localarray.size();i++)
        {
            System.out.println("Please enter the new price for: " + localarray.get(i).get_share_name());
            Scanner myscan = new Scanner(System.in);
            double new_price = myscan.nextDouble();              //variable new_price is used to store the new price of the stovk
            localarray.get(i).set_share_price(new_price);       //new price is updated in Investment object using the set_share_price method
        }

    }

    /**
     * @param localarray Stores all the investment in an Arraylist
     * @param localcount Stores the count of Investment in Portfolio
     * @param localindex Stores all the Map keywords and values 
     * @return Returns the number of Investments in the Portfolio
	*/
	//The Method is used to sell an certain investment from the portfolio
	//The method allows selling partial or complete shares of an investment
	//Investment will be deleted from the Portfolio if all the shares of that Investment are sold
    public static int sell_investment(ArrayList<Investment> localarray, int localcount,HashMap<String,ArrayList<Integer>> localindex)
	{
        System.out.println("Please enter the symbol of the investment you want to sell");
        String symbol;                                                     //String symbol stores the symbol of investment that has to be sold
        Scanner myscan = new Scanner(System.in);
        symbol = (myscan.nextLine());            //symbol being stored with input from user
        System.out.println("Please enter the quantity of shares you want to sell"); 
        int sell_num = myscan.nextInt();               //variable sell_num stores the number of shares to be sold
        if(sell_num <= 0)
        {
            System.out.println("This is a invalid sale");
            return localcount;
        }
        int doexist = 0;                               //the variable do exist is to check if the sale requsted is possible to make
        int investment_position = 0;                        //investment_postion is to store the position of investment object in the investment_array
	    /*
            for loop goes through all the Investment objects and check if the sale is valid to make
            For sale to be valid it has to satisfy two conditions:
            1) The share symbol requested should exist in the portfolio
            2)The number of shares to be sold should be less than or equal to numbe of sahres available
        */
        for(int i=0;i<localarray.size();i++)
        {
            //if condition to chec if the sale is valid
            if(symbol.equals(localarray.get(i).get_share_symbol()) && sell_num <= localarray.get(i).get_num_shares())
           	{
                doexist = 1;            //variable doexist will be equal to 1 if sale is valid and symbol is a stock
                investment_position = i;     //varaible stock_position stores the position of Stock object for which sale is valid
            }
        }

        if(doexist == 1) //Check whether the sale to be made is valid or not
        {
            System.out.println("Please enter the price you are selling each share for");
            Double sell_price_pershare = myscan.nextDouble();                    //variable sell_price_pershare stores the selling price of each share for stock
            if(sell_price_pershare <= 0)
            {
                System.out.println("This is a invalid sale");
                return localcount;
            }
            //if condition to check if the number of shares available is equal to number of shares to be sold
            if(sell_num == localarray.get(investment_position).get_num_shares())
            {
                delete_indexes_from_map(localarray,localindex,investment_position);
                double localgain;    //Variable localgain stores the gain made from the sale of the stock
                char investment_type = localarray.get(investment_position).get_investment_type();
                if(investment_type == 'a' || investment_type == 'A' )
                {
                	localgain = (sell_num*sell_price_pershare) - 9.99 - (localarray.get(investment_position).get_book_value()); //formula to calculate localgain
                    System.out.println("The gain from selling your shares was: " + localgain);
                }
                else
                {
                	localgain = (sell_num*sell_price_pershare) - 45.00 - (localarray.get(investment_position).get_book_value());
                }
                //The investment object is removed from the Arraylist because all the shares of that stock have been sold
                localarray.remove(investment_position);
                localcount = localcount - 1;
            }
            else
            {
            	double payment_received;
            	char investment_type = localarray.get(investment_position).get_investment_type();
            	if(investment_type == 'a' || investment_type == 'A')
            	{
            		payment_received = (sell_num*sell_price_pershare)-9.99;     //Varibale paymentreceived stores the amount received aftr selling the shares
                    System.out.println("The payment received from selling shares is: " + payment_received);
            	}
            	else
            	{
            		payment_received = (sell_num*sell_price_pershare)-45.00;   //Varibale paymentreceived stores the amount received aftr selling the shares
                    System.out.println("The payment received from selling shares was: " + payment_received);
            	}
            	int remaining_quantity = (localarray.get(investment_position).get_num_shares()) - sell_num;  //variable remaining_quantity stores number of shares left
                int total_share_number = localarray.get(investment_position).get_num_shares();
                double num = remaining_quantity;
                double denom = total_share_number;
                double multiplier = num/denom;
                double new_book_value = (localarray.get(investment_position).get_book_value())*multiplier;  //Variable new_book_value stores the updates book value after the sale
                localarray.get(investment_position).set_book_value(new_book_value);                    //the book value of stock is updated with method set_book_value
                localarray.get(investment_position).set_num_shares(remaining_quantity);                //the number of shares is updates using method set_num_shares
            }
        }
        else //The following message is printed if the sale is not valid
        {
        	System.out.println("This sale is not valid and cannot be completed");
        }
	    return localcount;	
	}

	/**
     * @param localarray Stores all the investment in an Arraylist
     * @param localcount Stores the number of Investments in the Portfolio
     * @return Returns the number of Investments in the Portfolio 
	*/
	//Method checks if a certain buy is valid or not
	//If a buy is valid then the user will be allowed to complete the buy
	//Information about the new purchased Investment will be stored in the Portfolio
	public static int buy_investment(ArrayList<Investment> localarray,int localcount)
	{
		//String localsymbol will store the symbol of investment taken as input from user
        String localsymbol;
        System.out.println("Please enter symbol of the Investment you want to buy");
        Scanner scan = new Scanner(System.in);
        localsymbol = (scan.nextLine());         //Sysbol stored with input from user
        //User will select character a or A if they want to buy stock and B or b if they want to buy mutual funds
        System.out.println("select a if you want to invest in stock and b if in mutual fund");
        char userinput = (scan.next().charAt(0)); //Character input from user is stored in userinput variable
        if(userinput == 'a' || userinput == 'A' || userinput == 'b' || userinput == 'B')
        {

        }
        else
        {
        	System.out.println("The choice you made was not valid");
        	return localcount;
        }
        int count = 0;
        int check = 0;     //Variable check is declared to check if the requested stock alreay exist
        /*
            The for loop goes through all the Stock objects and check if their symbol matches with symbol from user
        */
        for(int i=0; i<localarray.size();i++)
        {
            if(localsymbol.equals(localarray.get(i).get_share_symbol()))   //if statement to check the equals condition of symbols
            {
                check = 1;             //variable check will be changed to 1 if the symbol matches with any of the existing stock symbol
                count = i;             //variable count stores the position of Stock object that has the matching symbol
            }
        }
        
        /*
            if the varibale check = 0, then a new stock will be created and stored in the Arraylist
        */
        if(check == 0)
        {
            System.out.println("Please enter name off investment");
            String name;                                                 //String name stores the name of stock
            Scanner myscan = new Scanner(System.in);
            name = (myscan.nextLine());
            System.out.println("Please enter number of shares you wish to buy");
            int numshare = myscan.nextInt();                                    //int numshare stores number of shares user wants to buy
            System.out.println("Please enter cost of one share");
            double cost_of_share = myscan.nextDouble();                    //double cost_of_share stores cost of each share of the stock
            if(numshare <= 0 || cost_of_share <= 0)
            {
                System.out.println("This is a invalid buy");
                return localcount;
            }
            localarray.add(new Investment());         //New Stock object created 
            localarray.get(localcount).set_share_symbol(localsymbol);       //sharesymbol of Stock is stored using the set_share_symbol method in Stock class
            localarray.get(localcount).set_investment_type(userinput);
            if(userinput == 'a' || userinput == 'A')
            {
            	double bookval = (numshare*cost_of_share)+9.99;    //double bookval is set equal to the book value of the stock
            	localarray.get(localcount).set_book_value(bookval);
            }
            else
            {
            	double bookval = numshare*cost_of_share;
            	localarray.get(localcount).set_book_value(bookval);
            }
            /*
                All the variable are stored in the Stock object using various set methods in the Stock class
           */
            localarray.get(localcount).set_share_name(name);
            localarray.get(localcount).set_num_shares(numshare);
            localarray.get(localcount).set_share_price(cost_of_share);
            localcount++;          //variable stock_count keep record of the number of stock in the arraylist
        }

        else  //if check is not equal to zero then that means the requested symbol already exist in the portfolio
        {
            System.out.println("Please enter number of additional shares you want to buy");
            Scanner myscan = new Scanner(System.in);
            int addshare = myscan.nextInt();                               //Variable addshare stores the number of additional shares to be baught
            System.out.println("Please enter the cost of each new share");
            double cost = myscan.nextDouble();                             //Varibale cost stores the cost of each new share
            
            if(addshare <= 0 || cost <= 0)
            {
                System.out.println("This is a invalid buy");
                return localcount;
            }
            localarray.get(count).add_book_value((cost*addshare)+9.99);  //Using the method add_book_value to adjust the book value of stock
            localarray.get(count).add_num_shares(addshare);              //using add_num_shares method to adjust the additional number of shares
            localarray.get(count).set_share_price(cost);                 //Using set_share_price method to adjust the new share price of the stock
            if(userinput == 'a' || userinput == 'A')
            {
            	localarray.get(count).add_book_value((cost*addshare)+9.99);  //Using the method add_book_value to adjust the book value of stock
            }
            else
            {
            	localarray.get(count).add_book_value(cost*addshare);  //Using the method add_book_value to adjust the book value of stock
            }
        }

        System.out.println("You successfully bought the shares");
        return localcount;

	}

}
