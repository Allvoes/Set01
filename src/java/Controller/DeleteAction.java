

package Controller;

import DB.EmployeeDTO;
import Model.EmployeeDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;


public class DeleteAction extends ActionSupport {
    
    private String employeeidProcess;
    private ArrayList<EmployeeDTO> employee;

    public ArrayList<EmployeeDTO> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<EmployeeDTO> employee) {
        this.employee = employee;
    }

    public String getEmployeeidProcess() {
        return employeeidProcess;
    }

    public void setEmployeeidProcess(String employeeidProcess) {
        this.employeeidProcess = employeeidProcess;
    }
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
         String url = "error";
        try
        {
            System.out.println("employeeid can xoa lai: " + employeeidProcess);
            EmployeeDAO dao = new EmployeeDAO();
            dao.delete(employeeidProcess);
            employee = dao.searchLikeName("");
            url = "success";
                        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return url;
    }
    
}
