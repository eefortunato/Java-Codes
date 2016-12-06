/**
 * Node.java
 * Class that has the node values.
 * 
 *  @version   $Id: Node.java,v 1.0 2013/10/21 11:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */
public class Node {

	private Object value;
	private Node leftNode;
	private Node rightNode;
	
	/**
	 * Constructor for Node class
	 * @param value is an Object of any kind
	 */
	Node (Object value) {
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	/**
	 * Getter method for value of the node.
	 * @return the object
	 */
	public Object getValue() {
		return this.value;
	}
	
	/**
	 * Setter method for value of the node.
	 * @param value Object
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/**
	 * Getter method for left node.
	 * @return left node of current one.
	 */
	public Node getleftNode() {
		return this.leftNode;
	}
	
	/**
	 * Setter method for left node.
	 * @param node to set the left node.
	 */
	public void setLeftNode(Node node) {
		this.leftNode = node;
	}
	
	/**
	 * Getter method for right node.
	 * @return right node of current one.
	 */
	public Node getrightNode() {
		return this.rightNode;
	}
	
	/**
	 * Setter method for right node.
	 * @param node to set the right node.
	 */
	public void setRightNode(Node node) {
		this.leftNode = node;
	}
}

