import org.junit.Before;
import org.junit.Test;
import ua.patlan.task51.Employee;
import ua.patlan.task51.EmployeeUtils;
import ua.patlan.task51.Manager;
import ua.patlan.task51.Programmer;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTask51 {

    private List<Employee> list;
    @Before
    public void setUp(){
        list=new ArrayList<>();
        list.add(new Manager(1, "Tom", "surname", 2000, 16));
        list.add(new Programmer(2, "Bob", "surname", 2000, 16));
    }

    @Test
    public void testSaveAndRead(){
        String filePath="a.csv";
        EmployeeUtils.saveEmployeesToCSVFile(list,filePath,false);
        assertEquals(list, EmployeeUtils.readFromFile(filePath));
    }

}
