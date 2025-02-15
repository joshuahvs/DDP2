import java.util.ArrayList;
import java.util.Scanner;

public class PacilValley {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Employee> employees = new ArrayList<>();

    private static void printSeparator() {
        System.out.println("=".repeat(64));
    }

    public static void employeeList() {
        int totalEmployee = employees.size();
        //jika belum ada employee
        if (totalEmployee == 0) {
            System.out.println("PacilValley belum memiliki karyawan :(\n");
            return;
        }

        printSeparator();
        System.out.println("PacilValley memiliki total " + totalEmployee + " karyawan:");
        // mencetak semua employee
        for (Employee employee : employees) {
            System.err.println(employee);
            System.out.println();
        }

        printSeparator();
    }
    //method untuk menghire employee
    public static void hireEmployee() {
        Employee newEmployee;
        //meminta input nama, pengalaman, base salary, dan role employee
        System.out.print("Nama: ");
        in.nextLine();
        String nama = in.nextLine();

        System.out.print("Pengalaman Kerja (tahun): ");
        int pengalamanKerja = Integer.parseInt(in.nextLine());

        System.out.print("Base Salary (IDR): ");
        double baseSalary = Integer.parseInt(in.nextLine());

        String role;

        // menggunakan while loop agar terus meminta input jika salah        
        while (true) {
            System.out.print("Role Employee: ");
            role = in.nextLine();
            int employeeID = employees.size() + 1; //employee idnya

            if (role.equalsIgnoreCase("Engineer")) {
                // Meminta input
                System.out.print("Project Fee (IDR): ");
                double projectFee = Integer.parseInt(in.nextLine());
                //menginisiasi engineer
                newEmployee = new Engineer(employeeID, nama, pengalamanKerja, baseSalary, 0, 0, projectFee);
                break;
            } else if (role.equalsIgnoreCase("Salesman")) {
                // Meminta input
                System.out.print("Commission Fee (%): ");
                double commissionFee = Integer.parseInt(in.nextLine());
                // menginisiasi salesman
                newEmployee = new Salesman(employeeID, nama, pengalamanKerja, baseSalary, 0, 0, commissionFee);
                break;
            } else if (role.equalsIgnoreCase("Accountant")) {
                // Meminta input
                System.out.print("Hourly Rate (IDR): ");
                double hourlyRate = Integer.parseInt(in.nextLine());
                //menginisiasi accountant
                newEmployee = new Accountant(employeeID, nama, pengalamanKerja, baseSalary, 0, 0, hourlyRate);
                break;
            //jika input yang diingikan tidak sesuai
            } else {
                System.out.println("\nRole employee tidak valid, silahkan input kembali dengan nilai yang benar!\n");
            }
        }
        // Menambahkan employee dan mencetak keluaran yang diminta
        employees.add(newEmployee);
        System.out.println(role + " dengan ID " + newEmployee.getEmployeeId() + " bernama " + newEmployee.getName()
                + " berhasil dihire!");
        System.out.println();

    }
    // method untuk menambahkan gaji berdasarkan total project dll
    public static void logEmployeeSalary() {
        if (employees.isEmpty()) {
            System.out.println("PacilValley belum memiliki karyawan :(\n");
            return;
        }
        // Meminta ID dan validasi ID
        // Meminta input data dan hitung gaji berdasarkan tipe employee
        boolean employeeFound = false;
        while (employeeFound == false) {
            System.out.print("Masukkan employee ID: ");
            int idToCheck = in.nextInt();
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == idToCheck) {
                    employeeFound = true;
                    //jika employee memiliki role engineer
                    if (employee instanceof Engineer) {
                        System.out.println(
                                "Employee bernama " + employee.getName() + " dengan role Engineer berhasil dipilih!"); 
                        System.out.print("Jumlah assigned project: ");
                        int jumlahAssignedProject = in.nextInt(); //meminta jumlah projek
                        Engineer engineer = (Engineer) employee; //casting employee ke engineer
                        engineer.setTotalProject(jumlahAssignedProject); //menyetel jumlah project
                        String formattedSalary = String.format("%.1f", engineer.CalculateSalary()); //memformat salary
                        System.out.println(
                                "Gaji " + employee.getName() + " bulan ini adalah " + formattedSalary + " IDR!"); //mencetak keluaran
                        employeeFound = true;
                        //jika employee memiliki role salesman
                    } else if (employee instanceof Salesman) {
                        System.out.println(
                                "Employee bernama " + employee.getName() + " dengan role Salesman berhasil dipilih!");
                        System.out.print("Jumlah sales: ");
                        int jumlahSales = in.nextInt(); 
                        Salesman salesman = (Salesman) employee; //casting employee ke salesman
                        salesman.setTotalSales(jumlahSales); 
                        String formattedSalary = String.format("%.1f", salesman.CalculateSalary());
                        System.out.println(
                                "Gaji " + employee.getName() + " bulan ini adalah " + formattedSalary + " IDR!");
                        employeeFound = true;
                        //jika employee memiliki role accountant
                    } else if (employee instanceof Accountant) {
                        System.out.println(
                                "Employee bernama " + employee.getName() + " dengan role Accountant berhasil dipilih!");
                        System.out.print("Jumlah jam bekerja: ");
                        int jumlahJamBekerja = in.nextInt();
                        Accountant accountant = (Accountant) employee;
                        accountant.setTotalHourWorked(jumlahJamBekerja);
                        String formattedSalary = String.format("%.1f", accountant.CalculateSalary());
                        System.out.println(
                                "Gaji " + employee.getName() + " bulan ini adalah " + formattedSalary + " IDR!");
                        employeeFound = true;
                    }
                }
            }
            //jika employee tidak ditemukan
            if (employeeFound == false) {
                System.out.println(
                        "Employee dengan ID " + idToCheck + " tidak ditemukan! Silahkan masukkan ID yang sesuai.");
            }
        }
        System.out.println();
    }
    //method untuk mencetak menu
    private static void printMenu() {
        System.out.println("Silakan pilih salah satu opsi berikut:");
        System.out.println("[1] Employee List");
        System.out.println("[2] Hire Employee");
        System.out.println("[3] Log Employee Salary");
        System.out.println("[4] Exit");
        System.out.println("=".repeat(64));
    }

    //method utama untuk menjalankan program
    public static void main(String[] args) {
        System.out.println("Selamat datang di PacilValley!");
        while (true) {
            printMenu();
            System.out.print("Input: ");
            int pilihan = in.nextInt();
            if (pilihan == 1) {
                employeeList();
            } else if (pilihan == 2) {
                hireEmployee();
            } else if (pilihan == 3) {
                logEmployeeSalary();
            } else {
                System.out.println("Terima kasih telah menggunakan layanan PacilValley ~ !");
                break;
            }
        }
    }
}