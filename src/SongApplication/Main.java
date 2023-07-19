package SongApplication;

import java.util.*;

public class Main {
    static HashMap<String,List<Song>> map;
    public static void main(String[] args) {

        map = new HashMap<>();

        Album a1 = new Album("Champagne Talk", "King");

        a1.addNewSongToAlbum("Na Ja Tu", 3.4);
        a1.addNewSongToAlbum("OOPS", 4.2);
        a1.addNewSongToAlbum("Maan Meri Jaan", 3.9);
        a1.addNewSongToAlbum("Champagne Talk", 4.8);

        List<Song> songsFromA1= a1.getSongList();
        String artistFromA1 = a1.getArtistName();
        map.put(artistFromA1,songsFromA1);



        Album a2 = new Album("The Eminem Show", "Eminem");
        a2.addNewSongToAlbum("Curtains Up", 4.8);
        a2.addNewSongToAlbum("White America", 4.2);
        a2.addNewSongToAlbum("Business", 5.4);
        a2.addNewSongToAlbum("The Kiss", 4.8);
        a2.addNewSongToAlbum("Superman", 5.2);
        a2.addNewSongToAlbum("Soldier", 3.46);

        List<Song> songsFromA2= a2.getSongList();
        String artistFromA2 = a2.getArtistName();
        map.put(artistFromA2,songsFromA2);

        ArrayList<Song> playList = new ArrayList<>();

        a1.addSongToPlayList(2, playList);
        a1.addSongToPlayList(4, playList);

        a2.addSongToPlayList("Business", playList);
        a2.addSongToPlayList("Superman", playList);
        play(playList);
    }
    public static void play(ArrayList<Song>playList){
        printMenu();

        Scanner sc = new Scanner(System.in);

        //we are maintaining a index pointer:
        int currIdx = 0;


        //Initially we will print the first song:
        System.out.println("Now Playing");
        System.out.println(playList.get(currIdx).toString());


        int choice = sc.nextInt();




        Boolean isOver = false;

        while(!isOver){
            switch(choice){
                case 1:
                    //if we are at the last song of playlist we cant go next:
                    if(currIdx==playList.size()-1){
                        System.out.println("You are at the last Song");
                    }else{
                        currIdx++;
                        System.out.println(playList.get(currIdx).toString());
                    }
                    break;
                case 2:
                    //if we are at the first song of playlist we cant go prev:
                    if(currIdx == 0){
                        System.out.println("You are at the first Song");
                    }else{
                        currIdx--;
                        System.out.println(playList.get(currIdx).toString());
                    }
                    break;
                case 3:
                    System.out.println(playList.get(currIdx).toString());
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    for(Song song : playList){
                        System.out.println(song.toString());
                    }
                    break;
                case 6:
                    playList.remove(currIdx);
                    break;
                case 7:
                   shuffle(playList);
                   break;
                case 8:
                   String artist = sc.next();
                   playSongByArtist(artist,playList);
                   break;
                case 9:
                    isOver = true;
                    break;
            }
            choice = sc.nextInt();
        }

    }
    public static void playSongByArtist(String artist,ArrayList<Song>playList){
        if(map.containsKey(artist)){
            for(Song song :map.get(artist)){
                if(playList.contains(song)){
                    System.out.println(song.toString());
                }
            }
        }else{
            System.out.println("Artist not present.");
        }
    }


    public static void shuffle(ArrayList<Song>playList){
        Random rdm = new Random();
        int rdmIdx = rdm.nextInt(playList.size());
        Song song = playList.get(rdmIdx);
        System.out.println(song.toString());
    }

    public static void printMenu(){
        System.out.println("Enter your choice");
        System.out.println("1. Go to next song");
        System.out.println("2. Go to previous Song");
        System.out.println("3. Repeat this song");
        System.out.println("4. Print the Menu");
        System.out.println("5. Print the playList");
        System.out.println("6. Delete the current song");
        System.out.println("7. Shuffle the PlayList and Pick a Song");
        System.out.println("8. Play Song from Album of your Artist choice");

    }

    }
