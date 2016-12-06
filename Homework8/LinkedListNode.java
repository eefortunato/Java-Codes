/**
 * Node.java
 * This is the class Node where we define the methods and
 * members for traveling inside the list.
 * 
 *  @version   $Id: Node.java,v 1.0 2013/10/14 8:30pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

public class LinkedListNode {
	private Object value;
	private LinkedListNode previousNode;
	private static LinkedListNode endingNode;
	
	/**
	 * This is the constructor, it will create new nodes
	 * @param key receives the hashcode of the object
	 * @param value receives the object
	 */
	LinkedListNode (Object value) {
		this.value = value;
		endingNode = this;
	}
	
	/**
	 * This method gets the node address
	 * @return value the address of the node
	 */
	public Object getValue() {
		return this.value;
	}
	
	/**
	 * This is the setter method for value
	 * @param value receives the value of the object
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/**
	 * This method returns the next node
	 * @return next the next node
	 */
	public LinkedListNode getPreviousNode() {
		return previousNode;
	}
	
	/**
	 * This method returns the next node
	 * @return next the next node
	 */
	public void setPreviousNode(Object value) {
		this.previousNode.setValue(value);
	}
	/**
	 * This method sets the value of the next node
	 * @param next receives the value of the next node 
	 */
	public void setNext(Object value) {
		LinkedListNode newNode = new LinkedListNode(value);
		endingNode = newNode;
		endingNode.previousNode = this;
	}
	
		
	public void delete() {
		if (previousNode != null) {
			 endingNode = endingNode.previousNode;
			}
		
	}
}

