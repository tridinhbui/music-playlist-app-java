import java.util.Scanner;

public class Playlist
{
    private String name;
    private String genre;
    private Playlist[] playList;

    private void askName()
    {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("What is the Name of the PlayList ? ");
        String name = myObj.nextString();
    }

    private void askGenre()
    {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("What is the Genre of the PlayList ? ");
        String genre = myObj.nextString();
    }    

    public String getName()
    {
        return name;
    }

    public String getGenre()
    {
        return genre;
    }
}