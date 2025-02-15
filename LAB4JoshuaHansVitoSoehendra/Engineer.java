// Class Engineer adalah subclass dari Employee
public class Engineer extends Employee {
    // melengkapi visibility modifier attribute dan methods di bawah
    private int totalProject;
    private double projectFee;

    // menambahkan Constructor serta Setter dan Getter
    public Engineer(int employeeID, String name, int yearsOfWork, double baseSalary, double finalSalary,
            int totalProject, double projectFee) {
        super(employeeID, name, yearsOfWork, baseSalary, finalSalary);
        this.totalProject = totalProject;
        this.projectFee = projectFee;
    }

    // SETTER
    public void setTotalProject(int totalProject) {
        this.totalProject = totalProject;
    }

    public void setProjectFee(double projectFee) {
        this.projectFee = projectFee;
    }

    // GETTER
    public int getTotalProject() {
        return totalProject;
    }

    public double getProjectFee() {
        return projectFee;
    }

    //mengkalkulasi salary dan mereturn serta menyetelnya menjadi final salary
    double CalculateSalary() {
        // mengimplementasikan method CalculateSalary yang merupakan method override dari class Employee
        double totalFee = getBaseSalary() + (this.totalProject * this.projectFee);
        setFinalSalary(totalFee*super.CalculateSalary());
        return totalFee * super.CalculateSalary();
    }

    @Override
    public String toString() {
        // mengimplementasikan method toString yang merupakan method override dari class Object
        return "Nama: " + getName() + "\n" +
                "Pengalaman Kerja: " + getYearsOfWork() +" tahun"+ "\n"+
                "Jabatan: " + getJabatan() + "\n"+
                "Role: Engineer" + "\n"+
                "Banyak Project: " + getTotalProject()+ "\n"+
                "Final salary: " + String.format("%.1f", getFinalSalary()) + " IDR";
    }
}
