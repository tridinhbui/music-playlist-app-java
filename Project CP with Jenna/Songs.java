import java.util.Scanner;
public class Songs
{
    public Songs()
    {
    }
    
    private static String genre;
    private static  String artist;
    private static String name;
    
    //setter
    public static void setName(String theName)
    {
        name = theName;
    }
    
    public static void setArtist(String artistName)
    {
        artist = artistName;
    }
    
    public static void setGenre(String type)
    {
        genre = type;
    }
    
    //getter
    public String getSongGenre()
    {
        return genre;
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public String getName()
    {
        return name;
    }
    
    
}
