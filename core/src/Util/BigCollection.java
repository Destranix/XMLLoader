package Util;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface BigCollection<E> extends Iterable<E>{

	public abstract boolean add(E e);
	
	public abstract boolean addAll(BigCollection<? extends E> c);
	public abstract boolean addAll(Collection<? extends E> c);
	
	public abstract void clear();
	
	public abstract boolean contains(Object o);
	
	public abstract boolean containsAll(BigCollection<?> c);
	public abstract boolean containsAll(Collection<?> c);
	
	@Override
	public abstract boolean equals(Object o);
	
	@Override
	public abstract int hashCode();
	
	public abstract boolean isEmpty();
	
	default Stream<E> parallelStream(){
		return StreamSupport.stream(spliterator(), true);
	}
	
	public abstract boolean remove(Object o);
	
	public abstract boolean removeAll(BigCollection<?> c);
	public abstract boolean removeAll(Collection<?> c);
	
	default boolean removeIf(Predicate<? super E> filter){
		Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
	}
	
	public abstract boolean retainAll(BigCollection<?> c);
	public abstract boolean retainAll(Collection<?> c);
	
	public abstract BigInteger size();
	
	@Override
	default Spliterator<E> spliterator(){
		return BigSpliterators.spliterator(this, 0);
	}
	
	default Stream<E> stream(){
		return StreamSupport.stream(spliterator(), false);
	}
}
