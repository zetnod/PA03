/*
 *   Test_SecurityHierarchy. java
 * 
 *   This test harness will allow for batch testing of all classes in the Security hierarachy.
 * 
 *   The test cases here are limited & generalized - it would be a good idea to add test cases to more fully 
 *     test the validation and exception handling in the associated classes. Testing for grading will include 
 *     different and additional test cases.
 * 
 * (c) 2017, Terri Davis
 */

public class Test_SecurityHierarchy
{
   /*
    * The following array holds the test cases. It may be enlarged as needed/desired.
    * 
    * PLEASE NOTE:  The first character in each String identifies which type of object is to be 
    *   instantiated. "M" = MutualFund; "S" = Stock.
    */
   public static void main( String[] args )
   {          
     String[] dataArray = { 
                            "S,1111111,20100324,6.0,8.0,AAPL,MARKET,false,0,0.0",    // Stock test case template
                            "M,1111111,19000101,4.0,7.5,NSDQ,TYPE,9.0,Q,true"       // MutualFund test case template
                           };
     /*
      *  The enhanced for loop will take each String in the above array, determine which type of object is to be
      *    instantiated, and call the appropriate method based on that information.
      */
     for( String candidate: dataArray )
     {
       String[] parts = candidate.split( "," );               // 'parse' the String into its constituent data items
       
       if( parts[0].equals( "M" ) )                           // check the first data item for object type 
         buildMutualFund( parts );
       else
         buildStock( parts );
     } // end for loop
   }  // end main

   /*
    *  If the String in the array contained data to create a MutualFund, execute this method.
    *  
    *  The individual data items will be extracted and converted (if necessary). The class constructor is called.
    *    IF an exception is thrown, it is caught and a VERBOSE message is displayed to the errror output.
    *    ELSE, the toString method of the newly instantiated object is output to Sysout.
    */
   private static void buildMutualFund( String[] parts )
   {    
     MutualFund nextSecure;
     
     try
     {
       nextSecure = new MutualFund( // Security items
                                    parts[ 1 ],
                                    Integer.parseInt( parts[ 2 ] ),
                                    Double.parseDouble( parts[ 3 ] ),
                                    Double.parseDouble( parts[ 4 ] ),
                                    parts[ 5 ],
                                    // MututalFund items
                                    parts[ 6 ],
                                    Double.parseDouble( parts[ 7 ]),
                                    parts[ 8 ].charAt( 0 ),
                                    Boolean.parseBoolean( parts[ 9 ] ) );
       System.out.printf( "%s%n",
                          nextSecure.toString( ) );
     }  // end try
     catch( SecurityException secErr )
     {
       System.err.printf( "%s thrown%n%s%n",
                         secErr.getClass( ).getName( ), 
                         secErr.getMessage( ) );
     }  // end catch SecurityException
   }  // end buildMutualFund

   
   /*
    *  If the String in the array contained data to create a Stock, execute this method.
    *  
    *  The individual data items will be extracted and converted (if necessary). The class constructor is called.
    *    IF an exception is thrown, it is caught and a VERBOSE message is displayed to the errror output.
    *    ELSE, the toString method of the newly instantiated object is output to Sysout.
    */
   private static void buildStock( String[] parts )
   {    
     Stock nextSecure;
     
     try
     {
       nextSecure = new Stock( // Security items
                               parts[ 1 ],                                 
                               Integer.parseInt( parts[ 2 ] ),
                               Double.parseDouble( parts[ 3 ] ),
                               Double.parseDouble( parts[ 4 ] ), 
                               parts[ 5 ],
                               // Stock items
                               parts[ 6 ],
                               Boolean.parseBoolean( parts[ 7 ]),
                               Integer.parseInt( parts[ 8 ] ),  
                               Double.parseDouble( parts[ 9 ] ) );
       System.out.printf( "%s%n",
                          nextSecure.toString( ) );
     }  // end try
     catch( SecurityException secErr )
     {
       System.err.printf( "%s thrown%n%s%n",
                         secErr.getClass( ).getName( ), 
                         secErr.getMessage( ) );
     }  // end catch SecurityException
   }  // end buildStock

} // end Test_SecurityHierarchy
