package kwic.pf;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoiseFilter extends Filter {
	
	private String noiseWord;

	public NoiseFilter(Pipe input, Pipe output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void transform() {
		CharArrayWriter writer = new CharArrayWriter();
		try {
			FileInputStream fileInputStream = new FileInputStream(KWIC.noiseFile);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			noiseWord = bufferedReader.readLine();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			int ch;
			
			while ((ch = input_.read()) != -1) {
				if ((char)ch == '\n') {
					char[] filteredChars = filterNoise(writer.toString()).toCharArray();
					for (int i = 0; i < filteredChars.length; i++) {
						output_.write(filteredChars[i]);
					}
					output_.write('\n');
					writer.reset();
				} else {
					writer.write(ch);
				}
			}
			
			// terminate the last line
			output_.write('\n');
			
			// close the pipe
		    output_.closeWriter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private String filterNoise(String line) {
		String[] words = line.split("\\s+");
		StringBuffer ret = new StringBuffer();
		
		for (int i = 0; i < words.length; i++) {
			if (!words[i].startsWith(noiseWord)) {
				ret.append(words[i]);
				if (i < words.length - 1) {
					ret.append(' ');
				}
			}
		}
		
		return ret.toString();
	}

}
