package sa41.ca.uno;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class groupException extends Exception {

	public groupException() {
		super();
	}

	public groupException(String msg) {
		super(msg);
	}
	
}
