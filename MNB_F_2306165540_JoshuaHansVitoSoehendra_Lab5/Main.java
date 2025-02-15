import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Selamat Datang di PacilRekrutment");
        while (true) {
            printWelcomingMsg();
            System.out.print("Input: ");
            int actionCode = sc.nextInt();
            switch (actionCode) {
                case 1:
                    printEmployeeList();
                    break;
                case 2:
                    hireEmployee();
                    break;
                case 3:
                    askForRaise();
                    break;
                case 4:
                    extendContract();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan layanan PacilRekrutment ~ !");
                    sc.close();
                    return;
                default:
                    unknownActionMsg();
                    break;
            }
        }
    }

    // mengimplemntasikan untuk print daftar employee
    public static void printEmployeeList() {
        //mengecheck apakah employeelist empty
        if (employeeList.isEmpty()) {
            System.out.println("Tidak Ada Employee yang Terdaftar!!!");
            System.out.println();
        } else {
            ArrayList<PermanentEmployee> permanentList = getPermanentEmployee();
            ArrayList<ContractEmployee> contractList = getContractEmployee();
            ArrayList<InternEmployee> internList = getInternEmployee();
            //jika list tidak empty maka akan menampilkan data employee
            if (!permanentList.isEmpty()) {
                displayPermanentEmployee();
            }
            if (!contractList.isEmpty()) {
                displayContractEmployee();
            }
            if (!internList.isEmpty()) {
                displayInternEmployee();
            }
        }
    }

     // Mengimplementasikan untuk hire employee
    public static void hireEmployee() {
        //meminta nama dan mengecheck apakah nama sudah terdaftar
        System.out.print("Nama: ");
        sc.nextLine();
        String nama = sc.nextLine();
        for (Employee e : employeeList) {
            if (e.name.equals(nama)) {
                System.out.println("Nama sudah terdaftar!!!");
                System.out.println();
                return;
            }
        }
        //meminta base salary dan status employee
        System.out.print("Base Salary: ");
        double salary = sc.nextDouble();
        System.out.print("Status Employee (Permanent/Contract/Intern): ");
        sc.nextLine();
        String status = sc.nextLine();
        Employee employee = null;
        // membuat object baru sesuai dengan status yang diinput, dan mengeprint pesan yang sesuai
        if (status.toLowerCase().equals("permanent")) {
            employee = new PermanentEmployee(nama, salary);
            System.out.println("PermanentEmployee dengan ID " + employee.employeeId + " bernama " + nama
                    + " berhasil ditambahkan!");
        } else if (status.toLowerCase().equals("contract")) {
            System.out.print("Lama Kontrak (Bulan): ");
            int duration = sc.nextInt();
            employee = new ContractEmployee(nama, salary, duration);
            System.out.println("ContractEmployee dengan ID " + employee.employeeId + " bernama " + nama
                    + " berhasil ditambahkan!");
        } else if (status.toLowerCase().equals("intern")) {
            System.out.print("Lama Kontrak (Bulan): ");
            int durasi = sc.nextInt();
            employee = new InternEmployee(nama, salary, durasi);
            System.out.println("InternEmployee dengan ID " + employee.employeeId + " bernama " + nama
                    + " berhasil ditambahkan!");
        }
        System.out.println();
        employeeList.add(employee);
    }

    // Mengimplementasikan untuk pengajuan kenaikan gaji
    public static void askForRaise() {
        // mengecheck apakah employeelist kosong empty
        if (employeeList.isEmpty()) {
            System.out.println("Tidak Ada Permanent atau Contract Employee yang Terdaftar!!!");
            System.out.println();
            return;
        }
        // mendapatkan list permanent employee dan contract employee
        ArrayList<PermanentEmployee> permanentList = getPermanentEmployee();
        ArrayList<ContractEmployee> contractList = getContractEmployee();
        // mengecheck apakah ada permanent employee dan contract employee
        if (!permanentList.isEmpty()) {
            displayPermanentEmployee();
        }
        if (!contractList.isEmpty()) {
            displayContractEmployee();
        }
        // meminta nama atau ID employee
        System.out.print("Masukan Nama/ID Employee: ");
        sc.nextLine();
        String namaOrId = sc.nextLine();
        // mengambil employee yang sesuai
        Employee employee = getEmployeeByNameOrId(namaOrId);
        if (employee == null) {
            System.out.println("Employee dengan Nama/ID " + namaOrId + " Tidak Ditemukan!!!");
        } else {
            //jika employee merupakan intern
            if (employee instanceof InternEmployee){
                System.out.println("Intern Employee Tidak Bisa Mendapatkan Raise!!!");
            } else{
                System.out.print("Masukkan Jumlah Kenaikan: ");
                double raiseAmount = sc.nextDouble();
                // jika raise amount negatif
                if (raiseAmount < 0) {
                    System.out.println("Kenaikan Gaji Tidak Boleh Negatif!!!");
                } else {
                    //jika employee merupakan permanent employee
                    if (employee instanceof PermanentEmployee) {
                        ((PermanentEmployee) employee).askRaise(raiseAmount);
                        System.out.println(
                                "Employee dengan Nama/ID " + namaOrId + " Berhasil Dinaikkan Gajinya sebesar "
                                        + String.format("%.0f", raiseAmount));
                    // jika employee merupakan contract employee
                    } else if (employee instanceof ContractEmployee) {
                        ((ContractEmployee) employee).askRaise(raiseAmount);
                        System.out.println(
                                "Employee dengan Nama/ID " + namaOrId + " Berhasil Dinaikkan Gajinya sebesar "
                                        + String.format("%.0f", raiseAmount));
                    }
                }
            }
        }
        System.out.println();
    }
    // Mengimplementasikan untuk pengajuan perpanjangan masa kontrak
    public static void extendContract() {
        //jika employee list kosong
        if (employeeList.isEmpty()) {
            System.out.println("Tidak Ada Contract atau Intern Employee yang Terdaftar!!!");
            System.out.println();
            return;
        }
        //mengambil list contract dan intern employee
        ArrayList<ContractEmployee> contractList = getContractEmployee();
        ArrayList<InternEmployee> internList = getInternEmployee();
        //jika listnya ada tidak kosong maka akan menampilkan daftar employee
        if (!contractList.isEmpty()) {
            displayContractEmployee();
        }
        if (!internList.isEmpty()) {
            displayInternEmployee();
        }
        // meminta dan mengambil employee yang sesuai
        System.out.print("Masukan Nama/Id Employee: ");
        sc.nextLine();
        String namaOrId = sc.nextLine();
        Employee employee = getEmployeeByNameOrId(namaOrId);
        // jika employee tidak ada
        if (employee == null) {
            System.out.println("Employee dengan Nama/ID " + namaOrId + " Tidak Ditemukan!!!");
        } else {
            //jika employee merupakan permanent employee
            if (employee instanceof PermanentEmployee){
                System.out.println("PermanentEmployee Tidak Bisa Extend Kontrak!!!");
            } else{
                //meminta lama extend
                System.out.print("Masukan Lama Extend Kontrak (Bulan): ");
                int extendAmount = sc.nextInt();
                //jika employee merupakan contract employee
                if (employee instanceof ContractEmployee) {
                    ((ContractEmployee) employee).extendContract(extendAmount);
                    System.out.println(
                            "Employee dengan Nama/ID " + namaOrId + " Berhasil Diperpanjang Kontraknya Selama "
                                    + extendAmount
                                    + " Bulan");
                // jika employee merupakan intern employee
                } else if (employee instanceof InternEmployee) {
                    ((InternEmployee) employee).extendContract(extendAmount);
                    System.out.println(
                            "Employee dengan Nama/ID " + namaOrId + " Berhasil Diperpanjang Kontraknya Selama " + extendAmount
                                    + " Bulan");
                }
            }
        }
        System.out.println();
    }

    // Kumpulan Helper Method
    // method untuk mendapatkan employee yang sesuai
    public static Employee getEmployeeByNameOrId(String nameOrId) {
        // Return employee if exists, otherwise null
        for (Employee employee : employeeList) {
            if (employee.name.equals(nameOrId) || Integer.toString(employee.employeeId).equals(nameOrId)) {
                return employee;
            }
        }
        return null;
    }
    //method untuk display permanent employee
    public static void displayPermanentEmployee() {
        if (PermanentEmployee.employeeCnt == 0) {
            return;
        }
        System.out.println("===== Pegawai Tetap =====");
        ArrayList<PermanentEmployee> permanentEmployees = getPermanentEmployee();
        for (PermanentEmployee employee : permanentEmployees) {
            System.out.println(employee);
        }
        System.out.println();
    }
    //method untuk display contract employee
    public static void displayContractEmployee() {
        if (ContractEmployee.employeeCnt == 0) {
            return;
        }
        System.out.println("===== Pegawai Kontrak =====");
        ArrayList<ContractEmployee> contractEmployees = getContractEmployee();
        for (ContractEmployee employee : contractEmployees) {
            System.out.println(employee);
        }
        System.out.println();
    }
    //method untuk display intern employee
    public static void displayInternEmployee() {
        if (InternEmployee.employeeCnt == 0) {
            return;
        }
        System.out.println("===== Pegawai Intern =====");
        ArrayList<InternEmployee> internEmployees = getInternEmployee();
        for (InternEmployee employee : internEmployees) {
            System.out.println(employee);
        }
        System.out.println();
    }

    // Penggunaan Generics dapat digunakan (akan dipelajari di week mendatang)
    // untuk mengurangi pengulangan 3 method ini
    public static ArrayList<InternEmployee> getInternEmployee() {
        ArrayList<InternEmployee> internEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee instanceof InternEmployee) {
                internEmployees.add((InternEmployee) employee);
            }
        }
        return internEmployees;
    }

    public static ArrayList<ContractEmployee> getContractEmployee() {
        ArrayList<ContractEmployee> contractEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee instanceof ContractEmployee) {
                contractEmployees.add((ContractEmployee) employee);
            }
        }
        return contractEmployees;
    }

    public static ArrayList<PermanentEmployee> getPermanentEmployee() {
        ArrayList<PermanentEmployee> permanentEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee instanceof PermanentEmployee) {
                permanentEmployees.add((PermanentEmployee) employee);
            }
        }
        return permanentEmployees;
    }

    // Printing Function
    public static void printWelcomingMsg() {
        System.out.println("Silakan pilih salah satu opsi berikut:");
        System.out.println("[1] Employee List");
        System.out.println("[2] Hire Employee");
        System.out.println("[3] Raise Salary");
        System.out.println("[4] Extend Contract");
        System.out.println("[5] Exit");
        System.out.println("=".repeat(64));
    }

    public static void unknownActionMsg() {
        System.out.println("Mohon masukkan opsi yang valid!\n");
    }
}