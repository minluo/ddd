package com.amith;

/**
 * 未注册实例提供者异常
 * @author amith
 *
 */
public class InstanceProviderNotRegisterException extends IocException {

	private static final long serialVersionUID = -2095402271828025788L;

	public InstanceProviderNotRegisterException() {
	}

	public InstanceProviderNotRegisterException(String message) {
		super(message);
	}

	public InstanceProviderNotRegisterException(Throwable cause) {
		super(cause);
	}
	
	public InstanceProviderNotRegisterException(String message, Throwable cause) {
		super(message, cause);
	}
}
