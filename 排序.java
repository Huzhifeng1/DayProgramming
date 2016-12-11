import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class seqencing {
	public static void main(String args[]) throws IOException{
		List<Integer> angelToA_time_complete = new LinkedList<Integer>();
		String filePath = "D:/LaPose/angelToA/angelToA_time_complete.txt";
	    Scanner in = new Scanner(Paths.get(filePath));
	    while(in.hasNextInt()){
	    	angelToA_time_complete.add(in.nextInt());
	    }
	
		
	//将angelToA_time_complete从小到大排序，放回原链表
	for(int i=0;i<angelToA_time_complete.size();i++){
		int min = angelToA_time_complete.get(i);
		int n=i;
		for(int j=i+1;j<angelToA_time_complete.size();j++){
			if(angelToA_time_complete.get(j)<min){
				min=angelToA_time_complete.get(j);
				n=j;
			}
		}
		int temp=angelToA_time_complete.get(i);
		angelToA_time_complete.set(n, temp);
		angelToA_time_complete.set(i,min);
	}


	//计算angelToA_time_complete中每个数字的重复个数
	List<Integer> number = new LinkedList<Integer>();
	    
	for(int i=0;i<angelToA_time_complete.size();i++){
		int count = 0;
		for(int j=0;j<angelToA_time_complete.size();j++){		
			if(angelToA_time_complete.get(i).equals(angelToA_time_complete.get(j)))
				count=count+1;
		}
		number.add(count);
	}
	
	
		//test
	    for(int i=0;i<angelToA_time_complete.size();i++)
	    	System.out.println(angelToA_time_complete.get(i)+"  "+number.get(i));
	
	
	
	}
}
