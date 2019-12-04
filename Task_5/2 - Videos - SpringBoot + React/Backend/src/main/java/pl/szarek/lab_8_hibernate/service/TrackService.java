package pl.szarek.lab_8_hibernate.service;

import pl.szarek.lab_8_hibernate.model.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    List<Track> getTracksByName(String name);

    List<Track> getTracksByAuthor(String author);

    Optional<Track> getTrackById(Long id);
}
