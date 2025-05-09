import java.util.Scanner;

public class MainModule 
{
    public static void main(String[] args) 
    {
        DAO dao=new DAO();
        Scanner sc=new Scanner(System.in);
        int option=0;
        String opt="";
        do
        {
            System.out.println("CRUD OPERATION PROJECT");
            System.out.println("1.Create(Insert Emp)");
            System.out.println("2.Read(Display Emp)");
            System.out.println("3.Find");
            System.out.println("4.Update");
            System.out.println("5.Delete");
            System.out.print("Enter your option:");
            option=sc.nextInt();
            switch(option)
            {
                case 1->
                {
                    System.out.print("Enter empno:");
                    int eno=sc.nextInt();
                    System.out.print("Enter Ename:");
                    String ename=sc.next();
                    System.out.print("Enter sal:");
                    Float sal=sc.nextFloat();
                    if(dao.insertEmp(eno,ename,sal))
                    {
                        System.out.println("Insertion Success.....");
                    }
                    else
                    {
                        System.out.println("Insertion failed........");
                    }
                }
                case 2->
                {
                    dao.displayEmp();
                }
                case 3->
                {
                    System.out.print("enter eno:");
                    int eno=sc.nextInt();
                    if(dao.findEmp(eno))
                    {
                        System.out.println("Details founded successfully");
                    }
                    else
                    {
                        System.out.println("failed while getting data");
                    }
                }
                case 4->
                {
                    System.out.print("enter eno:");
                    int eno=sc.nextInt();
                    System.out.print("enter NewName:");
                    String name=sc.next();
                    if(dao.updateName(name, eno))
                    {
                        System.out.println("updated successfully...");
                    }
                    else
                    {
                        System.out.println("updation failed...");
                    }
                }
                case 5->
                {
                    System.out.print("enter eno:");
                    int eno=sc.nextInt();
                    if(dao.deleteEmp(eno))
                    {
                        System.out.println("deletion success");
                    }
                    else
                    {
                        System.out.println("deletion failed");
                    }
                }
                default->throw new IllegalArgumentException("Invalid Option"+option);
            }
            System.out.print("Do you want to Continue(yes/no):"); 
            opt=sc.next();   
        }
        while(opt.equalsIgnoreCase("Yes"));
       System.out.println("........END..........");
    }    
}
