import java.util.Iterator;
import java.util.TreeSet;

      public class MyTest {
    	  long milliSeconds = 0;
          TreeSet aTreeSet;
          public MyTest() {
          }
          public void start() {
              milliSeconds = System.currentTimeMillis();
          }
          public MyTest  init(TreeSet aTreeSet) {
              this.aTreeSet = aTreeSet;
              return this;
          }
          public void end(String whatKind)    {
              System.err.println(whatKind + ": Time for all:  " + ( System.currentTimeMillis() - milliSeconds) );
          }
          public void executeTest()   {

        	  System.out.println("Inserting string 1234: " + aTreeSet.add(new String("1234")));

              System.out.println("Checking if string 1234 is present in the Tree set : " + aTreeSet.contains("1234"));

              System.out.println("Trying to add string  ab: " + aTreeSet.add(new String("ab")));
              
              System.out.println("Cheking if number ab is present: " + aTreeSet.contains("ab"));
              
              System.out.println("Cheking if the Tree is empty: " + aTreeSet.isEmpty());
              
              System.out.println("Inserting string 12: " + aTreeSet.add("12"));
              
              System.out.println("Trying to insert same string 1234: " + aTreeSet.add(new String("1234")));
              
              Iterator testIterator = aTreeSet.iterator();
      		
              System.out.println("Checking if there is another object: " + testIterator.hasNext());
      		
              System.out.println("Printing the next object: " + testIterator.next());
              
              System.out.println("Printing another object: " + testIterator.next());
              
              System.out.println("Size: " + aTreeSet.size());
              
              aTreeSet.clear();
              
              System.out.println("Size after clearing: " + aTreeSet.size());
              
              System.out.println("Inserting string 1234: " + aTreeSet.add(new String("1234")));

              System.out.println("Checking if string 1234 is present in the Tree set : " + aTreeSet.contains("1234"));

              
              System.out.println("\n***  ***\n");
          }
         public void testIt() {
              start();
              (init(new HpTreeSet())).executeTest();
              end("HpTreeSet");
              start();
              (init(new TreeSet())).executeTest();
              end("TreeSet");
         }

         public static void main(String args[] )      {
              new MyTest().testIt();
              System.exit(0);
         }
      }