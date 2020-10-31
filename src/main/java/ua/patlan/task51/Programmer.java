package ua.patlan.task51;

public class Programmer extends Employee {

    public Programmer(long id) {
        super(id);
    }

    public Programmer(long id, String name, String surname, double defaultSalary, double workedHours) {
        super(id, name, surname, defaultSalary, workedHours);
    }

    public void p1(){
        System.out.println("p1");
    }
    @Override
    public String info() {
        return getId() + ";" + getName() + ";" +
                getSurname() + ";" + getDefaultSalary() + ";" +
                getWorkedHours() + ";";
    }
}
