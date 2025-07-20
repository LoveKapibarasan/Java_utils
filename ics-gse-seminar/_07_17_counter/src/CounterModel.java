import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CounterModel {
	private int nAccesses;
	private final PropertyChangeSupport support;
	
	public CounterModel() {
		this.support = new PropertyChangeSupport(this);
	}	
	
	public int getNAccesses() {
		return nAccesses;
	}
	
	public void access() {
		support.firePropertyChange("nAccesses", nAccesses, nAccesses+1);
		nAccesses ++;
	}
	
	public void reset() {
		support.firePropertyChange("nAccesses", nAccesses, 0);
		nAccesses = 0;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}
}