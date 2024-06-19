package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path));){
		
			Map<String, Integer> map = new TreeMap<>();
			
			String line = br.readLine();
			while(line != null) {
				String[]fields = line.split(",");
				String candidate = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				if(map.containsKey(candidate)) {
					int partialVote = map.get(candidate);
					map.put(candidate, votes + partialVote);
				}
				else {
					map.put(candidate, votes);
				}
				
				line = br.readLine();
			}
			for(String m : map.keySet()) {
				System.out.println(m + ": " + map.get(m));
			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
