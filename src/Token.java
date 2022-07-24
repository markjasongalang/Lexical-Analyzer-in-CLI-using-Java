
public class Token {
	
	private String type;
	private int integerValue;
	private float floatingValue;
	
	Token(String type) {
		this.type = type;
		integerValue = -1;
		floatingValue = -1;
	}
	
	Token(String type, int integerValue) {
		this.type = type;
		this.integerValue = integerValue;
		floatingValue = -1;
	}
	
	Token(String type, float floatingValue) {
		this.type = type;
		this.floatingValue = floatingValue;
		integerValue = -1;
	}
	
	/***
	 * returns the format specified if a
	 * token instance is displayed
	 */
	public String toString() {
		if (integerValue != -1) {
			return type + ":" + String.valueOf(integerValue);
		} else if (floatingValue != -1) {
			return type + ":" + String.valueOf(floatingValue);
		}
		return type;
	}
	
}
