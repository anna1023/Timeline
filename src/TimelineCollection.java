import javax.naming.TimeLimitExceededException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TimelineCollection {
    private ArrayList<Timeline> timelines;
    private Scanner scanner;

    public TimelineCollection(String filename){
        importTimeline(filename);
        scanner = new Scanner(System.in);
    }

    private void importTimeline(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            timelines = new ArrayList<Timeline>();

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] timelineFromCSV = line.split(",");

                int year = Integer.parseInt(timelineFromCSV[0]);
                String name = timelineFromCSV[1];
                String involve = timelineFromCSV[3];
                String description = timelineFromCSV[2];
                String moreInfo = timelineFromCSV[4];


                Timeline nextTime = new Timeline(year,name,involve,description,moreInfo);
                timelines.add(nextTime);
            }
            bufferedReader.close();
        }
        catch(IOException exception)
        {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

    public void menu()
    {
        String menuOption = "";

        System.out.println("Welcome to the mini timeline!");

        while (!menuOption.equals("q"))
        {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- (L)oad timeline by year");
            System.out.println("- (S)earch by event");
            System.out.println("- search by (p)eople");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();

            if (!menuOption.equals("q"))
            {
                processOption(menuOption);
            }
        }
    }

    private void processOption(String option)
    {
        if (option.equals("S")||option.equals("s"))
        {
            searchEvents("stuff");
        }
        else if (option.equals("P")||option.equals("p"))
        {
            searchInvolvement("stuff");
        }
        else if (option.equals("L")||option.equals("l"))
        {
            listYears();
        }
        else
        {
            System.out.println("Invalid choice!");
        }
    }

    private void sortResults(ArrayList<Timeline> listToSort)
    {
        for (int j = 1; j < listToSort.size(); j++)
        {
            Timeline temp = listToSort.get(j);
            String tempTitle = temp.getName();

            int possibleIndex = j;
            while (possibleIndex > 0 && tempTitle.compareTo(listToSort.get(possibleIndex - 1).getName()) < 0)
            {
                listToSort.set(possibleIndex, listToSort.get(possibleIndex - 1));
                possibleIndex--;
            }
            listToSort.set(possibleIndex, temp);
        }
    }

    public String displayInfo(Timeline timeline)
    {
        return "<html><body style=\"width:500px\">Name: " + timeline.getName()+
                "<br>"+"Year: " + timeline.getYear()+"<br>"+ "Involvement: "+timeline.getInvolve()+"<br>"+
                "Description: " + timeline.getDescription()+"<br>"+ "More information: " + timeline.getMoreInfo() +
                "</body></html>";
    }

    public ArrayList<Timeline> getTimelines() {
        return timelines;
    }

    public ArrayList<Timeline> searchEvents(String something)
    {

        // prevent case sensitivity
        something = something.toLowerCase();

        // arraylist to hold search results
        ArrayList<Timeline> results = new ArrayList<Timeline>();

        for (int i = 0; i < timelines.size(); i++)
        {
            String event = timelines.get(i).getName();
            event = event.toLowerCase();

            if (event.indexOf(something)!=-1)
            {

                results.add(timelines.get(i));
            }

        }

        // sort the results by title
        sortResults(results);
        return results;

    }

    public ArrayList<Timeline> searchInvolvement(String name) {
        name = name.toLowerCase();
        ArrayList<Timeline> results = new ArrayList<Timeline>();
        for (int i = 0; i < timelines.size(); i++) {
            String cast = timelines.get(i).getInvolve();
            cast = cast.toLowerCase();
            if (cast.contains(name)) {
                results.add(timelines.get(i));
            }
        }
        sortResults(results);
        return results;
    }
    private void listYears()
    {
        ArrayList<Timeline>results= new ArrayList<Timeline>();
        for (int i=0;i<timelines.size();i++){
            int temp = timelines.get(i).getYear();
            int x = 0;
            while (x<results.size()&&temp>results.get(x).getYear()){
                x++;
            }
            results.add(x,timelines.get(i));
        }

        for (int i=0;i<results.size();i++){
            int year = results.get(i).getYear();
            int choiceNum=i+1;
            System.out.println(""+choiceNum+". "+year+" "+results.get(i).getName());
        }
        System.out.println("Which event would you like to learn more about?");
        System.out.println("Enter number: ");
        int choices = scanner.nextInt();
        Timeline selectedTimeline = results.get(choices-1);
        displayInfo(selectedTimeline);
        System.out.println("\n ** Press Enter to Return to Main Menu **");
        scanner.nextLine();
    }

}
