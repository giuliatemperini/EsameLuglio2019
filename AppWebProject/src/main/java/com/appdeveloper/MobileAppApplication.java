package com.appdeveloper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.controller.Element;
import com.app.service.DownloadFile;

@SpringBootApplication
public class MobileAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppApplication.class, args);
		
		DownloadFile.JsonDecode("http://data.europa.eu/euodp/data/api/3/action/package_show?id=yGVKnIzbkC2ZHpT6jQouDg");
		
		
		
		
		int i=0;		
		List<List<String>> records = new ArrayList<>();
		
		Vector<Element> v=new Vector<Element>();
				
		try (BufferedReader br = new BufferedReader(new FileReader("dataset.csv"))) {
			
			String line;
			
			while ((line = br.readLine()) != null && i<5000) {
				if(i!=0) {
				String[] values = line.split(",");
				//System.out.println(values.length);
				
				if (values[6].isEmpty())					
				{ 
					values[6]="0";		 
				}	
				
				records.add(Arrays.asList(values));									
				if (values.length==8)
				{
				v.add(new Element(values[0], Integer.parseInt(values[1].substring(1, values[1].length()-1)), values[2].substring(1, values[2].length()-1), 
						values[3].substring(1, values[3].length()-1), values[4].substring(1, values[4].length()-1),
						values[5].substring(1, values[5].length()-1),
						Float.parseFloat(values[6]),
					values[7].substring(1, values[7].length()-1), null));				
				}
				
				if (values.length==9)
				{
				v.add(new Element(values[0], Integer.parseInt(values[1].substring(1, values[1].length()-1)), values[2].substring(1, values[2].length()-1), 
						values[3].substring(1, values[3].length()-1), values[4].substring(1, values[4].length()-1),
						values[5].substring(1, values[5].length()-1),
						Float.parseFloat(values[6]),
					values[7].substring(1, values[7].length()-1), values[8].substring(1, values[8].length()-1)));
				}				
				System.out.println(" " +i);
				}				
				i++;				
			}
			
			System.out.println(v.get(81).toString());
			br.close();
			
			
		} catch (IOException j) {
			j.printStackTrace();
			return;
		}
		
		
	}

}
