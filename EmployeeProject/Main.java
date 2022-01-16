package week3;

public class Main {
    
    public static void main(String[] args){
        
        SalariedEmployee salariedEmployee = new SalariedEmployee("Ali", "Veli", "1234-123-1234", 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
        CommissionEmployee commissionEmployee = new CommissionEmployee("John", "Doe", "321-21-321" , 100, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
        
        
        System.out.println( "Employees processed individually:\n" );
        
        System.out.printf("%s \n%s: $%.2f\n\n",salariedEmployee,"Earned: ", salariedEmployee.earnings());
        // sout hourly employee
        System.out.printf("%s \n%s: $%.2f\n\n",commissionEmployee,"Earned: ", commissionEmployee.earnings());
        //sout basepluscomissionemployee
        
        
        
        
        Employee employees[] = new Employee[4];
        
        employees[ 0 ] = salariedEmployee;
        employees[ 1 ] = hourlyEmployee;
        employees[ 2 ] = commissionEmployee;
        employees[ 3 ] = basePlusCommissionEmployee;
        
        System.out.println( "Employees processed polymorphically:\n" );
        
        for (Employee currentEmployee : employees){
            
            System.out.println(currentEmployee);
            
            if (currentEmployee instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                
                double oldBaseSalary = employee.getBaseSalary();
                employee.setBaseSalary(1.10 * oldBaseSalary);
                System.out.printf("New Base Salary is: $%,.2f\n", employee.getBaseSalary());    
            }
            
            System.out.printf("Earned $%,.2f\n\n", currentEmployee.earnings());
        }
    }
}
