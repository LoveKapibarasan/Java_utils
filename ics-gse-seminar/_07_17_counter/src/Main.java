import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CounterModel model = new CounterModel();
        CounterController controller = new CounterController(model);
        CounterView view = new CounterView(model, controller);
        SwingUtilities.invokeLater(view::show);
    }
}
