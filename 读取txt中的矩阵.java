				
				
				
				Scanner scanner = new Scanner(new File("D:/LaPose/theta9trainingset.txt"));
				Integer[][] value_9trainingset = new Integer[Length3][440];	//存放9个训练集数据
				int k=0;
				while(scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] columns = line.split(" ");
					int data[] = new int[columns.length];
					for(int i=0;i<columns.length;i++){
						data[i] = Integer.parseInt(columns[i]);
						value_9trainingset[k][i] = data[i] ;					
					}
					k++;
					
				}
				System.out.println(k);


				//value_9trainingset[k][i] 就是所求矩阵
