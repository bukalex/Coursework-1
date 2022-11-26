public class Main {
    public static void main(String[] args) {
        EmployeeBook skyPro = new EmployeeBook();
        skyPro.addEmployee("Смирнов", "Максим", "Фёдорович", 1, 100000);
        skyPro.addEmployee("Рыбакова", "Теона", "Михайловна", 2, 103000);
        skyPro.addEmployee("Наумов", "Роман", "Максимович", 3, 90000);
        skyPro.addEmployee("Яковлев", "Павел", "Даниилович", 4, 8000);
        skyPro.addEmployee("Головин", "Руслан", "Григорьевич", 5, 200000);
        skyPro.addEmployee("Зайцева", "Марьям", "Егоровна", 1, 150000);
        skyPro.addEmployee("Сидоров", "Николай", "Матвеевич", 2, 125000);
        skyPro.addEmployee("Виноградов", "Гордей", "Владиславович", 3, 130000);
        skyPro.addEmployee("Кузин", "Роман", "Ильич", 4, 180000);
        skyPro.addEmployee("Иванов", "Никита", "Владиславович", 5, 10000);

        System.out.println("getEmployees");
        skyPro.getEmployees();

        System.out.println("getSumSalary");
        System.out.println(skyPro.getSumSalary());

        System.out.println("getWithMinSalary");
        System.out.println(skyPro.getWithMinSalary().toString());

        System.out.println("getWithMaxSalary");
        System.out.println(skyPro.getWithMaxSalary().toString());

        System.out.println("getAverageSalary");
        System.out.println(skyPro.getAverageSalary());

        System.out.println("getSNP");
        skyPro.getSNP();

        System.out.println("indexing");
        skyPro.indexing(2);
        skyPro.getEmployees();

        System.out.println("getWithMinSalaryInDep");
        System.out.println(skyPro.getWithMinSalaryInDep(2).toString());

        System.out.println("getWithMaxSalaryInDep");
        System.out.println(skyPro.getWithMaxSalaryInDep(2).toString());

        System.out.println("getSumSalaryInDep");
        System.out.println(skyPro.getSumSalaryInDep(2));

        System.out.println("getAverageSalaryInDep");
        System.out.println(skyPro.getAverageSalaryInDep(2));

        System.out.println("getDepartment");
        skyPro.getDepartment(2);

        System.out.println("indexingInDep");
        skyPro.indexingInDep(2, 2);
        skyPro.getDepartment(2);

        System.out.println("getWithLowerSalary");
        skyPro.getWithLowerSalary(150000);

        System.out.println("getWithHigherSalary");
        skyPro.getWithHigherSalary(150000);

        System.out.println("removeEmployee");
        skyPro.removeEmployee("Смирнов Максим Фёдорович");

        System.out.println("removeEmployee");
        skyPro.removeEmployee(2);
        skyPro.getEmployees();

        System.out.println("changeDepartment");
        skyPro.changeDepartment("Иванов Никита Владиславович", 4);

        System.out.println("changeSalary");
        skyPro.changeSalary("Иванов Никита Владиславович", 140000);

        System.out.println("getByDepartments");
        skyPro.getByDepartments();
    }
}