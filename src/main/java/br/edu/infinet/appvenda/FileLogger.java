package br.edu.infinet.appvenda;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class FileLogger {

	private static final Logger logger = Logger.getLogger(FileLogger.class.getName());
	
	private static void Init(String file) throws SecurityException, IOException {
		FileHandler fileHandler = new FileHandler(file);
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
	}
	
	public static void LogException(String msg) throws SecurityException, IOException {
		String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Init("file/log_" + data + ".txt");
				
		logger.log(Level.SEVERE, msg);
	}
}
