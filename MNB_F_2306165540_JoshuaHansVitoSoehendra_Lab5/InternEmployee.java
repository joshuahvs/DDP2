public class InternEmployee extends Employee implements ExtendContractDuration { // mengimplementasikan sesuai UML
                                                                                 // diagram
    public int contractDuration; //atribut untuk durasi kontrak

    // melengkapi constructor berikut
    InternEmployee(String name, double salary, int contractDuration) {
        super(name, salary);
        this.contractDuration = contractDuration;
    }

    // Method yang megoveride calculate salary dari class employee
    @Override
    double calculateSalary() {
        return salary * getSalaryMultiplier();
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
                + String.format("%.0f", calculateSalary()) + " | " + "Kontrak : " + this.contractDuration + " Bulan";
        return output;
    }

    // method untuk mendapatkan salary multiplier berdasarkan durasi kontrak
    private double getSalaryMultiplier() {
        if(this.contractDuration<=6){
            return 1;
        } else if (6<this.contractDuration&& this.contractDuration<=12){
            return 1.25;
        } else{
            return 1.5;
        }
    }
}
