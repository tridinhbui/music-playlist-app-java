package app;

public class Song
{
    public Song()
    {
    }
    
    private static String genre;
    private static  String artist;
    private static String name;
    
    //setter
    public static void setName(String name)
    {
        this.name = name;
    }
    
    public static void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    public static void setGenre(String genre)
    {
        this.genre = genre;
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
