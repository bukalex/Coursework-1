import java.util.ArrayList;

public class EmployeeBook {
    private Employee[] employeeArray = new Employee[1];


    public void addEmployee(String surname, String name, String patronymic, int department, int salary){
        Employee newEmployee = new Employee(surname, name, patronymic, department, salary);
        for(int i = 0; i < employeeArray.length; i++){
            if (employeeArray[i] == null){
                employeeArray[i] = newEmployee;
                break;
            }
            if(i == employeeArray.length-1){
                Employee[] newEmployeeArray = new Employee[employeeArray.length + 1];
                for(int j = 0; j < employeeArray.length; j++){
                    newEmployeeArray[j] = employeeArray[j];
                }
                newEmployeeArray[newEmployeeArray.length - 1] = newEmployee;
                employeeArray = newEmployeeArray;
                break;
            }
        }
    }

    public void removeEmployee(String SNP){
        for (int i = 0; i < employeeArray.length; i++){
            if (employeeArray[i] != null){
                if(employeeArray[i].getSNP().equalsIgnoreCase(SNP)){
                    employeeArray[i] = null;
                    break;
                }
            }
        }
    }

    public void removeEmployee(int id){
        for (int i = 0; i < employeeArray.length; i++){
            if (employeeArray[i] != null){
                if(employeeArray[i].getId() == id){
                    employeeArray[i] = null;
                    break;
                }
            }
        }
    }

    public void changeDepartment(String SNP, int newDepartment){
        if(newDepartment < 1 || 5 < newDepartment){
            throw new IllegalArgumentException("Неверный номер отдела!");
        }
        for (int i = 0; i < employeeArray.length; i++){
            if (employeeArray[i] != null){
                if(employeeArray[i].getSNP().equalsIgnoreCase(SNP)){
                    employeeArray[i].setDepartment(newDepartment);
                    break;
                }
            }
        }
    }

    public void changeSalary(String SNP, int newSalary){
        for (int i = 0; i < employeeArray.length; i++){
            if (employeeArray[i] != null){
                if(employeeArray[i].getSNP().equalsIgnoreCase(SNP)){
                    employeeArray[i].setSalary(newSalary);
                    break;
                }
            }
        }
    }

    public void getByDepartments(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Department: " + i);
            getDepartment(i);
        }
    }

    public void getEmployees(){
        for(Employee employee : employeeArray){
            if (employee != null){
                System.out.println(employee.toString());
            }
        }
    }

    public int getSumSalary(){
        int sum = 0;
        for(Employee employee : employeeArray){
            if (employee != null){
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getWithMinSalary(){
        int min = getMinOrMaxSalary(employeeArray);
        Employee person = employeeArray[0];
        for(Employee employee : employeeArray){
            if (employee != null){
                if(employee.getSalary() < min) {
                    min = employee.getSalary();
                    person = employee;
                }
            }
        }
        return person;
    }

    public Employee getWithMaxSalary(){
        int max = getMinOrMaxSalary(employeeArray);
        Employee person = employeeArray[0];
        for(Employee employee : employeeArray){
            if (employee != null){
                if(employee.getSalary() > max) {
                    max = employee.getSalary();
                    person = employee;
                }
            }
        }
        return person;
    }

    public float getAverageSalary(){
        if(employeeArray.length == 0){
            throw new RuntimeException("Нет людей!");
        }
        return (float)getSumSalary()/employeeArray.length;
    }

    public void getSNP(){
        for(Employee employee : employeeArray){
            if (employee != null) {
                System.out.println("Surname: " + employee.getSurname() + "\n" +
                        "Name: " + employee.getName() + "\n" +
                        "Patronymic: " + employee.getPatronymic() + "\n" +
                        "====================");
            }
        }
    }

    public void indexing(float percent){
        for(Employee employee : employeeArray){
            if (employee != null){
                employee.setSalary((int)((1+percent/100)*employee.getSalary()));
            }
        }
    }

    public Employee[] sortByDepartment(Employee[] array, int department){
        if(department < 1 || 5 < department){
            throw new IllegalArgumentException("Неверный номер отдела!");
        }
        ArrayList<Employee> sortedArrayList = new ArrayList<Employee>();
        for(Employee employee : array){
            if (employee != null){
                if(employee.getDepartment() == department){
                    sortedArrayList.add(employee);
                }
            }
        }
        Employee[] sortedArray = new Employee[sortedArrayList.size()];
        return sortedArrayList.toArray(sortedArray);
    }

    public Employee getWithMinSalaryInDep(int department){
        Employee[] array = sortByDepartment(employeeArray, department);
        int min = getMinOrMaxSalary(employeeArray);
        Employee person = array[0];
        for(Employee employee : array){
            if (employee != null){
                if(employee.getSalary() < min) {
                    min = employee.getSalary();
                    person = employee;
                }
            }

        }
        return person;
    }

    public Employee getWithMaxSalaryInDep(int department){
        Employee[] array = sortByDepartment(employeeArray, department);
        int max = getMinOrMaxSalary(employeeArray);
        Employee person = array[0];
        for(Employee employee : array){
            if (employee != null){
                if(employee.getSalary() >= max) {
                    max = employee.getSalary();
                    person = employee;
                }
            }
        }
        return person;
    }

    public int getSumSalaryInDep(int department){
        int sum = 0;
        for(Employee employee : sortByDepartment(employeeArray, department)){
            if (employee != null){
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public float getAverageSalaryInDep(int department){
        if(sortByDepartment(employeeArray, department).length == 0){
            throw new RuntimeException("Нет людей!");
        }
        return (float)getSumSalaryInDep(department)/sortByDepartment(employeeArray, department).length;
    }

    public void indexingInDep(int department, float percent){
        for(Employee employee : sortByDepartment(employeeArray, department)){
            if (employee != null){
                employee.setSalary((int)(1+percent/100)*employee.getSalary());
            }
        }
    }

    public void getDepartment(int department){
        if(department < 1 || 5 < department){
            throw new IllegalArgumentException("Неверный номер отдела!");
        }
        for(Employee employee : employeeArray){
            if (employee != null){
                if(employee.getDepartment() == department){
                    System.out.println(employee.toString("отдел"));
                }
            }
        }
    }

    public void getWithLowerSalary(int salary){
        for(Employee employee : employeeArray){
            if (employee != null){
                if(employee.getSalary() < salary){
                    System.out.println(employee.toString("зарплата"));
                }
            }
        }
    }

    public void getWithHigherSalary(int salary){
        for(Employee employee : employeeArray){
            if (employee != null){
                if(employee.getSalary() >= salary){
                    System.out.println(employee.toString("зарплата"));
                }
            }
        }
    }

    public int getMinOrMaxSalary(Employee[] array){
        int minOrMax = 0;
        for(Employee employee : array){
            if (employee != null){
                minOrMax = employee.getSalary();
                break;
            }
        }
        return minOrMax;
    }
}
