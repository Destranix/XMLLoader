package Util;

import java.math.BigInteger;
import java.util.Iterator;

public interface BigListIterator<E> extends Iterator<E>{

	public abstract void add(E e);
	
	public abstract boolean hasPrevious();
	
	public abstract BigInteger nextIndex();
	
	public abstract E previous();
	
	public abstract BigInteger previousIndex();
	
	@Override
	public abstract void remove();
	
	public abstract void set(E e);
	
}
