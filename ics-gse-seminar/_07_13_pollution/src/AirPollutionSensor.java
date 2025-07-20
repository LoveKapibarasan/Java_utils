import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AirPollutionSensor {
	private int pollution;
	private PropertyChangeSupport support;
	
	public AirPollutionSensor() {
		this.support = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}

	public void setPollution(int pollution) {
		support.firePropertyChange("pollution", this.pollution, pollution);
		this.pollution = pollution;
	}
}
