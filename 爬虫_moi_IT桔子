import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test0 {
	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= 20; i++) {
			String url = "http://itjuzi.com/investfirm?page=" + i;
			Document doc = Jsoup.connect(url).get();
			String result = doc.toString();
			Pattern pat = Pattern.compile("名称.+?>");
			Matcher mat = pat.matcher(result);

			while (mat.find()) // 得到 链接，放进list
			{
				list.add(mat.group().replaceAll("名称: ", "")
						.replaceAll("<a href=\"", "")
						.replaceAll("/\">", "")
						.replaceAll("\">", ""));
			}

			String url2 = list.get(i); // 用來放第一層
			Document doc2 = Jsoup.connect(url2).get();
			String result2 = doc2.toString();

			Pattern pat0 = Pattern.compile("<p> <a href=.+?</a> </p>"); // 获取 名称
			Matcher mat0 = pat0.matcher(result2);
			if (mat0.find())
				System.out.println(mat0.group()
						.replaceAll("<p> <a href=\"\">", "")
						.replaceAll("</a> </p>", ""));

			Pattern pat1 = Pattern.compile("<td.+?</td>"); 		
			Matcher mat1 = pat1.matcher(result2);
			while (mat1.find())
//				append("D:/IT桔子.txt",mat1.group()
//				.replaceAll("<td>", "")				// 时间和金额
//				.replaceAll("<a href=\"http://itjuzi.com/company.+?\">", "")		// 公司
//				.replaceAll("<a href=\"http://itjuzi.com/investevents.+?\">", "")		// 行业，轮次
//				.replaceAll("</a>","")  
//				.replaceAll("<td class=\"no-rigth-border\"></td>", "\r\n")
//				.replaceAll("<a href=\"http://itjuzi.com/investor.+?\">", "")
//				.replaceAll("</td>", ",")
//				.replaceAll("<td class=\"no-rigth-border\">", ""));
				System.out.print(mat1.group()
						.replaceAll("<td>", "")				// 时间和金额
						.replaceAll("<a href=\"http://itjuzi.com/company.+?\">", "")		// 公司
						.replaceAll("<a href=\"http://itjuzi.com/investevents.+?\">", "")		// 行业，轮次
						.replaceAll("</a>","")  
						.replaceAll("<td class=\"no-rigth-border\"></td>", "\r\n")
						.replaceAll("<a href=\"http://itjuzi.com/investor.+?\">", "")
						.replaceAll("</td>", ",")
						.replaceAll("<td class=\"no-rigth-border\">", ""));		//  投资人
				System.out.println(" ");
		}
	}

	
	public static void append(String path,String content){
			PrintWriter pw;
			try {
				pw = new PrintWriter( new FileWriter(new File (path)),true);
				pw.append(content);
				pw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
	}
	
	
}
