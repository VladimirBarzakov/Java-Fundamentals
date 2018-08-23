package p05_online_radio_database;
import p05_online_radio_database.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayList playList = new PlayList();
        int n  = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Song song=null;
            try {
            String[] tokens = reader.readLine().split(";");
            String artistName = tokens[0];
            String songName = tokens[1];
            String length = tokens[2];
            song = new Song(artistName,songName,length);
            } catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }
            if (song!=null){
                playList.addSong(song);
                System.out.println("Song added.");
            }
        }
        System.out.println(String.format("Songs added: %d",playList.getSongsCount()));
        System.out.println(String.format("Playlist length: %s",playList.getSongsLenght()));
    }
}
