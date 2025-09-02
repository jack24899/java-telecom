package messageSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

/**
 * Jack Male - 40325609
 * J unit test case to test the oop sections of the message system program
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import p3.SmsMessage;
import p3.ValidityPeriod;

class SmsMessageTest {
	
	int messageId;
	long destinationAddress, originatingAddress;
	LocalDateTime timeStamp;
	ValidityPeriod validityPeriod;
	String messageBody;
	boolean confidential;
	SmsMessage smsMessage;

	/**
	 * Before each set up
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		messageId = 1234;
		destinationAddress = 123456888;
		originatingAddress = 987654555;
		timeStamp = LocalDateTime.of(2007, 12, 03, 10, 15,30);
		validityPeriod = ValidityPeriod.FULL_DAY;
		messageBody = "hello";
		confidential = true;
		
		
	}

	/**
	 * default constructor test
	 */
	@Test
	void testDefaultConstructor() {
		smsMessage = new SmsMessage();
		assertNotNull(smsMessage);
	}

	/**
	 * Constructor with args test
	 */
	@Test
	void testConstructorWithArgs() {
		smsMessage = new SmsMessage(messageId, destinationAddress, originatingAddress, timeStamp, validityPeriod, messageBody, confidential);
		
		assertEquals(messageId, smsMessage.getMessageId());
		assertEquals(destinationAddress, smsMessage.getDestinationAddress());
		assertEquals(originatingAddress, smsMessage.getOriginatingAddress());
		assertEquals(timeStamp, smsMessage.getTimeStamp());
		assertEquals(validityPeriod, smsMessage.getValidityPeriod());
		assertEquals(messageBody, smsMessage.getMessageBody());
		assertEquals(confidential, smsMessage.isConfidential());
	}

	/**
	 * Testing getters and setters for message id
	 */
	@Test
	void testGetSetMessageId() {
		smsMessage = new SmsMessage();
		smsMessage.setMessageId(messageId);
		assertEquals(messageId, smsMessage.getMessageId());
	}

	/**
	 * Testing getters and setters for destination address
	 */
	@Test
	void testGetSetDestinationAddress() {
		smsMessage = new SmsMessage();
		smsMessage.setDestinationAddress(destinationAddress);
		assertEquals(destinationAddress, smsMessage.getDestinationAddress());
	}

	/**
	 * Testing getters and setters for originating address
	 */
	@Test
	void testGetSetOriginatingAddress() {
		smsMessage = new SmsMessage();
		smsMessage.setOriginatingAddress(originatingAddress);
		assertEquals(originatingAddress, smsMessage.getOriginatingAddress());
	}

	/**
	 * Testing getters and setters for time stamp
	 */
	@Test
	void testGetSetTimeStamp() {
		smsMessage = new SmsMessage();
		smsMessage.setTimeStamp(timeStamp);
		assertEquals(timeStamp, smsMessage.getTimeStamp());
	}

	/**
	 * Testing getters and setters for validity period
	 */
	@Test
	void testGetSetValidityPeriod() {
		smsMessage = new SmsMessage();
		smsMessage.setValidityPeriod(validityPeriod);
		assertEquals(validityPeriod, smsMessage.getValidityPeriod());
	}

	/**
	 * Testing getters and setters for message body
	 */
	@Test
	void testGetSetMessageBody() {
		smsMessage = new SmsMessage();
		smsMessage.setMessageBody(messageBody);
		assertEquals(messageBody, smsMessage.getMessageBody());
	}

	/**
	 * Testing getters and setters for confidential
	 */
	@Test
	void testIsSetConfidential() {
		smsMessage = new SmsMessage();
		smsMessage.setConfidential(confidential);
		assertEquals(confidential, smsMessage.isConfidential());
	}

}
