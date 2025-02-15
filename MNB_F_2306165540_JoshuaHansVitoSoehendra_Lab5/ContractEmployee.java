public class ContractEmployee extends Employee implements RaiseSalary, ExtendContractDuration { // TODO:
                                                                                                // impelementasikan
                                                                                                // sesuai UML diagram
    //atribut
    public int contractDuration;
    private double salaryRaise;

    // melengkapi constructor
    ContractEmployee(String name, double salary, int contractDuration) {
        super(name, salary);
        this.contractDuration = contractDuration;
        this.salaryRaise = 0;
    }

    // method yang mengoveride method dari interface untuk menambah gaji
    @Override
    public void askRaise(double raise) {
        this.salary += raise;
        this.salaryRaise += raise;
    }

    // Method yang megoveride calculate salary dari class employee
    @Override
    public double calculateSalary() {
        return this.salary*getSalaryMultiplier();
    }

    // method yang mengoveride method dari interface untuk mengextend kontrak
    @Override
    public void extendContract(int duration) {
        this.contractDuration += duration;
    }

    // method yang mengoveride method toString dari class Employee
    @Override
    public String toString() {
        String output = "[" + this.employeeId + "] " + this.name + " | " + "Salary : "
                + String.format("%.0f", calculateSalary()) + " | Kenaikan : " + String.format("%.0f",this.salaryRaise) + " | " 
                + "Kontrak  : " + this.contractDuration;
        return output;
    }

    // method untuk mendapatkan salary multiplier berdasarkan durasi kontrak
    private double getSalaryMultiplier() {
        if (this.contractDuration<=6){
            return 1;
        } else if (6<this.contractDuration&& this.contractDuration<=12){
            return 1.5;
        } else {
            return 2;
        }
    }
}
