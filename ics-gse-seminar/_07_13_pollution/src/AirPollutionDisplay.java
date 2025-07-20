import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AirPollutionDisplay implements PropertyChangeListener {
	@Override public void propertyChange(PropertyChangeEvent evt) {
		int old = (int) evt.getOldValue();
		int newValue = (int) evt.getNewValue();
		if (old < newValue) {
			System.out.println("Pollution increased to " + newValue);
		} else if (newValue < old) {
			System.out.println("Pollution decreased to " + newValue);
		}
	}
}
