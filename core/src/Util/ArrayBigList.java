package Util;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayBigList<E> extends AbstractBigList<E> implements BigList<E>, RandomAccess, Cloneable{

	/**
    * Default initial capacity.
    */
   private static final BigInteger DEFAULT_CAPACITY = BigInteger.TEN;

   /**
    * Shared empty array instance used for empty instances.
    */
   private static final Object[] EMPTY_ELEMENTDATA = {};

   /**
    * Shared empty array instance used for default sized empty instances. We
    * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
    * first element is added.
    */
   private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

   /**
    * The array buffer into which the elements of the ArrayList are stored.
    * The capacity of the ArrayList is the length of this array buffer. Any
    * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
    * will be expanded to DEFAULT_CAPACITY when the first element is added.
    */
   transient Object[] elementData; // non-private to simplify nested class access

   /*
    * Indicates, how many dimensions the elementData-Array has.
    */
   transient int dimension = 1;
   
   /**
    * The size of the ArrayList (the number of elements it contains).
    *
    * @serial
    */
   private BigInteger size = BigInteger.ZERO;
   
   private BigInteger capacity;

   /**
    * Constructs an empty list with the specified initial capacity.
    *
    * @param  initialCapacity  the initial capacity of the list
    * @throws IllegalArgumentException if the specified initial capacity
    *         is negative
    */
   public ArrayBigList(long initialCapacity) {
      this(BigInteger.valueOf(initialCapacity));
   }
   
   /**
    * Constructs an empty list with the specified initial capacity.
    *
    * @param  initialCapacity  the initial capacity of the list
    * @throws IllegalArgumentException if the specified initial capacity
    *         is negative
    */
   public ArrayBigList(BigInteger initialCapacity) {
       if (initialCapacity.compareTo(BigInteger.ZERO) > 0) {
           this.elementData = createContainerAndSetDimension(initialCapacity);
       } else if (initialCapacity.equals(BigInteger.ZERO)) {
           this.elementData = EMPTY_ELEMENTDATA;
       } else {
           throw new IllegalArgumentException("Illegal Capacity: "+
                                              initialCapacity);
       }
       capacity = initialCapacity;
   }

   /**
    * Constructs an empty list with an initial capacity of ten.
    */
   public ArrayBigList() {
       this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
       capacity = BigInteger.valueOf(this.elementData.length);
   }

   /**
    * Constructs a list containing the elements of the specified
    * collection, in the order they are returned by the collection's
    * iterator.
    *
    * @param c the collection whose elements are to be placed into this list
    * @throws NullPointerException if the specified collection is null
    */
   public ArrayBigList(Collection<? extends E> c) {
       elementData = c.toArray();
       this.size = BigInteger.valueOf(elementData.length);
       this.capacity = this.size;
       if (size.intValue() != 0) {
           // defend against c.toArray (incorrectly) not returning Object[]
           // (see e.g. https://bugs.openjdk.java.net/browse/JDK-6260652)
           if (elementData.getClass() != Object[].class)
               elementData = Arrays.copyOf(elementData, size.intValue(), Object[].class);
       } else {
           // replace with empty array.
           this.elementData = EMPTY_ELEMENTDATA;
       }
   }
   
   /**
    * Constructs a list containing the elements of the specified
    * collection, in the order they are returned by the collection's
    * iterator.
    *
    * @param c the collection whose elements are to be placed into this list
    * @throws NullPointerException if the specified collection is null
    */
   public ArrayBigList(BigCollection<? extends E> c) {
	   size = c.size();
	   capacity = size;
       if (!size.equals(BigInteger.ZERO)) {
    	   this.elementData = createContainerAndSetDimension(size);
    	   Iterator<? extends E> cIt = c.iterator();
    	   if(this.dimension == 1){
    		   for(int i=0;i<size.intValue();++i){
    			   this.elementData[i] = cIt.next();
    		   }
    	   }else if(this.dimension == 2){
    		   for(int i=0;i<this.elementData.length;++i){
    			   for(int j=0;j<((Object[]) this.elementData[i]).length;++j){
    				   ((Object[]) this.elementData[i])[j] = cIt.next();
        		   }
    		   }
    	   }else{
    		   BigListIterator<E> it = listIterator();
    		   while(it.hasNext() && cIt.hasNext()){
    			   it.next();
    			   it.set(cIt.next());
    		   }
    	   }
    	   
       } else {
           // replace with empty array.
           this.elementData = EMPTY_ELEMENTDATA;
       }
   }

   /**
    * Trims the capacity of this {@code ArrayList} instance to be the
    * list's current size.  An application can use this operation to minimize
    * the storage of an {@code ArrayList} instance.
    */
   public void trimToSize() {
       modCount++;
       if (size.compareTo(capacity) < 0) {
    	   if(size.equals(BigInteger.ZERO)){
    		   elementData = EMPTY_ELEMENTDATA;
    	   }else{
    		   int[][] lastDims = new int[1][];
    		   int newDimension = calculateDimension(size, lastDims);
    		   if(this.dimension > newDimension){
    			   for(int i=0;i<(this.dimension - newDimension);++i){
    				  this.elementData = (Object[]) this.elementData[0];
    			   }
    		   }else if(this.dimension < newDimension){
    			   throw new AssertionError("Should not reach this state! Size cannot be bigger than capacity!");
    		   }
    		   this.dimension = newDimension;
    		   if(this.dimension == 1){
				   this.elementData = Arrays.copyOf(this.elementData, size.intValue());
    		   }else{
				   Object[] lastArr = this.elementData;
				   for(int i=0;i<this.dimension;++i){
					   lastArr = Arrays.copyOf(elementData, lastDims[0][i]);
					   lastArr = (Object[]) lastArr[lastArr.length-1];
				   }
			   }
    	   }
       }
       capacity = size;
   }
   
   /**
   * Increases the capacity of this {@code ArrayList} instance, if
   * necessary, to ensure that it can hold at least the number of elements
   * specified by the minimum capacity argument.
   *
   * @param minCapacity the desired minimum capacity
   */
  public void ensureCapacity(long minCapacity) {
      ensureCapacity(BigInteger.valueOf(minCapacity));
  }

   /**
    * Increases the capacity of this {@code ArrayList} instance, if
    * necessary, to ensure that it can hold at least the number of elements
    * specified by the minimum capacity argument.
    *
    * @param minCapacity the desired minimum capacity
    */
   public void ensureCapacity(BigInteger minCapacity) {
       if (minCapacity.compareTo(capacity) > 0
           && !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                && minCapacity.compareTo(DEFAULT_CAPACITY) <= 0)) {
           modCount++;
           grow(minCapacity);
       }
   }

   /**
    * The maximum size of array to allocate (unless necessary).
    * Some VMs reserve some header words in an array.
    * Attempts to allocate larger arrays may result in
    * OutOfMemoryError: Requested array size exceeds VM limit
    */
   private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
   
   /**
    * Increases the capacity to ensure that it can hold at least the
    * number of elements specified by the minimum capacity argument.
    *
    * @param minCapacity the desired minimum capacity
    * @throws OutOfMemoryError if minCapacity is less than zero
    */
   private Object[] grow(BigInteger minCapacity) {
	   minCapacity =  newCapacity(minCapacity);
	   int[][] lastDims = new int[1][];
	   int newDimension = calculateDimension(minCapacity, lastDims);
	   Class<?>[] arrayClasses = new Class<?>[newDimension];
	   Class<?> componentClass = elementData.getClass();
	   for(int i=0;i<dimension;++i){
		   componentClass = componentClass.getComponentType();
	   }
	   arrayClasses[arrayClasses.length-1] = componentClass;
	   for(int i=arrayClasses.length-1;i>0;--i){//Counts down; Ends before 0
		   arrayClasses[i-1] = Array.newInstance(arrayClasses[i], 0).getClass();
	   }
	   int[] lengths = new int[dimension];
	   Arrays.fill(lengths, MAX_ARRAY_SIZE);
	   if(this.dimension < newDimension){
		   Object[] firstElement = this.elementData;
		   for(int i=arrayClasses.length-1;i>0;--i){//Counts down; Ends before 0
			   
			   boolean isLast = true;
			   for(int j=0;j<i;++j){
				   if(lastDims[0][j] > 1){
					   isLast = false;
					   break;
				   }
			   }
			   Object[] newFirstElement;
			   if(isLast){
				   newFirstElement = (Object[]) Array.newInstance(arrayClasses[i], lastDims[0][i]);
			   }else{
				   newFirstElement = (Object[]) Array.newInstance(arrayClasses[i], MAX_ARRAY_SIZE);
			   }
			   if(lastDims[0][i] > 1){
				   newFirstElement[0] = Arrays.copyOf(firstElement, MAX_ARRAY_SIZE);
			   }else{
				   newFirstElement[0] = Arrays.copyOf(firstElement, lastDims[0][i+1]);
			   }
			   for(int j=1;j<newFirstElement.length-1;++j){
				   newFirstElement[j] = Array.newInstance(newFirstElement.getClass().getComponentType().getComponentType(), Arrays.copyOf(lengths, i));
			   }
			   if(newFirstElement.length > 1){
				   if(isLast){
					   newFirstElement[newFirstElement.length-1] = Array.newInstance(newFirstElement.getClass().getComponentType().getComponentType(), lastDims[0][i]);
				   }else{
					   newFirstElement[newFirstElement.length-1] = Array.newInstance(newFirstElement.getClass().getComponentType().getComponentType(), Arrays.copyOf(lengths, i));
				   }
			   }
			   firstElement = newFirstElement;
		   }
		   this.elementData = (Object[]) Array.newInstance(arrayClasses[0], lastDims[0][0]);
		   this.elementData[0] = firstElement;
		   Object[] current = this.elementData;
		   for(int i=0;i<newDimension-2;++i){
			   if(current[current.length-1] == null){
				   current[current.length-1] = Array.newInstance(arrayClasses[i+1], lastDims[0][i+1]);
			   }
			   for(int j=1;j<((Object[]) current[current.length-1]).length-1;++j){
				   ((Object[]) current[current.length-1])[j] = Array.newInstance(arrayClasses[i+2], Arrays.copyOf(lengths, i));
			   }
			   current = (Object[]) current[current.length-1];
		   }
	   }else if(this.dimension > newDimension){
		   throw new IllegalArgumentException("The given capacity should be greater or equal the current capacity!");
	   }else{
		   int[] currentDims = new int[dimension];
		   Object[] current = this.elementData;
		   for(int i=0;i<dimension-1;++i){
			   currentDims[i] = current.length;
			   current = (Object[]) current[current.length-1];
		   }
		   this.elementData = Arrays.copyOf(this.elementData, lastDims[0][0]);
		   current = this.elementData;
		   for(int i=0;i<dimension-1;++i){
			   
			   for(int j=currentDims[i];j<lastDims[0][i]-1;++j){
				   current[j] = Array.newInstance(arrayClasses[i+1], Arrays.copyOf(lengths, i));
			   }
			   
			   if(lastDims[0][i] > 1){
				   current[current.length-1] = Array.newInstance(arrayClasses[i+1], lastDims[0][i+1]);
			   }else{
				   current[current.length-1] = Arrays.copyOf(((Object[]) current[0]), lastDims[0][i+1]);
			   }
		   }
	   }
	   this.dimension = newDimension;
	   capacity = minCapacity;
	   return elementData;
   }

   private Object[] grow() {
       return grow(size.add(BigInteger.ONE));
   }
   
   /**
    * Returns a capacity at least as large as the given minimum capacity.
    * Returns the current capacity increased by 50% if that suffices.
    * Will not return a capacity greater than MAX_ARRAY_SIZE unless
    * the given minimum capacity is greater than MAX_ARRAY_SIZE.
    *
    * @param minCapacity the desired minimum capacity
    * @throws OutOfMemoryError if minCapacity is less than zero
    */
   private BigInteger newCapacity(BigInteger minCapacity) {
       // overflow-conscious code
	   BigInteger oldCapacity = capacity;
	   BigInteger newCapacity = oldCapacity.add((oldCapacity.shiftRight(1)));
       if (newCapacity.subtract(minCapacity).compareTo(BigInteger.ZERO) <= 0) {
           if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
               return DEFAULT_CAPACITY.max(minCapacity);
           return minCapacity;
       }
       return newCapacity;
   }

   /**
    * Returns the number of elements in this list.
    *
    * @return the number of elements in this list
    */
   public BigInteger size() {
       return size;
   }

   /**
    * Returns {@code true} if this list contains no elements.
    *
    * @return {@code true} if this list contains no elements
    */
   public boolean isEmpty() {
       return size.equals(BigInteger.ZERO);
   }

   /**
    * Returns {@code true} if this list contains the specified element.
    * More formally, returns {@code true} if and only if this list contains
    * at least one element {@code e} such that
    * {@code Objects.equals(o, e)}.
    *
    * @param o element whose presence in this list is to be tested
    * @return {@code true} if this list contains the specified element
    */
   public boolean contains(Object o) {
       return indexOf(o).compareTo(BigInteger.ZERO) >= 0;
   }

   /**
    * Returns the index of the first occurrence of the specified element
    * in this list, or -1 if this list does not contain the element.
    * More formally, returns the lowest index {@code i} such that
    * {@code Objects.equals(o, get(i))},
    * or -1 if there is no such index.
    */
   public BigInteger indexOf(Object o) {
       return indexOfRange(o, BigInteger.ZERO, size);
   }
   
   BigInteger indexOfRange(Object o, BigInteger start, BigInteger end) {
       if (o == null) {
    	   BigListIterator<E> it = listIterator(start);
    	   BigInteger index = start;
           while(it.hasNext() && index.compareTo(end) < 0){
               if (it.next() == null) {
                   return index;
               }
               index = index.add(BigInteger.ONE);
           }
       } else {
    	   BigListIterator<E> it = listIterator(start);
    	   BigInteger index = start;
           while(it.hasNext() && index.compareTo(end) < 0){
        	   if (o.equals(it.next())) {
                   return index;
               }
               index = index.add(BigInteger.ONE);
           }
       }
       return BigInteger.valueOf(-1);
   }

   /**
    * Returns the index of the last occurrence of the specified element
    * in this list, or -1 if this list does not contain the element.
    * More formally, returns the highest index {@code i} such that
    * {@code Objects.equals(o, get(i))},
    * or -1 if there is no such index.
    */
   public BigInteger lastIndexOf(Object o) {
       return lastIndexOfRange(o, BigInteger.ZERO, size);
   }

   BigInteger lastIndexOfRange(Object o, BigInteger start, BigInteger end) {
	   if (o == null) {
    	   BigListIterator<E> it = listIterator(end.subtract(BigInteger.ONE));
    	   BigInteger index = end.subtract(BigInteger.ONE);
           while(it.hasPrevious() && index.compareTo(start) >= 0){
               if (it.previous() == null) {
                   return index;
               }
               index = index.subtract(BigInteger.ONE);
           }
       } else {
    	   BigListIterator<E> it = listIterator(end.subtract(BigInteger.ONE));
    	   BigInteger index = end.subtract(BigInteger.ONE);
           while(it.hasPrevious() && index.compareTo(start) >= 0){
        	   if (o.equals(it.previous())) {
                   return index;
               }
               index = index.subtract(BigInteger.ONE);
           }
       }
       return BigInteger.valueOf(-1);
   }

   /**
    * Returns a shallow copy of this {@code ArrayList} instance.  (The
    * elements themselves are not copied.)
    *
    * @return a clone of this {@code ArrayList} instance
    */
   public Object clone() {
       try {
           @SuppressWarnings("unchecked")
		ArrayBigList<E> v = (ArrayBigList<E>) super.clone();
           
           if(this.dimension == 1){
               v.elementData = Arrays.copyOf(elementData, size.intValue());
           }else if(this.dimension == 2){
        	   v.elementData = (Object[]) Array.newInstance(elementData[0].getClass().componentType(), elementData.length);
        	   for(int i=0;i<elementData.length;++i){
        		   v.elementData[i] = Arrays.copyOf((Object[]) elementData[i], ((Object[]) elementData[i]).length);
        	   }
           }else{
        	   v.elementData = createContainer(this.size);
        	   BigListIterator<E> vIt = v.listIterator();
        	   for(E elem : this){
        		   vIt.next();
        		   vIt.set(elem);
        	   }
           }
           v.modCount = 0;
           return v;
       } catch (CloneNotSupportedException e) {
           // this shouldn't happen, since we are Cloneable
           throw new InternalError(e);
       }
   }

   // Positional Access Operations

   @SuppressWarnings("unchecked")
   E elementData(BigInteger index) {
	   int[] position = indexPosition(index, dimension);
	   Object ret = elementData;
	   for(int i=0;i<dimension;++i){
		   ret = ((Object[]) ret)[position[i]];
	   }
       return (E) ret;
   }
   
   @SuppressWarnings("unchecked")
   E elementData(int[] position) {
	   Object ret = elementData;
	   for(int i=0;i<dimension;++i){
		   ret = ((Object[]) ret)[position[i]];
	   }
       return (E) ret;
   }

   @SuppressWarnings("unchecked")
   static <E> E elementAt(Object[] es, BigInteger index, int dimension) {
	   int[] position = indexPosition(index, dimension);
	   Object ret = es;
	   for(int i=0;i<dimension;++i){
		   ret = ((Object[]) ret)[position[i]];
	   }
       return (E) ret;
   }
   
   static int[] indexPosition(BigInteger index, int dimension){
	   int[] ret = new int[dimension];
	   int[][] lastDims = new int[1][];
	   int indexDimension = calculateDimension(index, lastDims);
	   int currentIndex = 0;
	   for(int i=0;i<(dimension-indexDimension);++i){
		   ret[currentIndex] = 0;
		   currentIndex++;
	   }
	   for(int i=0;i<indexDimension;++i){
		   ret[currentIndex] = lastDims[0][i];
		   currentIndex++;
	   }
	   return ret;
   }

   /**
    * Returns the element at the specified position in this list.
    *
    * @param  index index of the element to return
    * @return the element at the specified position in this list
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E get(long index) {
       return get(BigInteger.valueOf(index));
   }
   
   /**
    * Returns the element at the specified position in this list.
    *
    * @param  index index of the element to return
    * @return the element at the specified position in this list
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E get(BigInteger index) {
       checkIndex(index, size);
       return elementData(index);
   }
   
   /**
    * Replaces the element at the specified position in this list with
    * the specified element.
    *
    * @param index index of the element to replace
    * @param element element to be stored at the specified position
    * @return the element previously at the specified position
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E set(long index, E element) {
      return set(BigInteger.valueOf(index), element);
   }

   /**
    * Replaces the element at the specified position in this list with
    * the specified element.
    *
    * @param index index of the element to replace
    * @param element element to be stored at the specified position
    * @return the element previously at the specified position
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E set(BigInteger index, E element) {
       checkIndex(index, capacity);
       int[] position = indexPosition(index, dimension);
       E oldValue = elementData(position);
       Object[] current = elementData;
       for(int i=0;i<dimension-1;++i){
    	   current = (Object[]) current[position[i]];
       }
       current[position[dimension-1]] = element;
       return oldValue;
   }

   /**
    * This helper method split out from add(E) to keep method
    * bytecode size under 35 (the -XX:MaxInlineSize default value),
    * which helps when add(E) is called in a C1-compiled loop.
    */
   private void add(E e, Object[] elementData, BigInteger s) {
       if (s.equals(capacity)){
           elementData = grow();
       }
       set(s, e);
       size = s.add(BigInteger.ONE);
       capacity = size;
   }

   /**
    * Appends the specified element to the end of this list.
    *
    * @param e element to be appended to this list
    * @return {@code true} (as specified by {@link Collection#add})
    */
   public boolean add(E e) {
       modCount++;
       add(e, elementData, size);
       return true;
   }
   
   /**
    * Inserts the specified element at the specified position in this
    * list. Shifts the element currently at that position (if any) and
    * any subsequent elements to the right (adds one to their indices).
    *
    * @param index index at which the specified element is to be inserted
    * @param element element to be inserted
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public void add(long index, E element) {
       add(BigInteger.valueOf(index), element);
   }

   /**
    * Inserts the specified element at the specified position in this
    * list. Shifts the element currently at that position (if any) and
    * any subsequent elements to the right (adds one to their indices).
    *
    * @param index index at which the specified element is to be inserted
    * @param element element to be inserted
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public void add(BigInteger index, E element) {
       rangeCheckForAdd(index);
       modCount++;
       final BigInteger s;
       s = size;
       if (s.equals(capacity))
           elementData = grow();
       BigListIterator<E> it = listIterator(index);
       BigListIterator<E> it2 = listIterator(index.add(BigInteger.ONE));
       while(it2.hasNext()){
    	   it.next();
    	   it.set(it2.next());
       }
       set(index, element);
       size = s.add(BigInteger.ONE);
       capacity = size;
   }
   
   /**
    * Removes the element at the specified position in this list.
    * Shifts any subsequent elements to the left (subtracts one from their
    * indices).
    *
    * @param index the index of the element to be removed
    * @return the element that was removed from the list
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E remove(long index) {
      return remove(BigInteger.valueOf(index));
   }

   /**
    * Removes the element at the specified position in this list.
    * Shifts any subsequent elements to the left (subtracts one from their
    * indices).
    *
    * @param index the index of the element to be removed
    * @return the element that was removed from the list
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E remove(BigInteger index) {
       checkIndex(index, size);
       final Object[] es = elementData;

       E oldValue = (E) get(index);
       fastRemove(es, index);

       return oldValue;
   }

   /**
    * {@inheritDoc}
    */
   public boolean equals(Object o) {
       if (o == this) {
           return true;
       }

       if (!(o instanceof BigList)) {
           return false;
       }

       final int expectedModCount = modCount;
       // ArrayList can be subclassed and given arbitrary behavior, but we can
       // still deal with the common case where o is ArrayList precisely
       boolean equal = (o.getClass() == ArrayBigList.class)
           ? equalsArrayList((ArrayBigList<?>) o)
           : equalsRange((BigList<?>) o, BigInteger.ZERO, size, capacity);

       checkForComodification(expectedModCount);
       return equal;
   }

   boolean equalsRange(BigList<?> other, BigInteger from, BigInteger to, BigInteger capacity) {
       if (to.compareTo(capacity) > 0) {
           throw new ConcurrentModificationException();
       }
       Iterator<?> oit = other.iterator();
       BigListIterator<E> it = listIterator(from);
       BigInteger index = from;
       while(it.hasNext() && index.compareTo(to) < 0){
           if (!oit.hasNext() || !Objects.equals(it.next(), oit.next())) {
               return false;
           }
           index = index.add(BigInteger.ONE);
       }
       return !oit.hasNext();
   }

   private boolean equalsArrayList(ArrayBigList<?> other) {
       final int otherModCount = other.modCount;
       final BigInteger s = size;
       boolean equal;
       if (equal = (s == other.size)) {
           if (s.compareTo(capacity) > 0 || s.compareTo(other.capacity) > 0) {
               throw new ConcurrentModificationException();
           }
           Iterator<?> oit = other.iterator();
           for (E elem : this) {
               if (!Objects.equals(elem, oit.next())) {
                   equal = false;
                   break;
               }
           }
       }
       other.checkForComodification(otherModCount);
       return equal;
   }

   private void checkForComodification(final int expectedModCount) {
       if (modCount != expectedModCount) {
           throw new ConcurrentModificationException();
       }
   }

   /**
    * {@inheritDoc}
    */
   public int hashCode() {
       int expectedModCount = modCount;
       int hash = hashCodeRange(BigInteger.ZERO, size);
       checkForComodification(expectedModCount);
       return hash;
   }

   int hashCodeRange(BigInteger from, BigInteger to) {
       if (to.compareTo(capacity) > 0) {
           throw new ConcurrentModificationException();
       }
       int hashCode = 1;
       BigListIterator<E> it = listIterator(from);
       BigInteger index = to;
       while(it.hasNext() && index.compareTo(to) < 0){
           Object e = it.next();
           hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
           index = index.add(BigInteger.ONE);
       }
       return hashCode;
   }

   /**
    * Removes the first occurrence of the specified element from this list,
    * if it is present.  If the list does not contain the element, it is
    * unchanged.  More formally, removes the element with the lowest index
    * {@code i} such that
    * {@code Objects.equals(o, get(i))}
    * (if such an element exists).  Returns {@code true} if this list
    * contained the specified element (or equivalently, if this list
    * changed as a result of the call).
    *
    * @param o element to be removed from this list, if present
    * @return {@code true} if this list contained the specified element
    */
   public boolean remove(Object o) {
       final Object[] es = elementData;
       BigInteger i = BigInteger.ZERO;
       found: {
           if (o == null) {
               for (E elem: this){
                   if (elem == null)
                       break found;
                   i = i.add(BigInteger.ONE);
               }
           } else {
        	   for (E elem: this){
                   if (o.equals(elem))
                       break found;
                   i = i.add(BigInteger.ONE);
        	   }
           }
           return false;
       }
       fastRemove(es, i);
       return true;
   }

   /**
    * Private remove method that skips bounds checking and does not
    * return the value removed.
    */
   private void fastRemove(Object[] es, BigInteger i) {
       modCount++;
       final BigInteger newSize = size.subtract(BigInteger.ONE);
       if (newSize.compareTo(i) > 0){
           BigListIterator<E> it = listIterator(i);
           it.next();
           while(it.hasNext()){
        	  it.set(it.next()); 
           }
       }
       set(size, null);
       size = newSize;
   }

   /**
    * Removes all of the elements from this list.  The list will
    * be empty after this call returns.
    */
   public void clear() {
       modCount++;
       final Object[] es = elementData;
       if(dimension == 1){
    	   for (int to = size.intValue(), i = 0; i < to; i++)
               es[i] = null;
       }else{
    	   Iterator<E> it = iterator();
    	   while(it.hasNext()){
    		   it.remove();
    	   }
       }
       size = BigInteger.ZERO;
   }

   /**
    * Appends all of the elements in the specified collection to the end of
    * this list, in the order that they are returned by the
    * specified collection's Iterator.  The behavior of this operation is
    * undefined if the specified collection is modified while the operation
    * is in progress.  (This implies that the behavior of this call is
    * undefined if the specified collection is this list, and this
    * list is nonempty.)
    *
    * @param c collection containing elements to be added to this list
    * @return {@code true} if this list changed as a result of the call
    * @throws NullPointerException if the specified collection is null
    */
   public boolean addAll(Collection<? extends E> c) {
       Object[] a = c.toArray();
       modCount++;
       int numNew = a.length;
       if (numNew == 0)
           return false;
       final BigInteger s = size;
       BigInteger grow = BigInteger.valueOf(numNew).subtract(capacity.subtract(size));
       if(grow.compareTo(BigInteger.ZERO) > 0){
    	   grow(grow);
       }
       int[] position = indexPosition(size, dimension);
       if((MAX_ARRAY_SIZE - position[position.length-1]) < numNew){
    	   int newIndex = numNew-(MAX_ARRAY_SIZE - position[position.length-1]);
    	   Object[] current = elementData;
    	   for(int i=0;i<dimension-1;++i){
    		   current = (Object[]) current[position[i]];
    	   }
    	   System.arraycopy(current, position[position.length-1], a, 0, newIndex);
    	   position = indexPosition(BigInteger.valueOf(newIndex), dimension);
    	   current = elementData;
    	   for(int i=0;i<dimension-1;++i){
    		   current = (Object[]) current[position[i]];
    	   }
    	   System.arraycopy(current, position[position.length-1], a, newIndex, numNew-newIndex);
       }else{
    	   Object[] current = elementData;
    	   for(int i=0;i<dimension-1;++i){
    		   current = (Object[]) current[position[i]];
    	   }
    	   System.arraycopy(current, position[position.length-1], a, 0, numNew);
       }
       size = s.add(BigInteger.valueOf(numNew));
       return true;
   }
   
   /**
    * Appends all of the elements in the specified collection to the end of
    * this list, in the order that they are returned by the
    * specified collection's Iterator.  The behavior of this operation is
    * undefined if the specified collection is modified while the operation
    * is in progress.  (This implies that the behavior of this call is
    * undefined if the specified collection is this list, and this
    * list is nonempty.)
    *
    * @param c collection containing elements to be added to this list
    * @return {@code true} if this list changed as a result of the call
    * @throws NullPointerException if the specified collection is null
    */
   public boolean addAll(BigCollection<? extends E> c) {
       modCount++;
       BigInteger numNew = c.size();
       if (numNew.equals(BigInteger.ZERO))
           return false;
       final BigInteger s = size;
       BigInteger grow = numNew.subtract(capacity.subtract(size));
       if(grow.compareTo(BigInteger.ZERO) > 0){
    	   grow(grow);
       }
       BigListIterator<E> it = listIterator(s);
       for(E elem : c){
    	   it.next();
    	   it.set(elem);
       }
       size = s.add(numNew);
       return true;
   }

   /**
    * Inserts all of the elements in the specified collection into this
    * list, starting at the specified position.  Shifts the element
    * currently at that position (if any) and any subsequent elements to
    * the right (increases their indices).  The new elements will appear
    * in the list in the order that they are returned by the
    * specified collection's iterator.
    *
    * @param index index at which to insert the first element from the
    *              specified collection
    * @param c collection containing elements to be added to this list
    * @return {@code true} if this list changed as a result of the call
    * @throws IndexOutOfBoundsException {@inheritDoc}
    * @throws NullPointerException if the specified collection is null
    */
   public boolean addAll(long index, Collection<? extends E> c) {
      return addAll(BigInteger.valueOf(index), c);
   }
   
   /**
    * Inserts all of the elements in the specified collection into this
    * list, starting at the specified position.  Shifts the element
    * currently at that position (if any) and any subsequent elements to
    * the right (increases their indices).  The new elements will appear
    * in the list in the order that they are returned by the
    * specified collection's iterator.
    *
    * @param index index at which to insert the first element from the
    *              specified collection
    * @param c collection containing elements to be added to this list
    * @return {@code true} if this list changed as a result of the call
    * @throws IndexOutOfBoundsException {@inheritDoc}
    * @throws NullPointerException if the specified collection is null
    */
   public boolean addAll(BigInteger index, Collection<? extends E> c) {
       rangeCheckForAdd(index);

       Object[] a = c.toArray();
       modCount++;
       int numNew = a.length;
       BigInteger numNewBig = BigInteger.valueOf(numNew);
       if (numNew == 0)
           return false;
       final BigInteger s = size;
       BigInteger grow = BigInteger.valueOf(numNew).subtract(capacity.subtract(size));
       if(grow.compareTo(BigInteger.ZERO) > 0){
    	   grow(grow);
       }
	   for(BigInteger i = index; i.compareTo(s) < 0; i = i.add(BigInteger.ONE)){
		   set(i.add(numNewBig),get(i));
	   }
       int[] position = indexPosition(index, dimension);
       if((MAX_ARRAY_SIZE - position[position.length-1]) < numNew){
    	   int newIndex = numNew-(MAX_ARRAY_SIZE - position[position.length-1]);
    	   Object[] current = elementData;
    	   for(int i=0;i<dimension-1;++i){
    		   current = (Object[]) current[position[i]];
    	   }
    	   System.arraycopy(current, position[position.length-1], a, 0, newIndex);
    	   position = indexPosition(BigInteger.valueOf(newIndex), dimension);
    	   current = elementData;
    	   for(int i=0;i<dimension-1;++i){
    		   current = (Object[]) current[position[i]];
    	   }
    	   System.arraycopy(current, position[position.length-1], a, newIndex, numNew-newIndex);
       }else{
    	   Object[] current = elementData;
    	   for(int i=0;i<dimension-1;++i){
    		   current = (Object[]) current[position[i]];
    	   }
    	   System.arraycopy(current, position[position.length-1], a, 0, numNew);
       }
       size = s.add(BigInteger.valueOf(numNew));
       return true;
   }
   
   /**
    * Inserts all of the elements in the specified collection into this
    * list, starting at the specified position.  Shifts the element
    * currently at that position (if any) and any subsequent elements to
    * the right (increases their indices).  The new elements will appear
    * in the list in the order that they are returned by the
    * specified collection's iterator.
    *
    * @param index index at which to insert the first element from the
    *              specified collection
    * @param c collection containing elements to be added to this list
    * @return {@code true} if this list changed as a result of the call
    * @throws IndexOutOfBoundsException {@inheritDoc}
    * @throws NullPointerException if the specified collection is null
    */
   public boolean addAll(long index, BigCollection<? extends E> c) {
       return addAll(BigInteger.valueOf(index), c);
   }
   
   /**
    * Inserts all of the elements in the specified collection into this
    * list, starting at the specified position.  Shifts the element
    * currently at that position (if any) and any subsequent elements to
    * the right (increases their indices).  The new elements will appear
    * in the list in the order that they are returned by the
    * specified collection's iterator.
    *
    * @param index index at which to insert the first element from the
    *              specified collection
    * @param c collection containing elements to be added to this list
    * @return {@code true} if this list changed as a result of the call
    * @throws IndexOutOfBoundsException {@inheritDoc}
    * @throws NullPointerException if the specified collection is null
    */
   public boolean addAll(BigInteger index, BigCollection<? extends E> c) {
       rangeCheckForAdd(index);

       modCount++;
       BigInteger numNew = c.size();
       if (numNew.equals(BigInteger.ZERO))
           return false;
       final BigInteger s = size;
       BigInteger grow = numNew.subtract(capacity.subtract(size));
       if(grow.compareTo(BigInteger.ZERO) > 0){
    	   grow(grow);
       }
       for(BigInteger i = index; i.compareTo(s) < 0; i = i.add(BigInteger.ONE)){
		   set(i.add(numNew),get(i));
	   }
       BigListIterator<E> it = listIterator(s);
       for(E elem : c){
    	   it.next();
    	   it.set(elem);
       }
       size = s.add(numNew);
       return true;
   }

   /**
    * Removes from this list all of the elements whose index is between
    * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
    * Shifts any succeeding elements to the left (reduces their index).
    * This call shortens the list by {@code (toIndex - fromIndex)} elements.
    * (If {@code toIndex==fromIndex}, this operation has no effect.)
    *
    * @throws IndexOutOfBoundsException if {@code fromIndex} or
    *         {@code toIndex} is out of range
    *         ({@code fromIndex < 0 ||
    *          toIndex > size() ||
    *          toIndex < fromIndex})
    */
   protected void removeRange(BigInteger fromIndex, BigInteger toIndex) {
       if (fromIndex.compareTo(toIndex) > 0) {
           throw new IndexOutOfBoundsException(
                   outOfBoundsMsg(fromIndex, toIndex));
       }
       modCount++;
       shiftTailOverGap(fromIndex, toIndex);
   }

   /** Erases the gap from lo to hi, by sliding down following elements. */
   private void shiftTailOverGap(BigInteger lo, BigInteger hi) {
	   BigInteger dif = hi.subtract(lo);
	   for(BigInteger i = lo; i.compareTo(hi) < 0; i = i.add(BigInteger.ONE)){
		   set(i,get(i.add(dif)));
	   }
   }

   /**
    * A version of rangeCheck used by add and addAll.
    */
   private void rangeCheckForAdd(BigInteger index) {
       if (index.compareTo(size) > 0 || index.compareTo(BigInteger.ZERO) < 0)
           throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
   }

   /**
    * Constructs an IndexOutOfBoundsException detail message.
    * Of the many possible refactorings of the error handling code,
    * this "outlining" performs best with both server and client VMs.
    */
   private String outOfBoundsMsg(BigInteger index) {
       return "Index: "+index+", Size: "+size;
   }

   /**
    * A version used in checking (fromIndex > toIndex) condition
    */
   private static String outOfBoundsMsg(BigInteger fromIndex, BigInteger toIndex) {
       return "From Index: " + fromIndex + " > To Index: " + toIndex;
   }

   /**
    * Removes from this list all of its elements that are contained in the
    * specified collection.
    *
    * @param c collection containing elements to be removed from this list
    * @return {@code true} if this list changed as a result of the call
    * @throws ClassCastException if the class of an element of this list
    *         is incompatible with the specified collection
    * (<a href="Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if this list contains a null element and the
    *         specified collection does not permit null elements
    * (<a href="Collection.html#optional-restrictions">optional</a>),
    *         or if the specified collection is null
    * @see Collection#contains(Object)
    */
   public boolean removeAll(Collection<?> c) {
       return batchRemove(c, false, BigInteger.ZERO, size);
   }

   /**
    * Removes from this list all of its elements that are contained in the
    * specified collection.
    *
    * @param c collection containing elements to be removed from this list
    * @return {@code true} if this list changed as a result of the call
    * @throws ClassCastException if the class of an element of this list
    *         is incompatible with the specified collection
    * (<a href="Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if this list contains a null element and the
    *         specified collection does not permit null elements
    * (<a href="Collection.html#optional-restrictions">optional</a>),
    *         or if the specified collection is null
    * @see Collection#contains(Object)
    */
   public boolean removeAll(BigCollection<?> c) {
       return batchRemove(c, false, BigInteger.ZERO, size);
   }

   
   /**
    * Retains only the elements in this list that are contained in the
    * specified collection.  In other words, removes from this list all
    * of its elements that are not contained in the specified collection.
    *
    * @param c collection containing elements to be retained in this list
    * @return {@code true} if this list changed as a result of the call
    * @throws ClassCastException if the class of an element of this list
    *         is incompatible with the specified collection
    * (<a href="Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if this list contains a null element and the
    *         specified collection does not permit null elements
    * (<a href="Collection.html#optional-restrictions">optional</a>),
    *         or if the specified collection is null
    * @see Collection#contains(Object)
    */
   public boolean retainAll(Collection<?> c) {
       return batchRemove(c, true, BigInteger.ZERO, size);
   }
   
   /**
    * Retains only the elements in this list that are contained in the
    * specified collection.  In other words, removes from this list all
    * of its elements that are not contained in the specified collection.
    *
    * @param c collection containing elements to be retained in this list
    * @return {@code true} if this list changed as a result of the call
    * @throws ClassCastException if the class of an element of this list
    *         is incompatible with the specified collection
    * (<a href="Collection.html#optional-restrictions">optional</a>)
    * @throws NullPointerException if this list contains a null element and the
    *         specified collection does not permit null elements
    * (<a href="Collection.html#optional-restrictions">optional</a>),
    *         or if the specified collection is null
    * @see Collection#contains(Object)
    */
   public boolean retainAll(BigCollection<?> c) {
       return batchRemove(c, true, BigInteger.ZERO, size);
   }

   boolean batchRemove(Collection<?> c, boolean complement,
                       final BigInteger from, final BigInteger end) {
       Objects.requireNonNull(c);
       BigInteger r;
       // Optimize for initial run of survivors
       for (r = from;; r = r.add(BigInteger.ONE)) {
           if (r.equals(end))
               return false;
           if (c.contains(get(r)) != complement)
               break;
       }
	   BigListIterator<E>it = listIterator(r);
	   while(it.hasNext()){
		   E next = it.next();
		   if (c.contains(next) == complement)
               it.remove();
	   }
       return true;
   }
   
   boolean batchRemove(BigCollection<?> c, boolean complement,
		   final BigInteger from, final BigInteger end) {
	   Objects.requireNonNull(c);
       BigInteger r;
       // Optimize for initial run of survivors
       for (r = from;; r = r.add(BigInteger.ONE)) {
           if (r.equals(end))
               return false;
           if (c.contains(get(r)) != complement)
               break;
       }
	   BigListIterator<E>it = listIterator(r);
	   while(it.hasNext()){
		   E next = it.next();
		   if (c.contains(next) == complement)
               it.remove();
	   }
       return true;
   }

   /**
    * Returns a list iterator over the elements in this list (in proper
    * sequence), starting at the specified position in the list.
    * The specified index indicates the first element that would be
    * returned by an initial call to {@link ListIterator#next next}.
    * An initial call to {@link ListIterator#previous previous} would
    * return the element with the specified index minus one.
    *
    * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
    *
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public BigListIterator<E> listIterator(BigInteger index) {
       rangeCheckForAdd(index);
       return new ListItr(index);
   }

   /**
    * Returns a list iterator over the elements in this list (in proper
    * sequence).
    *
    * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
    *
    * @see #listIterator(int)
    */
   public BigListIterator<E> listIterator() {
       return new ListItr(BigInteger.ZERO);
   }

   /**
    * Returns an iterator over the elements in this list in proper sequence.
    *
    * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
    *
    * @return an iterator over the elements in this list in proper sequence
    */
   public Iterator<E> iterator() {
       return new Itr();
   }

   /**
    * An optimized version of AbstractList.Itr
    */
   private class Itr implements Iterator<E> {
	   BigInteger cursor = BigInteger.ZERO;       // index of next element to return
       BigInteger lastRet = BigInteger.valueOf(-1); // index of last element returned; -1 if no such
       int expectedModCount = modCount;

       // prevent creating a synthetic constructor
       Itr() {}

       public boolean hasNext() {
           return !cursor.equals(size);
       }

       public E next() {
           checkForComodification();
           BigInteger i = cursor;
           if (i.compareTo(size) >= 0)
               throw new NoSuchElementException();
           cursor = i.add(BigInteger.ONE);
           return (E) get(i);
       }

       public void remove() {
           if (lastRet.compareTo(BigInteger.ZERO) < 0)
               throw new IllegalStateException();
           checkForComodification();

           try {
               ArrayBigList.this.remove(lastRet);
               cursor = lastRet;
               lastRet = BigInteger.valueOf(-1);
               expectedModCount = modCount;
           } catch (IndexOutOfBoundsException ex) {
               throw new ConcurrentModificationException();
           }
       }

       @Override
       public void forEachRemaining(Consumer<? super E> action) {
           Objects.requireNonNull(action);
           final BigInteger size = ArrayBigList.this.size;
           BigInteger i = cursor;
           if (i.compareTo(size) < 0) {
               while(hasNext())
                   action.accept(next());
           }
       }

       final void checkForComodification() {
           if (modCount != expectedModCount)
               throw new ConcurrentModificationException();
       }
   }

   /**
    * An optimized version of AbstractList.ListItr
    */
   private class ListItr extends Itr implements BigListIterator<E> {
       ListItr(BigInteger index) {
           super();
           cursor = index;
       }

       public boolean hasPrevious() {
           return !cursor.equals(BigInteger.ZERO);
       }

       public BigInteger nextIndex() {
           return cursor;
       }

       public BigInteger previousIndex() {
           return cursor.subtract(BigInteger.ONE);
       }

       public E previous() {
           checkForComodification();
           BigInteger i = cursor.subtract(BigInteger.ONE);
           if (i.compareTo(BigInteger.ZERO) < 0)
               throw new NoSuchElementException();
           
           cursor = i;
           lastRet = i;
           return (E) get(i);
       }

       public void set(E e) {
           if (lastRet.compareTo(BigInteger.ZERO) < 0)
               throw new IllegalStateException();
           checkForComodification();

           try {
               ArrayBigList.this.set(lastRet, e);
           } catch (IndexOutOfBoundsException ex) {
               throw new ConcurrentModificationException();
           }
       }

       public void add(E e) {
           checkForComodification();

           try {
        	   BigInteger i = cursor;
               ArrayBigList.this.add(i, e);
               cursor = i.add(BigInteger.ONE);
               lastRet = BigInteger.valueOf(-1);
               expectedModCount = modCount;
           } catch (IndexOutOfBoundsException ex) {
               throw new ConcurrentModificationException();
           }
       }
   }
   
   /**
    * Returns a view of the portion of this list between the specified
    * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
    * {@code fromIndex} and {@code toIndex} are equal, the returned list is
    * empty.)  The returned list is backed by this list, so non-structural
    * changes in the returned list are reflected in this list, and vice-versa.
    * The returned list supports all of the optional list operations.
    *
    * <p>This method eliminates the need for explicit range operations (of
    * the sort that commonly exist for arrays).  Any operation that expects
    * a list can be used as a range operation by passing a subList view
    * instead of a whole list.  For example, the following idiom
    * removes a range of elements from a list:
    * <pre>
    *      list.subList(from, to).clear();
    * </pre>
    * Similar idioms may be constructed for {@link #indexOf(Object)} and
    * {@link #lastIndexOf(Object)}, and all of the algorithms in the
    * {@link Collections} class can be applied to a subList.
    *
    * <p>The semantics of the list returned by this method become undefined if
    * the backing list (i.e., this list) is <i>structurally modified</i> in
    * any way other than via the returned list.  (Structural modifications are
    * those that change the size of this list, or otherwise perturb it in such
    * a fashion that iterations in progress may yield incorrect results.)
    *
    * @throws IndexOutOfBoundsException {@inheritDoc}
    * @throws IllegalArgumentException {@inheritDoc}
    */
   public BigList<E> subList(long fromIndex, long toIndex) {
       return subList(BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
   }

   /**
    * Returns a view of the portion of this list between the specified
    * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
    * {@code fromIndex} and {@code toIndex} are equal, the returned list is
    * empty.)  The returned list is backed by this list, so non-structural
    * changes in the returned list are reflected in this list, and vice-versa.
    * The returned list supports all of the optional list operations.
    *
    * <p>This method eliminates the need for explicit range operations (of
    * the sort that commonly exist for arrays).  Any operation that expects
    * a list can be used as a range operation by passing a subList view
    * instead of a whole list.  For example, the following idiom
    * removes a range of elements from a list:
    * <pre>
    *      list.subList(from, to).clear();
    * </pre>
    * Similar idioms may be constructed for {@link #indexOf(Object)} and
    * {@link #lastIndexOf(Object)}, and all of the algorithms in the
    * {@link Collections} class can be applied to a subList.
    *
    * <p>The semantics of the list returned by this method become undefined if
    * the backing list (i.e., this list) is <i>structurally modified</i> in
    * any way other than via the returned list.  (Structural modifications are
    * those that change the size of this list, or otherwise perturb it in such
    * a fashion that iterations in progress may yield incorrect results.)
    *
    * @throws IndexOutOfBoundsException {@inheritDoc}
    * @throws IllegalArgumentException {@inheritDoc}
    */
   public BigList<E> subList(BigInteger fromIndex, BigInteger toIndex) {
       subListRangeCheck(fromIndex, toIndex, size);
       return new SubBigList<>(this, fromIndex, toIndex);
   }

   private static class SubBigList<E> extends AbstractBigList<E> implements RandomAccess {
       private final ArrayBigList<E> root;
       private final SubBigList<E> parent;
       private final BigInteger offset;
       private BigInteger size;

       /**
        * Constructs a sublist of an arbitrary ArrayList.
        */
       public SubBigList(ArrayBigList<E> root, BigInteger fromIndex, BigInteger toIndex) {
           this.root = root;
           this.parent = null;
           this.offset = fromIndex;
           this.size = toIndex.subtract(fromIndex);
           this.modCount = root.modCount;
       }

       /**
        * Constructs a sublist of another SubList.
        */
       private SubBigList(SubBigList<E> parent, BigInteger fromIndex, BigInteger toIndex) {
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
           E oldValue = root.elementData(offset.add(index));
           root.set(offset.add(index), element);
           return oldValue;
       }
       
       public E get(long index) {
           return get(BigInteger.valueOf(index));
       }

       public E get(BigInteger index) {
           checkIndex(index, size);
           checkForComodification();
           return root.elementData(offset.add(index));
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
           return addAll(this.size, c);
       }
       
       public boolean addAll(BigCollection<? extends E> c) {
           return addAll(this.size, c);
       }
       
       public boolean addAll(long index, Collection<? extends E> c) {
           return addAll(BigInteger.valueOf(index), c);
       }

       public boolean addAll(BigInteger index, Collection<? extends E> c) {
           rangeCheckForAdd(index);
           int cSize = c.size();
           if (cSize==0)
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

       public void replaceAll(UnaryOperator<E> operator) {
           root.replaceAllRange(operator, offset, offset.add(size));
       }

       public boolean removeAll(Collection<?> c) {
           return batchRemove(c, false);
       }
       
       public boolean removeAll(BigCollection<?> c) {
           return batchRemove(c, false);
       }

       public boolean retainAll(Collection<?> c) {
           return batchRemove(c, true);
       }
       
       public boolean retainAll(BigCollection<?> c) {
           return batchRemove(c, true);
       }

       private boolean batchRemove(Collection<?> c, boolean complement) {
           checkForComodification();
           BigInteger oldSize = root.size;
           boolean modified =
               root.batchRemove(c, complement, offset, offset.add(size));
           if (modified)
               updateSizeAndModCount(root.size.subtract(oldSize));
           return modified;
       }
       
       private boolean batchRemove(BigCollection<?> c, boolean complement) {
           checkForComodification();
           BigInteger oldSize = root.size;
           boolean modified =
               root.batchRemove(c, complement, offset, offset.add(size));
           if (modified)
               updateSizeAndModCount(root.size.subtract(oldSize));
           return modified;
       }

       public boolean removeIf(Predicate<? super E> filter) {
           checkForComodification();
           BigInteger oldSize = root.size;
           boolean modified = root.removeIf(filter, offset, offset.add(size));
           if (modified)
               updateSizeAndModCount(root.size.subtract(oldSize));
           return modified;
       }

       public boolean equals(Object o) {
           if (o == this) {
               return true;
           }

           if (!(o instanceof BigList)) {
               return false;
           }

           boolean equal = root.equalsRange((BigList<?>)o, offset, offset.add(size), root.capacity);
           checkForComodification();
           return equal;
       }

       public int hashCode() {
           int hash = root.hashCodeRange(offset, offset.add(size));
           checkForComodification();
           return hash;
       }

       public BigInteger indexOf(Object o) {
    	   BigInteger index = root.indexOfRange(o, offset, offset.add(size));
           checkForComodification();
           return index.compareTo(BigInteger.ZERO) >= 0 ? index.subtract(offset) : BigInteger.valueOf(-1);
       }

       public BigInteger lastIndexOf(Object o) {
    	   BigInteger index = root.lastIndexOfRange(o, offset, offset.add(size));
           checkForComodification();
           return index.compareTo(BigInteger.ZERO) >= 0 ? index.subtract(offset) : BigInteger.valueOf(-1);
       }

       public boolean contains(Object o) {
           return indexOf(o).compareTo(BigInteger.ZERO) >= 0;
       }

       public Iterator<E> iterator() {
           return listIterator();
       }

       public BigListIterator<E> listIterator(BigInteger index) {
           checkForComodification();
           rangeCheckForAdd(index);

           return new BigListIterator<E>() {
        	   BigInteger cursor = index;
        	   BigInteger lastRet = BigInteger.valueOf(-1);
               int expectedModCount = root.modCount;

               public boolean hasNext() {
                   return cursor != SubBigList.this.size;
               }

               public E next() {
                   checkForComodification();
                   BigInteger i = cursor;
                   if (i.compareTo(SubBigList.this.size) >= 0)
                       throw new NoSuchElementException();
                   cursor = i.add(BigInteger.ONE);
                   lastRet = i;
                   return (E) root.get(offset.add(i));
               }

               public boolean hasPrevious() {
                   return !cursor.equals(BigInteger.ZERO);
               }

               public E previous() {
                   checkForComodification();
                   BigInteger i = cursor.subtract(BigInteger.ONE);
                   if (i.compareTo(BigInteger.ZERO) < 0)
                       throw new NoSuchElementException();
                   cursor = i;
                   lastRet = i;
                   return (E) root.get(offset.add(i));
               }

               public void forEachRemaining(Consumer<? super E> action) {
                   Objects.requireNonNull(action);
                   final BigInteger size = SubBigList.this.size;
                   BigInteger i = cursor;
                   if (i.compareTo(size) < 0) {
                       for (; i.compareTo(size) < 0 && modCount == expectedModCount; i = i.add(BigInteger.ONE))
                           action.accept(elementAt(root.elementData, offset.add(i), root.dimension));
                       // update once at end to reduce heap write traffic
                       cursor = i;
                       lastRet = i.subtract(BigInteger.ONE);
                       checkForComodification();
                   }
               }

               public BigInteger nextIndex() {
                   return cursor;
               }

               public BigInteger previousIndex() {
                   return cursor.subtract(BigInteger.ONE);
               }

               public void remove() {
                   if (lastRet.compareTo(BigInteger.ZERO) < 0)
                       throw new IllegalStateException();
                   checkForComodification();

                   try {
                       SubBigList.this.remove(lastRet);
                       cursor = lastRet;
                       lastRet = BigInteger.valueOf(-1);
                       expectedModCount = root.modCount;
                   } catch (IndexOutOfBoundsException ex) {
                       throw new ConcurrentModificationException();
                   }
               }

               public void set(E e) {
                   if (lastRet.compareTo(BigInteger.ZERO) < 0)
                       throw new IllegalStateException();
                   checkForComodification();

                   try {
                       root.set(offset.add(lastRet), e);
                   } catch (IndexOutOfBoundsException ex) {
                       throw new ConcurrentModificationException();
                   }
               }

               public void add(E e) {
                   checkForComodification();

                   try {
                	   BigInteger i = cursor;
                       SubBigList.this.add(i, e);
                       cursor = i.add(BigInteger.ONE);
                       lastRet = BigInteger.valueOf(-1);
                       expectedModCount = root.modCount;
                   } catch (IndexOutOfBoundsException ex) {
                       throw new ConcurrentModificationException();
                   }
               }

               final void checkForComodification() {
                   if (root.modCount != expectedModCount)
                       throw new ConcurrentModificationException();
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
           if (index.compareTo(BigInteger.ZERO) < 0 || index.compareTo(this.size) < 0)
               throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
       }

       private String outOfBoundsMsg(BigInteger index) {
           return "Index: "+index+", Size: "+this.size;
       }

       private void checkForComodification() {
           if (root.modCount != modCount)
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

       public Spliterator<E> spliterator() {
           checkForComodification();

           // ArrayListSpliterator not used here due to late-binding
           return new Spliterator<E>() {
               private BigInteger index = offset; // current index, modified on advance/split
               private BigInteger fence = BigInteger.valueOf(-1); // -1 until used; then one past last index
               private int expectedModCount; // initialized when fence set

               private BigInteger getFence() { // initialize fence to size on first use
            	   BigInteger hi; // (a specialized variant appears in method forEach)
                   hi = fence;
                   if (fence.compareTo(BigInteger.ZERO) < 0) {
                       expectedModCount = modCount;
                       hi = fence = offset.add(size);
                   }
                   return hi;
               }

               public ArrayBigList<E>.ArrayBigListSpliterator trySplit() {
            	   BigInteger hi = getFence(), lo = index, mid = (lo.add(hi)).multiply(BigInteger.TWO);
                   // ArrayListSpliterator can be used here as the source is already bound
                   return (lo.compareTo(mid) >= 0) ? null : // divide range in half unless too small
                       root.new ArrayBigListSpliterator(lo, index = mid, expectedModCount);
               }

               public boolean tryAdvance(Consumer<? super E> action) {
                   Objects.requireNonNull(action);
                   BigInteger hi = getFence(), i = index;
                   if (i.compareTo(hi) < 0) {
                       index = i.add(BigInteger.ONE);
                       E e = (E)root.get(i);
                       action.accept(e);
                       if (root.modCount != expectedModCount)
                           throw new ConcurrentModificationException();
                       return true;
                   }
                   return false;
               }

               public void forEachRemaining(Consumer<? super E> action) {
                   Objects.requireNonNull(action);
                   BigInteger i, hi; // hoist accesses and checks from loop
                   int mc;
                   ArrayBigList<E> lst = root;
                   if (lst.elementData != null) {
                       if ((hi = fence).compareTo(BigInteger.ZERO) < 0) {
                           mc = modCount;
                           hi = offset.add(size);
                       }
                       else
                           mc = expectedModCount;
                       if ((i = index).compareTo(BigInteger.ZERO) >= 0 && (index = hi).compareTo(lst.capacity) <= 0) {
                           for (; i.compareTo(hi) < 0; i = i.add(BigInteger.ONE)) {
                               E e = (E) lst.get(i);
                               action.accept(e);
                           }
                           if (lst.modCount == mc)
                               return;
                       }
                   }
                   throw new ConcurrentModificationException();
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
           };
       }

	@Override
	public void sort(Comparator<? super E> c) {
		throw new UnsupportedOperationException();
	}
   }

   /**
    * @throws NullPointerException {@inheritDoc}
    */
   @Override
   public void forEach(Consumer<? super E> action) {
       Objects.requireNonNull(action);
       final int expectedModCount = modCount;
       final BigInteger size = this.size;
       for (BigInteger i = BigInteger.ZERO; modCount == expectedModCount && i.compareTo(size) < 0; i = i.add(BigInteger.ONE))
           action.accept(elementAt(elementData, i, dimension));
       if (modCount != expectedModCount)
           throw new ConcurrentModificationException();
   }

   /**
    * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
    * and <em>fail-fast</em> {@link Spliterator} over the elements in this
    * list.
    *
    * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
    * {@link Spliterator#SUBSIZED}, and {@link Spliterator#ORDERED}.
    * Overriding implementations should document the reporting of additional
    * characteristic values.
    *
    * @return a {@code Spliterator} over the elements in this list
    * @since 1.8
    */
   @Override
   public Spliterator<E> spliterator() {
       return new ArrayBigListSpliterator(BigInteger.ZERO, BigInteger.valueOf(-1), 0);
   }

   /** Index-based split-by-two, lazily initialized Spliterator */
   final class ArrayBigListSpliterator implements Spliterator<E> {

       /*
        * If ArrayLists were immutable, or structurally immutable (no
        * adds, removes, etc), we could implement their spliterators
        * with Arrays.spliterator. Instead we detect as much
        * interference during traversal as practical without
        * sacrificing much performance. We rely primarily on
        * modCounts. These are not guaranteed to detect concurrency
        * violations, and are sometimes overly conservative about
        * within-thread interference, but detect enough problems to
        * be worthwhile in practice. To carry this out, we (1) lazily
        * initialize fence and expectedModCount until the latest
        * point that we need to commit to the state we are checking
        * against; thus improving precision.  (This doesn't apply to
        * SubLists, that create spliterators with current non-lazy
        * values).  (2) We perform only a single
        * ConcurrentModificationException check at the end of forEach
        * (the most performance-sensitive method). When using forEach
        * (as opposed to iterators), we can normally only detect
        * interference after actions, not before. Further
        * CME-triggering checks apply to all other possible
        * violations of assumptions for example null or too-small
        * elementData array given its size(), that could only have
        * occurred due to interference.  This allows the inner loop
        * of forEach to run without any further checks, and
        * simplifies lambda-resolution. While this does entail a
        * number of checks, note that in the common case of
        * list.stream().forEach(a), no checks or other computation
        * occur anywhere other than inside forEach itself.  The other
        * less-often-used methods cannot take advantage of most of
        * these streamlinings.
        */

       private BigInteger index; // current index, modified on advance/split
       private BigInteger fence; // -1 until used; then one past last index
       private int expectedModCount; // initialized when fence set

       /** Creates new spliterator covering the given range. */
       ArrayBigListSpliterator(BigInteger origin, BigInteger fence, int expectedModCount) {
           this.index = origin;
           this.fence = fence;
           this.expectedModCount = expectedModCount;
       }

       private BigInteger getFence() { // initialize fence to size on first use
    	   BigInteger hi; // (a specialized variant appears in method forEach)
           if ((hi = fence).compareTo(BigInteger.ZERO) < 0) {
               expectedModCount = modCount;
               hi = fence = size;
           }
           return hi;
       }

       public ArrayBigListSpliterator trySplit() {
    	   BigInteger hi = getFence(), lo = index, mid = (lo.add(hi)).multiply(BigInteger.TWO);
           return (lo.compareTo(mid) >= 0) ? null : // divide range in half unless too small
               new ArrayBigListSpliterator(lo, index = mid, expectedModCount);
       }

       public boolean tryAdvance(Consumer<? super E> action) {
           if (action == null)
               throw new NullPointerException();
           BigInteger hi = getFence(), i = index;
           if (i.compareTo(hi) < 0) {
               index = i.add(BigInteger.ONE);
               E e = (E)get(i);
               action.accept(e);
               if (modCount != expectedModCount)
                   throw new ConcurrentModificationException();
               return true;
           }
           return false;
       }

       public void forEachRemaining(Consumer<? super E> action) {
    	   BigInteger i, hi; // hoist accesses and checks from loop
    	   int mc;
           if (action == null)
               throw new NullPointerException();
           if (elementData != null) {
               if ((hi = fence).compareTo(BigInteger.ZERO) < 0) {
                   mc = modCount;
                   hi = size;
               }
               else
                   mc = expectedModCount;
               if ((i = index).compareTo(BigInteger.ZERO) >= 0 && (index = hi).compareTo(capacity) <= 0) {
                   for (; i.compareTo(hi) < 0; i = i.add(BigInteger.ONE)) {
                       E e = (E) get(i);
                       action.accept(e);
                   }
                   if (modCount == mc)
                       return;
               }
           }
           throw new ConcurrentModificationException();
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
   }

   /**
    * @throws NullPointerException {@inheritDoc}
    */
   @Override
   public boolean removeIf(Predicate<? super E> filter) {
       return removeIf(filter, BigInteger.ZERO, size);
   }

   /**
    * Removes all elements satisfying the given predicate, from index
    * i (inclusive) to index end (exclusive).
    */
   boolean removeIf(Predicate<? super E> filter, BigInteger i, final BigInteger end) {
       Objects.requireNonNull(filter);
       boolean oneRemoved = false;
       for (; i.compareTo(end) < 0; i = i.add(BigInteger.ONE)){
    	   if(filter.test(elementAt(elementData, i, dimension))){
    		   remove(i);
    		   oneRemoved = true;
    	   }
       }
       return oneRemoved;
   }

   @Override
   public void replaceAll(UnaryOperator<E> operator) {
       replaceAllRange(operator, BigInteger.ZERO, size);
       modCount++;
   }

   private void replaceAllRange(UnaryOperator<E> operator, BigInteger i, BigInteger end) {
       Objects.requireNonNull(operator);
       final int expectedModCount = modCount;
       for (; modCount == expectedModCount && i.compareTo(end) < 0; i = i.add(BigInteger.ONE))
           set(i, operator.apply(elementAt(elementData, i, dimension)));
       if (modCount != expectedModCount)
           throw new ConcurrentModificationException();
   }

   @Override
   public void sort(Comparator<? super E> c) {
	   throw new UnsupportedOperationException();
   }

   void checkInvariants() {
       // assert size >= 0;
       // assert size == elementData.length || elementData[size] == null;
   }
   
   public static int calculateDimension(BigInteger size, int[][] lastDims){
	   int dimension = 0;
	   ArrayList<Integer> lastDimsList = new ArrayList<Integer>(255);
	   do{
		   lastDimsList.add(Integer.valueOf(size.mod(BigInteger.valueOf(MAX_ARRAY_SIZE)).intValue()));
		   size = size.divide(BigInteger.valueOf(MAX_ARRAY_SIZE));
		   dimension++;
		   checkDimension(dimension);
	   }while(size.compareTo(BigInteger.ONE) > 0);
	   lastDims[0] = new int[lastDimsList.size()];
	   for(int i=0;i<lastDims[0].length;++i){
		   lastDims[0][i] = lastDimsList.get(i).intValue();
	   }
	   return dimension;
   }
   
   private Object[] createContainerAndSetDimension(BigInteger size){
	   int[][] lastDims = new int[1][];
	   this.dimension = calculateDimension(size, lastDims);
       return createContainer(Object.class, dimension, lastDims[0]);
   }
   
   private Object[] createContainer(BigInteger size){
	   int[][] lastDims = new int[1][];
	   int dimension = calculateDimension(size, lastDims);
       return createContainer(Object.class, dimension, lastDims[0]);
   }
   
   private static Object[] createContainer(Class<?> arrayClass, int dimension, int[] lastDims){
	   checkDimension(dimension);
	   Class<?>[] arrayClasses = new Class<?>[dimension];
	   arrayClasses[arrayClasses.length-1] = arrayClass;
	   for(int i=arrayClasses.length-1;i>0;--i){//Counts down; Ends before 0
		   arrayClasses[i-1] = Array.newInstance(arrayClasses[i], 0).getClass();
	   }
	   int[] lengths = new int[dimension];
	   Arrays.fill(lengths, MAX_ARRAY_SIZE);
	   Object[] ret = (Object[]) Array.newInstance(arrayClasses[0], lastDims[0]);
	   Object[] lastArr = ret;
	   for(int i=1;i<arrayClasses.length;++i){
		   for(int j=0;j<lastDims[i-1]-1;++j){
			   lastArr[j] = Array.newInstance(arrayClasses[i], Arrays.copyOf(lengths, i));
		   }
		   lastArr[lastDims[i-1]-1] = (Object[]) Array.newInstance(arrayClasses[i], lastDims[i]);
		   lastArr =  (Object[]) lastArr[lastDims[i-1]-1];
	   }
	   return (Object[]) ret;
   }
   
   private static void checkDimension(int dimension){
	   if(dimension > 255){
		   throw new UnsupportedOperationException("This implementation does not support Collections with a size bigger than Integer.MAX_VALUE^255");
	   }
   }
   
   private static void checkIndex(BigInteger index, BigInteger size){
		if(BigInteger.ZERO.compareTo(index) > 0 || index.compareTo(size) >= 0){
			throw new IndexOutOfBoundsException(index.toString());
		}
	}
	
}
