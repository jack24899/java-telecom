/**
 * 
 */
package p3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Jack Male - 40325609
 * SMS class which represents an sms message object, extending message superclass
 */
public class SmsMessage extends Message {
	
	private int messageId;
	private long destinationAddress, originatingAddress;
	private LocalDateTime timeStamp;
	private ValidityPeriod validityPeriod;
	private String messageBody;
	private boolean confidential;
	
	
	
	
	/**
	 * Default constructor for testing purposes
	 */
	public SmsMessage() {
	}
	
	/**
	 * Constructor with args 
	 * @param messageId
	 * @param destinationAddress
	 * @param originatingAddress
	 * @param timeStamp
	 * @param validityPeriod
	 * @param messageBody
	 * @param confidential
	 */
	public SmsMessage(int messageId, long destinationAddress, long originatingAddress, LocalDateTime timeStamp,
			ValidityPeriod validityPeriod, String messageBody, boolean confidential) {
		super();
		this.messageId = messageId;
		this.destinationAddress = destinationAddress;
		this.originatingAddress = originatingAddress;
		this.timeStamp = timeStamp;
		this.validityPeriod = validityPeriod;
		this.messageBody = messageBody;
		this.confidential = confidential;
	}
	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	/**
	 * @return the destinationAddress
	 */
	public long getDestinationAddress() {
		return destinationAddress;
	}
	/**
	 * @param destinationAddress the destinationAddress to set
	 */
	public void setDestinationAddress(long destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	/**
	 * @return the originatingAddress
	 */
	public long getOriginatingAddress() {
		return originatingAddress;
	}
	/**
	 * @param originatingAddress the originatingAddress to set
	 */
	public void setOriginatingAddress(long originatingAddress) {
		this.originatingAddress = originatingAddress;
	}
	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the validityPeriod
	 */
	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}
	/**
	 * @param validityPeriod the validityPeriod to set
	 */
	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}
	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	/**
	 * @return the confidential
	 */
	public boolean isConfidential() {
		return confidential;
	}
	/**
	 * @param confidential the confidential to set
	 */
	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}
	
	/**
	 * Overridden method to display a messages details
	 */
	@Override
	public void displayContent() {
		System.out.println("-".repeat(50));
		System.out.println("\033[1mMessage ID: \033[0m" + messageId);
		System.out.print("\033[1mFrom: +\033[0m" + destinationAddress);
		System.out.print(" | \033[1mTo: +\033[0m" + originatingAddress +"\n");
		
		//formatting date correctly for print
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.print("\033[1mTimeStamp: \033[0m" + timeStamp.format(formatter));
		
		// if statement to output validity period enum as a number of hours
		if (validityPeriod == ValidityPeriod.FULL_DAY) {
			System.out.print(" | \033[1mValidity: \033[0m 24 hours \n");
		} else if (validityPeriod == ValidityPeriod.HALF_DAY) {
			System.out.print(" | \033[1mValidity: \033[0m 12 hours \n");
		} else if (validityPeriod == ValidityPeriod.TWO_DAYS) {
			System.out.print(" | \033[1mValidity: \033[0m 48 hours \n");
		}
		
		// if statement to check if message is confidential, and if it is print a padlock beside message body
		if (confidential) {
			System.out.println("\033[1mMessage: \033[0m" + "\uD83D\uDD10 " + messageBody);
		} else {
			System.out.println("\033[1mMessage: \033[0m" + messageBody);
		}
		
		System.out.println("-".repeat(50));
		
	}
	
	/**
	 * Overridden method from super class to return message details as a string representation
	 */
	@Override
	public String messageToText() {
		
		return messageId + ",+" + destinationAddress + ",+" + originatingAddress + "," + messageBody;
	}
	
	
	
	
	
	

}
