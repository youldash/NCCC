
package outputemployees;
import java.util.Formatter;
import java.io.FileNotFoundException;
public class OutputEmployees {

    public static void main(String[] args) {
        
       // create subclass objects                                          
      SalariedEmployee salariedEmployee =                                 
         new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );  
      HourlyEmployee hourlyEmployee =                                     
         new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
      CommissionEmployee commissionEmployee =                             
         new CommissionEmployee(                                          
         "Sue", "Jones", "333-33-3333", 10000, .06 );                     
      BasePlusCommissionEmployee basePlusCommissionEmployee =             
         new BasePlusCommissionEmployee(                                  
         "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );                 

      System.out.println( "Employees processed individually:\n" );

      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "earned", salariedEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings() );

      // create four-element Employee array
      
Employee employee [] = new Employee [4];
      // initialize array with Employees          
     employee[0]=salariedEmployee;
     employee[1]=hourlyEmployee;
     employee[2]=commissionEmployee;
     employee[3]=basePlusCommissionEmployee;
      System.out.println( "Output the elements of the array into a text file:\n" );
      try{
Formatter output= new Formatter("EmployeeData.txt");

output.format("%n", employee[0].toString());
output.close();
      }
      catch (FileNotFoundException e){
          System.err.println(" the file not found");
          System.exit(1);
      }
      /* Write code here that opens the file EmployeeData.txt for object output
        then writes all the elements of the array employees into the file */    
      
   } // end main
} // end class OutputEmployees

