package controller;

import model.Priority;
import model.Wishlist;
import model.WishlistItem;
import view.IWishlistView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WishlistController implements ActionListener {
	public static final String SET_OWNER = "setOwner";
	public static final String ADD_ITEM = "addItem";	
	public static final String REMOVE_ITEM = "removeItem";
	public static final String SORT_BY_PRIO = "sortByPrio";
	public static final String SORT_BY_NAME = "sortByName";

	private final Wishlist model;
	private final IWishlistView view;

	public WishlistController(Wishlist model, IWishlistView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case SET_OWNER -> model.setOwner(view.getOwner());
		case ADD_ITEM -> {
			WishlistItem wi = new WishlistItem();
			wi.setPriority(Priority.NICE_TO_HAVE);
			model.addItem(wi);
		}
		case REMOVE_ITEM -> {
			if (view.getSelectedRow() > -1) {
				model.removeItem(view.getSelectedRow());
			}
		}
		case SORT_BY_PRIO -> model.sortByPriority();
		case SORT_BY_NAME -> model.sortByName();
		}
	}

}
