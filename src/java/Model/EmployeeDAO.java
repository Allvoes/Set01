

package Model;

import DB.DBUtils;
import DB.EmployeeDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EmployeeDAO implements Serializable{
    
    private DBUtils dbUtils;
    
    public EmployeeDAO() {
    }
    
    public boolean checkLogin(String employeeid, String password){
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try{
            conn = dbUtils.makeConnection();
            preStm = conn.prepareStatement("SELECT * FROM Employee WHERE EmployeeID = ? and Password = ?");
            preStm.setString(1, employeeid);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch(Exception e){ 
            e.printStackTrace(); 
        } finally {
            try{
                if(rs!=null){
                    rs.close();
                } 
                if(preStm!=null){
                    preStm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public ArrayList<EmployeeDTO> searchLikeName(String name){
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try{
            conn = dbUtils.makeConnection();
            preStm = conn.prepareStatement("SELECT * FROM Employee WHERE Name LIKE ?");
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            ArrayList result = new ArrayList();
            while(rs.next()){
                String employeeid = rs.getString("EmployeeId");
                String password = rs.getString("Password");
                String name1 = rs.getString("Name");
                int age = rs.getInt("Age");
                
                EmployeeDTO dto = new EmployeeDTO(employeeid, password, name1, age);
                result.add(dto);
            }
            return result;
        } catch(Exception e){ 
            e.printStackTrace(); 
        } finally {
            try{
                if(rs!=null){
                    rs.close();
                } 
                if(preStm!=null){
                    preStm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public boolean insert(String employeeid, String password, String name, int age){
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try{
            conn = dbUtils.makeConnection();
            preStm = conn.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?)");
            preStm.setString(1, employeeid);
            preStm.setString(2, password);
            preStm.setString(3, name);
            preStm.setInt(4, age);
            rs = preStm.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch(Exception e){ 
            e.printStackTrace(); 
        } finally {
            try{
                if(rs!=null){
                    rs.close();
                } 
                if(preStm!=null){
                    preStm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean delete(String employeeid){
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try{
            conn = dbUtils.makeConnection();
            preStm = conn.prepareStatement("DELETE FROM Employee WHERE EmployeeID=?");
            preStm.setString(1, employeeid);
            rs = preStm.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch(Exception e){ 
            e.printStackTrace(); 
        } finally {
            try{
                if(rs!=null){
                    rs.close();
                } 
                if(preStm!=null){
                    preStm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean update(String employeeid, String password, String name, int age){
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try{
            conn = dbUtils.makeConnection();
            preStm = conn.prepareStatement("UPDATE Employee set Password = ?, Name = ?, Age = ? WHERE EmployeeID = ?");
            preStm.setString(1, password);
            preStm.setString(2, name);
            preStm.setInt(3, age);
            preStm.setString(4, employeeid);
            rs = preStm.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch(Exception e){ 
            e.printStackTrace(); 
        } finally {
            try{
                if(rs!=null){
                    rs.close();
                } 
                if(preStm!=null){
                    preStm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return check;
    }
    
}
