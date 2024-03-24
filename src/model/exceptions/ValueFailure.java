package model.exceptions;

public class ValueFailure extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValueFailure(String msg) {
		super(msg);
	}
}
