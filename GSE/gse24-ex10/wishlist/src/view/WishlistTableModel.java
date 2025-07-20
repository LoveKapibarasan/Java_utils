package view;

import model.Priority;
import model.Wishlist;
import model.WishlistItem;

import javax.swing.table.AbstractTableModel;

public class WishlistTableModel extends AbstractTableModel {
	private final Wishlist model;
	
	public WishlistTableModel(Wishlist model) {
		this.model = model;
	}

	@Override
	public int getRowCount() {
		return model.getItems().size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= model.getItems().size() || columnIndex > 2) {
			return null;
		}
		WishlistItem item = model.getItems().get(rowIndex);
		switch (columnIndex) {
		case 0: return item.getName();
		case 1: return item.getPriority() == null ? null : item.getPriority().name();
		case 2: return item.getComment();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0: return "Title";
		case 1: return "Priority";
		case 2: return "Comment";
		}
		return null;
	}
		
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex < 3 && rowIndex < model.getItems().size();
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		if (rowIndex >= model.getItems().size() || columnIndex > 2) {
			return;
		}
		WishlistItem item = model.getItems().get(rowIndex);
		try {
			switch (columnIndex) {
			case 0: 
				item.setName((String) value);
				break;
			case 1: 
				try {
					item.setPriority(Priority.valueOf((String) value));
				} catch (Exception e) {
					item.setPriority(Priority.NICE_TO_HAVE);
					e.printStackTrace();
				}
				break;
			case 2:
				item.setComment((String) value);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
