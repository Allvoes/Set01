/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DB.EmployeeDTO;
import Model.EmployeeDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author David
 */
public class LoginAction extends ActionSupport {
    
    String employeeid,password;
     private ArrayList<EmployeeDTO> employee;

    public ArrayList<EmployeeDTO> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<EmployeeDTO> employee) {
        this.employee = employee;
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
    
    public LoginAction() {
    }
    
    @Override
    public String execute() throws Exception {
       String check = "error";
        EmployeeDAO dao = new EmployeeDAO();
        if(dao.checkLogin(employeeid, password)){
            Map session = ActionContext.getContext().getSession();
            session.put("ADMIN",employeeid);
            employee = dao.searchLikeName("");
            check = "success";
        }else{
            check = "error";
        }
        return check;
    }
    
    
   
    
    
    @Override
    public void validate()
    {
        if(!employeeid.equals("E01")){
            addFieldError("employeeid", "Access Denied.");
        }
        if(this.employeeid.length() == 0)
        {
            addFieldError("employeeid", "Employee ID is required!!!");;
        }
        if(this.password.length() == 0)
        {
            addFieldError("password", "Password is required!!!");;
        }
    }
    
}
