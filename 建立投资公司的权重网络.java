import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Net2 {
	public static void main(String arg[]) {
		String[] InvestFirm = new String[2000]; // 用来存放所有的投资公司名称（去重复）
		String[][] Project = new String[2000][500]; // 用来存放 被投资的 项目名称 （去重复）
		int i = 0;
		int temp = 0;
		try {
			Connection con = null; // 定义一个MYSQL链接对象
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL驱动
			con = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/db_investment?useUnicode=true&characterEncoding=GBK",
							"root", "password"); // 链接本地MYSQL

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
					Project[j][k] = project_name; // 放入数组
					k++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 定义邻接矩阵
		double[][] Link = new double[2000][2000];
		int l, m = 0;
		double count = 0;
		System.out.println("yes"); // 测试
		for (l = 0; l < temp; l++) {// 投資公司
			for (m = l + 1; m < temp; m++) {
				count = 0;
				for (int j = 0; j < Project[l].length; j++) {
					if (Project[l][j] == null)			break;// j=Project[l].length-1;
					for (int n = 0; n < Project[m].length; n++) {
						if (Project[m][n] == null)		break;// n=Project[m].length-1;
						if (Project[l][j].equals(Project[m][n])) {
							count += 1;
						}
					}
				}
				Link[l][m] = count; // 两间公司的权值
			}
		}
		System.out.println("yes1");
		for (l = 0; l < 1000; l++) {
			for (m = 0; m < 1000; m++) {
				if (Link[l][m] > 1.0) {
					System.out.println(InvestFirm[l] + "  和  " + InvestFirm[m]+ "  的权重为  " + Link[l][m]);
					StringBuffer sb = new StringBuffer();
					StringBuffer str = sb.append(InvestFirm[l] + "  和  "+ InvestFirm[m] + "  的权重为  " + Link[l][m]);
					try {
						append("D:/IT桔子_投资公司权重.txt", str);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void append(String path, StringBuffer content)throws IOException {
		System.out.println(content);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path),true));
		bw.write(content.toString() + "\r\n");
		bw.flush();
		bw.close();
	}
}
