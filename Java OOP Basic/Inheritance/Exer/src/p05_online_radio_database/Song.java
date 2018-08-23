package p05_online_radio_database;
import p05_online_radio_database.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, String lenght) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(lenght);
    }

    private void setLength(String length) throws InvalidSongLengthException {
        int minutes =0;
        int seconds =0;
        try {
            String[] tokens = length.split(":");
            minutes = Integer.parseInt(tokens[0]);
            seconds = Integer.parseInt(tokens[1]);
        } catch (Exception e){
            throw new InvalidSongLengthException("Invalid song length.");
        }
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName==null||artistName.length()<3 || artistName.length()>20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    public void setSongName(String songName) throws InvalidSongNameException {
        if (songName==null||songName.length()<3 || songName.length()>20){
            throw new InvalidSongNameException  ("p05_online_radio_database.Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    public void setMinutes(int minutes) throws InvalidSongMinutesException {
        if (minutes<0 || minutes>14){
            throw  new InvalidSongMinutesException("p05_online_radio_database.Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds<0 || seconds>59){
            throw new InvalidSongSecondsException("p05_online_radio_database.Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    public int getLength(){
        return seconds+minutes*60;
    }
}
