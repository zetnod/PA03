/**
 * CustomerException class
 * 
 * Purpose: Exception class to catch exceptions when incorrect data 
 *          is received from user input
 * 
 * Programmer: Dontez Wherry
 * 
 * Course:     IS 2043 008
 * Semester:   Spring 2019
 * Assignment: PA03
 */

public class CustomerException extends Exception {
  
  public CustomerException(String msg)
  {
   super(msg);
  }// end single parameter constructor CustomerException
  
  public CustomerException(String msg, Throwable cause)
  {
    super(msg, cause);
  }// end double parameter constructor CustomerException
  
}// end class CustomerException
