package kwic.pf;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
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
					char[] chars = writer.toString().toCharArray();
					if (!containsNoise(writer.toString())) {
						for (int i = 0; i < chars.length; i++) {
							output_.write(chars[i]);
						}
						output_.write('\n');
					}
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
	
	private boolean containsNoise(String line) {
		
		if (line.startsWith(noiseWord)) {
			return true;
		}
		
		return false;
	}

}
