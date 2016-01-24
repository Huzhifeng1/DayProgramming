	    //append函数
			public static void append(String path, StringBuffer content)throws IOException {
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path),true));
				bw.write(content.toString() + "\r\n");
				bw.flush();
				bw.close();
			}
			
			
			 //输出到txt
			static void outputToTXT(List content,String path){
				for( int i = 0 ; i < content.size() ; i++ ){
					StringBuffer sb = new StringBuffer();
					StringBuffer str = sb.append(content.get(i));
					try {
						append(path, str);		//
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
