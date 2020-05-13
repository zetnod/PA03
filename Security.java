/**
 * Security class
 * 
 * Purpose: Receive user input regarding investment accounts and returns information 
 *          relevant to the customer and security accounts.
 * 
 * Programmer: Dontez Wherry
 * 
 * Course:     IS 2043 008
 * Semester:   Spring 2019
 * Assignment: PA03
 */

public class Security implements CostBasis
{
  // instance variables 
  private String custNumber; /* A unique identifier for a customer; must be 7 digits in length; 
                              * must be greater than 10000
                              */
  private int purchDt; /* Purchase date of Security in Julian date format: yyyyddd. 
                        * The value for year must be greater than 1900. The value for days must be between 
                        * 1 and 365, inclusive
                        */
  private double purchPrc; // Purchase price of Security, per share, in dollars
  private double shares; /* Number of shares purchased; for display purposed, 
                          * decimal positions should be limited to three (3)
                          */
  private String symbol; // Market symbol of Security

  // Full constructor; returns a reference to a fully formed and functional Security object
  public Security(String nbr, int date, double price, double qty, String sym) throws SecurityException
    {
  
      setCustNumber(nbr); // sets the customer number object
      setPurchDt(date); // sets the purchase date object
      setPurchPrc(price); // sets the purchase price object
      setShares(qty); // sets the # of shares object
      setSymbol(sym.toUpperCase()); // sets the security symbol object

      // throw exceptions when invalid data is entered
      if(!custNumber.matches("\\d{7}") || Integer.parseInt(custNumber) < 10000)
          {
            throw new SecurityException("Customer number must be 7 digits long and greater than 0010000." 
                                          + offeredValues());

           }//end if statement

      String convertDate = String.valueOf(purchDt);
  
      
     if(convertDate.length() != 8)
      {
       throw new SecurityException("Purchase date must be entered in the format YYYYDDD" 
                                     + offeredValues());
  
     }//end if statement

     String year = convertDate.substring(0,4);
     String day = convertDate.substring(4,7);   
     

     if(Integer.parseInt(year) < 1900 || Integer.parseInt(year) > 9999 ||
     Integer.parseInt(day) < 001 || Integer.parseInt(day) > 365)
       {
        throw new SecurityException("Purchase year must be > 1900; Purchase day must be 001 to 365, inclusive." 
                                      + offeredValues());

        }//end if statement

    }//end constructor


  // setter method
  
  // Accepts a String object and assigns it to the instances variable custName
  public final void setCustNumber(String custNumber)
    {
     this.custNumber = custNumber;

     }//end setCustNumber



  // Accepts an int object and assigns it to the instances variable purchDt 
  public final void setPurchDt(int purchDt)
   {
    this.purchDt = purchDt;

   }//end setPurchDt



  // Accepts a double object and assigns it to the instances variable purchPrc
  public final void setPurchPrc(double purchPrc)
   {
    this.purchPrc = purchPrc;

   }//end setPurchPrc



  // Accepts a double object and assigns it to the instances variable shares
  public final void setShares(double shares)
   {
    this.shares = shares;

   }//end setShares


  // Accepts a String object and assigns it to the instances variable symbol
  public final void setSymbol(String symbol)
   {
    this.symbol = symbol;

   }//end  setSymbol


  //getter methods
  
  // Returns the current value of instance variable custNumber
  public final String getCustNumber()
   {
    return custNumber;

   }//end getCustNumber


  // Returns the current value of instance variable purchDt
  public final int getPurchDt()
   {
     return purchDt;

   }//end getPurchDt


  // Returns the current value of instance variable purchPrc
  public final double getPurchPrc()
   {
    return purchPrc;

   }//end public final double getPurchPrc


  // Returns the current value of instance variable shares
  public final double getShares()
   {
     return shares;

   }//end public final double getShares


  // Returns the current value of instance variable symbol
  public final String getSymbol()
   {
    return symbol;

   }//end getSymbol


  // caputured values input by user 
  public String offeredValues()
   {
     return String.format("%nOffered values:%n" +
                          "\tCustomer number: %s%n"+
                          "\tPurchase date: %d%n"+ 
                          "\tShare price: %f%n"+ 
                          "\tNumber shares: %f%n"+ 
                          "\tSymbol: %s%n", getCustNumber(), getPurchDt(), getPurchPrc(),
     getShares(), getSymbol());

   }//end offeredValues


  /* Returns a formatted String object describing the Security object:  The Security belongs to Customer# 
   * custNumber; shares shares of symbol were purchased on purchDt for $purchPrc per share
   */  
  public String toString()
   {
     StringBuilder objInfo = new StringBuilder(String.format("The Security belongs to Customer# %s; ", 
                                                             getCustNumber()));

     objInfo.append(String.format("%.3f shares of %s were%n", getShares(), getSymbol()));
     objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));

     return objInfo.toString();

   }//end public String toString

  @Override
  public double calcCost() {
   throw new UnsupportedOperationException("Not supported yet."); 
   }// end calcCost method
}// end class Security