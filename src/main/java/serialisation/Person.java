package serialisation;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String position;
    private int salary;

    public Person(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void showInfo(){
        System.out.println("Сотрудник " + name + " в должности " + position + " зарабатывает " + salary);
    }
}
