//this class holds a string. That way all logs can have this object and I can change the string text for all
//string doesn't work because they are immutable.

public class Log {

	private String logText;
	
	public Log() {
		logText = "Game begins";
	}
	
	public void updateLog(String message) {
		logText = logText + "\n" + message;
	}
	
	public String getLogText() {
		return logText;
	}
}
