package exceptions;

public class HorasErradasException extends Exception {
	String Message;
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public HorasErradasException(String message) {
	    this.setMessage(message);
	}
}
