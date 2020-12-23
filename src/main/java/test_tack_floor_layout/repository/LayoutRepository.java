package test_tack_floor_layout.repository;

import net.bytebuddy.description.NamedElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test_tack_floor_layout.models.Layout;

import java.util.Optional;

@Repository
public interface LayoutRepository extends JpaRepository<Layout, Long> {
    Optional<Layout> findById(Long id);
    Layout findByName(String name);
}
