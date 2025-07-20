package view;

import controller.WishlistController;
import model.Wishlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class WishlistView implements PropertyChangeListener, IWishlistView {
	private final Wishlist model;
	private final WishlistController controller;
	
	private JTextField owner;
	private JTable itemTable;

	public WishlistView(Wishlist model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		controller = new WishlistController(model, this);
	}

	public void show() {
		JFrame frame = new JFrame("Wishlist");
		frame.setLayout(new BorderLayout());
		
		JPanel ownerPanel = new JPanel();
		ownerPanel.setLayout(new FlowLayout());
		frame.add(ownerPanel, BorderLayout.NORTH);

		JLabel ownerLabel = new JLabel("Wishlist of ");
		ownerPanel.add(ownerLabel);
		
		owner = new JTextField();
		owner.setText(model.getOwner());
		owner.setPreferredSize(new Dimension(200, 20));
		ownerPanel.add(owner);
		
		JButton updateOwner = new JButton();
		updateOwner.setText("Update");
		updateOwner.setActionCommand(WishlistController.SET_OWNER);
		updateOwner.addActionListener(controller);
		ownerPanel.add(updateOwner);		
		
		JPanel tablePanel = new JPanel(new BorderLayout());
		itemTable = new JTable(new WishlistTableModel(model));
		tablePanel.add(itemTable, BorderLayout.CENTER);
		tablePanel.add(itemTable.getTableHeader(), BorderLayout.NORTH);
		frame.add(tablePanel);
		
		JPanel actionsPanel = new JPanel();
		actionsPanel.setLayout(new GridLayout(8, 1, 5, 5));
		frame.add(actionsPanel, BorderLayout.EAST);
		
		JButton addItem = new JButton();
		addItem.setText("Add");
		addItem.setActionCommand(WishlistController.ADD_ITEM);
		addItem.addActionListener(controller);
		actionsPanel.add(addItem);
		
		JButton removeItem = new JButton();
		removeItem.setText("Remove");
		removeItem.setActionCommand(WishlistController.REMOVE_ITEM);
		removeItem.addActionListener(controller);
		actionsPanel.add(removeItem);
		
		JButton sortByPrio = new JButton();
		sortByPrio.setText("Sort by Priority");
		sortByPrio.setActionCommand(WishlistController.SORT_BY_PRIO);
		sortByPrio.addActionListener(controller);
		actionsPanel.add(sortByPrio);
		
		JButton sortByName = new JButton();
		sortByName.setText("Sort by Name");
		sortByName.setActionCommand(WishlistController.SORT_BY_NAME);
		sortByName.addActionListener(controller);
		actionsPanel.add(sortByName);
		
		frame.setMinimumSize(new Dimension(800, 400));
		frame.setVisible(true);
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				frame.repaint();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Wishlist.OWNER)) {
			owner.setText(evt.getNewValue().toString());
		} else if (evt.getPropertyName().equals(Wishlist.ITEMS)) {
			itemTable.repaint();
		}
	}

	@Override
	public String getOwner() {
		return owner.getText();
	}

	@Override
	public int getSelectedRow() {
		return itemTable.getSelectedRow();
	}

	public static void main(String[] args) {
		Wishlist model = new Wishlist();
		model.setOwner("Ada");
		WishlistView view = new WishlistView(model);
		SwingUtilities.invokeLater(view::show);
	}
}
