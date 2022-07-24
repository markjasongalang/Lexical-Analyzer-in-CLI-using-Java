import java.util.ArrayList;

public class Lexer {
	
	// private fields
	private String fn;
	private String text;
	private Error err;
	private Position pos;
	private char currentChar;
	
	// public fields (constants)
	public static final String DIGITS = "0123456789";
	public static final String TT_INT = "INT";
	public static final String TT_FLOAT = "FLOAT";
	public static final String TT_PLUS = "PLUS";
	public static final String TT_MINUS = "MINUS";
	public static final String TT_MUL = "MUL";
	public static final String TT_DIV = "DIV";
	public static final String TT_LPAREN = "LPAREN";
	public static final String TT_RPAREN = "RPAREN";
	
	Lexer(String fn, String text) {
		this.fn = fn;
		this.text = text;
		pos = new Position(-1, 0, -1, fn, text);
		currentChar = '?';
		advance();
	}
	
	/***
	 * iterates through every character in the string
	 */
	private void advance() {
		pos.advance(currentChar);
		if (pos.getIdx() < text.length()) {
			currentChar = text.charAt(pos.getIdx());
		} else {
			currentChar = '?';
		}
	}
	
	/***
	 * generates the tokens based on the string input and
	 * an error if invalid characters are present
	 * @return
	 */
	public ArrayList<String> makeTokens() {
		
		ArrayList<String> tokens = new ArrayList<>();
		
		while (currentChar != '?') {
			
			if (isDigit(currentChar)) {
				
				tokens.add(String.valueOf(makeNumber()));
			
			} else {
				
				switch (currentChar) {
					
					case ' ': case '\t':
						advance();
						break;
					
					case '+':
						tokens.add(String.valueOf(new Token(TT_PLUS)));
						advance();
						break;
					
					case '-':
						tokens.add(String.valueOf(new Token(TT_MINUS)));
						advance();
						break;
					
					case '*':
						tokens.add(String.valueOf(new Token(TT_MUL)));
						advance();
						break;
					
					case '/':
						tokens.add(String.valueOf(new Token(TT_DIV)));
						advance();
						break;
					
					case '(':
						tokens.add(String.valueOf(new Token(TT_LPAREN)));
						advance();
						break;
					
					case ')':
						tokens.add(String.valueOf(new Token(TT_RPAREN)));
						advance();
						break;
					
					default:
						Position posStart = pos.copy();
						char ch = currentChar;
						advance();
						err = new IllegalCharError(posStart, pos, "'" + ch + "'");
						return null;
				}
				
			}
			
		}
		
		return tokens;
	}
	
	/***
	 * handles the tokenization of integer and float values
	 * @return
	 */
	private Token makeNumber() {
		
		String numStr = "";
		int dotCount = 0;
		
		while (currentChar != '?' && (isDigit(currentChar) || currentChar == '.')) {
			if (currentChar == '.') {
				if (dotCount == 1) {
					break;
				}
				dotCount++;
				numStr += ".";
			} else {
				numStr += currentChar;
			}
			advance();
		}
		
		if (dotCount == 0) {
			return new Token(TT_INT, Integer.parseInt(numStr));
		} else {
			return new Token(TT_FLOAT, Float.parseFloat(numStr));
		}
		
	}
	
	private boolean isDigit(char ch) {
		return DIGITS.contains(String.valueOf(ch));
	}
	
	/***
	 * getter method for the error instance
	 * @return
	 */
	public Error getError() {
		return err;
	}
}
