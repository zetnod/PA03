/**
 * Customer Class
 * 
 * Purpose: To obtain cutomer information regarding their account 
 *          and output information regarding account preledges and
 *          reinvestment options
 *         
 * Programmer: Dontez Wherry
 * 
 * Course:     IS 2043 008
 * Semester:   Spring 2019
 * Assignment: PA03
 */

public class Customer{
  
  private String custNumber; //A unique identifier for a customer
  private String tin; //Customer's tax reporting number - TIN, EIN, or SSN
  private String last; //Customer's last name (or surname) as per legal identification
  private String first; //Customer's first (or given) name as per legal indentification
  private int margin = 0; /*Margin limit for trading; expressed as whole dollars; if equal 
   *to zero - customer is not authorized for margin trading
   */
  private boolean drip; /*Indicates customer's instructions on dividend reinvestment: 
   *true = automatic reinvestment; false by customer instruction
   */
  private boolean futures; //Indicates whether customer is authorized for futures contracts trading
  
  /* Full constructor; returns a reference to a fully formed and functional 
   * Customer
   */
  public Customer(String nbr, String id, String lName, String fName, int lim, boolean reUp, boolean fAuth)
    throws CustomerException
  {    
    setCustNumber(nbr); //set "this" object's customer number
    setTin(id); //set "this" object's tax identifier
    setLast(lName); //set "this" object's last name
    setFirst(fName); //set "this" object's first name
    setMargin(lim); //set "this" object's margin limits
    setDrip(reUp); //set "this" object's reinvestment option
    setFutures(fAuth); //set "this" object's futures trade option    
    
    // throw exceptions when invalid data is entered
    if(!getCustNumber().matches("\\d{7}") || Integer.parseInt(getCustNumber()) < 10000)
    {
      throw new CustomerException("Customer number must be 7 digits in length and greater than 10000."
                                    + offeredValues());
    }// end if 
    
    // if statement for incorrect customer 
    else if(!getTin().matches("\\d{9}"))
    {
      throw new CustomerException("Tax Identifier must be 9 digits in length." + offeredValues());
    }
    
    // if statement for null or blank last name
    else if(!getLast().matches("[a-zA-z]*"))
    {
      throw new CustomerException("Last name must not be null or blank." + offeredValues());      
    }
    
    // if statement for null or blank last name
    else if(!getFirst().matches("[a-zA-z]*"))
    {
      throw new CustomerException("First name must not be null or blank." + offeredValues());
    }
    
    else if(getMargin()<0)
    {
      throw new CustomerException("Negative values are not permitted." + offeredValues());
    }
    
    
  }//end full custructor Customer
  
  //Set the value of the instance variable custNumber
  public final void setCustNumber(String nbr)
  {
    custNumber = nbr;
  }//end method setCustNumber
  
  
  //Set the value of the instance variable tin
  public final void setTin(String id)
  {
    tin = id;
  }//end method setTin
  
  
  //Set the value of the instance variable last
  public final void setLast(String lName)
  {
    last = lName;
  }//end method setLast
  
  
  
  //Set the value of the instance variable first
  public final void setFirst(String fName)
  {
    first = fName;
  }//end method setFirst
  
  
  
  //Set the value of the instance variable margin
  public final void setMargin(int lim)
  {
    margin = lim; 
  }//end method setMargin
  
  
  //Set the value of the instance variable drip
  public final void setDrip(boolean reUp)
  {
    drip = reUp;
  }//end method setDrip
  
  
  //Set the value of the instance variable futures
  public final void setFutures(boolean fAuth)
  {
    futures = fAuth; 
  }//end method setFutures
  
  //Return the value of the instance variable custNumber
  public final String getCustNumber(){
    return custNumber;
  }//end method getCustNumber
  
  
  //Return the value of the instance variable tin
  public final String getTin(){
    return tin;
  }//end method getTin
  
  
  //Return the value of the instance variable last
  public final String getLast(){
    return last;
  }//end method getLast
  
  
  //Return the value of the instance variable first
  public final String getFirst(){
    return first;
  }//end method getFirst
  
  
  //Return the value of the instance variable margin
  public final int getMargin(){
    return margin; 
  }//end method getMargin
  
  
  //Return the value of the instance variable drip
  public final boolean getDrip(){
    return drip;
  }//end method getDrip
  
  
  //Return the value of the instance variable futures
  public final boolean getFutures(){
    return futures; 
  }//end method getFutures
  
  public String offeredValues()
  {
    return String.format("%nOffered Values: "+
                         "%n\tCustomer number: %s"+
                         "%n\tTax Id: %s"+
                         "%n\tLast Name: %s"+
                         "%n\tFirst Name: %s"+
                         "%n\tMargin: %d"+
                         "%n\tDRIP: %b"+
                         "%n\tFutures: %b", 
                         getCustNumber(), getTin(), getLast(), getFirst(), getMargin(), getDrip(), getFutures());
  }// end method offeredValues
  
  public String describeCustomer(){
    /* if/else statments to dispay formatted string depending if futures and
     * drip are true or false
     */
    if(getDrip() == false && getFutures() == true){
      return String.format("%nCustomer %s, %s %s"+
                           "%nThis account does not have margin privileges. $%s"+
                           "%nDividends will be deposited as cash funds."+
                           "%nThe account is authorized to trade in futures contracts.", getCustNumber(), 
                           getFirst(), getLast(), getMargin());
    }//end if when drip is false and futures is true
    
    if(getDrip() == true && getFutures() == false){
      return String.format("%nCustomer %s, %s %s"+
                           "%nThe account carries a margin limit of $%s."+
                           "%nThe account will reinvest dividends as recieved."+
                           "%nThe account is not authorized to trade futures contracts.",
                           getCustNumber(), getFirst(), getLast(), getMargin());
    }//end if when drip is true and futures is false
    
    if(getDrip() == true && getFutures() == true){
      return String.format("%nCustomer %s, %s %s"+
                           "%nThe account carries a margin limit of $%s."+
                           "%nThe account will reinvest dividends as recieved."+
                           "%nThe account is authorized to trade in futures contracts.",
                           getCustNumber(), getFirst(), getLast(), getMargin());
    }//end if when drip is true and futures is true
    
    else {
      return String.format("%nCustomer %s, %s %s"+
                           "%nThis account does not have margin privileges."+
                           "%nDividends will be deposited as cash funds."+
                           "%nThe account is not authorized to trade futures contracts.", 
                           getCustNumber(), getFirst(), getLast());
    }//end else when drip and futures do not receive a response
    
  }//end method describeCustomer
  
  public String toString()
  {
    return String.format("%n%s,%s,%s,%s,%d,%b,%b", getCustNumber(), getTin(), getLast(), getFirst(), 
                         getMargin(), getDrip(), getFutures());
  }//end method toString
  
}//end class Customer