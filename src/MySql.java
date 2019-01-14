import java.sql.*;


/**
 * @author He.H
 * @date 2019/1/10 15:40
 **/


public class MySql {
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/world?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "Huanghehe67389";
    public static void main(String[] args){
        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //mysql查询语句
            String sql = "SELECT code, name FROM world.country where Continent  regexp 'Africa|America' order by Name LIMIT 10";
            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                System.out.println("国家:" + rs.getString("name"));
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
