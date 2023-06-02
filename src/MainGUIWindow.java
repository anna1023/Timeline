import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUIWindow extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel mainPanel;
    private JButton loadTimelineButton;
    private JButton searchByPeopleButton;
    private JButton searchByEventButton;
    private JButton addYourOwnEventButton;
    private JLabel welcome;

    public MainGUIWindow(){
        createUIComponents();
    }

    private void createUIComponents(){
        setContentPane(mainPanel);
        setTitle("Tip Calculate");
        setSize(700,400);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loadTimelineButton.addActionListener(this);
        searchByEventButton.addActionListener(this);
        searchByPeopleButton.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            String text = button.getText();
            if (button == loadTimelineButton) {
                this.dispose();
                LoadGUI myWindow = new LoadGUI();
            }
            if (button == searchByEventButton) {

            }
            if (button == searchByPeopleButton) {

            }

            }

        }
    }
    //}

