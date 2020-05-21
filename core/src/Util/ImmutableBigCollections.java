package Util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import jdk.internal.misc.VM;
import jdk.internal.vm.annotation.Stable;

public class ImmutableBigCollections {

	static UnsupportedOperationException uoe() { return new UnsupportedOperationException(); }
	
	@SuppressWarnings("unchecked")
    static <E> BigList<E> listCopy(Collection<? extends E> coll) {
		return (BigList<E>)BigList.of(coll.toArray());
    }
	
	@SuppressWarnings("unchecked")
    static <E> BigList<E> listCopy(BigCollection<? extends E> coll) {
        if (coll instanceof AbstractImmutableBigList && coll.getClass() != SubBigList.class) {
            return (BigList<E>)coll;
        } else {
          throw uoe();
        }
    }
	
	static abstract class AbstractImmutableBigCollection<E> extends AbstractBigCollection<E> {
        // all mutating methods throw UnsupportedOperationException
        @Override public boolean add(E e) { throw uoe(); }
        @Override public boolean addAll(Collection<? extends E> c) { throw uoe(); }
        @Override public boolean addAll(BigCollection<? extends E> c) { throw uoe(); }
        @Override public void    clear() { throw uoe(); }
        @Override public boolean remove(Object o) { throw uoe(); }
        @Override public boolean removeAll(Collection<?> c) { throw uoe(); }
        @Override public boolean removeAll(BigCollection<?> c) { throw uoe(); }
        @Override public boolean removeIf(Predicate<? super E> filter) { throw uoe(); }
        @Override public boolean retainAll(Collection<?> c) { throw uoe(); }
        @Override public boolean retainAll(BigCollection<?> c) { throw uoe(); }
    }
	
	static abstract class AbstractImmutableBigList<E> extends AbstractImmutableBigCollection<E>
	implements BigList<E>, RandomAccess {

		// all mutating methods throw UnsupportedOperationException
		@Override public void    add(long index, E element) { throw uoe(); }
		@Override public void    add(BigInteger index, E element) { throw uoe(); }
		@Override public boolean addAll(long index, Collection<? extends E> c) { throw uoe(); }
		@Override public boolean addAll(BigInteger index, Collection<? extends E> c) { throw uoe(); }
		@Override public boolean addAll(long index, BigCollection<? extends E> c) { throw uoe(); }
		@Override public boolean addAll(BigInteger index, BigCollection<? extends E> c) { throw uoe(); }
		@Override public E       remove(long index) { throw uoe(); }
		@Override public E       remove(BigInteger index) { throw uoe(); }
		@Override public void    replaceAll(UnaryOperator<E> operator) { throw uoe(); }
		@Override public E       set(long index, E element) { throw uoe(); }
		@Override public E       set(BigInteger index, E element) { throw uoe(); }
		@Override public void    sort(Comparator<? super E> c) { throw uoe(); }
		
		@Override
		public BigList<E> subList(long fromIndex, long toIndex) {
			long size = size().longValue();
			subListRangeCheck(fromIndex, toIndex, size);
			return SubBigList.fromList(this, fromIndex, toIndex);
		}
		
		@Override
		public BigList<E> subList(BigInteger fromIndex, BigInteger toIndex) {
			BigInteger size = size();
			subListRangeCheck(fromIndex, toIndex, size);
			return SubBigList.fromList(this, fromIndex, toIndex);
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

		@Override
		public Iterator<E> iterator() {
			return new BigListItr<E>(this, size());
		}

		@Override
		public BigListIterator<E> listIterator() {
			return listIterator(0);
		}

		@Override
		public BigListIterator<E> listIterator(final long index) {
			long size = size().longValue();
			if (index < 0 || index > size) {
				throw outOfBounds(index);
			}
			return new BigListItr<E>(this, size, index);
		}
		
		@Override
		public BigListIterator<E> listIterator(final BigInteger index) {
			BigInteger size = size();
			if (index.compareTo(BigInteger.ZERO) < 0 || index.compareTo(size) > 0) {
				throw outOfBounds(index);
			}
			return new BigListItr<E>(this, size, index);
		}

		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}

			if (!(o instanceof BigList)) {
				return false;
			}

			Iterator<?> oit = ((BigList<?>) o).iterator();
			for(E elem : this){
				if (!oit.hasNext() || !elem.equals(oit.next())) {
					return false;
				}
			}
			return !oit.hasNext();
		}

		@Override
		public BigInteger indexOf(Object o) {
			Objects.requireNonNull(o);
			BigInteger index = BigInteger.ZERO;
			long size = 0;
			for (E elem : this) {
				if (o.equals(elem)) {
					index = index.add(BigInteger.valueOf(size));
					size = 0;
					return index;
				}
				size++;
				if(size == Long.MAX_VALUE){
					index = index.add(BigInteger.valueOf(size));
					size = 0;
				}
			}
			return BigInteger.valueOf(-1);
		}

