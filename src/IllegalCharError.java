
public class IllegalCharError extends Error {
	
	IllegalCharError(Position posStart, Position posEnd, String details) {
		super(posStart, posEnd, "Illegal Character", details);
	}
	
}
