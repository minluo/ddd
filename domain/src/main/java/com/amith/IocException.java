package com.amith;

/**
 * Ioc异常。预防Ioc实例提供者的实现类出现异常
 * @author amith
 *
 */
public class IocException extends RuntimeException {

	private static final long serialVersionUID = -4194445450234809496L;

	public IocException() {
	}

	public IocException(String message) {
		super(message);
	}

	public IocException(Throwable cause) {
		super(cause);
	}

	public IocException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
