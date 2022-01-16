package week3;

public class SalariedEmployee extends Employee {
    
    private double weeklySalary;
    
    public SalariedEmployee(String first, String last, String ssn, double salary){
        super(first, last, ssn);
        setWeeklySalary(salary);
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double salary) {
        weeklySalary = salary < 0.0 ? 0.0 : salary;
    }
    
    @Override
    public double earnings(){
        return getWeeklySalary();
    }
    
    @Override
    public String toString(){
        return String.format("Salaried Employee: %s\n %s: $%.2f",
                super.toString(),"Weekly Salary", getWeeklySalary() );
    }
}


