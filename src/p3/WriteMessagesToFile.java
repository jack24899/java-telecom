/**
 * 
 */
package p3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Jack Male - 40325609
 * Class to write messages to file using a seperate thread
 */
public class WriteMessagesToFile implements Runnable {
	private List<SmsMessage> smsMessages = new ArrayList<SmsMessage>();
	
	// constructor in order to properly access sms message array list
	public WriteMessagesToFile(List<SmsMessage> smsMessages) {
		this.smsMessages = smsMessages;
	}

	/**
	 * Overridden run method for thread
	 */
	@Override
	public void run() {
		writeAllSmsToFile();
		
	}
	
	
	/**
	 * Method for writing all sms messages to file, uses message to text method for output formatting.
	 */
	public void writeAllSmsToFile() {
		String fileName = "message_sent.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			bw.write("MessageID,DestinationAddress,OriginatingAddress,MessageBody");
			bw.newLine();
			if (!smsMessages.isEmpty()) {
				for (SmsMessage smsMessage : smsMessages) {
					bw.write(smsMessage.messageToText());
					bw.newLine();
				}
			}
			
		} catch (IOException e) {
			System.out.println("There was an error outputting data to: " + fileName);
			e.printStackTrace();
		}
	}

}
