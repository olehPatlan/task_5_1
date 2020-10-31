package ua.patlan.task51;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

    public static void saveEmployeesToCSVFile(List<Employee> list, String path, boolean append) {
        try (FileOutputStream fos = new FileOutputStream(path, append)) {
            for (Employee employee : list) {
                saveEmployeeToCSVFile(employee, fos);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void saveEmployeeToCSVFile(Employee employee, FileOutputStream fos) throws IOException {
        byte[] buffer;
        buffer = (employee.getClass().getSimpleName() + ";" + employee.info()).getBytes();
        fos.write(buffer, 0, buffer.length);
        fos.write('\n');
    }

    public static List<Employee> readFromFile(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(filePath)) {
            int i;
            while ((i = fin.read()) != -1) {
                fileContent.append((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return transformStringToEmployees(fileContent.toString());
    }

    private static List<Employee> transformStringToEmployees(String fileContent) {
        List<Employee> employees = new ArrayList<>();
        for (String row : fileContent.split("\n")) {
            String[] values = row.split(";");
            Employee employee = null;

            if (values[0].equals("Manager")) {
                employee = new Manager(Integer.parseInt(values[1]), values[2], values[3],
                        Double.parseDouble(values[4]), Double.parseDouble(values[5]));
            }
            if (values[0].equals("Programmer")) {
                employee = new Programmer(Integer.parseInt(values[1]), values[2], values[3],
                        Double.parseDouble(values[4]), Double.parseDouble(values[5]));
            }
            if (employee != null) {
                employees.add(employee);
            }
        }
        return employees;
    }
}