		@Override
		public BigInteger lastIndexOf(Object o) {
			Objects.requireNonNull(o);
			BigInteger index = BigInteger.ZERO;
			long size = 0;
			BigListIterator<?> it = listIterator(size().subtract(BigInteger.ONE));
			while(it.hasPrevious()) {
				if (o.equals(it.previous())) {
					index = index.add(BigInteger.valueOf(size));
					size = 0;
					return index;
				}
				size++;
				if(size == Long.MAX_VALUE){
					index = index.add(BigInteger.valueOf(size));
					size = 0;
				}
			}
			return BigInteger.valueOf(-1);
		}

		@Override
		public int hashCode() {
			int hash = 1;
			for (E elem : this) {
				hash = 31 * hash + elem.hashCode();
			}
			return hash;
		}

		@Override
		public boolean contains(Object o) {
			return indexOf(o).compareTo(BigInteger.ZERO) >= 0;
		}
		
		IndexOutOfBoundsException outOfBounds(long index) {
			return new IndexOutOfBoundsException("Index: " + index + " Size: " + size());
		}

		IndexOutOfBoundsException outOfBounds(BigInteger index) {
			return new IndexOutOfBoundsException("Index: " + index + " Size: " + size());
		}
	}

	static final class BigListItr<E> implements BigListIterator<E> {

        @Stable
        private final BigList<E> list;

        @Stable
        private final BigInteger size;

        @Stable
        private final boolean isListIterator;

        private BigInteger cursor;

        BigListItr(BigList<E> list, long size) {
            this(list, BigInteger.valueOf(size));
        }
        
        BigListItr(BigList<E> list, BigInteger size) {
            this.list = list;
            this.size = size;
            this.cursor = BigInteger.ZERO;
            isListIterator = false;
        }
        
        BigListItr(BigList<E> list, long size, long index) {
            this(list, BigInteger.valueOf(size), BigInteger.valueOf(index));
        }

        BigListItr(BigList<E> list, BigInteger size, BigInteger index) {
            this.list = list;
            this.size = size;
            this.cursor = index;
            isListIterator = true;
        }

        public boolean hasNext() {
            return !cursor.equals(size);
        }

        public E next() {
            try {
                BigInteger i = cursor;
                E next = list.get(i);
                cursor = cursor.add(BigInteger.ONE);
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw uoe();
        }

        public boolean hasPrevious() {
            if (!isListIterator) {
                throw uoe();
            }
            return !cursor.equals(BigInteger.ZERO);
        }

        public E previous() {
            if (!isListIterator) {
                throw uoe();
            }
            try {
            	BigInteger i = cursor.subtract(BigInteger.ONE);
                E previous = list.get(i);
                cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public BigInteger nextIndex() {
            if (!isListIterator) {
                throw uoe();
            }
            return cursor;
        }

        public BigInteger previousIndex() {
            if (!isListIterator) {
                throw uoe();
            }
            return cursor.subtract(BigInteger.ONE);
        }

        public void set(E e) {
            throw uoe();
        }

        public void add(E e) {
            throw uoe();
        }
    }
	
	static final class SubBigList<E> extends AbstractImmutableBigList<E>
	implements RandomAccess {

		@Stable
		private final BigList<E> root;

		@Stable
		private final BigInteger offset;

		@Stable
		private final BigInteger size;

		private SubBigList(BigList<E> root, long offset, long size) {
			this(root, BigInteger.valueOf(offset), BigInteger.valueOf(size));
		}
		
		private SubBigList(BigList<E> root, BigInteger offset, BigInteger size) {
			this.root = root;
			this.offset = offset;
			this.size = size;
		}
		
		/**
		 * Constructs a sublist of another SubList.
		 */
		static <E> SubBigList<E> fromSubList(SubBigList<E> parent, long fromIndex, long toIndex) {
			return fromSubList(parent, BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
		}

		/**
		 * Constructs a sublist of another SubList.
		 */
		static <E> SubBigList<E> fromSubList(SubBigList<E> parent, BigInteger fromIndex, BigInteger toIndex) {
			return new SubBigList<>(parent.root, parent.offset.add(fromIndex), toIndex.subtract(fromIndex));
		}

		/**
		 * Constructs a sublist of an arbitrary AbstractImmutableList, which is
		 * not a SubList itself.
		 */
		static <E> SubBigList<E> fromList(BigList<E> list, long fromIndex, long toIndex) {
			return new SubBigList<>(list, fromIndex, toIndex - fromIndex);
		}
		
		/**
		 * Constructs a sublist of an arbitrary AbstractImmutableList, which is
		 * not a SubList itself.
		 */
		static <E> SubBigList<E> fromList(BigList<E> list, BigInteger fromIndex, BigInteger toIndex) {
			return new SubBigList<>(list, fromIndex, toIndex.subtract(fromIndex));
		}

		public E get(long index) {
			return get(BigInteger.valueOf(index));
		}
		
		public E get(BigInteger index) {
			checkIndex(index, size);
			return root.get(offset.add(index));
		}

		public BigInteger size() {
			return size;
		}

		public Iterator<E> iterator() {
			return new BigListItr<>(this, size());
		}

		public BigListIterator<E> listIterator(long index) {
			return listIterator(BigInteger.valueOf(index));
		}
		
		public BigListIterator<E> listIterator(BigInteger index) {
			rangeCheck(index);
			return new BigListItr<>(this, size(), index);
		}

		public BigList<E> subList(long fromIndex, long toIndex) {
			return subList(BigInteger.valueOf(fromIndex), BigInteger.valueOf(toIndex));
		}
		
		public BigList<E> subList(BigInteger fromIndex, BigInteger toIndex) {
			subListRangeCheck(fromIndex, toIndex, size);
			return SubBigList.fromSubList(this, fromIndex, toIndex);
		}
		
		private void rangeCheck(BigInteger index) {
			if(BigInteger.ZERO.compareTo(index) > 0 || index.compareTo(size) >= 0){
				throw outOfBounds(index);
			}
		}
	}
	
	static final class BigList12<E> extends AbstractImmutableBigList<E> {

		@Stable
		private final E e0;

		@Stable
		private final E e1;

		BigList12(E e0) {
			this.e0 = Objects.requireNonNull(e0);
			this.e1 = null;
		}

		BigList12(E e0, E e1) {
			this.e0 = Objects.requireNonNull(e0);
			this.e1 = Objects.requireNonNull(e1);
		}

		@Override
		public BigInteger size() {
			return e1 != null ? BigInteger.TWO : BigInteger.ONE;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public E get(long index) {
			if (index == 0) {
				return e0;
			} else if (index == 1 && e1 != null) {
				return e1;
			}
			throw outOfBounds(index);
		}
		
		@Override
		public E get(BigInteger index) {
			if (index.equals(BigInteger.ZERO)) {
				return e0;
			} else if (index.equals(BigInteger.ONE) && e1 != null) {
				return e1;
			}
			throw outOfBounds(index);
		}
	}
	
	static final class BigListN<E> extends AbstractImmutableBigList<E> {

		// EMPTY_LIST may be initialized from the CDS archive.
		static @Stable BigList<?> EMPTY_LIST;

		static {
			VM.initializeFromArchive(BigListN.class);
			if (EMPTY_LIST == null) {
				EMPTY_LIST = new BigListN<>();
			}
		}

		@Stable
		private final E[] elements;
		
		@SafeVarargs
		BigListN(E... input) {
			// copy and check manually to avoid TOCTOU
			@SuppressWarnings("unchecked")
			E[] tmp = (E[])new Object[input.length]; // implicit nullcheck of input
			for (int i = 0; i < input.length; i++) {
				tmp[i] = Objects.requireNonNull(input[i]);
			}
			elements = tmp;
		}

		@Override
		public boolean isEmpty() {
			return elements.length == 0;
		}

		@Override
		public BigInteger size() {
			return BigInteger.valueOf(elements.length);
		}

		@Override
		public E get(long index) {
			if(index > Integer.MAX_VALUE || index < Integer.MIN_VALUE){
				throw new ArithmeticException("Loosy conversation form long to int for: "+index);
			}
			return elements[(int)index];
		}
		
		@Override
		public E get(BigInteger index) {
			return elements[index.intValueExact()];
		}

		public Object[] toArray() {
			return Arrays.copyOf(elements, elements.length);
		}

		@SuppressWarnings("unchecked")
		public <T> T[] toArray(T[] a) {
			int size = elements.length;
			if (a.length < size) {
				// Make a new array of a's runtime type, but my contents:
				return (T[]) Arrays.copyOf(elements, size, a.getClass());
			}
			System.arraycopy(elements, 0, a, 0, size);
			if (a.length > size) {
				a[size] = null; // null-terminate
			}
			return a;
		}
	}
	
	private static void checkIndex(BigInteger index, BigInteger size){
		if(BigInteger.ZERO.compareTo(index) > 0 || index.compareTo(size) >= 0){
			throw new IndexOutOfBoundsException(index.toString());
		}
	}
	
}
