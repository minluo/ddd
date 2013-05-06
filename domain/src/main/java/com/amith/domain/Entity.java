package com.amith.domain;

import java.io.Serializable;

/**
 * 领域实体接口，以便于统一处理系统中的实体等。
 * 
 * @author amith
 * 
 */
public interface Entity extends Serializable {

	/**
	 * 实体唯一标识
	 * @return 实体ID
	 */
	Serializable getId();

}
