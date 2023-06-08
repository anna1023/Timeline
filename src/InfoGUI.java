import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoGUI extends JFrame {
    private JPanel panel1;
    private JLabel Info;
    private TimelineCollection timeline;
    private int years;

    public InfoGUI(int years){
        timeline = new TimelineCollection("src/Timeline Data - Sheet1.csv");
        this.years = years;
        createUIComponents();
    }

    private void createUIComponents(){
        setContentPane(panel1);
        setTitle("Timeline App");
        setInfo();
        setSize(700, 200);
        setLocation(450, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void setInfo() {
        ArrayList<Timeline> timess =timeline.getTimelines();
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
        Info.setText(timeline.displayInfo(finalTime));
    }
}
