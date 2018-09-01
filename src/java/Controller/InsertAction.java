

package Controller;

import DB.EmployeeDTO;
import Model.EmployeeDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;


public class InsertAction extends ActionSupport {
    
    private String employeeid,password,name;
    private int age;
    private ArrayList<EmployeeDTO> employee;

    public ArrayList<EmployeeDTO> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<EmployeeDTO> employee) {
        this.employee = employee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    
    public InsertAction() {
    }
    
    public String execute() throws Exception {
         return "error";
    }
    
    public String insert() throws Exception{
        String url = "error";
        EmployeeDAO dao = new  EmployeeDAO();
        if(dao.insert(employeeid, password, name, age)){
            url = "error";
            
        }else{
            employee = dao.searchLikeName("");
            url = "success";
        }
        return url;
    }
    
}
