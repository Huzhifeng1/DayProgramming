import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Net2 {
	public static void main(String arg[]) {
		String[] InvestFirm = new String[2000]; // 用来存放所有的投资公司名称（去重复）
		String[][] Project = new String[2000][500]; // 用来存放 被投资的 项目名称 （去重复）
		int i = 0;
		int temp=0;
		try {
			Connection con = null; // 定义一个MYSQL链接对象
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL驱动
			con = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/db_investment?useUnicode=true&characterEncoding=GBK",
							"root", "password"); // 链接本地MYSQL
			// System.out.print("yes");			// 测试

			Statement stmt; // 创建声明
			stmt = con.createStatement();

			String selectSql2 = "SELECT DISTINCT invest_firm_name FROM tb_investment_event"; // 去重复
			ResultSet selectRes2 = stmt.executeQuery(selectSql2);
			while (selectRes2.next()) {
				String invest_firm_name2 = selectRes2.getString("invest_firm_name");
				InvestFirm[i] = invest_firm_name2; // 将所有投资公司名放入 InvestFirm[]数组存放
				i = i + 1;
			}
			temp = i;

			for (int j = 0; j < temp; j++) { // 遍历所有投资者
				int k = 0;

				String selectSql3 = "SELECT DISTINCT project_name FROM tb_investment_event WHERE invest_firm_name='"+ InvestFirm[j] + "'";
				stmt.execute(selectSql3);
				ResultSet selectRes3 = stmt.executeQuery(selectSql3);
				while (selectRes3.next()) {
					String project_name = selectRes3.getString("project_name");
					// System.out.println(project_name); // 测试
					Project[j][k] = project_name; // 放入数组
					k++;
				}
			}
			// System.out.println(Project[10][0]); // 测试
			// }

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.print("MYSQL ERROR:" + e.getMessage());
		}
		
		// 定义邻接矩阵
		double[][] Link = new double[2000][2000]; 
		int l,m=0;
		System.out.println("yes");	//测试
		for( l=1;l<1000;l++){
			for( m=l+1;m<1000;m++){
				int count=0;
				for(int j=0;j<Project[l].length;j++){
					for(int n=0;n<Project[m].length;n++){
						if(Project[l][j]==Project[m][n])
							count=count+1;
						else ;
					}
				}
				Link[l][m]=count;		// 两间公司的权值
				
			}
	//		System.out.println(Link[l][m]);	
		}
		System.out.println("yes1");
		for(l=0;l<1000;l++){
			for(m=0;m<1000;m++){		
				if(Link[l][m]!=0)  
					System.out.println(InvestFirm[l]+"  和  "+InvestFirm[m]+"  的权重为  "+Link[l][m]);
		}
			}
	}
}
