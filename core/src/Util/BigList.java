package Util;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

/*
 * A List with BigIntegers or longs as index
 */
public interface BigList<E> extends BigCollection<E> {

	public abstract void add(long index, E element);
	public abstract void add(BigInteger index, E element);
	
	public abstract boolean addAll(long index, Collection<? extends E> c);
	public abstract boolean addAll(BigInteger index, Collection<? extends E> c);
	
	public abstract boolean addAll(long index, BigCollection<? extends E> c);
	public abstract boolean addAll(BigInteger index, BigCollection<? extends E> c);
	
	public static <E> BigList<E> copyOf(Collection<? extends E> c){
		return ImmutableBigCollections.listCopy(c);
	}
	
	public static <E> BigList<E> copyOf(BigCollection<? extends E> c){
		return ImmutableBigCollections.listCopy(c);
	}
	
	public abstract E get(long index);
	public abstract E get(BigInteger index);
	
	public abstract BigInteger indexOf(Object o);
	
	public abstract BigListIterator<E> listIterator();
	
	public abstract BigListIterator<E> listIterator(long index);
	public abstract BigListIterator<E> listIterator(BigInteger index);
	
	public abstract BigInteger lastIndexOf(Object o);
	
	@SuppressWarnings("unchecked")
	public static <E> BigList<E> of(){
		return (BigList<E>) ImmutableBigCollections.BigListN.EMPTY_LIST;
	}
	
	public static <E> BigList<E> of(E e1){
		return new ImmutableBigCollections.BigList12<>(e1);
	}
	
	@SafeVarargs
	public static <E> BigList<E> of(E... elements){
		switch (elements.length) { // implicit null check of elements
	        case 0:
	            @SuppressWarnings("unchecked")
	            BigList<E> list = (BigList<E>) ImmutableBigCollections.BigListN.EMPTY_LIST;
	            return list;
	        case 1:
	            return new ImmutableBigCollections.BigList12<>(elements[0]);
	        case 2:
	            return new ImmutableBigCollections.BigList12<>(elements[0], elements[1]);
	        default:
	            return new ImmutableBigCollections.BigListN<>(elements);
	    }
	}
	
	public static <E> BigList<E> of(E e1, E e2){
		return new ImmutableBigCollections.BigList12<>(e1);
	}
	
	public static <E> BigList<E> of(E e1, E e2, E e3){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4, E e5){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4, e5);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4, E e5, E e6){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4, e5, e6);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4, e5, e6, e7);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4, e5, e6, e7, e8);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4, e5, e6, e7, e8, e9);
	}

	public static <E> BigList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10){
		return new ImmutableBigCollections.BigListN<>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}
	
	public abstract E remove(long index);
	public abstract E remove(BigInteger index);
	
	default void replaceAll(UnaryOperator<E> operator){
		Objects.requireNonNull(operator);
        final BigListIterator<E> li = this.listIterator();
        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }
	}
	
	public abstract E set(long index, E element);
	public abstract E set(BigInteger index, E element);
	
	public abstract BigInteger size();
	
	abstract void sort(Comparator<? super E> c);
	
	@Override
	default Spliterator<E> spliterator(){
		if (this instanceof RandomAccess) {
            return new AbstractBigList.RandomAccessSpliterator<>(this);
        } else {
            return BigSpliterators.spliterator(this, Spliterator.ORDERED);
        }
	}
	
	public abstract BigList<E> subList(long fromIndex, long toList);
	public abstract BigList<E> subList(BigInteger fromIndex, BigInteger toList);
}
