 //连接数据库
         Connection conn = null;
		 Statement stmt = null;
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8",
										       //数据库名					
"root", "password");
		 stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
		 //把数据放入表中
		 for(int i=0;i<education_noRepeat.size();i++){		
			 System.out.println(education_noRepeat.get(i));
			 String sql = "INSERT INTO education(education_noRepeat0) values ('"+education_noRepeat.get(i)+"')";
			 try {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			    
		 }
        try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}   
