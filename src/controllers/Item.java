package controllers;

/**
 * @author Judy
 * @param A Items Class 
 */
public class Item implements Comparable<Item> {


	public String english;
	public String spanish;
	

	/** Constructor for object of class Item. 
	 * @param Item Class
	 
	 * @return Spanish Word
	 * @return English translation
	 */

	public Item(String spanish, String english)
	{
		this.english = english;
		this.spanish = spanish;

	}

	
	/**
	 * Getters and Setters
	 */

	public String getEnglish() {
		return english;
	}


	public void setEnglish(String english) {
		this.english = english;
	}


	public String getSpanish() {
		return spanish;
	}


	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}


	@Override
	public String toString() {
		return spanish + " = "   + english;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((english == null) ? 0 : english.hashCode());
		result = prime * result + ((spanish == null) ? 0 : spanish.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (english == null) {
			if (other.english != null)
				return false;
		} else if (!english.equals(other.english))
			return false;
		if (spanish == null) {
			if (other.spanish != null)
				return false;
		} else if (!spanish.equals(other.spanish))
			return false;
		return true;
	}


	/**
	 * @param Comparason of two items
	  * @returns the item in decending order
	  */ 


	@Override
    public int compareTo(Item item) {
        return this.spanish.compareTo(item.spanish);
    }

	
	
	
}
