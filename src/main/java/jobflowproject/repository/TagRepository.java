package jobflowproject.repository;

import jobflowproject.model.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Integer> {

    Optional<Tag> findByName(String name);
}
