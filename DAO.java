import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
    private Connection con;
    public DAO()
    {
        try
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mtsdb1?user=root&password=siva");
            System.out.println("Connection Established.....");
        }
        catch(SQLException ex)
        {
            System.out.println("Error while connecting....");
            ex.getMessage();
        }    
    }
    public boolean insertEmp(int eno,String ename,Float sal)
    {
        boolean flag=false;
        try
        {
            PreparedStatement pstmt=con.prepareStatement("insert into employees values(?,?,?)");
            pstmt.setInt(1, eno);
            pstmt.setString(2, ename);
            pstmt.setFloat(3, sal);
            pstmt.executeUpdate();
            flag=true;
        }
        catch(SQLException ex)
        {
            System.out.println("Error while inserting data");
            ex.getMessage();
        }
        return flag;
    }
    public boolean displayEmp()
    {
        boolean flag=false;
        try
        {
            PreparedStatement pstmt=con.prepareStatement("select * from employees");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
               int eno=rs.getInt(1);
               String name=rs.getString(2);
               float sal=rs.getFloat(3);
               System.out.printf("%2d %2s %2f %n",eno,name,sal);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error while getting data");
            ex.getMessage();
        }
        return flag;
    }
    public boolean findEmp(int eno)
    {
        boolean flag=false;
        try
        {
            PreparedStatement pstmt=con.prepareStatement("select * from employees where eno="+eno);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                eno=rs.getInt(1);
                String ename=rs.getString(2);
                float sal=rs.getFloat(3);
                System.out.printf("%2d %2s %2f %n",eno,ename,sal);
                flag=true;
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Error while finding..."+ex.getMessage());
            
        }
        return flag;
    }
    public boolean updateName(String ename,int eno)
    {
        boolean flag=false;
        try
        {
            PreparedStatement pstmt=con.prepareStatement("update employees set ename=? where eno=?");
            pstmt.setString(1, ename);
            pstmt.setInt(2, eno);
            pstmt.executeUpdate();
            flag=true;
        }
        catch(SQLException ex)
        {
            System.out.println("Error while updating data...."+ex.getMessage());
        }
        return flag;
    }
    public boolean deleteEmp(int eno)
    {
        boolean flag=false;
        try
        {
            PreparedStatement pstmt=con.prepareStatement("delete from employees where eno=?");
            pstmt.setInt(1, eno);
            pstmt.executeUpdate();
            flag=true;
        }
        catch(SQLException ex)
        {
            System.out.println("Error while deleting....."+ex.getMessage());
        }
        return flag;
    }

}
