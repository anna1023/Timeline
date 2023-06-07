import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class SearchGUI extends JFrame implements ActionListener {
    private JLabel results;
    private JButton backButton;
    private JPanel mainPanel;
    private ArrayList<Timeline> times;
    private ArrayList<JButton> buttons;

    public SearchGUI(ArrayList<Timeline> times) {
        this.times = times;
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        createUIComponents();

    }

    public void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Timeline App");
        setSize(700, 700);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        mainPanel.setLayout(null);
        backButton.addActionListener(this);
        this.setVisible(true);
        int x = -20;
        int y = 180;
        for(int i = 0;i<times.size();i++){
            System.out.println(times.get(i).getName());
            JButton ne = new JButton();
            ne.setText(""+times.get(i).getYear()+" "+times.get(i).getName()+times.size());
            ne.addActionListener(this);
            //ne.setSize(700,70);
            ne.setLayout(null);
            ne.setBounds(0,y+30,700,70);
            x+=50;
            y+=70;
            mainPanel.add(ne);
            buttons.add(ne);
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
            else{
                //for(int i=0; i<buttons)
            }



        }
    }
}
