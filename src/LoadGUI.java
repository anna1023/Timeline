import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LoadGUI extends JFrame implements ActionListener {
    private JButton a1914;
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
        timeline = new TimelineCollection("src/Timeline Data - Sheet1.csv");
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Timeline App");
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
                info(1919);

            }
            if (button == a1929) {
                info(1929);
            }
            if (button == a1939) {
                info(1939);

            }
            if (button == a1945) {
                info(1945);
            }
            if (button == a1950) {
                info(1950);

            }
            if (button == a1955) {
                info(1955);

            }
            if (button == a1961) {
                info(1961);

            }
            if (button == a1963) {
                info(1963);

            }
            if (button == a1964) {
                info(1964);

            }
            if (button == a1969) {
                info(1969);

            }
            if (button == a1972) {
                info(1972);

            }
            if (button == a1991) {
                info(1991);

            }
            if (button == a1998) {
                info(1998);

            }
            if (button == backButton) {
                this.dispose();
                MainGUIWindow myWindow = new MainGUIWindow();
            }
        }
    }
    public void info (int years){
        JFrame year = new JFrame("year");
        setSize(700, 700);
        setLocation(450, 100);
        year.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        year.setLayout(new BorderLayout());
        year.setVisible(true);
        ArrayList<Timeline> timess=timeline.getTimelines();
        boolean time = false;
        int i = 0;
        while (time!=true){
            int timeYear=timess.get(i).getYear();
            if(timeYear==years){
                time=true;
            }
            else{
                i++;
            }
        }
        Timeline finalTime = timess.get(i);
        JLabel name = new JLabel();
        name.setText(timeline.displayMovieInfo(finalTime));
    }
}
