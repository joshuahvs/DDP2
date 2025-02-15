public class PermanentEmployee extends Employee implements RaiseSalary { //mengimplementasikan sesuai UML diagram
    private double salaryRaise;
    // melengkapi constructor berikut
    PermanentEmployee(String name, double salary) {
        super(name, salary);
        this.salaryRaise = 0;
    };

    // Method yang megoveride calculate salary dari class employee
    @Override
    public double calculateSalary() {
        return this.salary;
    }

    // method yang mengoveride method dari interface untuk menambah gaji
    @Override
    public void askRaise(double raise) {
        this.salary += raise;
        salaryRaise += raise;
    }

    // method yang mengoveride method toString dari class Employee
    @Override
    public String toString() {
        String output = "["+ this.employeeId + "] " + this.name + " | " + "Salary : " + String.format("%.0f", calculateSalary()) + " | " + "Kenaikan  : " + String.format("%.0f", this.salaryRaise);
        return output;
    }
}