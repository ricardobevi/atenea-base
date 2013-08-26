package org.squadra.atenea.base;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;

import org.apache.log4j.Layout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.LogLog;


/**
 * RollingFileAppender performs poorly when rolling over the log files. 
 *  
 *  log4j.xml configuration example:
 *  
 * 	<appender name="file" class="ar.com.redmondsoftware.commons.util.RedmondRollingFileAppender">
 *		<param name="file" value="logfile.start.log" />
 *		<param name="MaxFileSize" value="50MB"/>
 *   	<param name="append" value="false"/>
 *    	<param name="bufferedIO" value="true"/>
 *		<layout class="org.apache.log4j.PatternLayout">
 *			<param name="ConversionPattern" value="%d [%-5p] [%-25t] %m%n" />
 * 		</layout>
 * </appender>
 *
 */

public class AteneaRollingFileAppender extends RollingFileAppender {


	private int rolloverSeq;
	private String originalFileName;

	public AteneaRollingFileAppender() {
		super();
		initialize();
	}

	AteneaRollingFileAppender(Layout layout, String filename, boolean append)
			throws IOException {
		super(layout, filename, append);
		initialize();
	}

	public AteneaRollingFileAppender(Layout layout, String filename)
			throws IOException {
		super(layout, filename);
		initialize();
	}

	private void initialize() {
		originalFileName = this.fileName;
		
		rolloverSeq = this.readLastFileId(0);
	}

	@Override 
	public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException {
		if (StringUtil.isNullOrEmpty(originalFileName)) {
			this.originalFileName = fileName;
			this.rolloverSeq = this.readLastFileId(0);
			writeLastFileId(rolloverSeq);
			fileName = getNewFileName();
		}
		super.setFile(fileName, append, bufferedIO, bufferSize);
	}
	
	@Override
	public void rollOver() {
		rolloverSeq = ((rolloverSeq + 1) % this.getMaxBackupIndex());
		
		writeLastFileId(rolloverSeq);
		
		String newFileName = this.getNewFileName();

		this.closeFile(); 

		try {
			this.setFile(newFileName, false, bufferedIO, bufferSize);
		} catch (IOException e) {
			if (e instanceof InterruptedIOException) {
				Thread.currentThread().interrupt();
			}
			LogLog.error("setFile(" + fileName + ", false) call failed.", e);
		}
	}
	
	private String getNewFileName() {
		String fileNameWithoutExt = this.getFileNameWithoutExtension();
		String fileExt = this.getFileExtension();
		
		return String.format("%s%04d.%s", fileNameWithoutExt, rolloverSeq, fileExt);
	}
	
	private String getFileNameWithoutExtension() {
		int extensionIdx = originalFileName.lastIndexOf('.');
		return originalFileName.substring(0, extensionIdx);
	}
	
	private String getFileExtension() {
		int extensionIdx = originalFileName.lastIndexOf('.');
		return originalFileName.substring(extensionIdx + 1, originalFileName.length());
	}
	
	private String getFileNameLastLog() {
		return String.format("%s.last", this.getFileNameWithoutExtension());
	}
	
	
	private int readLastFileId(int defaultStartSeq) {
		int rolloverSeqInitial;
		
		// Getting the latest ID if exists in log.last...
		try {
			InputStreamReader lastFileReader = new InputStreamReader(new FileInputStream(this.getFileNameLastLog()), "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(lastFileReader);
			String fileLastInfo = bufferedReader.readLine();
			rolloverSeqInitial = (NumberUtil.toInt(fileLastInfo) + 1) % this.getMaxBackupIndex(); 
			lastFileReader.close();
		} catch (Exception e) {
			rolloverSeqInitial = defaultStartSeq;
		}
		
		return rolloverSeqInitial;
	}
	
	private void writeLastFileId(int rolloverSeqCurrent) {
		// Getting the latest ID if exists in log.last...
		try {
			OutputStreamWriter lastFileWriter = new OutputStreamWriter(new FileOutputStream(this.getFileNameLastLog()), "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(lastFileWriter);
			bufferedWriter.write(Integer.toString(rolloverSeqCurrent));
			bufferedWriter.flush();
			lastFileWriter.close();
		} catch (Exception e) {
		}
	}

}
