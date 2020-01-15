package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Program {
	

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);
		List<Products>list=new ArrayList<>();
		
		System.out.println("Type the path of the file:");
		String strPath=sc.nextLine();
		File sourceFile=new File(strPath);
		
		String sourceFolder= sourceFile.getParent();
		
		boolean success=new File(sourceFolder +"//out").mkdir();
		
		String targetFile=sourceFolder+"//out//Summary.csv";
		
		try(BufferedReader br=new BufferedReader(new FileReader(sourceFile))) {
			String productsCsv=br.readLine();
			
			while(productsCsv!=null) {
				String[]vect=productsCsv.split(",");
				String name=vect[0];
				double price=Double.parseDouble(vect[1]);
				int quantity=Integer.parseInt(vect[2]);
				
				list.add(new Products(name, price, quantity));
				productsCsv= br.readLine();
			}
			
			try(BufferedWriter bw=new BufferedWriter(new FileWriter(targetFile))){
				for(Products products:list) {
					bw.write(products.getName()+", "+String.format("%.2f", products.total()));
					bw.newLine();
					
					System.out.println(targetFile+"SUCESS!");
				}
				
				
			}
			catch(IOException e) {
				System.out.println("Writting error: "+ e.getMessage());
			}
			
			
		}
		catch(IOException e) {
			System.out.println("Reading error: "+e.getMessage());
		}
		
		
		sc.close();

	}

}
