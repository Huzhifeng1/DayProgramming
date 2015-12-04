
//输出矩阵到txt
	public static void outputMatrixToTXT(int NumberOfTrainSet,
			int NumberOfAllFeatures,Integer[][] value,String filepath) throws IOException{
		
		  File file = new File(filepath);  			  
		  FileWriter out = new FileWriter(file,true);   //可追加的关键就在这个‘true’
		 		  
		  for(int i=0;i<NumberOfTrainSet;i++){
		   for(int j=0;j<NumberOfAllFeatures;j++){
		    out.write(value[i][j]+" ");//将数组中的数据写入到文件中。每行各数据之间TAB间隔
		   }
		   out.write("\r\n");
		  }
		  out.close();
		
		  
		  
	}//end of outputMatrixToTXT
	
	
	public static void main(String[] args){
	      outputMatrixToTXT(NumberOfTrainSet2,NumberOfAllFeatures,value10,"D:/LaPose/justatest2.txt");
	}
	
