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

public class Node {

	private Object value;
	private Node left;
	private Node right;
	private LinkedList parent;
	
	/**
	 * This is the constructor, it will create new nodes
	 * @param key receives the hashcode of the object
	 * @param value receives the object
	 */
	Node (Object value) {
		this.value = value;
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
	public Node getLeftNode() {
		return left;
	}
	
	public Node getRightNode() {
		return right;
	}
	
	/**
	 * This method sets the value of the next node
	 * @param next receives the value of the next node 
	 */
	public void setNext(LinkedList parentToAdd) {
		this.parent = parentToAdd;
	}
	
	
}
