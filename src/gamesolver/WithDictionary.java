package gamesolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class WithDictionary {
	
	protected List<String> readDictionary() throws IOException {
		
		String word;
		List<String> words = new ArrayList<String>();

		BufferedReader bufferedReader = new BufferedReader(
			new FileReader("C:\\Users\\User\\eclipse-workspace6\\gamesolver\\src\\gamesolver\\dict.txt"));
			
			while ((word = bufferedReader.readLine()) != null) {
				
			words.add(word);
			}
			
			bufferedReader.close();

		return words;

	}
}
