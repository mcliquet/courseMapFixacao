package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		System.out.println("Entre com o local do arquivo: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				//se na lista votes contém a key name, ele soma os valores daquele nome,
				//se não, ele mantém.
				if(votes.containsKey(name)) {
					//se achar a key com o mesmo nome, adicionar no contador votesSoFar
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				} 
				else {
					votes.put(name, count);
				}
				
				line = br.readLine();
			}
			
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
			
			
		} catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
