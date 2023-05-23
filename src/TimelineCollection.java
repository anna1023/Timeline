import javax.naming.TimeLimitExceededException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
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
            searchEvents();
        }
        else if (option.equals("P")||option.equals("p"))
        {
            searchCast();
        }
        else if (option.equals("L")||option.equals("l"))
        {
            //searchKeywords();
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

    private void displayMovieInfo(Timeline timeline)
    {
        System.out.println();
        System.out.println("Name: " + timeline.getName());
        System.out.println("Year: " + timeline.getYear());
        System.out.println("Involvement: "+timeline.getInvolve());
        System.out.println("Description: " + timeline.getDescription());
        System.out.println("More information: " + timeline.getMoreInfo());
    }
    private void searchEvents()
    {
        System.out.print("Enter a tital search term: ");
        String searchTerm = scanner.nextLine();

        // prevent case sensitivity
        searchTerm = searchTerm.toLowerCase();

        // arraylist to hold search results
        ArrayList<Timeline> results = new ArrayList<Timeline>();

        // search through ALL movies in collection
        for (int i = 0; i < timelines.size(); i++)
        {
            String event = timelines.get(i).getName();
            event = event.toLowerCase();

            if (event.indexOf(searchTerm)!=-1)
            {
                //add the Movie objest to the results list
                results.add(timelines.get(i));
            }

        }

        // sort the results by title
        sortResults(results);

        // now, display them all to the user
        for (int i = 0; i < results.size(); i++)
        {
            String title = results.get(i).getName();

            // this will print index 0 as choice 1 in the results list; better for user!
            int choiceNum = i + 1;

            System.out.println("" + choiceNum + ". " + title);
        }

        System.out.println("Which event would you like to learn more about?");
        System.out.print("Enter number: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Timeline selectedTime = results.get(choice - 1);

        displayMovieInfo(selectedTime);

        System.out.println("\n ** Press Enter to Return to Main Menu **");
        scanner.nextLine();
    }

    private void searchCast()
    {
        System.out.println("Enter a cast: ");
        String searchTerm = scanner.nextLine();
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < timelines.size(); i++) {
            String cast = timelines.get(i).getInvolve();
            if (cast.equals(searchTerm)) {
                String temp = timelines.get(i).getInvolve();
                results.add(temp);
                }
            }
        for (int i = 1; i < results.size(); i++) {
            int j = i;
            while (j > 0 && results.get(j - 1).compareTo(results.get(j)) > 0) {
                String swap = results.set(j - 1, results.get(j));
                results.set(j, swap);
                j--;
            }
        }
        for (int i=0; i<results.size()-1;i++){
            if (results.get(i+1).equals(results.get(i))){
                results.remove(i);
                i--;
            }
        }
        for (int i=0;i<results.size();i++){
            String cast = results.get(i);
            int choiceNum=i+1;
            System.out.println(""+choiceNum+". "+cast);
        }
        System.out.println("Which cast would you like to learn more about?");
        System.out.println("Enter number: ");
        int choice = scanner.nextInt();
        String selectedCast = results.get(choice-1);
        ArrayList<Timeline>Movie1 = new ArrayList<Timeline>();
        for (int i=0; i<timelines.size();i++){
            String casts = timelines.get(i).getInvolve();
            if (casts.indexOf(selectedCast)!=-1){
                Movie1.add(timelines.get(i));
            }
        }
        sortResults(Movie1);
        for (int i=0;i<Movie1.size();i++){
            String title = Movie1.get(i).getName();
            int choiceNum = i+1;
            System.out.println(""+choiceNum+". "+title);
        }
        System.out.println("Which movie would you like to learn more about?");
        System.out.println("Enter number: ");
        int choices = scanner.nextInt();
        Timeline selectedTime = Movie1.get(choices-1);
        displayMovieInfo(selectedTime);
        System.out.println("\n ** Press Enter to Return to Main Menu **");
        scanner.nextLine();
    }

}
