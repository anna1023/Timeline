import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadGUI extends JFrame implements ActionListener {
    private JFrame b1914;
    private JFrame b1998;
    private JFrame b1991;
    private JFrame b1972;
    private JFrame b1969;
    private JFrame b1919;
    private JFrame b1929;
    private JFrame b1963;
    private JFrame b1964;
    private JFrame b1961;
    private JFrame b1955;
    private JFrame b1950;
    private JFrame b1945;
    private JFrame b1939;
    private JFrame year;
    private JFrame frame;
    private JPanel panel;
    private JButton a1914;
    private JButton button2;
    private JButton a1998;
    private JButton a1991;
    private JButton a1972;
    private JButton a1969;
    private JButton a1919;
    private JButton a1929;
    private JButton a1963;
    private JButton a1964;
    private JButton a1961;
    private JButton a1955;
    private JButton a1950;
    private JButton a1945;
    private JButton a1939;
    private JButton backButton;
    private JPanel mainPanel;
    private TimelineCollection timeline;

    public LoadGUI() {
        createUIComponents();
        timeline = new TimelineCollection("Timeline Data - Sheet1.csv");
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Tip Calculate");
        setSize(700, 700);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        a1914.addActionListener(this);
        a1998.addActionListener(this);
        a1991.addActionListener(this);
        a1972.addActionListener(this);
        a1969.addActionListener(this);
        a1919.addActionListener(this);
        a1929.addActionListener(this);
        a1963.addActionListener(this);
        a1964.addActionListener(this);
        a1961.addActionListener(this);
        a1955.addActionListener(this);
        a1950.addActionListener(this);
        a1945.addActionListener(this);
        a1939.addActionListener(this);
        backButton.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button == a1914) {

            }
            if (button == a1919) {

            }
            if (button == a1929) {

            }
            if (button == a1939) {

            }
            if (button == a1945) {

            }
            if (button == a1950) {

            }
            if (button == a1955) {

            }
            if (button == a1961) {

            }
            if (button == a1963) {

            }
            if (button == a1964) {

            }
            if (button == a1969) {

            }
            if (button == a1972) {

            }
            if (button == a1991) {

            }
            if (button == a1998) {

            }
            if (button == backButton) {
                frame.dispose();
                MainGUIWindow myWindow = new MainGUIWindow();
            }
        }
    }
    public void info (int years){
        year = new JFrame("year");
        year.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        year.setLayout(new BorderLayout());
        setContentPane(year);

    }
}
