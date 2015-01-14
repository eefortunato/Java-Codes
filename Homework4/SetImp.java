import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetImp<E> implements  Set<E>{

	public ArrayList<E> setElements = new ArrayList<E>();
	
	public boolean add(E element){
		if(!this.contains(element) && !this.contains(null)){
			setElements.add(element);
			return true;
		}				
		return false;
	}
    
    /**
     * Remove an element from the Set.
     *
     * @param   element The element to remove.
     *
     * @return          true if element was in set before
     */
    public boolean remove(Object oElement){
    	if(!this.equals(null)){
    		if(this.contains(oElement)){
    			setElements.remove(oElement);
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Remove all elements from the set.
     */
    public void clear(){
    	setElements.clear();
    }
    
    /**
     * Determine if this set is a subset of another set.
     *
     * @param   set     The set to compare with.
     *
     * @return          true if this set is a subset of set.
     */
    public boolean isSubSet(Set<E> set){
    	if(this.size() < set.size()){
    		for(E sElements : this.setElements){
    			if(!set.contains(sElements)){
    				return false;
    			}
    		}
    		return true;
    	}    	
    	return false;
    }
    
    /**
     * Determine if this set is a superset of another set.
     *
     * @param   set     The set to compare with.
     *
     * @return          true if this set is a superset of set.
     */
    public boolean isSuperSet(Set<E> set){
    	
    	if(this.size() < set.size()){
    		return false;
    	}
    	Iterator setIterator = this.setElements.iterator();
    	SetImp setB = (SetImp) set;
    	Iterator setIterator2 = setB.setElements.iterator();    			
    	while(setIterator2.hasNext()){
    		if(!this.contains(setIterator2.next())){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Returns a new Set that is the union of this & another set.
     * The union of two sets contains all elements in either set.
     *
     * @param   set     The other set.
     *
     * @return          The union of this & set.
     */
    public Set<E> union(Set<E> set){
    	SetImp<E> setB = (SetImp) set;
    	SetImp<E> unionSet = new SetImp<E>();
    	if(this.size() >= set.size()){
    		for(int i=0; i < this.size(); i++){        		
        			unionSet.add(this.get(i));
        			if(i < setB.size() && setB.get(i)!=null){
        				unionSet.add(setB.get(i));
        			}
        	}
    	}
    	for(int i=0; i < set.size(); i++){        		
			if(i < this.size() && this.get(i)!=null){
				unionSet.add(this.get(i));     		  
			}
			unionSet.add(setB.get(i));
    	}    	
		return unionSet;
    }
    
    /**
     * Returns a new Set that is the intersection of this & another set.
     * The intersection of two sets contains only elements in both sets.
     *
     * @param   set     The other set.
     *
     * @return          The intersection of this & set.
     */
    public Set<E> intersection(Set<E> set){
    	SetImp<E> setB = (SetImp) set;
    	SetImp<E> intersectionSet = new SetImp<E>();
    	for(E sElements : setB.setElements){
    		if(this.contains(sElements)){
    			intersectionSet.add(sElements);	
    		}  
    	}    	  
		return intersectionSet;
    }
    
    /**
     * Returns a new Set that is the difference of this & another set.
     * The result will contain all elements from this set but any elements 
     * that are also in the other set will have been removed.
     *
     * @param   set     The other set.
     *
     * @return          The difference of this & set.
     */
    public Set<E> difference(Set<E> set){
    	SetImp<E> differenceSet = new SetImp<E>();
    	for(E sElements : this.setElements){
    		if(!set.contains(sElements)){
    			differenceSet.add(sElements);	
    		}  
    	}    	  
		return differenceSet;
    }
    
    /**
     * Returns the element at index.
     *
     * @param   index   The index to get the element from.
     *
     * @return          The element at index.
     */
    public E get(int index){
    	
    	
    	return setElements.get(index); 
    }
    
    /**
     * Gets the number of elements within this set.
     *
     * @return          The number of elements in this set.
     */
    public int size(){
    	if(this.setElements.size() !=0){
    		return setElements.size();
    	}
    		return 0;
    }
    
    /**
     * Checks to see if this set contains a specific element.
     *
     * @param   element The element to check for.
     *
     * @return          true if the element is in this set.
     */
    public boolean contains(Object oElement){
    	if(setElements.contains(oElement)){
    		return true;
    	}
    	return false;
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(setElements.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
    
    

	
	
}
