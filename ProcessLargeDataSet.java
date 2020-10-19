package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessLargeDataSet {


	
	public static void main(String[] args) throws IOException {
		
		File file = new File("src/lab4/Salary.txt");
		
		if(file.exists()) {
			System.out.println("This file exists");
		}
		else {
			System.out.println("File does not exist");
			
			file.createNewFile();
		
		}
		
		
		ArrayList<Double> assistant = new ArrayList<>();
		ArrayList<Double> associate = new ArrayList<>();
		ArrayList<Double> full = new ArrayList<>();
		
		
		readData(assistant, associate, full, file);
		
		
		System.out.printf("%s %30s %30s", "Rank", "Total Salary", "Average Salary\n");
		System.out.println("------------------------------------------------------------------");
		System.out.printf("%s %23.2f %27.2f\n", "Assistant:",calculateTotal(assistant), (calculateTotal(assistant)/ assistant.size()));
		System.out.printf("%s %24.2f %27.2f\n", "Associate", calculateTotal(associate),(calculateTotal(associate)/ associate.size()));
		System.out.printf("%s %28.2f %27.2f\n", "Full:", calculateTotal(full),(calculateTotal(full)/ full.size()));
		
	}
	
	public static void readData(ArrayList<Double> assistant, ArrayList<Double> associate, ArrayList<Double> full, File file) throws FileNotFoundException {
		
		try(Scanner input = new Scanner(file)) {
			while(input.hasNext()) {
				String[] rank = input.nextLine().split(" ");
				
				if(rank[2].equals("Assistant")) {
					assistant.add(Double.parseDouble(rank[3]));
				}
				else if(rank[2].equals("Associate")) {
					associate.add(Double.parseDouble(rank[3]));
				}
				else if(rank[2].equals("Full")) {
					full.add(Double.parseDouble(rank[3]));
				}
	
			}
		}
	}
	
	public static double calculateTotal(ArrayList<Double> ranks) throws ArrayIndexOutOfBoundsException {
		
		double total = 0;
		
		for(int i = 0; i < ranks.size(); i++) {
			total += ranks.get(i);
		}
		return total;
	}
	
	

}
