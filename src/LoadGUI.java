import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LoadGUI extends JFrame implements ActionListener {
    private JButton backButton;
    private JPanel mainPanel;
    private JScrollPane Scrollpane;
    private TimelineCollection timeline;
    private ArrayList<JButton> buttonList;
    private ArrayList<Timeline> sorted;



    public LoadGUI() {
        timeline = new TimelineCollection("src/Timeline Data - Sheet2.csv");
        buttonList = new ArrayList<JButton>();
        sorted = new ArrayList<Timeline>();
        backButton = new JButton();
        backButton.setText("Back");
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Timeline App");
        setSize(700, 700);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,1,10,10));
        JViewport viewport = new JViewport();
        viewport.setSize(700,700);
        viewport.add(buttonPanel);
        int y = -30;
        ArrayList<Timeline> year = timeline.getTimelines();
        for(int x = 0; x<year.size();x++){ //sort the list
            int temp = year.get(x).getYear();
            int z = 0;
            while (z<sorted.size()&&temp>sorted.get(z).getYear()){
                z++;
            }
            sorted.add(z,year.get(x));
        }
        for(int i =0; i<sorted.size();i++){  //create a buttons
            JButton newtime = new JButton();
            newtime.setText(sorted.get(i).getYear()+" "+sorted.get(i).getName());
            newtime.addActionListener(this);
            newtime.setLayout(null);
            newtime.setBounds(0,y+30,700,40);
            y+=50;
            newtime.setVisible(true);
            buttonPanel.add(newtime);
        }
        buttonPanel.add(backButton);
        Scrollpane.setViewport(viewport);
        Scrollpane.getVerticalScrollBar().setUnitIncrement(10);
        backButton.setBounds(0,y,700,40);
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
