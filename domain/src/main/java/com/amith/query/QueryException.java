package com.amith.query;

/**
 * 查询条件异常
 * 
 * @author amith
 * 
 */
public class QueryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QueryException() {
		super();
	}

	public QueryException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryException(String message) {
		super(message);
	}

	public QueryException(Throwable cause) {
		super(cause);
	}

}
