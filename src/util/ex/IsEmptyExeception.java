package util.ex;

public class IsEmptyExeception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IsEmptyExeception(String content) {
		System.err.println(content + " is empty");
	}

}
