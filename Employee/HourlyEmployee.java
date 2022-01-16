package week3;

public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    public HourlyEmployee(String first, String last, String ssn, double wage, double worked) {
        super(first,last,ssn);
        setHourlyWage(wage);
        setHoursWorked(worked);
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double earnings() {
        if(getHoursWorked() <= 40){
            return getHourlyWage() * getHoursWorked();
        }
        else{
            return 40 * getHourlyWage() + (getHoursWorked() - 40) * getHourlyWage() * 1.5;
        }
        
     
    }
    
    public String toString(){
        return String.format("%s \n%s $%,.2f \n%s %.2f", super.toString()
                ,"Hourly Wage :", getHourlyWage(),"Hours Worked :",getHoursWorked());
    }
    

    
    
}
