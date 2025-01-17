/**
 * MutualFund class
 * 
 * Purpose: Receive user input regarding stock Mutual Fund accounts and returns information 
 *          relevant to the customer and Mutual Funds account.
 * 
 * Programmer: Dontez Wherry
 * 
 * Course:     IS 2043 008
 * Semester:   Spring 2019
 * Assignment: PA03
 */

public class MutualFund extends Security
{
  // instance variables
  private String type; // Identifies general type of Mutual Fund: bonds, money market, exchange, etc.
  private double admin; /* Administrative fee cap, expressed as a percentage of value of 
   * funds held (e.g.: 0.0024 or 0.03)
   */
  private char rptPeriod; /* Reporting period, expressed as character. The valid values are:
   * A: annual
   * Q: quarterly
   * M: monthly
   */
  private boolean mgmt; /* Describes whether or not the fund is "actively managed": 
   * true = active; false = passive management
   */
  
  // Full constructor; returns a reference to a fully formed and functional MutualFund object
  public MutualFund(String nbr, int date, double price, double qty, String sym,
                    String sort, double cost, char rpt, boolean style) throws SecurityException
  {
    super(nbr, date, price, qty, sym); // call to superclass Security constructor
    setType(sort); // sets the type object
    setAdmin(cost); // sets the cost object
    setRptPeriod(rpt); // sets the rptPeriod object
    setMgmt(style); // sets the mgmt object
    
    
    // throw exceptions when incorrect data is provided 
    if(!getCustNumber().matches("\\d{7}") || Integer.parseInt(getCustNumber()) < 10000)
    {
      throw new SecurityException("Customer number must be 7 digits in length and greater than 10000" 
                                    + offeredValues());
      
    }//end if statement
    
    
    if(Character.toUpperCase(rptPeriod) != 'A' && Character.toUpperCase(rptPeriod) != 'Q' &&
       Character.toUpperCase(rptPeriod) != 'M')
    {
      throw new SecurityException("The reporting period must be A, Q, or M." + 
                                  offeredValues() + additionalInfo());
      
    }//end if statement
    
  }//end construcotr
  
  // setter methods
  
  // Accepts a String object and assigns it to the instances variable sort
  public void setType(String type)
  {
    this.type = type; 
  }//end setType
  
  // Accepts a double object and assigns it to the instances variable admin
  public void setAdmin(double admin)
  {
    this.admin = admin;
    
  }//end setAdmin
  
  // Accepts a char object and assigns it to the instances variable rptPeriod
  public void setRptPeriod(char rptPeriod)
  {
    this.rptPeriod = rptPeriod; 
    
  }//end setRptPeriod
  
  // Accepts a boolean object and assigns it to the instances variable mgmt
  public void setMgmt(boolean mgmt)
  {
    this.mgmt = mgmt; 
    
  }//end setMgmt
  
  
  // getter methods
  
  // Returns the current value of instance variable type
  public String getType()
  {
    return type; 
  }//end getType
  
  // Returns the current value of instance variable admin
  public double getAdmin()
  {
    return admin; 
    
  }//end getAdmin
  
  // Returns the current value of instance variable rptPeriod
  public char getRptPeriod()
  {
    return rptPeriod;
    
  }//end getRptPeriod
  
  // Returns management style for Mutual Funds accounts
  public boolean getMgmt()
  {
    return mgmt; 
    
  }//end getMgmt
  
  // capture info inputed by user
  public String additionalInfo()
  {
    return String.format("Type: %s%n Admin cost: %f%n Reporting Period: %c%n Managment: %b%n",
                         getType(), getAdmin(), getRptPeriod(), getMgmt());
    
  }//end additionalInfo
  
  
  // toString method returns a formatted String object describing the MutualFund object
  public String toString()
  {
        
    StringBuilder objInfo = new StringBuilder(String.format("The MutualFund belongs to Customer# %s; ", 
                                                            getCustNumber()));
    
    objInfo.append(String.format("%.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
    objInfo.append(String.format("This is a %s fund.%n", getType()));
    objInfo.append(String.format("Admin cost are capped at %.6f.%n", getAdmin()));
    
        
    if(Character.toUpperCase(getRptPeriod()) == 'A')
    {
      objInfo.append("\tReporting cycle is Annual.\n");
      
    }//end if statement
    
    else if(Character.toUpperCase(getRptPeriod()) == 'Q')
    {
      objInfo.append("\tReporting cycle is Quarterly.\n");
      
    }//end else if statement
    
    else if(Character.toUpperCase(getRptPeriod()) == 'M')
    {
      objInfo.append("\tReporting cycle is Monthly.\n");
      
    }//end else if statement
    
    
    
    if(getMgmt() == true)
    {
      objInfo.append("\tThe fund is managed actively.\n");
      
    }//end if statement
    
    else if(getMgmt() == false)
    {
      objInfo.append("\tThe fund is managed passively.\n");
      
    }//end else if statement
    
    return objInfo.toString(); 
    
  }//end toString
  
  public double calcCost()
  {
    return (getShares() * getPurchPrc()) * (1 + getAdmin()); //calcCost returns calculated cost
    
  }//end calcCost
}// end class MutualFund