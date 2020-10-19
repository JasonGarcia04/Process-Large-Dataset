package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class LargeDataSet {
	
	static Random rand = new Random();
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("src/lab4/Salary.txt");
		
		if(file.exists()) {
			System.out.println("This file exists");
		}
		else {
			System.out.println("File does not exist");
			
			file.createNewFile();
		
		}
		
		dataSet(file);
	}
	
	public static void dataSet(File file) throws FileNotFoundException {
		
		try(PrintWriter output = new PrintWriter(file)){
		
			for(int i = 0; i <= 9; i++) {
				output.println("FirstName0" + i + " LastName0" + i + " " +  getRankAndSalary());
			}
			
			for(int i = 10; i < 1000; i++) {
				output.println("FirstName" + i + " LastName" + i + " " +  getRankAndSalary());
			}
		}
		
	
	}
	
	public static String getRankAndSalary() {
		
		int rank = rand.nextInt(3);
		double assistantSalary = (50000 + Math.random() * 30000);
		double associateSalary = (60000 + Math.random() * 45000);
		double fullSalary = (70000 + Math.random() * 60000);
		
		String output = "";
		
		if(rank == 0) {
			output = "Assistant " + String.format("%5.2f", assistantSalary);
		}
		else if(rank == 1) {
			output = "Associate " + String.format("%5.2f",associateSalary);
		}
		else if(rank == 2) {
		
			output = "Full " + String.format("%-10.2f",fullSalary);
			
		}
		
		return output;
	}
	
	

}
