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
    private boolean event;

    public ButtonGUI(ArrayList<Timeline> times, boolean event) {
        this.times = times;
        this.event = event;
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
        for(int i = 0;i<times.size();i++){ //auto generate buttons
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
            if (button == backButton && event) {
                this.dispose();
                SearchGUI myWindow = new SearchGUI(true);
            }
            if(button == backButton &&!event){
                this.dispose();
                SearchGUI myWindow = new SearchGUI(false);
            }
            else{
                for(int i=0; i<buttonList.size();i++){ //parse the button to get int for info parameter
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
