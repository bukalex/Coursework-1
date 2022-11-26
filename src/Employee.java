public class Employee {
    static int idCounter = 0;

    String surname;
    String name;
    String patronymic;
    int department;
    int salary;
    int id;

    public Employee(String surname, String name, String patronymic, int department, int salary){
        if(department < 1 || 5 < department){
            throw new IllegalArgumentException("Неверный номер отдела!");
        }
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = idCounter;
        idCounter++;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(){
        return "====================" + "\n" +
                "ID: " + id + "\n" +
                "Surname: " + surname + "\n" +
                "Name: " + name + "\n" +
                "Patronymic: " + patronymic + "\n" +
                "Department: " + department + "\n" +
                "Salary: " + salary + "\n" +
                "====================";
    }

    public String toString(String exception) {
        String answer = "====================" + "\n" +
                "ID: " + id + "\n" +
                "Surname: " + surname + "\n" +
                "Name: " + name + "\n" +
                "Patronymic: " + patronymic + "\n";
        if(!exception.toLowerCase().equals("отдел")){
            answer += "Department: " + department + "\n";
        }
        if(!exception.toLowerCase().equals("зарплата")){
            answer += "Salary: " + salary + "\n";
        }
        answer += "====================";
        return answer;
    }

    public String getSNP(){
        return surname + " " + name + " " + patronymic;
    }
}
