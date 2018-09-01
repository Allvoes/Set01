

package DB;

import java.io.Serializable;


public class EmployeeDTO implements Serializable{
    
    private String employeeid;
    private String password;
    private String name;
    private int age;


    public EmployeeDTO(String employeeid, String password, String name, int age) {
        this.employeeid = employeeid;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
