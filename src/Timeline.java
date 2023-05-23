public class Timeline {

    private int year;
    private String name;
    private String description;
    private String involve;
    private String moreInfo;

    public Timeline(int year, String name, String description, String involve, String moreInfo){
        this.year = year;
        this.name = name;
        this.description = description;
        this.involve = involve;
        this.moreInfo = moreInfo;
    }

    public int getYear(){
        return year;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getInvolve(){
        return involve;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String toString (){
        return year+" "+name;
    }
}
