import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;


public class exe2 {
	public static void main(String argv[]){
        String filePath = "D:\\manager_name1.txt";
        readTxtFile(filePath);
    }


public static void readTxtFile(String filePath){
    try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println(lineTxt);
                }
                read.close();
    }else{
        System.out.println("找不到指定的文件");
    }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
 
}


public static void readTxtFile(List<String> list,String filePath){
    try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    //System.out.println(lineTxt);
                	list.add(lineTxt);
                }
                read.close();
            }else{
            	System.out.println("找不到指定的文件");
            }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
}
}
