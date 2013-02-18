package lists;
import exceptionclasses.*;

/**
 * <p>Title: ArrayOrderedList.java</p>
 *
 * <p>Description: Represents an array implementation of an ordered list.</p>
 *
 * @author Brian Chung, Zainab Ebrahimi
 */
public class ArrayOrderedList<T> extends ArrayList<T>
implements OrderedListADT<T>
{
	/**
	 * default constructor -- 
	 * creates an empty list using the default capacity.
	 */
	public ArrayOrderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 * @param initialCapacity the initial size of the list as specified by the user
	 */
	public ArrayOrderedList (int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * add --
	 * adds the specified Comparable element to this list, keeping
	 * the elements in sorted order.
	 * @param newItem a reference to the new item to be added to the list  
	 */
	@SuppressWarnings("unchecked")
	public void add(T newItem)
	{
		if (size() == contents.length)
			expandCapacity();

		Comparable<T> temp = (Comparable<T>) newItem;
		int i = 0;
		while (i < count && temp.compareTo(contents[i]) > 0)
			i++;

		for (int j=count; j > i; j--)
			contents[j] = contents[j-1];

		contents[i] = newItem;
		count++;
	}

	/**
	 * binSearch --
	 * locates and returns the target from the list if it is found
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an EmptyCollection if the list is empty
	 * @throws an ElementNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	public T binSearch(T target)
	{
		int first=0;
		int last=count-1;
		int midPoint=0;
		boolean keepLooping=true;
		Comparable<T> temp = (Comparable<T>) target;
		while(first<=last && keepLooping)
		{
			midPoint=(first+last)/2;
			if(temp.compareTo(contents[midPoint])>0)
			{
				first=midPoint+1;
			}
			else if(temp.compareTo(contents[midPoint])<0)
			{
				last=midPoint-1;
			}
			else{
				keepLooping=false;
			}
		}
		if(first>last)
			throw new ElementNotFoundException("array");
		
	return contents[midPoint];
	}
	
	/**
	 * recursiveBinSearch --
	 * calls the private recursive method to locate and return the target
	 * from the list if it is found
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an EmptyCollection if the list is empty
	 * @throws an ElementNotFoundException if the target is not found
	 */
	public T recursiveBinSearch(T target)
	{
		if (isEmpty())
			throw new EmptyCollectionException("ArrayOrderedList");

		return recBinSearch(target, 0, count-1);
	}

	/**
	 * recBinSearch --
	 * locates and returns the target from the list if it is found; the 
	 * method searches the subset of items from first to last
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @param first the index of the first item in the current subset
	 * @param last the index of the last item in the current subset
	 * @return a reference to the item from the list if found
	 * @throws an ElementNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	private T recBinSearch(T target, int first, int last)
	{
		if(first>last)
			throw new ElementNotFoundException("array");
		int midPoint=(first+last)/2;
		Comparable<T> temp = (Comparable<T>) target;
		if(temp.compareTo(contents[midPoint])== 0)
			return contents[midPoint];
		
		else{
			if(temp.compareTo(contents[midPoint])<0)
			{
				return recBinSearch(target,first,midPoint-1);
			}else 
			{
				return recBinSearch(target,midPoint+1,last);
			}
		}
			
	}
}


