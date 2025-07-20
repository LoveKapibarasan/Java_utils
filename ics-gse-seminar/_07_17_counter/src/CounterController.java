import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterController implements ActionListener {

	public static final String ACCESS = "access";
	public static final String RESET = "reset";

	private final CounterModel model;
	
	public CounterController(CounterModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ACCESS -> model.access();
		case RESET -> model.reset();
		}
	}
}
