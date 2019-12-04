package pl.szarek.lab_8_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.szarek.lab_8_hibernate.model.Track;
import pl.szarek.lab_8_hibernate.service.TrackService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tracks")
@CrossOrigin
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<List<Track>> get(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) String author) {

        if (name != null && author == null) {
            return new ResponseEntity<>(trackService.getTracksByName(name), HttpStatus.OK);

        }
        else if (name == null && author != null) {
            return new ResponseEntity<>(trackService.getTracksByAuthor(author), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getById(@PathVariable("id") Long id) {
        Optional<Track> track = trackService.getTrackById(id);
        return track.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
