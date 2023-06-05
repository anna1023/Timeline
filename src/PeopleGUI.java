import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeopleGUI extends JFrame implements ActionListener {
    private JLabel People;
    private JTextField textField1;
    private JButton backButton;
    private boolean event;
    private JPanel mainPanel;
    private JButton searchButton;

    public PeopleGUI(boolean event) {
        this.event = event;
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Timeline App");
        setSize(400, 400);
        setLocation(450, 100);
        if (event) {
            People.setText("What do you want to search?");
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button == backButton) {
                this.dispose();
                MainGUIWindow myWindow = new MainGUIWindow();
            }
            if (button == searchButton && event) {

            }
            if (button == searchButton && !event) {

            }
        }
    }
}
