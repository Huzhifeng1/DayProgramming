import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Test2 {

	@Test
	public void getResult() {
		String url = null;
		 for (int i = 1; i <= 1943; i++) {
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			 url = "http://itjuzi.com/investfirm/" + i;
		test(url);
		 }
	}

	public void test(String url) {

		try {
			Document doc = Jsoup.connect(url).get();
			// 获取机构名称
			String name = null;
			Elements ele0 = doc.getElementsByAttributeValue("class",
					"public-info pull-left");
			name = ele0.select("p").text();

			// 获取投资事件
			Elements ele = doc.getElementsByAttributeValue("class",
					"children-norml-link");
			for (Element element : ele) {
				Elements alltrs = element.getElementsByTag("tr");
				//迭代器iterator
				Iterator it =  alltrs.iterator();
				it.next();//直接跳到下一个元素
				while(it.hasNext()){
					Element tr = (Element) it.next();
					StringBuffer sb = new StringBuffer();
					sb.append(name).append(" ");
				//	System.out.println(sb.append(tr.text()));
					StringBuffer str=sb.append(tr.text());		
					append("D:/IT桔子.txt",str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void append(String path, StringBuffer content) throws IOException {
		System.out.println(content);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path),true));
		bw.write(content.toString()+"\r\n");
		bw.flush();
		bw.close();
	}
	

			
	}
