
public class Tree {
	
	private Node root;
	private static int size = 0;
	
	public boolean add(Object e) {
		if (null != e && !e.toString().isEmpty()) {
			if (!contains(e)) {
				Node newNode = new Node(e);
				if (null != root) {
					Node currentNode = root;
					int i;
					do {
						i = e.toString().compareTo(currentNode.getValue().toString());
						if (i > 0) {
							currentNode = currentNode.getrightNode();
						} else if (i < 0){
							currentNode = currentNode.getleftNode();
						}
						
					} while (i != 0 && null != currentNode);
					if (null == currentNode) {
						currentNode.setValue(newNode);
					}
				} else {
					root = newNode;
				}
			}
			size++;
			return true;
		} else {
			return false;
		}
	}
    public void clear() {
    	root = null;
    	size = 0;
    }
    public boolean contains(Object e) {
    	if (null != e && !e.toString().isEmpty()) {
    		return contains(root, e);
    	} else {
    		return false;
    	}
    	
    }
    public boolean isEmpty() {
    	boolean empty;
    	if (null == root) {
    		empty = true;
    	} else {
    		empty = false;
    	}
    	return empty;
    }
    public int size() {
    	return size;
    }
    
    boolean contains(Node n, Object e) {
    	if (null != n) {
    		if (n.getValue() != e && !(n.getValue().equals(e))) {
        		contains(n.getleftNode(), e);
        		contains(n.getrightNode(), e);
        	} else {
        		return true;
        	}
    	}
    	return false;
    }
    
    public Node getRoot() {
    	return root;
    }
}
