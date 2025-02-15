// Class Salesman adalah subclass dari Employee
public class Salesman extends Employee {
    // Mengkapi visibility modifier attribute dan methods di bawah
    private double totalSales;
    private double commissionFee;

    // Tambahkan Constructor serta Setter dan Getter
    public Salesman(int employeeID, String name, int yearsOfWork, double baseSalary, double finalSalary, double totalSales, double commissionFee){
        super(employeeID, name, yearsOfWork, baseSalary, finalSalary);
        this.totalSales = totalSales;
        this.commissionFee = commissionFee;
    }

    //SETTER
    public void setTotalSales(double totalSales){
        this.totalSales = totalSales;
    }
    public void setCommisionFee(double commissionFee) {
        this.commissionFee = commissionFee;
    }
    //GETTER
    public double getTotalSales(){
        return totalSales;
    }
    public double commissionFee(){
        return commissionFee;
    }

    //mengkalkulasi salary dan mereturn serta menyetelnya menjadi final salary
    double CalculateSalary() {
        // Implementasikan method CalculateSalary yang merupakan method override dari class Employee
        double totalFee = getBaseSalary()+(this.totalSales*this.commissionFee/100);
        setFinalSalary(totalFee*super.CalculateSalary());
        return totalFee*super.CalculateSalary();
    }

    @Override
    public String toString() {
        // Implementasikan method toString yang merupakan method override dari class Object
        return "Nama: " + getName() + "\n" +
                "Pengalaman Kerja: " + getYearsOfWork() +" tahun"+ "\n"+
                "Jabatan: " + getJabatan() + "\n"+
                "Role: Salesman" + "\n"+
                "Banyak Sales: " + String.format("%.1f", getTotalSales())+ " IDR"+  "\n"+
                "Final salary: " + String.format("%.1f", getFinalSalary()) + " IDR";
    }
}
