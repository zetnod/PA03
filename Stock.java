/**
 * Stock class
 * 
 * Purpose: Receive user input regarding stock investment accounts and returns
 *          relevant customer and stock account information.
 * 
 * Programmer: Dontez Wherry
 * 
 * Course:     IS 2043 008
 * Semester:   Spring 2019
 * Assignment: PA03
 */


public class Stock extends Security
{
  private String exchange; // The exchange on which the stock trades (e.g.: NASDAQ, Nikkei, etc.)
  private boolean dividends;  /* Indicates whether or not the stock pays dvidends: 
   * true = dividends paid; false = no dividends paid 
   */
  private int divDate; /* Indicates when dividends are paid by quarter; 
   * allowed values are 0 (if dividends = false) through 4  
   */
  private double divAmount; /* Dollar value of dividents/share; 
   * 0 if dividends = false and/or divDate is invalid
   */
  
  // Full constructor; returns a reference to a fully formed and functional Stock object
  public Stock(String nbr, int date, double prc, double qty, String sym, String xchg, boolean div,
               int divDt,double amt) throws SecurityException
  {
    super(nbr, date, prc, qty, sym); // call to superclass Security constructor
    
    setExchange(xchg); // sets the exchange object
    setDividends(div); // sets the dividend object
    setDivDate(divDt); // sets the divDate object
    setDivAmount(amt); // sets the divAmount object
    
    //exceptions to be throw when invalide data is provided
    if(divDate < 0 || divDate > 4)
    {
      throw new SecurityException("Allowed dividend payment dates are 0-4." + offeredValues());
      
    }//end if statement
    
    if(dividends == false && divAmount != 0)
    {
      throw new SecurityException("Invalid input for dividend amount." + offeredValues());
      
    }//end if statement
    
    if(divDate < 0 || divDate > 4 && divAmount != 0)
    {
      throw new SecurityException("Invalid input for dividend amount." + offeredValues());
      
    }//end if statement
    
  }//end constructor
  
  // setter methods
  
  // Accepts a String object and assigns it to the instances variable exchange
  public void setExchange(String exchange)
  {
    this.exchange = exchange; 
    
  }//end setExchange
  
  // Accepts a boolean object and assigns it to the instances variable dividends
  public void setDividends(boolean dividends)
  {
    this.dividends = dividends;
    
  }//end setDividends
  
  // Accepts an int object and assigns it to the instances variable divDate
  public void setDivDate(int divDate)
  {
    this.divDate = divDate; 
  }//end setDivDate
  
  // Accepts a double object and assigns it to the instances variable divAmount
  public void setDivAmount(double divAmount)
  {
    this.divAmount = divAmount; 
    
  }//end setDivAmount
  
  
  //getter methods
  
  // Returns the current value of instance variable exchange
  public String getExchange()
  {
    return exchange; 
    
  }//end getExchange
  
  // Returns the current value of instance variable dividends
  public boolean getDividends()
  {
    return dividends; 
    
  }//end public boolean getDividends
  
  // Returns the current value of instance variable divDate
  public int getDivDate()
  {
    return divDate; 
    
  }//end getDivDate
  
  // Returns the current value of instance variable divAmount
  public double getDivAmount()
  {
    return divAmount; 
    
  }//end getDivAmount
  
  // toString method: Returns a formatted String object describing this Stock object
  public String toString()
  {
        
    StringBuilder objInfo = new StringBuilder(String.format("The Stock belongs to Customer# %s; ", getCustNumber()));
    
    objInfo.append(String.format("%.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
    objInfo.append(String.format("This stock is traded on the %s exchange.%n", getExchange()));
        
    
    if(getDividends() == true)
    {
      objInfo.append(String.format("\tA dividend of $%.2f will be paid in the %d quarter.%n",
                                   getDivAmount(), getDivDate()));
      
    }//end if statement
    
    else
    {
      objInfo.append("\tThis stock does not pay dividends\n");
      
    }//end else statement
    
    
    return objInfo.toString();
    
  }//end toString
  
  public double calcCost()
  {
    return (getShares() * (getPurchPrc() - getDivAmount())); 
    
  }//end calcCost
}// end class Stock