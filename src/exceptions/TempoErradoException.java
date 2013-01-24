package exceptions;

public class TempoErradoException extends Exception {
 String message;
 public TempoErradoException(String string) {
	this.message=string;
}
 public String getMessage() {
	return message;
}
}
