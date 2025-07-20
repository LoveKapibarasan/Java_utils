package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class Wishlist {
	
	public static final String OWNER = "owner";
	public static final String ITEMS = "items";
	
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	private final List<WishlistItem> items = new ArrayList<>();
	private String owner;
	
	public List<WishlistItem> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	public void addItem(WishlistItem item) {
		List<WishlistItem> oldItems = new ArrayList<WishlistItem>(items);
		items.add(item);
		propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, ITEMS, oldItems, items));
	}
	
	public void removeItem(int index) {
		List<WishlistItem> oldItems = new ArrayList<WishlistItem>(items);
		items.remove(index);
		propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, ITEMS, oldItems, items));
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		String oldOwner = this.owner;
		this.owner = owner;
		propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, OWNER, oldOwner, owner));
	}
	
	public void sortByPriority() {
		List<WishlistItem> oldItems = new ArrayList<WishlistItem>(items);
		Collections.sort(items, Comparator.comparing(i -> Optional.ofNullable(i.getPriority()).orElse(Priority.NICE_TO_HAVE)));
		propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, ITEMS, oldItems, items));
	}
	
	public void sortByName() {
		List<WishlistItem> oldItems = new ArrayList<WishlistItem>(items);
		Collections.sort(items, Comparator.comparing(i -> Optional.ofNullable(i.getName()).orElse("")));
		propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, ITEMS, oldItems, items));
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
}
