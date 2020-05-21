package Util;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class AbstractBigList<E> extends AbstractBigCollection<E> implements BigList<E> {

	  /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected AbstractBigList() {
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @implSpec
     * This implementation calls {@code add(size(), e)}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless
     * {@link #add(int, Object) add(int, E)} is overridden.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the {@code add} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this list
     */
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public abstract E get(long index);
    
    /**
     * {@inheritDoc}
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public abstract E get(BigInteger index);

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public E set(long index, E element) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public E set(BigInteger index, E element) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public void add(long index, E element) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public void add(BigInteger index, E element) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public E remove(long index) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public E remove(BigInteger index) {
        throw new UnsupportedOperationException();
    }


    // Search Operations

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation first gets a list iterator (with
     * {@code listIterator()}).  Then, it iterates over the list until the
     * specified element is found or the end of the list is reached.
     *
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    public BigInteger indexOf(Object o) {
        BigListIterator<E> it = listIterator();
        if (o==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return it.previousIndex();
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return it.previousIndex();
        }
        return BigInteger.valueOf(-1);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation first gets a list iterator that points to the end
     * of the list (with {@code listIterator(size())}).  Then, it iterates
     * backwards over the list until the specified element is found, or the
     * beginning of the list is reached.
     *
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    public BigInteger lastIndexOf(Object o) {
        BigListIterator<E> it = listIterator(size());
        if (o==null) {
            while (it.hasPrevious())
                if (it.previous()==null)
                    return it.nextIndex();
        } else {
            while (it.hasPrevious())
                if (o.equals(it.previous()))
                    return it.nextIndex();
        }
        return BigInteger.valueOf(-1);
    }


    // Bulk Operations

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @implSpec
     * This implementation calls {@code removeRange(0, size())}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless {@code remove(int
     * index)} or {@code removeRange(int fromIndex, int toIndex)} is
     * overridden.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *         is not supported by this list
     */
    public void clear() {
        removeRange(BigInteger.ZERO, size());
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation gets an iterator over the specified collection
     * and iterates over it, inserting the elements obtained from the
     * iterator into this list at the appropriate position, one at a time,
     * using {@code add(int, E)}.
     * Many implementations will override this method for efficiency.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless
     * {@link #add(int, Object) add(int, E)} is overridden.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public boolean addAll(long index, Collection<? extends E> c) {
       return addAll(BigInteger.valueOf(index), c);
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation gets an iterator over the specified collection
     * and iterates over it, inserting the elements obtained from the
     * iterator into this list at the appropriate position, one at a time,
     * using {@code add(int, E)}.
     * Many implementations will override this method for efficiency.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless
     * {@link #add(int, Object) add(int, E)} is overridden.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public boolean addAll(BigInteger index, Collection<? extends E> c) {
        rangeCheckForAdd(index);
        boolean modified = false;
        BigListIterator<E> it = listIterator(index);
        for (E e : c) {
        	it.next();
            it.set(e);
            modified = true;
        }
        return modified;
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation gets an iterator over the specified collection
     * and iterates over it, inserting the elements obtained from the
     * iterator into this list at the appropriate position, one at a time,
     * using {@code add(int, E)}.
     * Many implementations will override this method for efficiency.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless
     * {@link #add(int, Object) add(int, E)} is overridden.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public boolean addAll(long index, BigCollection<? extends E> c) {
    	return addAll(BigInteger.valueOf(index), c);
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation gets an iterator over the specified collection
     * and iterates over it, inserting the elements obtained from the
     * iterator into this list at the appropriate position, one at a time,
     * using {@code add(int, E)}.
     * Many implementations will override this method for efficiency.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless
     * {@link #add(int, Object) add(int, E)} is overridden.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public boolean addAll(BigInteger index, BigCollection<? extends E> c) {
    	 rangeCheckForAdd(index);
         boolean modified = false;
         BigListIterator<E> it = listIterator(index);
         for (E e : c) {
         	it.next();
             it.set(e);
             modified = true;
         }
         return modified;
    }


    // Iterators

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @implSpec
     * This implementation returns a straightforward implementation of the
     * iterator interface, relying on the backing list's {@code size()},
     * {@code get(int)}, and {@code remove(int)} methods.
     *
     * <p>Note that the iterator returned by this method will throw an
     * {@link UnsupportedOperationException} in response to its
     * {@code remove} method unless the list's {@code remove(int)} method is
     * overridden.
     *
     * <p>This implementation can be made to throw runtime exceptions in the
     * face of concurrent modification, as described in the specification
     * for the (protected) {@link #modCount} field.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns {@code listIterator(0)}.
     *
     * @see #listIterator(int)
     */
    public BigListIterator<E> listIterator() {
        return listIterator(BigInteger.ZERO);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns a straightforward implementation of the
     * {@code ListIterator} interface that extends the implementation of the
     * {@code Iterator} interface returned by the {@code iterator()} method.
     * The {@code ListIterator} implementation relies on the backing list's
     * {@code get(int)}, {@code set(int, E)}, {@code add(int, E)}
     * and {@code remove(int)} methods.
     *
     * <p>Note that the list iterator returned by this implementation will
     * throw an {@link UnsupportedOperationException} in response to its
     * {@code remove}, {@code set} and {@code add} methods unless the
     * list's {@code remove(int)}, {@code set(int, E)}, and
     * {@code add(int, E)} methods are overridden.
     *
     * <p>This implementation can be made to throw runtime exceptions in the
     * face of concurrent modification, as described in the specification for
     * the (protected) {@link #modCount} field.
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public BigListIterator<E> listIterator(final long index) {
        return listIterator(BigInteger.valueOf(index));
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns a straightforward implementation of the
     * {@code ListIterator} interface that extends the implementation of the
     * {@code Iterator} interface returned by the {@code iterator()} method.
     * The {@code ListIterator} implementation relies on the backing list's
     * {@code get(int)}, {@code set(int, E)}, {@code add(int, E)}
     * and {@code remove(int)} methods.
     *
     * <p>Note that the list iterator returned by this implementation will
     * throw an {@link UnsupportedOperationException} in response to its
     * {@code remove}, {@code set} and {@code add} methods unless the
     * list's {@code remove(int)}, {@code set(int, E)}, and
     * {@code add(int, E)} methods are overridden.
     *
     * <p>This implementation can be made to throw runtime exceptions in the
     * face of concurrent modification, as described in the specification for
     * the (protected) {@link #modCount} field.
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public BigListIterator<E> listIterator(final BigInteger index) {
        rangeCheckForAdd(index);

        return new ListItr(index);
    }

    private class Itr implements Iterator<E> {
        /**
         * Index of element to be returned by subsequent call to next.
         */
        BigInteger cursor = BigInteger.ZERO;

        /**
         * Index of element returned by most recent call to next or
         * previous.  Reset to -1 if this element is deleted by a call
         * to remove.
         */
        BigInteger lastRet = BigInteger.valueOf(-1);

        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            checkForComodification();
            try {
            	BigInteger i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i.add(BigInteger.ONE);
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet.compareTo(BigInteger.ZERO) < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                AbstractBigList.this.remove(lastRet);
                if (lastRet.compareTo(cursor) < 0)
                    cursor.subtract(BigInteger.ONE);
                lastRet = BigInteger.valueOf(-1);
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class ListItr extends Itr implements BigListIterator<E> {
        ListItr(BigInteger index) {
            cursor = index;
        }

        public boolean hasPrevious() {
            return !cursor.equals(BigInteger.ZERO);
        }

        public E previous() {
            checkForComodification();
            try {
            	BigInteger i = cursor.subtract(BigInteger.ONE);
                E previous = get(i);
                lastRet = cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public BigInteger nextIndex() {
            return cursor;
        }

        public BigInteger previousIndex() {
            return cursor.subtract(BigInteger.ONE);
        }

        public void set(E e) {
            if (lastRet.compareTo(BigInteger.ZERO) < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                AbstractBigList.this.set(lastRet, e);
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            checkForComodification();

            try {
            	BigInteger i = cursor;
                AbstractBigList.this.add(i, e);
                lastRet = BigInteger.valueOf(-1);
                cursor = i.add(BigInteger.ONE);
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns a list that subclasses
     * {@code AbstractList}.  The subclass stores, in private fields, the
     * size of the subList (which can change over its lifetime), and the
     * expected {@code modCount} value of the backing list.  There are two
     * variants of the subclass, one of which implements {@code RandomAccess}.
     * If this list implements {@code RandomAccess} the returned list will
     * be an instance of the subclass that implements {@code RandomAccess}.
     *
     * <p>The subclass's {@code set(int, E)}, {@code get(int)},
     * {@code add(int, E)}, {@code remove(int)}, {@code addAll(int,
     * Collection)} and {@code removeRange(int, int)} methods all
     * delegate to the corresponding methods on the backing abstract list,
     * after bounds-checking the index and adjusting for the offset.  The
     * {@code addAll(Collection c)} method merely returns {@code addAll(size,
     * c)}.
     *
     * <p>The {@code listIterator(int)} method returns a "wrapper object"
     * over a list iterator on the backing list, which is created with the
     * corresponding method on the backing list.  The {@code iterator} method
     * merely returns {@code listIterator()}, and the {@code size} method
     * merely returns the subclass's {@code size} field.
     *
     * <p>All methods first check to see if the actual {@code modCount} of
     * the backing list is equal to its expected value, and throw a
     * {@code ConcurrentModificationException} if it is not.
     *
     * @throws IndexOutOfBoundsException if an endpoint index value is out of range
     *         {@code (fromIndex < 0 || toIndex > size)}
     * @throws IllegalArgumentException if the endpoint indices are out of order
     *         {@code (fromIndex > toIndex)}
     */
    public BigList<E> subList(long fromIndex, long toIndex) {
       return subList(BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
    }
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns a list that subclasses
     * {@code AbstractList}.  The subclass stores, in private fields, the
     * size of the subList (which can change over its lifetime), and the
     * expected {@code modCount} value of the backing list.  There are two
     * variants of the subclass, one of which implements {@code RandomAccess}.
     * If this list implements {@code RandomAccess} the returned list will
     * be an instance of the subclass that implements {@code RandomAccess}.
     *
     * <p>The subclass's {@code set(int, E)}, {@code get(int)},
     * {@code add(int, E)}, {@code remove(int)}, {@code addAll(int,
     * Collection)} and {@code removeRange(int, int)} methods all
     * delegate to the corresponding methods on the backing abstract list,
     * after bounds-checking the index and adjusting for the offset.  The
     * {@code addAll(Collection c)} method merely returns {@code addAll(size,
     * c)}.
     *
     * <p>The {@code listIterator(int)} method returns a "wrapper object"
     * over a list iterator on the backing list, which is created with the
     * corresponding method on the backing list.  The {@code iterator} method
     * merely returns {@code listIterator()}, and the {@code size} method
     * merely returns the subclass's {@code size} field.
     *
     * <p>All methods first check to see if the actual {@code modCount} of
     * the backing list is equal to its expected value, and throw a
     * {@code ConcurrentModificationException} if it is not.
     *
     * @throws IndexOutOfBoundsException if an endpoint index value is out of range
     *         {@code (fromIndex < 0 || toIndex > size)}
     * @throws IllegalArgumentException if the endpoint indices are out of order
     *         {@code (fromIndex > toIndex)}
     */
    public BigList<E> subList(BigInteger fromIndex, BigInteger toIndex) {
        subListRangeCheck(fromIndex, toIndex, size());
        return (this instanceof RandomAccess ?
                new RandomAccessSubBigList<>(this, fromIndex, toIndex) :
                new SubBigList<>(this, fromIndex, toIndex));
    }

    static void subListRangeCheck(long fromIndex, long toIndex, long size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                                               ") > toIndex(" + toIndex + ")");
    }
    
    static void subListRangeCheck(BigInteger fromIndex, BigInteger toIndex, BigInteger size) {
		if (BigInteger.ZERO.compareTo(fromIndex) > 0)
			throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
		if (toIndex.compareTo(size) > 0)
			throw new IndexOutOfBoundsException("toIndex = " + toIndex);
		if (fromIndex.compareTo(toIndex) > 0)
			throw new IllegalArgumentException("fromIndex(" + fromIndex +
					") > toIndex(" + toIndex + ")");
	}

    // Comparison and hashing

    /**
     * Compares the specified object with this list for equality.  Returns
     * {@code true} if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements {@code e1} and
     * {@code e2} are <i>equal</i> if {@code (e1==null ? e2==null :
     * e1.equals(e2))}.)  In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.
     *
     * @implSpec
     * This implementation first checks if the specified object is this
     * list. If so, it returns {@code true}; if not, it checks if the
     * specified object is a list. If not, it returns {@code false}; if so,
     * it iterates over both lists, comparing corresponding pairs of elements.
     * If any comparison returns {@code false}, this method returns
     * {@code false}.  If either iterator runs out of elements before the
     * other it returns {@code false} (as the lists are of unequal length);
     * otherwise it returns {@code true} when the iterations complete.
     *
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BigList))
            return false;

        BigListIterator<E> e1 = listIterator();
        BigListIterator<?> e2 = ((BigList<?>) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    /**
     * Returns the hash code value for this list.
     *
     * @implSpec
     * This implementation uses exactly the code that is used to define the
     * list hash function in the documentation for the {@link List#hashCode}
     * method.
     *
     * @return the hash code value for this list
     */
    public int hashCode() {
        int hashCode = 1;
        for (E e : this)
            hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
        return hashCode;
    }

    /**
     * Removes from this list all of the elements whose index is between
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
     * Shifts any succeeding elements to the left (reduces their index).
     * This call shortens the list by {@code (toIndex - fromIndex)} elements.
     * (If {@code toIndex==fromIndex}, this operation has no effect.)
     *
     * <p>This method is called by the {@code clear} operation on this list
     * and its subLists.  Overriding this method to take advantage of
     * the internals of the list implementation can <i>substantially</i>
     * improve the performance of the {@code clear} operation on this list
     * and its subLists.
     *
     * @implSpec
     * This implementation gets a list iterator positioned before
     * {@code fromIndex}, and repeatedly calls {@code ListIterator.next}
     * followed by {@code ListIterator.remove} until the entire range has
     * been removed.  <b>Note: if {@code ListIterator.remove} requires linear
     * time, this implementation requires quadratic time.</b>
     *
     * @param fromIndex index of first element to be removed
     * @param toIndex index after last element to be removed
     */
    protected void removeRange(long fromIndex, long toIndex) {
        BigListIterator<E> it = listIterator(fromIndex);
        removeRangeDif(toIndex-fromIndex, it);
    }
    
    /**
     * Removes from this list all of the elements whose index is between
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
     * Shifts any succeeding elements to the left (reduces their index).
     * This call shortens the list by {@code (toIndex - fromIndex)} elements.
     * (If {@code toIndex==fromIndex}, this operation has no effect.)
     *
     * <p>This method is called by the {@code clear} operation on this list
     * and its subLists.  Overriding this method to take advantage of
     * the internals of the list implementation can <i>substantially</i>
     * improve the performance of the {@code clear} operation on this list
     * and its subLists.
     *
     * @implSpec
     * This implementation gets a list iterator positioned before
     * {@code fromIndex}, and repeatedly calls {@code ListIterator.next}
     * followed by {@code ListIterator.remove} until the entire range has
     * been removed.  <b>Note: if {@code ListIterator.remove} requires linear
     * time, this implementation requires quadratic time.</b>
     *
     * @param fromIndex index of first element to be removed
     * @param toIndex index after last element to be removed
     */
    protected void removeRange(BigInteger fromIndex, BigInteger toIndex) {
        BigListIterator<E> it = listIterator(fromIndex);
        BigInteger dif = toIndex.subtract(fromIndex);
        if(dif.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0){
        	removeRangeDif(dif.longValue(), it);
        }else{
        	 while(dif.compareTo(BigInteger.ZERO) > 0){
                 BigInteger newDif = dif.subtract(BigInteger.valueOf(Long.MAX_VALUE));
                 if(newDif.compareTo(BigInteger.ZERO) < 0){
                	 removeRangeDif(Long.MAX_VALUE + newDif.longValue(), it);
                 }else{
                	 removeRangeDif(Long.MAX_VALUE, it);
                 }
                dif = newDif;
             }
        }
    }
    
    private void removeRangeDif(long dif, BigListIterator<E> it){
         for (long i=0; i<dif; i++) {
             it.next();
             it.remove();
         }
    }

    /**
     * The number of times this list has been <i>structurally modified</i>.
     * Structural modifications are those that change the size of the
     * list, or otherwise perturb it in such a fashion that iterations in
     * progress may yield incorrect results.
     *
     * <p>This field is used by the iterator and list iterator implementation
     * returned by the {@code iterator} and {@code listIterator} methods.
     * If the value of this field changes unexpectedly, the iterator (or list
     * iterator) will throw a {@code ConcurrentModificationException} in
     * response to the {@code next}, {@code remove}, {@code previous},
     * {@code set} or {@code add} operations.  This provides
     * <i>fail-fast</i> behavior, rather than non-deterministic behavior in
     * the face of concurrent modification during iteration.
     *
     * <p><b>Use of this field by subclasses is optional.</b> If a subclass
     * wishes to provide fail-fast iterators (and list iterators), then it
     * merely has to increment this field in its {@code add(int, E)} and
     * {@code remove(int)} methods (and any other methods that it overrides
     * that result in structural modifications to the list).  A single call to
     * {@code add(int, E)} or {@code remove(int)} must add no more than
     * one to this field, or the iterators (and list iterators) will throw
     * bogus {@code ConcurrentModificationExceptions}.  If an implementation
     * does not wish to provide fail-fast iterators, this field may be
     * ignored.
     */
    protected transient int modCount = 0;
    
    private void rangeCheckForAdd(BigInteger index) {
        if (index.compareTo(BigInteger.ZERO) < 0 || index.compareTo(size()) > 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(BigInteger index) {
        return "Index: "+index+", Size: "+size();
    }

    /**
     * An index-based split-by-two, lazily initialized Spliterator covering
     * a List that access elements via {@link List#get}.
     *
     * If access results in an IndexOutOfBoundsException then a
     * ConcurrentModificationException is thrown instead (since the list has
     * been structurally modified while traversing).
     *
     * If the List is an instance of AbstractList then concurrent modification
     * checking is performed using the AbstractList's modCount field.
     */
    static final class RandomAccessSpliterator<E> implements Spliterator<E> {

        private final BigList<E> list;
        private BigInteger index; // current index, modified on advance/split
        private BigInteger fence; // -1 until used; then one past last index

        // The following fields are valid if covering an AbstractList
        private final AbstractBigList<E> alist;
        private int expectedModCount; // initialized when fence set

        RandomAccessSpliterator(BigList<E> list) {
            assert list instanceof RandomAccess;

            this.list = list;
            this.index = BigInteger.ZERO;
            this.fence = BigInteger.valueOf(-1);

            this.alist = list instanceof AbstractBigList ? (AbstractBigList<E>) list : null;
            this.expectedModCount = alist != null ? alist.modCount : 0;
        }

        /** Create new spliterator covering the given  range */
        private RandomAccessSpliterator(RandomAccessSpliterator<E> parent,
        		BigInteger origin, BigInteger fence) {
            this.list = parent.list;
            this.index = origin;
            this.fence = fence;

            this.alist = parent.alist;
            this.expectedModCount = parent.expectedModCount;
        }

        private BigInteger getFence() { // initialize fence to size on first use
        	BigInteger hi;
            BigList<E> lst = list;
            if ((hi = fence).compareTo(BigInteger.ZERO) < 0) {
                if (alist != null) {
                    expectedModCount = alist.modCount;
                }
                hi = fence = lst.size();
            }
            return hi;
        }

        public Spliterator<E> trySplit() {
        	BigInteger hi = getFence(), lo = index, mid = (lo.add(hi)).abs().divide(BigInteger.TWO);
            return (lo.compareTo(mid) >= 0) ? null : // divide range in half unless too small
                    new RandomAccessSpliterator<>(this, lo, index = mid);
        }

        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null)
                throw new NullPointerException();
            BigInteger hi = getFence(), i = index;
            if (i.compareTo(hi) < 0) {
                index = i.add(BigInteger.ONE);
                action.accept(get(list, i));
                checkAbstractListModCount(alist, expectedModCount);
                return true;
            }
            return false;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            BigList<E> lst = list;
            BigInteger hi = getFence();
            BigInteger i = index;
            index = hi;
            BigInteger dif = hi.subtract(i);
            if(dif.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0){
            	 for (long count = i.longValue(); count < hi.longValue(); count++) {
                     action.accept(get(lst, count));
                 }
            }else{
            	 while(i.compareTo(hi) < 0){
            		 action.accept(get(lst, i));
            		 i = i.add(BigInteger.ONE);
                 }
            }
           
            checkAbstractListModCount(alist, expectedModCount);
        }

        public long estimateSize() {
        	BigInteger est = getFence().subtract(index);
        	if(est.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0){
        		return Long.MAX_VALUE;
        	}else{
        		return est.longValue();
        	}
        }

        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        }
        
        private static <E> E get(BigList<E> list, long i) {
            try {
                return list.get(i);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        private static <E> E get(BigList<E> list, BigInteger i) {
            try {
                return list.get(i);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        static void checkAbstractListModCount(AbstractBigList<?> alist, int expectedModCount) {
            if (alist != null && alist.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static class SubBigList<E> extends AbstractBigList<E> {
        private final AbstractBigList<E> root;
        private final SubBigList<E> parent;
        private final BigInteger offset;
        protected BigInteger size;

        /**
         * Constructs a sublist of an arbitrary AbstractList, which is
         * not a SubList itself.
         */
        public SubBigList(AbstractBigList<E> root, long fromIndex, long toIndex) {
            this(root, BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
        }
        
        /**
         * Constructs a sublist of an arbitrary AbstractList, which is
         * not a SubList itself.
         */
        public SubBigList(AbstractBigList<E> root, BigInteger fromIndex, BigInteger toIndex) {
        	this.root = root;
            this.parent = null;
            this.offset = fromIndex;
            this.size = toIndex.subtract(fromIndex);
            this.modCount = root.modCount;
        }
        
        /**
         * Constructs a sublist of another SubList.
         */
        public SubBigList(SubBigList<E> parent, long fromIndex, long toIndex) {
            this(parent, BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
        }

        /**
         * Constructs a sublist of another SubList.
         */
        protected SubBigList(SubBigList<E> parent, BigInteger fromIndex, BigInteger toIndex) {
            this.root = parent.root;
            this.parent = parent;
            this.offset = parent.offset.add(fromIndex);
            this.size = toIndex.subtract(fromIndex);
            this.modCount = root.modCount;
        }
        
        public E set(long index, E element) {
           return set(BigInteger.valueOf(index), element);
        }

        public E set(BigInteger index, E element) {
            checkIndex(index, size);
            checkForComodification();
            return root.set(offset.add(index), element);
        }
        
        public E get(long index) {
           return get(BigInteger.valueOf(index));
        }

        public E get(BigInteger index) {
            checkIndex(index, size);
            checkForComodification();
            return root.get(offset.add(index));
        }

        public BigInteger size() {
            checkForComodification();
            return size;
        }
        
        public void add(long index, E element) {
            add(BigInteger.valueOf(index), element);
        }

        public void add(BigInteger index, E element) {
            rangeCheckForAdd(index);
            checkForComodification();
            root.add(offset.add(index), element);
            updateSizeAndModCount(BigInteger.ONE);
        }
        
        public E remove(long index) {
           return remove(BigInteger.valueOf(index));
        }

        public E remove(BigInteger index) {
            checkIndex(index, size);
            checkForComodification();
            E result = root.remove(offset.add(index));
            updateSizeAndModCount(BigInteger.valueOf(-1));
            return result;
        }

        protected void removeRange(BigInteger fromIndex, BigInteger toIndex) {
            checkForComodification();
            root.removeRange(offset.add(fromIndex), offset.add(toIndex));
            updateSizeAndModCount(fromIndex.subtract(toIndex));
        }

        public boolean addAll(Collection<? extends E> c) {
            return addAll(size, c);
        }
        
        public boolean addAll(BigCollection<? extends E> c) {
            return addAll(size, c);
        }

        public boolean addAll(long index, Collection<? extends E> c) {
           return addAll(BigInteger.valueOf(index), c);
        }
        
        public boolean addAll(BigInteger index, Collection<? extends E> c) {
            rangeCheckForAdd(index);
            int cSize = c.size();
            if (cSize == 0)
                return false;
            checkForComodification();
            root.addAll(offset.add(index), c);
            updateSizeAndModCount(BigInteger.valueOf(cSize));
            return true;
        }
        
        public boolean addAll(long index, BigCollection<? extends E> c) {
            return addAll(BigInteger.valueOf(index), c);
         }
         
         public boolean addAll(BigInteger index, BigCollection<? extends E> c) {
             rangeCheckForAdd(index);
             BigInteger cSize = c.size();
             if (cSize.equals(BigInteger.ZERO))
                 return false;
             checkForComodification();
             root.addAll(offset.add(index), c);
             updateSizeAndModCount(cSize);
             return true;
         }

        public Iterator<E> iterator() {
            return listIterator();
        }
        
        public BigListIterator<E> listIterator(long index) {
        	return listIterator(BigInteger.valueOf(index));
        }

        public BigListIterator<E> listIterator(BigInteger index) {
            checkForComodification();
            rangeCheckForAdd(index);

            return new BigListIterator<E>() {
                private final BigListIterator<E> i =
                        root.listIterator(offset.add(index));

                public boolean hasNext() {
                    return nextIndex().compareTo(size) < 0;
                }

                public E next() {
                    if (hasNext())
                        return i.next();
                    else
                        throw new NoSuchElementException();
                }

                public boolean hasPrevious() {
                    return previousIndex().compareTo(BigInteger.ZERO) >= 0;
                }

                public E previous() {
                    if (hasPrevious())
                        return i.previous();
                    else
                        throw new NoSuchElementException();
                }

                public BigInteger nextIndex() {
                    return i.nextIndex().subtract(offset);
                }

                public BigInteger previousIndex() {
                    return i.previousIndex().subtract(offset);
                }

                public void remove() {
                    i.remove();
                    updateSizeAndModCount(BigInteger.valueOf(-1));
                }

                public void set(E e) {
                    i.set(e);
                }

                public void add(E e) {
                    i.add(e);
                    updateSizeAndModCount(BigInteger.ONE);
                }
            };
        }
        
        public BigList<E> subList(long fromIndex, long toIndex) {
        	 return subList(BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
        }

        public BigList<E> subList(BigInteger fromIndex, BigInteger toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new SubBigList<>(this, fromIndex, toIndex);
        }

        private void rangeCheckForAdd(BigInteger index) {
            if (index.compareTo(BigInteger.ZERO) < 0 || index.compareTo(size) > 0)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private String outOfBoundsMsg(BigInteger index) {
            return "Index: "+index+", Size: "+size;
        }

        private void checkForComodification() {
            if (root.modCount != this.modCount)
                throw new ConcurrentModificationException();
        }

        private void updateSizeAndModCount(BigInteger sizeChange) {
            SubBigList<E> slist = this;
            do {
                slist.size = slist.size.add(sizeChange);
                slist.modCount = root.modCount;
                slist = slist.parent;
            } while (slist != null);
        }

		@Override
		public void sort(Comparator<? super E> c) {
			throw new UnsupportedOperationException();
		}
    }

    private static class RandomAccessSubBigList<E>
            extends SubBigList<E> implements RandomAccess {

        /**
         * Constructs a sublist of an arbitrary AbstractList, which is
         * not a RandomAccessSubList itself.
         */
    	RandomAccessSubBigList(AbstractBigList<E> root,
                long fromIndex, long toIndex) {
            super(root, fromIndex, toIndex);
        }
    	
    	/**
         * Constructs a sublist of an arbitrary AbstractList, which is
         * not a RandomAccessSubList itself.
         */
    	RandomAccessSubBigList(AbstractBigList<E> root,
                BigInteger fromIndex, BigInteger toIndex) {
            super(root, fromIndex, toIndex);
        }

        /**
         * Constructs a sublist of another RandomAccessSubList.
         */
    	RandomAccessSubBigList(RandomAccessSubBigList<E> parent,
    			long fromIndex, long toIndex) {
            super(parent, fromIndex, toIndex);
        }
    	
    	 /**
         * Constructs a sublist of another RandomAccessSubList.
         */
    	RandomAccessSubBigList(RandomAccessSubBigList<E> parent,
    			BigInteger fromIndex, BigInteger toIndex) {
            super(parent, fromIndex, toIndex);
        }

        public BigList<E> subList(long fromIndex, long toIndex) {
            return subList(BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
        }
        
        public BigList<E> subList(BigInteger fromIndex, BigInteger toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new RandomAccessSubBigList<>(this, fromIndex, toIndex);
        }
    }
    
    private static void checkIndex(BigInteger index, BigInteger size){
		if(BigInteger.ZERO.compareTo(index) > 0 || index.compareTo(size) >= 0){
			throw new IndexOutOfBoundsException(index.toString());
		}
	}
	
}
