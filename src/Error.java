
public class Error {
	
	private Position posStart;
	private Position posEnd;
	private String errorName;
	private String details;
	
	Error(Position posStart, Position posEnd, String errorName, String details) {
		this.posStart = posStart;
		this.posEnd = posEnd;
		this.errorName = errorName;
		this.details = details;
	}
	
	/***
	 * returns the format specified if an
	 * error instance is displayed
	 */
	public String toString() {
		String result = errorName + ": " + details + "\n";
		result += "File " + posStart.getFn() + ", line " + (posStart.getLn() + 1);
		return result;
	}
	
}
