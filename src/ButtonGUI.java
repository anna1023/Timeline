import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ButtonGUI extends JFrame implements ActionListener {
    private JLabel results;
    private JButton backButton;
    private JPanel mainPanel;
    private ArrayList<Timeline> times;
    private ArrayList<JButton> buttonList;

    public ButtonGUI(ArrayList<Timeline> times) {
        this.times = times;
        buttonList = new ArrayList<JButton>();
        createUIComponents();

    }

    public void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Timeline App");
        setSize(700, 600);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        mainPanel.setLayout(null);
        backButton.addActionListener(this);
        results.setBounds(282,10,300,100);
        int y = 60;
        for(int i = 0;i<times.size();i++){
            JButton ne = new JButton();
            ne.setText(""+times.get(i).getYear()+" "+times.get(i).getName());
            ne.addActionListener(this);
            ne.setLayout(null);
            ne.setBounds(0,y+30,700,70);
            y+=70;
            mainPanel.add(ne);
            buttonList.add(ne);
        }
        backButton.setBounds(0,y+30,700,70);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button == backButton) {
                this.dispose();
                SearchGUI myWindow = new SearchGUI(true);
            }
            else{
                for(int i=0; i<buttonList.size();i++){
                    if(button==buttonList.get(i)){
                        String name = buttonList.get(i).getText();
                        int where = name.indexOf("1");
                        int year = Integer.parseInt(name.substring(where,where+4));
                        info(year);
                    }
                }
            }



        }
    }
    public void info (int years) {
        new InfoGUI(years);
    }
}
