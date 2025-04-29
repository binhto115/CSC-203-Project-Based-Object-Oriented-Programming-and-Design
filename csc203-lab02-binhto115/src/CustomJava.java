import java.util.ArrayList;
import java.util.List;
/*
 A static method can access a static field only
 A non-static method can access either a static field or a non-static field
 A static method can either be called from the class itself or
  from the instance of the class
 A non-static method can only be called from an instance of the class
 (create an instance of a class then call)
 */

public class CustomJava{
    // Initializing instance variables; one of it is type List
    public String songName;
    private int playbacks;
    private String artist;
    private double moneyGenerated;
    private final List<String> songList;


    // Constructor
    public CustomJava(String songName, int playbacks, String artist, double moneyGenerated) {
        // This refers to the above fields on the objects
        this.songName = songName;
        this.playbacks = playbacks;
        this.artist = artist;
        this.moneyGenerated = moneyGenerated;
        this.songList = new ArrayList<>();
    }


    // Public Instance Methods: two non-static and one static
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getArtistName() {
        return artist;
    }
    public void setArtistName(String artist) {
        this.artist = artist;
    }
    public int getNumberOfPlaybacks() {
        return playbacks;
    }
    public void setNumberOfPlaybacks(int playbacks) {
        this.playbacks = playbacks;
    }
    public double getMoneyGenerated() {
        return moneyGenerated;
    }
    public void setMoneyGenerated(double moneyGenerated) {
        this.moneyGenerated = moneyGenerated;
    }

    public List<String> getSongList() {
        return this.songList;

    }

    // 2 public non-static and one static method
    public int DoublePlaybacks() {
        return playbacks * 2;
    }
    public boolean isTheArtistInMyList(List<String> artistList, String artist) {
        return artistList.contains(artist);
    }
    public static double VectorMagnitude(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }


    /// Methods that deal with list
    public void insertSongNames(String songName) {
        songList.add(songName);

    }
    public static String LoopTheSongList(int index, List<String> songList) {
        for (int i = 0; i < songList.size(); i++) {
            if (i == index) {
                return songList.get(i);
            }
        }
        return null;
    }
}