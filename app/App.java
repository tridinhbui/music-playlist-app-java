package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class App {
    public static ArrayList<PlayList> albumn = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            showMenu();
            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            System.out.println("Enter what you want to do: ");
            String inputStr = myObj.nextLine();

            if (!inputStr.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid option number.");
                continue;
            }

            int input = Integer.parseInt(inputStr);
            switch (input) {
                case 1:
                    createPlaylists();
                    break;
                case 2:
                    showPlaylists();
                    break;
                case 3:
                    addSongsToPlaylist();
                    break;
                case 4:
                    removeSongsFromPlaylist();
                    break;
                case 5:
                    editPlaylistDetails();
                    break;
                case 6:
                    searchSongs();
                    break;
                case 7:
                    savePlaylistsToFile();
                    break;
                case 8:
                    clearPlaylist();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid input! Please enter a valid option number.");
                    break;
            }
        }

    }

    public static void showMenu() {
        System.out.println("");
        System.out.println("Main Menu: ");
        System.out.println("-------------------------------------------------");
        System.out.println("|   Option 1: Create album and playlists         |");
        System.out.println("|   Option 2: Show playlists                     |");
        System.out.println("|   Option 3: Add new songs to a playlist        |");
        System.out.println("|   Option 4: Remove songs from a playlist       |");
        System.out.println("|   Option 5: Edit playlist details              |");
        System.out.println("|   Option 6: Search songs                       |");
        System.out.println("|   Option 7: Save playlists to a file           |");
        System.out.println("|   Option 8: clear all songs from a playlist    |");
        System.out.println("|   Option 9: Exit                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void createPlaylists() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("How many playlists do you want to create: ");
        int numberPlaylists = myObj.nextInt();

        for (int i = 0; i < numberPlaylists; i++) {
            System.out.println("Enter the info for Playlist " + (i + 1));
            albumn.add(new PlayList());
            albumn.get(i).setName();
            albumn.get(i).setGenre();
        }

        System.out.println("Playlists created:");
        for (int i = 0; i < albumn.size(); i++) {
            System.out.println("Playlist " + (i + 1) + ": " + albumn.get(i).getName());
        }
    }

    public static void showPlaylists() {
        for (int i = 0; i < albumn.size(); i++) {
            PlayList playlist = albumn.get(i);
            System.out.println("This is playlist " + (i + 1));
            System.out.println("Name: " + playlist.getName());
            System.out.println("Genre: " + playlist.getGenre());
            ArrayList<Song> songs = playlist.getSongList();
            if (songs.isEmpty()) {
                System.out.println("No songs added to this playlist yet!");
            } else {
                System.out.println("Songs:");
                for (Song song : songs) {
                    System.out.println("Song: " + song.getName() + ", Artist: " + song.getArtist());
                }
            }
            System.out.println();
        }
    }

    public static void addSongsToPlaylist() {
        Scanner myObj3 = new Scanner(System.in);
        System.out.println("Which playlist do you want to add new song(s) to?");
        int choice = myObj3.nextInt();

        Scanner myObj4 = new Scanner(System.in);
        System.out.println("How many songs do you want to add?");
        int numSongs = myObj4.nextInt();
        for (int i = 0; i < numSongs; i++) {
            System.out.println("Enter the details for song " + (i + 1));
            albumn.get(choice - 1).addSong(numSongs);
        }
    }

    public static void savePlaylistsToFile() {
        try {
            FileWriter fileWriter = new FileWriter("savefile.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (PlayList playlist : albumn) {
                printWriter.println("Name: " + playlist.getName() + ", Genre: " + playlist.getGenre());
                ArrayList<Song> songs = playlist.getSongList();
                for (Song song : songs) {
                    printWriter.println("Song: " + song.getName() + ", Artist: " + song.getArtist());
                }
                printWriter.println();
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("Playlists saved to file successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editPlaylistDetails() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the playlist index you want to edit: ");
        int playlistIndex = myObj.nextInt();

        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) {
            PlayList playlist = albumn.get(playlistIndex - 1);
            System.out.println("Current details for Playlist " + playlistIndex);
            System.out.println("Name: " + playlist.getName());
            System.out.println("Genre: " + playlist.getGenre());

            System.out.println("Enter the updated name (press Enter to skip): ");
            playlist.setName();

            System.out.println("Enter the updated genre (press Enter to skip): ");
            playlist.setGenre();

            System.out.println("Playlist details updated successfully!");
        } else {
            System.out.println("Invalid playlist index!");
        }
    }

    public static void searchSongs() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the playlist index to search for songs: ");
        int playlistIndex = myObj.nextInt();

        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) {
            PlayList playlist = albumn.get(playlistIndex - 1);
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter the search query (song name or artist): ");
            String searchQuery = inputScanner.nextLine();

            ArrayList<Song> matchingSongs = playlist.searchSongs(searchQuery);
            if (matchingSongs.isEmpty()) {
                System.out.println("No matching songs found in the playlist!");
            } else {
                System.out.println("Matching songs in Playlist " + playlistIndex + ":");
                for (Song song : matchingSongs) {
                    System.out.println("Song: " + song.getName() + ", Artist: " + song.getArtist());
                }
            }
        } else {
            System.out.println("Invalid playlist index!");
        }
    }

    public static void removeSongsFromPlaylist() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the playlist index to remove songs from: ");
        int playlistIndex = myObj.nextInt();

        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) {
            PlayList playlist = albumn.get(playlistIndex - 1);
            ArrayList<Song> songs = playlist.getSongList();

            if (songs.isEmpty()) {
                System.out.println("No songs in the playlist to remove!");
            } else {
                System.out.println("Current songs in Playlist " + playlistIndex + ":");
                for (int i = 0; i < songs.size(); i++) {
                    System.out.println(
                            (i + 1) + ". Song: " + songs.get(i).getName() + ", Artist: " + songs.get(i).getArtist());
                }

                Scanner inputScanner = new Scanner(System.in);
                System.out.println("Enter the index of the song to remove: ");
                int songIndex = inputScanner.nextInt();

                if (songIndex >= 1 && songIndex <= songs.size()) {
                    playlist.removeSong(songIndex - 1);
                    System.out.println("Song removed successfully!");
                } else {
                    System.out.println("Invalid song index!");
                }
            }
        } else {
            System.out.println("Invalid playlist index!");
        }
    }

    public static void clearPlaylist() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the playlist index to clear: ");
        int playlistIndex = myObj.nextInt();
    
        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) {
            PlayList playlist = albumn.get(playlistIndex - 1);
            ArrayList<Song> songs = playlist.getSongList();
    
            if (songs.isEmpty()) {
                System.out.println("The playlist is already empty!");
            } else {
                Scanner confirmationScanner = new Scanner(System.in);
                System.out.println("Are you sure you want to clear the playlist? (yes/no)");
                String confirmation = confirmationScanner.nextLine();
    
                if (confirmation.equalsIgnoreCase("yes")) {
                    playlist.clear();
                    System.out.println("Playlist cleared successfully!");
                } else {
                    System.out.println("Clear operation canceled.");
                }
            }
        } else {
            System.out.println("Invalid playlist index!");
        }
    }
}
    

