import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 * @author He.H
 * @date 2019/1/3 15:48
 **/


public class MySqlTest {
    public static void main(String[] args){
        // 加载数据库驱动  com.mysql.jdbc.Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // 获取mysql连接地址
        String url = "jdbc:mysql://localhost:3306/world?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        // 数据名称
        String username = "root";
        // 数据库密码
        String password = "Huanghehe67389";
        // 获取一个数据的连接
        Connection conn;
        // 获取连接的一个状态
        try{
            Class.forName(driver);
            //getConnection()方法，连接MySQL数据库！
            conn=DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
                System.out.println("数据库连接成功！");
            //创建statement类对象，用来执行SQL语句！
            Statement Statement=conn.createStatement();
            //要执行的SQL语句
            String sql="SELECT code, name FROM world.country where Continent  regexp 'Africa|America' order by Name LIMIT 5;" ;
            //ResultSet类，用来存放获取的结果集！
            ResultSet rs=Statement.executeQuery(sql);
            System.out.println("-------------------------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-------------------------------");
            System.out.println("国家代码" + "\t" + "大洲");
            System.out.println("-------------------------------");
            String Code;
            String Name;
            while(rs.next()){
                //获取‘code’这列数据
                Code=rs.getString("Code");
                //获取‘name’这列数据
                Name=rs.getString("Name");
                //输出结果
                System.out.println(Code+"\t"+Name);
            }
            rs.close();
            conn.close();
        }
        catch(ClassNotFoundException e){
            //数据库驱动类异常处理
            System.out.println("数据库驱动加载失败！");
            e.printStackTrace();
        } catch(Exception e1){
            //数据库连接失败异常处理
            e1.printStackTrace();
        } finally {
            System.out.println("-------------------------------");
            System.out.println("数据库数据获取成功！");
        }
    }
}