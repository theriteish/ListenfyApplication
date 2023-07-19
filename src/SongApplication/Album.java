package SongApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String albumName;
    private String artistName;

    private List<Song> songList;

    public String getArtistName() {
        return artistName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public Boolean findSongByTitle(String title){
        for(Song songs : songList){
            if(title.equals(songs.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public String addNewSongToAlbum(String title, double duration){
        //check if already added:
        if(findSongByTitle(title)){
            return "Song is already added";
        }

        Song song = new Song(title,duration);
        this.songList.add(song);

        return "Song has been added successfully";
    }

    public String addSongToPlayList(int songNo, ArrayList<Song>playList){
        //first we will calculate the index of the song with the help of songNo;
        int idx = songNo-1;

        if(idx>=0 && idx<songList.size()){
            //this means we have this song in our songList
            //add it to the given playList:

            Song song = songList.get(idx);
            playList.add(song);

            return "Song added to playList successfully";
        }else{
            return "Song No entered is invalid";
        }
    }

    public String addSongToPlayList(String title, ArrayList<Song>playList){

       for(Song song : songList){
           if(song.getTitle().equals(title)){
               playList.add(song);
               return "Song added to playList";
           }
       }
       return "No song found with this title";
    }
}
