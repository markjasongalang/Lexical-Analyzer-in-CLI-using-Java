import java.util.ArrayList;

public class Basic {
	
	private String fn;
	private String text;
	private ArrayList<String> tokens;
	private Error err;
	
	/***
	 * generates the tokens based on the input and
	 * the error if an invalid character is present
	 * @param fn
	 * @param text
	 * @return
	 */
	public Basic run(String fn, String text) {
		this.fn = fn;
		this.text = text;
		
		Lexer l = new Lexer(fn, text);
		tokens = l.makeTokens();
		err = l.getError();
		
		return this;
	}
	
	/***
	 * getter method for the tokens
	 * @return
	 */
	public ArrayList<String> getResult() {
		return tokens;
	}
	
	/***
	 * getter method for the error
	 * @return
	 */
	public Error getError() {
		return err;
	}
}
