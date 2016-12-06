
public class LinkedList {
	
	private LinkedListNode previousParent;
	private static int size;
	
	public LinkedList() {
		previousParent = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public LinkedListNode getPreviousParent() {
		return previousParent;
	}
	
	public void add(Object value) {
		LinkedListNode tmp = previousParent;
		previousParent = new LinkedListNode(value);
		previousParent.setNext(tmp);
		size++;
		}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

}
