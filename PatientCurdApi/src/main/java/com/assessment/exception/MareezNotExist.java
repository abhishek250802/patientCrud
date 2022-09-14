package com.assessment.exception;

public class MareezNotExist extends RuntimeException {

  
    private static final long serialVersionUID = 1L;
    
    public MareezNotExist(String message) {
	super(message);
    }
   
}
