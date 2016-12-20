		  //遍历HashMap
        Set<Entry<String, Integer>> sets = wordMap.entrySet();  
        for(Entry<String, Integer> entry : sets) {  
            System.out.print(entry.getKey() + "/");  
            System.out.println(entry.getValue());  
        }  
