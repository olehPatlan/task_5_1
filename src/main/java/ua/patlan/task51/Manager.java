package ua.patlan.task51;

public class Manager extends Employee {

    public Manager(long id) {
        super(id);
    }

    public Manager(long id, String name, String surname, double defaultSalary, double workedHours) {
        super(id, name, surname, defaultSalary, workedHours);
    }

    @Override
    public String info() {
        return getId() + ";" + getName() + ";" +
                getSurname() + ";" + getDefaultSalary() + ";" +
                getWorkedHours() + ";";
    }

    @Override
    public double calculateSalary() {
        if (percentageWorkedTime() >= HUNDRED_PERCENT)
            return getDefaultSalary();
        return super.calculateSalary();
    }


}
