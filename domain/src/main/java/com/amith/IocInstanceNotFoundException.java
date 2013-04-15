package com.amith;

/**
 * Ioc实例提供者未找到实例异常
 * @author amith
 *
 */
public class IocInstanceNotFoundException extends IocException {

	private static final long serialVersionUID = 7146523722399383542L;

	public IocInstanceNotFoundException() {
	}

	public IocInstanceNotFoundException(String message) {
		super(message);
	}

	public IocInstanceNotFoundException(Throwable cause) {
		super(cause);
	}

	public IocInstanceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
