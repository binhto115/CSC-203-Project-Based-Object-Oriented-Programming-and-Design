import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
public class ClassTests {
    @Test
    public void exampleTest() {
        Assertions.assertEquals(2, 1 + 1);
    }
    @Test
    public void testSongInfo() {
        var testGetSong = new CustomJava("Midnight Snacks", 1000, "LOFI", 10000);
        Assertions.assertEquals("Midnight Snacks", testGetSong.getSongName());

    }
    @Test
    public  void testSetSongName() {
        CustomJava secondSong = new CustomJava("Hello", 2000, "me", 10000);
        secondSong.setSongName("Hellow");
        Assertions.assertEquals("Hellow", secondSong.getSongName());
    }

    @Test
    public void testGetArtistName() {
        var testGetSong = new CustomJava("Only", 1000000, "Lee Hi", 1000000);
        Assertions.assertEquals("Lee Hi", testGetSong.getArtistName());

    }
    @Test
    public  void testSetArtistName() {
        CustomJava secondSong = new CustomJava("Yes", 2000, "me", 10000);
        secondSong.setArtistName("yellow");
        Assertions.assertEquals("yellow", secondSong.getArtistName());
    }

    @Test
    public void testGetNumberOfPlaybacks() {
        var testGetSong = new CustomJava("Only", 1000000, "Lee Hi", 1000000);
        Assertions.assertEquals(1000000, testGetSong.getNumberOfPlaybacks());
    }
    @Test
    public void testSetNumberOfPlaybacks() {
        CustomJava song = new CustomJava("Only", 1000000, "Lee Hi", 10000);
        song.setNumberOfPlaybacks(10000000);
        Assertions.assertEquals(10000000, song.getNumberOfPlaybacks());
    }

    @Test
    public void testGetMoneyGenerated() {
        CustomJava SongMoneyGenerated = new CustomJava("My Love", 1000000, "Lee Hi", 999999);
        Assertions.assertEquals(999999, SongMoneyGenerated.getMoneyGenerated());
    }
    @Test
    public void testSetMoneyGenerated() {
        CustomJava SongMoneyGenerated = new CustomJava("My Love", 1000000, "Lee Hi", 888888.888);
        SongMoneyGenerated.setMoneyGenerated(999999.999);
        Assertions.assertEquals(999999.999, SongMoneyGenerated.getMoneyGenerated());
    }
    @Test
    public void testDoublePlaybacks() {
        CustomJava testDoublePLayBacksFunction = new CustomJava("VOH", 1000, "Kevin Penkin", 100000);
        Assertions.assertEquals(2000,testDoublePLayBacksFunction.DoublePlaybacks());
    }
    @Test
    public void testIsTheArtistInMyListTrue() {
        CustomJava testIsTheArtistInMyList = new CustomJava("VOH", 1000, "Kevin Penkin", 100000);
        List<String> artistListTest = new ArrayList<>();
        artistListTest.add("Kevin Penkin");
        Assertions.assertTrue(testIsTheArtistInMyList.isTheArtistInMyList(artistListTest, "Kevin Penkin"));
    }
    @Test
    public void testIsTheArtistInMyListFalse() {
        CustomJava testIsTheArtistInMyList = new CustomJava("VOH", 1000, "Kevin Penkin", 100000);
        List<String> artistListTest = new ArrayList<>();
        artistListTest.add("Kevin Penkin");
        Assertions.assertFalse(testIsTheArtistInMyList.isTheArtistInMyList(artistListTest, "Binh"));
    }
    @Test
    public void testVectorMagnitude() {
        Assertions.assertEquals(5, CustomJava.VectorMagnitude(3, 4) );
    }

    @Test
    public void testInsertSongNames() {
        CustomJava testInsertSongNames = new CustomJava("VOH", 1000, "Kevin Penkin", 10000);
        testInsertSongNames.insertSongNames("VOH");
        testInsertSongNames.insertSongNames("Hey");
        testInsertSongNames.insertSongNames("Neh");
        List<String> songList = testInsertSongNames.getSongList();
        Assertions.assertEquals(3, songList.size());
        Assertions.assertEquals("VOH", songList.get(0));
        Assertions.assertEquals("Hey", songList.get(1));
        Assertions.assertEquals("Neh", songList.get(2));
    }

    @Test
    public void testLoopTheSongList() {
        CustomJava testInsertSongNames = new CustomJava("VOH", 1000, "Kevin Penkin", 10000);
        testInsertSongNames.insertSongNames("VOH");
        testInsertSongNames.insertSongNames("Hey");
        testInsertSongNames.insertSongNames("Neh");
        List<String> songList = testInsertSongNames.getSongList();
        Assertions.assertEquals("VOH", CustomJava.LoopTheSongList(0, songList));
        Assertions.assertEquals("Hey", CustomJava.LoopTheSongList(1, songList));
        Assertions.assertEquals("Neh", CustomJava.LoopTheSongList(2, songList));
    }
}
