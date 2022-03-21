import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
	 //String word;
	/*
	 * use hashmaps and other data structures and classes maybe
	 * to find all consecutive paries of words 
	 * for every word that appears in the text
	 * track how often a pair shows up for each word
	 * 
	 */
	static HashMap<String, String> words = new HashMap<String, String>();
	static ArrayList<String> n = new ArrayList<String>();
	
	
	public static void consecutiveWords(String word) {
		try {
			Scanner s = new Scanner(new File("ToKillAMockingbird.txt"));
			int count = 0;
			for(int i = 0; i < 11; i++) { //skips to text of the book
				s.nextLine();
			}
			
			while(s.hasNextLine() && count <= 50) {
				
				String currLine = s.nextLine();
				String[] split = currLine.split(" ");
				for(int j = 0; j < split.length-1; j++) {
					String temp = split[j];
					if(temp.substring(temp.length()-1).equals(".") ||
							temp.substring(temp.length()-1).equals(",")) {
						temp = temp.substring(0, temp.length()-1);
					}
					temp.toLowerCase();
					
					if(temp.equals(word)) {
						String copy = split[j+1];
						if(copy.substring(copy.length()-1).equals(".") ||
								copy.substring(copy.length()-1).equals(",")) {
							copy = copy.substring(0, copy.length()-1);
						}
						n.add(copy);
						words.put(word, copy);
					}
				}
				
				count++;
			}
			
			
			
		}catch(FileNotFoundException e) {
			System.out.println(e);
		} 
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "of";
		consecutiveWords(str);
		/*
		for (String name : words.keySet()) {
		    System.out.println(name);
		}*/
		
		for(int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
		
		//most frequent
		int maxC = 0;
		int currC = 0;
		String result = n.get(0);
		
		//use hash maps...
		
		/*
		try {
			Scanner s = new Scanner(new File("ToKillAMockingbird.txt"));
			int count = 0;
			//long total = 0;
			
			for(int i = 0; i < 11; i++) { //skips to text of the book
				s.nextLine();
			}
			
			HashMap<String, String> wordPair = new HashMap<String, String>();
			
			while(s.hasNextLine() && count <= 10) {
				
				String currLine = s.nextLine();
				String[] split = currLine.split(" ");
				//System.out.println(currLine);
				for(int i = 0; i < split.length; i++) {
					String word = split[i].trim();
					//currently
					
					if(word.substring(word.length()-1).equals(".") ||
							word.substring(word.length()-1).equals(",")) {
						word = word.substring(0, word.length()-1);
					}
					word.toLowerCase();
					System.out.println(word);
					
					consecutiveWords(word);
					
				}
				count++;
				
				for (String name : words.keySet()) {
				    System.out.println(name);
				}
			
			}
		}catch(FileNotFoundException e) {
			System.out.println(e);
		} */
	}
}
			



