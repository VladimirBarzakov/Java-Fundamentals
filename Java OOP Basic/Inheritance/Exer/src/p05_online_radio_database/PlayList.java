package p05_online_radio_database;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> songs;

    public PlayList() {
        this.songs=new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public int getSongsCount(){
        return this.songs.size();
    }

    public String getSongsLenght(){
        long length = this.songs.stream().mapToLong(Song::getLength).sum();
        long hours = length/3600;
        long minutes = (length%3600)/60;
        long seconds = (length%3600)%60;
        return String.format("%dh %dm %ds",hours,minutes,seconds);

    }
}
