package util.ex;

public class FiledNotFoundExeception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FiledNotFoundExeception(String filedName) {
		System.err.println("Filed:"+ filedName + "Not Found");
	}
	

}
