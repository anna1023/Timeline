import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoGUI extends JFrame {
    private JPanel panel1;
    private JLabel Info;
    private TimelineCollection timeline;
    private int years;

    public InfoGUI(int years){
        this.years = years;
        createUIComponents();
        timeline = new TimelineCollection("src/Timeline Data - Sheet1.csv");
    }

    private void createUIComponents(){
        setTitle("Tip Calculate");
        setInfo();
        setSize(700, 700);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        Info.setText(timeline.displayMovieInfo(finalTime));
    }
}
