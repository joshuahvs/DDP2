public class Employee {
    // melengkapi visibility modifier attribute dan methods di bawah
    private int employeeID;
    private String name;
    private int yearsOfWork;
    private double baseSalary;
    private double finalSalary;

    // mambahkan Constructor serta Setter dan Getter
    public Employee(int employeeID, String name, int yearsOfWork, double baseSalary, double finalSalary) {
        this.employeeID = employeeID;
        this.name = name;
        this.yearsOfWork = yearsOfWork;
        this.baseSalary = baseSalary;
        this.finalSalary = finalSalary;
    }
    // SETTER
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void setFinalSalary(double finalSalary){
        this.finalSalary = finalSalary;
    }

    // GETTER
    public int getEmployeeId() {
        return employeeID;
    }
    public String getName() {
        return name;
    }
    public int getYearsOfWork() {
        return yearsOfWork;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public double getFinalSalary() {
        return finalSalary;
    }

    //method tambahan untuk menentukan jabatan berdasarkan lama dia bekerja
    public String getJabatan(){
        if (getYearsOfWork()<=5){
            return "Junior";
        } else if (getYearsOfWork() >10){
            return "Expert";
        } else{
            return "Senior";
        }
    }

    //mengkalkulasi salary dan mereturn serta menyetelnya menjadi final salary
    double CalculateSalary() {
        // Mengimplementasikan method CalculateSalary
        double multiplier = 1;
        if (5<yearsOfWork && yearsOfWork <=10){
            multiplier = 1.5;
        } else if(yearsOfWork > 10){
            multiplier = 2;
        }
        return multiplier;
    }

    @Override
    public String toString() {
        // Mengimplementasikan method toString yang merupakan method override dari class Object
        return "Employee ID: " + employeeID + ", Name: " + name + ", Years of Work: " + yearsOfWork;
    }
}
