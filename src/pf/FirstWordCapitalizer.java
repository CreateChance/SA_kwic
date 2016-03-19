package kwic.pf;

import java.io.CharArrayWriter;

public class FirstWordCapitalizer extends Filter {

	public FirstWordCapitalizer(Pipe input, Pipe output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void transform() {
		int ch;
		CharArrayWriter writer = new CharArrayWriter();
		char[] line;
		
		try {
			while ((ch = input_.read()) != -1) {
				if (ch == '\n') {
					// this is a new line
					line = capitalizedFirstWord(writer.toString()).toCharArray();
					for (int i = 0; i < line.length; i++) {
						output_.write(line[i]);
					}
					
					// write the end of a line.
					output_.write('\n');
					writer.reset();
				} else {
					writer.write(ch);
				}
			}
			// write the last line.
			output_.write('\n');
			
			// close the pipe
		    output_.closeWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private String capitalizedFirstWord(String line) {
		String[] words = line.split("\\s+");
		char[] firstWord = words[0].toCharArray();
		StringBuffer ret = new StringBuffer();
		
		for (int i = 0; i < firstWord.length; i++) {
			if (firstWord[i] >= 'a' && firstWord[i] <= 'z') {
				firstWord[i] = (char)(firstWord[i] - 32);
			}
		}
		
		words[0] = new String(firstWord);
		
		for (int i = 0; i < words.length; i++) {
			ret.append(words[i]);
			
			if (i < words.length - 1) {
				ret.append(' ');
			}
		}
		
		return ret.toString();
	}

}
