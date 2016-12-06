import java.util.Iterator;
import java.util.TreeSet;
/**
 * HpTreeSet.java
 * Class that wraps Tree class.
 * 
 *  @version   $Id: HpTreeSet.java,v 1.0 2013/10/21 11:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */
public class HpTreeSet extends TreeSet{

	Tree tree;
	/**
	 * Constructor for HpTreeSet
	 */
	HpTreeSet() {
		tree = new Tree();
	}
	/**
	 * Inserts object e into the tree set
	 */
	public boolean add(Object e) {
		return tree.add(e);
	}
	/**
	 * clears the tree set
	 */
    public void clear() {
    	tree.clear();
    }
    /**
     * checks if object e is present in the tree set
     */
    public boolean contains(Object e) {
    	return tree.contains(e);
    	
    }
    /**
     * checks if the tree set is empty
     */
    public boolean isEmpty() {
    	return tree.isEmpty();
    }
    /**
     * instantiates the iterator
     */
    public Iterator iterator() 
    {
        return new MyIterator();
    }
    /**
     * returns the size of the tree set
     */
    public int size() {
    	return tree.size();
    }
    /**
     * Iterator class
     * MyIterator.java
     * @author Pavan Kumar Pallerla
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
		 * @param h receives a hashtree
		 */
		public MyIterator(HpTreeSet t) {
            node = tree.getRoot();
            linkedListNode = new LinkedListNode(node.getValue());
    }

    
	/**
	 * This method returns true if the next element is present
	 * @return true if there is another element
	 */
	public boolean hasNext() {
		if (node.getleftNode() == null) {
			return false;
		}
		else if(node.getrightNode() == null){
			return false;
		}
		return true;
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
		
		if(null != currentParent.getleftNode()){
				linkedListNode.setNext(currentParent.getValue());
				currentParent = currentParent.getleftNode();
				if(null != currentParent){
					return currentParent;
				}
		}
		else if(null != currentParent.getrightNode()){
			linkedListNode.setNext(currentParent.getValue());
			currentParent = currentParent.getrightNode();
			if(null != currentParent){
				return currentParent;
			}
			linkedListNode.delete();
		}
		return null;
	}

//		@Override
		/**
		 * This method removes the current element
		 */
		public void remove() {

			}
		
	}
    
}
