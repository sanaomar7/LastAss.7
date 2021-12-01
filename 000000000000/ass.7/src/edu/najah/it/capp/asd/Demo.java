package edu.najah.it.capp.asd;


import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;




public class Demo {

	public static void main(String[] args) {
	
		Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");
		
		
		Protocol ssh = null ; Protocol ssh2 = null ; Protocol telnet = null  ;
		Protocol scp = null ; Protocol ftp  = null ; Protocol tftp = null ; Protocol tftp2 = null ; 
		try {
			ssh = Connection.getInstance(ConnectionType.SSH);
			ssh2 = Connection.getInstance(ConnectionType.SSH);
		    telnet = Connection.getInstance(ConnectionType.TELNET);
			scp = Connection.getInstance(ConnectionType.SCP);
			ftp = Connection.getInstance(ConnectionType.FTP);
			if(ssh == ssh2) {
				System.out.println(" ssh is equal to ssh2");
			}
			
		} catch (ProtocolException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			Logger.getInstance().logDebug("This is a debug message");
		}
		
		/////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		
		
	
		try {
			 
			ssh.send(" testing ssh ");
			telnet.send("Testing telnet ");
			scp.send("Testing scp");
		} catch (ProtocolException e) {
			
			System.out.println("---No connection---");
			Logger.getInstance().logDebug("This is a debug message");


		}finally {
			System.out.println(Connection.getCurrentConnections());
			Connection.release(ConnectionType.SSH);
			System.out.println(Connection.getCurrentConnections());
		}
		
		
		
		
		try {
			ftp = Connection.getInstance(ConnectionType.FTP);
			System.out.println(Connection.getCurrentConnections());
			
			
			ssh = Connection.getInstance(ConnectionType.SSH);
			ftp = Connection.getInstance(ConnectionType.FTP);
			ftp = Connection.getInstance(ConnectionType.FTP);
			
			ftp = Connection.getInstance(ConnectionType.FTP);
		} catch (ProtocolException e) {
			Logger.getInstance().logWarning("This is a warning message");

		}
		
		try {
			ftp.send("Testing FTP");
		} catch (ProtocolException e) {
			Logger.getInstance().logError("This is a error message");
		}
		
		
		///////////////////////////////////////////////
		
		
		
		
		try {
			tftp.send("test the TFTP ");
			tftp2.send("test the TFTP ");
			//ftp = Ftp.getInsatnce();
			///Connection.release(ConnectionType.TFTP);
			System.out.println(Connection.getCurrentConnections());//3
			if(ftp == null) {
				System.out.println("FTP is a null");
				Logger.getInstance().logError("This is a error message");
			} else {
				System.out.println("FTP is not a null");
				Logger.getInstance().logError("This is a error message");
			}
			ftp.send(" breaking the logic ");
			
		} catch (ProtocolException e) {
			Logger.getInstance().logDebug("This is a debug message");

		}
		finally {
			Logger.getInstance().logInfo("This is a info message"); 
		}
		

		
			
		
	}

}
