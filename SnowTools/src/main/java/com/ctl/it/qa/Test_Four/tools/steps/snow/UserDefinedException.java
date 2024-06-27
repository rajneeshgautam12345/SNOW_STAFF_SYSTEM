package com.ctl.it.qa.Test_Four.tools.steps.snow;

public class UserDefinedException extends Exception {
	// member variable to store our custom message
	String msg;

	UserDefinedException(String msg) {
		// passing the parameter to the super class constructor
//        super(msg);
//        this.msg=msg;
	}

	// overriding with our custom message
	@Override
	public String toString() {
		return msg;
	}
}
