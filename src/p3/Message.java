/**
 * 
 */
package p3;

/**
 * Jack Male - 40325609
 * Abstract class which represents a message object. No variables exist here, as the extension of the other message types, the content is unknown.
 * Two abstract methods exist both of which will be overridden and implemented in the classes extending Message.
 */
public abstract class Message {
	
	
	/**
	 * Abstract method for displaying all content
	 */
	public abstract void displayContent();
	
	
	/**
	 * Abstract method to return a text representation of a message
	 * @return
	 */
	public abstract String messageToText();

}
