package org.atenea.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	private Logger logger;
	
	
	public void startLogger(Object obj){
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	
}
