import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class SearchGUI extends JFrame implements ActionListener {
    private JLabel results;
    private JButton backButton;
    private JPanel mainPanel;
    private ArrayList<Timeline> times;

    public SearchGUI(ArrayList<Timeline> times) {
        this.times = times;
        createUIComponents();

    }

    public void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Timeline App");
        setSize(700, 700);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backButton.addActionListener(this);
        this.setVisible(true);
        int x = 20;
        int y = 180;
        for(int i = 0;i<times.size();i++){
            JButton ne = new JButton();
            ne.setText(""+times.get(i).getYear()+" "+times.get(i).getName());
            ne.addActionListener(this);
            ne.setSize(700,x+50);
            mainPanel.add(ne);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button == backButton) {
                this.dispose();
                PeopleGUI myWindow = new PeopleGUI(true);
            }



        }
    }
}
