package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();

    @PostConstruct
    public void init() {
        artistList.add(new Artist(11L, "Micheal", "Smith", "Eager for anything that includes musical"));
        artistList.add(new Artist(22L, "Dimitri", "Vegas", "Bomb on the stage"));
        artistList.add(new Artist(44L, "Jon", "Jones", "Old Head"));
        artistList.add(new Artist(612L, "Christian", "Pitt", "Country Man"));
        artistList.add(new Artist(327L, "Brad", "Aguer", "Rap Enthusiast"));

        songList.add(new Song("PacX", "Pacman", "Death Metal", 1998));
        songList.add(new Song("ZZX", "What is this", "Turbofolk", 1964));
        songList.add(new Song("TestSong", "TestTitle", "Metal", 2005));
        songList.add(new Song("EDM", "Electro House", "Techno", 2021));
        songList.add(new Song("Test2Random", "Test2Title", "Random", 2015));
    }
}
