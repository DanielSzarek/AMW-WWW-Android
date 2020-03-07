package pl.szarek.lab_8_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szarek.lab_8_hibernate.model.Track;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findAllByNameContaining(String name);

    List<Track> findAllByAuthorContaining(String author);

    Optional<Track> findById(Long id);
}
