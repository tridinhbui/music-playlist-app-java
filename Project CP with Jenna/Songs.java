import java.util.Scanner;
import java.util.ArrayList;
public class App
{
    public static void main(String[] args)
    {
        PlayList[] playList = null;

        while(true)
        {
            showMenu();

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter what you want to do: ");
            int input = myObj.nextInt();

            if (input == 1)
            {
                Scanner myObj2 = new Scanner(System.in);  
                System.out.println("How many playlist you want to make: ");
                int numberPlayList = myObj2.nextInt();
                playList = new PlayList[numberPlayList];

                for (int i = 0; i < numberPlayList; i ++)
                {
                    System.out.println("Enter the infos for PlayList " + i + 1);
                    playList[i] = new PlayList();
                    playList[i].askName();
                    playList[i].askGenre();
                }
            }
            if (input == 2)
            {
                getSong();
            }
        }

        
        
        
        
        //mine
        
    }
    
    public static void getSong()
    {
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("\'Print stop when done\'");
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Song name: ");
            String answer = scan.nextLine();
            Songs.setName(answer);
            
            if(answer.equalsIgnoreCase("stop"))
            {
                break;
            }
            
            //Scanner input_genre = new Scanner(System.in);
            System.out.println("Enter artist name: ");
            String genre = scan.nextLine();
            //if
            Songs.setGenre(genre);
            list.add(answer); //needs to be song with song info
        }
    }
    
    public static void showMenu()
    { 
        System.out.println("");
        System.out.println("Main Mene: ");
        System.out.println("---------------------------------------");
        System.out.println("|   Option 1: Create playlist         |");
        System.out.println("|   Option 2: Add songs to playlist   |");
        System.out.println("|   Option 3: Show playlist           |");
        System.out.println("|   Option 7: Exit                    |");
    }
}
