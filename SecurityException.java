/**
 * SecurityException class
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

public class SecurityException extends Exception { 
  public SecurityException(String msg) { super(msg); }
  public SecurityException(String msg, Throwable cause) 
  { super(msg, cause); }
}   //end public class SecurityException extends Exception