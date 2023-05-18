package app;

public class PlayList
{
    Song[] playList;

    public PlayList()
    {
        playList = new Song[];
    }

    private String name;
    private String genre;

    public void askName()
    {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("What is the Name of the PlayList ? ");
        name = myObj.nextLine();
    }

    public void askGenre()
    {
        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("What is the Genre of the PlayList ? ");
        genre = myObj2.nextLine();
    }    

    public String getName()
    {
        return name;
    }

    public String getGenre()
    {
        return genre;
    }

    public void addSong()
    {
        System.out.println("\'Print stop when done\'");
        int count = 0;
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Song name: ");
            String getSongName = scan.nextLine();
            Song newSong = new Song();
            newSong.setName(getSongName);
            
            System.out.println("Enter artist name: ");
            String getArtistName = scan.nextLine();
            newSong.setArtist(getArtistName);

            // System.out.println("Enter genre: ");
            // String getArtistName = scan.nextLine();
            // newSong.setArtist(getArtistName);
            
            playList[count] = newSong;
            count++;
            if(answer.equalsIgnoreCase("stop"))
            {
                break;
            }
        }
    }

    public void getSongByIndex(int z)
    {
        return playList[z];
    }
}
