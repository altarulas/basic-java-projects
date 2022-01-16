package week3;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    
    private  double baseSalary;

    public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary) {
        super(first, last, ssn, sales, rate);
        setBaseSalary(salary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    
    public double earnings(){
        return (getCommissionRate() * getGrossSales()) + baseSalary;
    }
    
    public String toString(){
        return String.format("%s \n%s $%,.2f", super.toString()
                ,"Base Salary :", getBaseSalary());
    }
    
    
    
    
}
