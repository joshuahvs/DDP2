abstract class Employee { //mengimplementasikan sesuai UML diagram
    int employeeId;
    static int employeeCnt = 0;
    String name;
    double salary;

    // melengkapi constructor berikut
    protected Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        employeeId = employeeCnt;
        employeeCnt++;
    }
    abstract double calculateSalary();
    abstract public String toString();
}
