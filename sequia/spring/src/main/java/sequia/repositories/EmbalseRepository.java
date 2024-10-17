package sequia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sequia.entities.Embalse;

@Repository
public interface EmbalseRepository extends JpaRepository<Embalse, Long> {
}
