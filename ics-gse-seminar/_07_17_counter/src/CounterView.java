import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CounterView implements PropertyChangeListener {

	private final CounterModel model;
	private final ActionListener controller;
	private JTextField nAccesses;
	
	public CounterView(CounterModel model, ActionListener controller) {
		this.model = model;
		this.model.addPropertyChangeListener(this);
		this.controller = controller;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("nAccesses") && nAccesses != null) {
			nAccesses.setText(evt.getNewValue().toString());
		}
	}

	public void show() {
		JFrame frame = new JFrame("Counter");
		frame.setLayout(new FlowLayout());
		
		frame.add(new JLabel("Times accessed:"));
		
		nAccesses = new JTextField();
		nAccesses.setText("" + model.getNAccesses());
		nAccesses.setPreferredSize(new Dimension(80, 20));
		frame.add(nAccesses);
		
		JButton access = new JButton("Access");
		access.setActionCommand(CounterController.ACCESS);
		access.addActionListener(controller);
		frame.add(access);
		
		JButton reset = new JButton("Reset");
		reset.setActionCommand(CounterController.RESET);
		reset.addActionListener(controller);
		frame.add(reset);
		
		frame.setSize(400, 100);
		frame.setVisible(true);
	}
}
