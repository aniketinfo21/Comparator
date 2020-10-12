package com.comparator.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class txtUtil {
	
	public static ArrayList<String> getURI(String fileName) throws Exception
	{
		String path = System.getProperty("user.dir") + "\\txtData\\"+fileName+".txt";
		File file=new File(path);    
		FileReader fr=new FileReader(file);  
		BufferedReader br=new BufferedReader(fr);  
		ArrayList<String> al = new ArrayList<String>();
		String line;
		while((line=br.readLine())!=null)  
		{  
			al.add(line);
		}  
		fr.close();
		return al;
	}

}
