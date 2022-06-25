/**
 * The class Implements a mapped association table (in ascending order), designed to store pairs of a key 
 * (of a  type that implements the interface Comparable<T>) ,and a value of any type (so that all of them
 * have the same type). 
 */

import java.util.TreeMap;
import java.util.Iterator;

public class AssociationTable<T extends Comparable<T>, E>  {
	private TreeMap associationTable;
	
	// creates an empty association table
	public AssociationTable() {
		associationTable = new TreeMap<T, E>();
	}
	
	// receives an array of keys (unsorted) and an array of values and creates a sorted mapped association 
	// table of them
	public AssociationTable(T[] keys, E[] values) throws IllegalArgumentException {
		if(keys.length != values.length){
			throw new IllegalArgumentException();
		} // if the size of the input arrays isn't equal throws IllegalArgumentException
		
		// creats and fills the association table
		associationTable = new TreeMap<T, E>(); 
		for(int i=0; i < keys.length; i++){
			// if the key already exists in the association table, the old value is replaced
			associationTable.put(keys[i], values[i]);
		} 
	}
	
	// receives a key and value and adds the key with the value to the association table. if the key already
	// exists in the association table, the old value is replaced
	public void add(T key, E value){
		associationTable.put(key, value);
	}
	
	// returns value to which the specified key is mapped, or null if the key doesn't exist
	public Object get(T key){
		return associationTable.get(key);
	}
	
	// returns true if the association table contains a mapping for the specified key, otherwise returns false
	public boolean contains(T key){
		return associationTable.containsKey(key);
	}
	
	// removes the of the key from the association table (if present) and returns true, otherwise 
	// returns false
	public boolean remove(T key){
		if(contains(key)){
			associationTable.remove(key);
			return true;
		} //  if the specified key present	
	return false;
	}
	
	// returns the number of key-value mappings in the association table
	public int size(){
		return associationTable.size();
	}
	
	// returns an iterator that allows to iterate on the table's keys in ascending order
	public Iterator<T> keyIterator(){
		return associationTable.keySet().iterator();
	}
}
