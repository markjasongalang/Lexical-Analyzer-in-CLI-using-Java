
public class Position {
	
	private int idx;
	private int ln;
	private int col;
	private String fn;
	private String ftxt;
	
	Position(int idx, int ln, int col, String fn, String ftxt) {
		this.idx = idx;
		this.ln = ln;
		this.col = col;
		this.fn = fn;
		this.ftxt = ftxt;
	}
	
	/***
	 * getter method for the idx
	 * @return
	 */
	public int getIdx() {
		return idx;
	}
	
	/***
	 * getter method for the fn
	 * @return
	 */
	public String getFn() {
		return fn;
	}
	
	/***
	 * getter method for the ln
	 * @return
	 */
	public int getLn() {
		return ln;
	}
	
	/***
	 * increments the value of idx and col
	 * @param currentChar
	 */
	public void advance(char currentChar) {
		idx++;
		col++;
		
		if (currentChar == '\n') {
			ln++;
			col = 0;
		}
	}
	
	/***
	 * creates a new Position instance based on
	 * the fields of the current instance
	 * @return
	 */
	public Position copy() {
		return new Position(idx, ln, col, fn, ftxt);
	}
}
