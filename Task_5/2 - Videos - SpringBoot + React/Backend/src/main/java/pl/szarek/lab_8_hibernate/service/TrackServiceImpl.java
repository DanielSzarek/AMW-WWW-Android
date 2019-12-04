package pl.szarek.lab_8_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.szarek.lab_8_hibernate.model.Track;
import pl.szarek.lab_8_hibernate.repository.TrackRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> getTracksByAuthor(String author) {
        return trackRepository.findAllByAuthorContaining(author);
    }

    @Override
    public Optional<Track> getTrackById(Long id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getTracksByName(String name) {
        return trackRepository.findAllByNameContaining(name);
    }

    public void addTracks() {
        List<Track> list = new ArrayList<>();
        list.add(new Track("Dance Monkey (Lyrics)", "Tones and I","https://www.youtube.com/watch?v=RaWufMtc-LY"));
        list.add(new Track("Chlorine (Official Video)", "Twenty one pilots","https://www.youtube.com/watch?v=eJnQBXmZ7Ek"));
        list.add(new Track("I Just Called To Say I Love You", "Stevie Wonder", "https://www.youtube.com/watch?v=1bGOgY1CmiU"));
        list.add(new Track("Take On Me", "a-ha", "https://www.youtube.com/watch?v=djV11Xbc914"));
        list.add(new Track("Ride", "Twenty one pilots","https://www.youtube.com/watch?v=Pw-0pbY9JeU"));
        list.add(new Track("LSD","Thunderclouds (Official Video) ft. Sia, Diplo, Labrinth","https://www.youtube.com/watch?v=kg1BljLu9YY"));
        list.add(new Track("Photograph", "Ed Sheeran", "https://www.youtube.com/watch?v=nSDgHBxUbVQ"));
        list.add(new Track("Somebody That I Used To Know", "Gotye", "https://www.youtube.com/watch?v=8UVNT4wvIGY"));
        list.add(new Track("Riptide", "Vance Joy", "https://www.youtube.com/watch?v=uJ_1HMAGb4k"));
        list.add(new Track("Catch & Release (Deepend remix) - Lyrics Video", "Matt Simons","https://www.youtube.com/watch?v=1LXsm9y-z3I"));

        trackRepository.saveAll(list);

    }
}
