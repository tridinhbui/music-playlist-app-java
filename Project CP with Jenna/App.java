import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        PlayList[] playList = null;

        while(true)
        {
            showMenu();

            if (input == 1)
            {
                Scanner myObj2 = new Scanner(System.in);  
                System.out.println("How many playlist you want to make: ");
                int numberPlayList = myObj2.nextInt();
                playList = new PlayList[numberPlayList];

                for (int i = 0; i < numberPlayList; i ++)
                {
                    playList[i] = new PlayList();
                    playList[i].askName();
                    playList[i].askGenre();
                    System.out.println(playList[i].getName());
                    System.out.println(playList[i].getGenre());
                }
            }
        }
    }
    public void showMenu()
    {
        
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter what you want to do: ");
        int input = myObj.nextInt();
    }
}


public class PlayList
{
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
}