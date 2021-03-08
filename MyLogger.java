package application;

import java.io.File;

///singleton logger

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	private static MyLogger instance;
    public Logger logger = Logger.getLogger("MyLog");  
    public FileHandler fh;
   
	
	
	private MyLogger() {
	    try {  

	        // This block configure the logger with handler and formatter
	    	String p = new File("MyLogFile.log").getAbsolutePath();
	        fh = new FileHandler(p);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  
	        logger.setUseParentHandlers(false);
	        
	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  

		
	}
	
	
	public static MyLogger GetInstance() {
		if(instance == null )
			instance = new MyLogger();
		return instance;
	}
	
}
