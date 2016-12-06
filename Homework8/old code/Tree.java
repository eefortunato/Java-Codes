/**
 * LinkedList.java
 * This is the outer class LinkedList where we define the methods and
 * members needed for implementing a hashset.
 * 
 *  @version   $Id: LinkedList.java,v 1.0 2013/10/14 8:30pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

public class Tree {
	
	private Node root;
	private static int size;
	
	/**
	 * Default constructor
	 */
	public Tree() {
		size = 0;
	}
	
	/**
	 * This methoid returns the size of the list
	 * @return size the size of the list
	 */
	
	public int getSize() {
		return size;
	}
	
	/**
	 * This method returns the first element in the list
	 * @return head the first element
	 */
	public Node getRoot() {
		return root;
	}
	
	/**
	 * This method adds a new element to the list
	 * @param key receives the hashcode of the object
	 * @param value receives the object to add
	 */
	public void add(int key, Object value) {
		Node nodeToAdd = new Node(value);
		if(root==null){
			root=nodeToAdd;
			size++;
		}
		else if (!(this.contains(key))) {
			Node current = root;
			Node parent;
			while(!(this.contains(key))){
			parent=current;
			if(key < current.getKey()){
				current = current.getLeftNode();
				if(current == null){
					parent.getLeftNode();
					size++;
					return;
				}
			}
			else {
				current = current.getRightNode();
				if(current == null){
					parent.getRightNode();
					size++;
					return;
				}
			}
			}
		}
	}
	
	
	/**
	 * This method returns true if the objects is already in the list
	 * @param value receives the object
	 * @return true if the object exists
	 */
	public boolean contains(int key) {
		Node current = root;
		while (current.getKey() != key) {
			if (current.getKey() < key) {// implement equals and substitute with ==
				current = current.getLeftNode();
			} else {
				current = current.getRightNode();
			}
			if(current==null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method will move out all the object
	 */
	public void clear() {
		Node current = root;
		while (null != current && current != null) {
			
			head.setNext(current = current.getNext());
			if(null!=current){
			size--;
			}
		}
	}
	
	/**
	 * This method returns true if the list is empty
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

}
