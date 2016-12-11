import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Net2 {
	public static void main(String arg[]) {
        try {
            Connection con = null; //定义一个MYSQL链接对象
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_investment", "root","password"); //链接本地MYSQL
                                                          //ip：端口/数据库名               用户名  密码
            System.out.print("yes");
            
            Statement stmt; //创建声明
            stmt = con.createStatement();
            
          //查询数据并输出
            String selectSql = "SELECT * FROM tb_investment_event";
            ResultSet selectRes = stmt.executeQuery(selectSql);
            while (selectRes.next()) { //循环输出结果集
                String invest_firm_name = selectRes.getString("invest_firm_name"); 
                  // 想要取出的列的名字
                String project_name = selectRes.getString("project_name");
                   // 想要取出的列的名字
                System.out.print("\r\n\r\n");
                System.out.print("invest_firm_name:" + invest_firm_name + "project_name:" + project_name);
            }
            
        	} catch (Exception e) {
        		System.out.print("MYSQL ERROR:" + e.getMessage());
        	}

    }

}
