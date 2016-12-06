/**
 * HpHashSet.java
 * This is the class HpHashSet where we define and implement our HashSet.
 * 
 *  @version   $Id: Node.java,v 1.0 2013/10/14 8:30pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

import java.util.Iterator;
import java.util.TreeSet;


@SuppressWarnings("rawtypes")
public class HpTreeSet extends TreeSet implements Iterable{

	Tree tree;
	
	
	/**
	 * Default constructor
	 */
	public HpTreeSet() {
		tree = new Tree();
	}
	
	/**
	 * This methods adds a new object to the set
	 * @param value receives the value of the object
	 */
	public boolean add(Object value) {
		list.add(value.hashCode(), value);
		return true;
	}
	
	/**
	 * This method removes an object from the set
	 * @param value receives the object to remove
	 */
	public boolean remove(Object value) {
		list.delete(value.hashCode());
		return true;
	}
	
	/**
	 * This method returns true if the object already exists
	 * @param value receives the object to search
	 */
	public boolean contains(Object value) {
		return list.contains(value);
	}
	
	/**
	 * This method returns the first node
	 * @return head the first element
	 */
	public Node getRoot() {
		return ourTree.getRoot();
	}
	
	/**
	 * This method returns the size of the hashset
	 * @return size the size of the hashset
	 */
	public int size() {
		return ourTree.getSize();
		}
	
	/**
	 * This methods moves out the objects from the hashset
	 */
	public void clear() {
		ourTree.clear();
	}
	
	/**
	 * This method returns true if the hashset is empty
	 * @return true if the hashset is empty
	 */
	public boolean isEmpty() {
		return ourTree.isEmpty();
	}
	
	/**
	 * This method returns an iterator
	 */
	public Iterator iterator() 
    {
        return new MyIterator ();
    }
	
	/**
	 * This class implements Iterator
	 * @author Pavan Kumar Pallerla
	 * @author Eric Fortunato
	 *
	 */
	class MyIterator implements Iterator {
		
		private Node node;
		private LinkedListNode linkedListNode;
		
		/**
		 * Default constructor
		 */
		public MyIterator() {
			node = tree.getRoot();
			linkedListNode = new LinkedListNode(node.getValue());
		}
		
		/**
		 * This constructor creates Iterator
		 * @param h receives a hashset
		 */
		public MyIterator(HpTreeSet t) {
			node = t.getRoot();
			linkedListNode = new LinkedListNode(node.getValue());
		}

		@Override
		/**
		 * This method returns true if the next element is present
		 * @return true if there is another element
		 */
		public boolean hasNext() {
			if (node.getLeftNode() != null) {
				return true;
			}
			else if(node.getRightNode() != null){
				return true;
			}
			return false;
		}

		/**
		 * This method returns the next node
		 * @return next the next node
		 */
		public Node next() {
			 
			MyIterator nodeIterator = new MyIterator();
			if(null != node){
				node = nodeIterator.next(node);
				return node;
			}
			return null;
		}
		
		public Node next(Node currentParent){
			
			if(null != currentParent.getLeftNode()){
					linkedListNode.setNext(currentParent.getValue());
					currentParent = currentParent.getLeftNode();
					if(null != currentParent){
						return currentParent;
					}
			}
			else if(null != currentParent.getRightNode()){
				linkedListNode.setNext(currentParent.getValue());
				currentParent = currentParent.getRightNode();
				if(null != currentParent){
					return currentParent;
				}
				linkedListNode.delete();
			}
			return null;
		}		
			
		

		@Override
		/**
		 * This method removes the current element
		 */
		public void remove() {
			Node previous = tree.getRoot();
			while (null != previous && previous != (node)) {
			//previous = previous.getNext();
			if (previous == node ) {
			break;
			} else if (previous.getNext() == (node)) {
			previous.setNext(node.getNext());
			}
			previous = previous.getNext();
			}
			node = previous.getNext();
			ourTree.size--;
			}
		
	}
	
}
