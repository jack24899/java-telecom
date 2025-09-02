/**
 * 
 */
package p3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Jack Male - 40325609
 * Main start point for the message server application. The file is read from here, as well as displaying all messages, and sending all messages.
 */
public class MessageServer {
	
	// setting up array list and reading analysis variables
	public static List<SmsMessage> smsMessages = new ArrayList<SmsMessage>();
	private static int attemptedReads = 0;
	private static int succesfullReads = 0;

	/**
	 * main method - starting point for application
	 * @param args
	 */
	public static void main(String[] args) {
		readMessageData();
		displayAllContent();
		//instantiating write to file class, then creating a new thread with this as the parameter
		WriteMessagesToFile writeMessages = new WriteMessagesToFile(smsMessages);
		Thread t = new Thread(writeMessages);
		t.start();
		System.out.println("Data has been written to file sucesfully.");
		System.out.println();
		System.out.println("Thank you for using this messaging server, Goodbye.");

	}
	
	/**
	 * Method for reading in message data. Various conditions to update variables, or skip a message based on time
	 */
	public static void readMessageData() {
		String fileName = "sms_message.csv";
		
		//try catch with resources for reading in the file
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			
			System.out.println("Message server started\n\n");
			System.out.println("Loading data...");
			String line;
			br.readLine();
			
			//While loop initialising line variable and checking if next line is null
			while((line = br.readLine()) != null) {
				String [] messageArray = line.split(",");
				
				// checking if number of fields is expected for a message, and reading if number is expected
				if (messageArray.length != 7) {
					throw new IllegalArgumentException();
				} else {
					attemptedReads++;
					ValidityPeriod validityPeriod;
					boolean confidential;
					int messageId = Integer.parseInt(messageArray[0].trim());
					long destinationAddress = Long.parseLong(messageArray[1].trim());
					long originatingAddress = Long.parseLong(messageArray[2].trim());
					LocalDateTime timeStamp = LocalDateTime.parse(messageArray[3].trim());
					int tempValidityPeriod = Integer.parseInt(messageArray[4].trim());
					
					// if statement to skip any messages beyond their validity 
					if (LocalDateTime.now().isAfter(timeStamp.plusHours(tempValidityPeriod)) ) {
						continue;
					}
					String messageBody = messageArray[5].trim();
					int tempConfidential = Integer.parseInt(messageArray[6].trim());
					
					// if statement to convert validity period to enum
					if (tempValidityPeriod == 12) {
						validityPeriod = ValidityPeriod.HALF_DAY;
					} else if (tempValidityPeriod == 24) {
						validityPeriod = ValidityPeriod.FULL_DAY;
					} else if (tempValidityPeriod == 48){
						validityPeriod = ValidityPeriod.TWO_DAYS;
					} else {
						throw new IllegalArgumentException();
					}
					
					// if statement to check if a message is encrypted and if it is decrypt it then assign the temp message body to the message body
					if (tempConfidential == 1) {
						String tempMessageBody = decrypt(messageBody);
						messageBody = tempMessageBody;
					}

					//if statement to convert confidential to boolean
					if (tempConfidential == 0) {
						confidential = false;
					} else if (tempConfidential == 1) {
						confidential = true;
					} else {
						throw new IllegalArgumentException();
					}
					
					//if statement to check if length of message body is over 20. If so, then a substring is taken to the 17th index 
					//then an elipsis is appended
					if(messageBody.length() > 20) {
						String messageBodyTruncate = messageBody.substring(0, 17);
						messageBody = messageBodyTruncate + "...";
					}
					
					//adding a new SmsMessage object to the array list
					smsMessages.add(new SmsMessage(messageId, destinationAddress, originatingAddress, timeStamp, validityPeriod, messageBody, confidential));
					succesfullReads++;
					System.out.println(line);
					
				}
			}
			System.out.println();
			System.out.println("Attempted to read messages: " + attemptedReads);
			System.out.println("Successful messages added: " + succesfullReads);
			
		} catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + " could not be found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was an error with the input from file: " + fileName);
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			//custom error message not included here as there is multiple illegal arg exceptions
			e.printStackTrace();
		}
	}

	/**
	 * Method to de-crypt message body
	 * @param data
	 * @return - de-crypted string
	 */
	public static String decrypt(String data) {
		StringBuilder decrypted = new StringBuilder();
		for (char c : data.toCharArray()) {
			if (Character.isLetter(c)) {
				decrypted.append((char)(c-1));
			} else {
				decrypted.append(c);
			}
		}
		return decrypted.toString();
	}
	
	/**
	 * method to display all messages
	 */
	
	public static void displayAllContent() {
		if (!smsMessages.isEmpty()) {
			for (SmsMessage smsMessage : smsMessages) {
				smsMessage.displayContent();
				System.out.println();
			}
		}
		
	}
	
	
	
	

}
