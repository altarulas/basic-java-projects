package week3;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecuritynumber;
    
    public Employee (String first, String last, String ssn ){
        firstName = first;
        lastName = last;
        socialSecuritynumber = ssn;
    }
    
    public void setFirstName(String first){
        this.firstName = first;
    }
    
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setSocialSecurityNumber(String ssn){
        this.socialSecuritynumber = ssn;
    }
    
    public String getSocialSecurityNumber(){
        return socialSecuritynumber;
    }
    
    public String toString(){
        return String.format("%s %s \nSocial Security Number: %s"
                ,getFirstName(), getLastName(),getSocialSecurityNumber());
    }
    
    public abstract double earnings();
    
}