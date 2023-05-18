package app;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
// import app.PlayList;
// import app.Song;

public class App
{
    public static void main(String[] args)
    {
        PlayList[] albumn = null;
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

                albumn = PlayList[numberPlayList];
                int a = 0;

                for (int i = 0; i < numberPlayList; i ++)
                {
                    a = i+1;
                    System.out.println("Enter the infos for PlayList " + a);
                    albumn[i].askName();
                    albumn[i].askGenre();
                }
            }

            if (input == 3)
            {
                int a = 0;
                for (int i = 0; i < albumn.length; i++)
                {
                    a = i+1;
                    System.out.println("This is playlist " + a);
                    System.out.println("Name: " + albumn[i].getName() + " " + "Genre: " + albumn[i].getGenre());
                    for (int z = 0; z < albumn[i].length; z++)
                    {
                    System.out.println("song: " + albumn[i].getSongByIndex(z).getSongName() + albumn[i].getSongByIndex(z).getArtist());
                    }
                    System.out.println(" ");
                }
            }

            if (input == 4)
            {
                Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
                System.out.println("What play list do you want to add new song(s) to ? ");
                int choice = myObj3.nextInt();
                
                Scanner myObj4 = new Scanner(System.in);  // Create a Scanner object
                System.out.println("How many songs do you want to add ? ");
                int newSongs = myObj4.nextInt();


                for (int i = 0; i < newSongs; i++)
                {
                    albumn[choice].setName();
                    albumn[choice].setArtist();
                    albumn[choice].setGenre();
                }
            }

            if (input == 6)
            {
                try 
                {
                    FileWriter fileWriter = new FileWriter("savefile.txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);

                    for (int i = 0; i < albumn.length; i++) 
                    {
                        printWriter.println("Name: " + albumn[i].getName() + " " + "Genre: " + albumn[i].getGenre());
                    }
                    printWriter.close();
                    fileWriter.close();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showMenu()
    { 
        System.out.println("");
        System.out.println("Main Mene: ");
        System.out.println("-------------------------------------------");
        System.out.println("|   Option 1: Create albumn, and playlists|");
        System.out.println("|   Option 2: Add songs to playlist       |");
        System.out.println("|   Option 4: Add  new songs to playlist  |");
        System.out.println("|   Option 3: Show playlist               |");
        System.out.println("|   Option 6: Save playlist to file       |");
        System.out.println("|   Option 7: Exit                        |");
    }
}
