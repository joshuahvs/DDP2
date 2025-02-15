// TODO: Class Accountant adalah subclass dari Employee
public class Accountant extends Employee {
    // TODO: Lengkapi visibility modifier attribute dan methods di bawah
    private int totalHoursWorked;
    private double hourlyRate;

    // TODO: Tambahkan Constructor serta Setter dan Getter
    public Accountant(int employeeID, String name, int yearsOfWork, double baseSalary, double finalSalary,
            int totalHoursWorked,
            double hourlyRate) {
        super(employeeID, name, yearsOfWork, baseSalary, finalSalary);
        this.totalHoursWorked = totalHoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // SETTER
    public void setTotalHourWorked(int totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // GETTER
    public int getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double hourlyRate() {
        return hourlyRate;
    }

    //mengkalkulasi salary dan mereturn serta menyetelnya menjadi final salary
    double CalculateSalary() {
        // mengimplementasikan method CalculateSalary yang merupakan method override
        double totalFee = getBaseSalary() + (this.totalHoursWorked * this.hourlyRate);
        setFinalSalary(totalFee*super.CalculateSalary());
        return totalFee * super.CalculateSalary();

    }

    @Override
    public String toString() {
        // meimplementasikan method toString yang merupakan method override dari class Object
        return "Nama: " + getName() + "\n" +
                "Pengalaman Kerja: " + getYearsOfWork() + " tahun" + "\n" +
                "Jabatan: " + getJabatan() + "\n" +
                "Role: Accountant" + "\n" +
                "Total jam kerja: " + getTotalHoursWorked() + "\n" +
                "Final salary: " + getFinalSalary() + " IDR";
    }
}
