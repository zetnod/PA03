/*
 *   Test_Customer. java
 * 
 *   This test harness will allow for batch testing of the Customer class.
 * 
 *   The test cases here are limited & generalized - it would be a good idea to add test cases to more fully 
 *     test the validation and exception handling in the associated classes. Testing for grading will include 
 *     different and additional test cases.
 * 
 * (c) 2017, Terri Davis
 */

public class Test_Customer
{
   
   public static void main( String[] args )
   {          

   /*
    * The following array holds the test cases. It may be enlarged as needed/desired.
    */
     String[] dataArray = { "1111111,999999999,LastName,FirstName,0,true,true"               // test case template
                          };

     /*
      *  The enhanced for loop will take each String in the above array and call the buildCustomer
      *     method, passing the array of individual data items.
      */
     for( String candidate: dataArray )
     {
       String[] parts = candidate.split( "," );
       buildCustomer( parts );
     } // end for loop
   }  //; end main

   /*
    *  The individual data items will be extracted and converted (if necessary). The class constructor is called.
    *    IF an exception is thrown, it is caught and a VERBOSE message is displayed to the errror output.
    *    ELSE, the describeCustomer method of the newly instantiated object is output to Sysout.
    */
   private static void buildCustomer( String[] parts )
   {    
     Customer nextCust;
     
     
     try
     {
       String  nbr     = parts[ 0 ];
       String  id      = parts[ 1 ];
       String  lName   = parts[ 2 ];
       String  fName   = parts[ 3 ];
       int     lim     = Integer.parseInt( parts[ 4 ] );
       boolean reUp    = Boolean.parseBoolean( parts[ 5 ] );
       boolean futures = Boolean.parseBoolean( parts[ 6 ] );
       
       nextCust = new Customer( nbr,
                                id,
                                lName,
                                fName,
                                lim,
                                reUp,
                                futures );
       System.out.printf( "%s%n",
                         nextCust.describeCustomer( ) );
     }  // end try
     catch( CustomerException custErr )
     {
       System.err.printf( "%s thrown%n%s%n",
                          custErr.getClass( ).getName( ), 
                          custErr.getMessage( ) );
     }  // end catch CustomerException
   }  // end buildCustomer

} // end Test_Customer
