package gr.aueb.cf.starter_data.repository;

import gr.aueb.cf.starter_data.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Repository   -- not needed if extending JpaRepository, as Spring Data JPA will automatically implement it
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUuid(UUID uuid);

    List<Teacher> findByLastname(String lastname);

    List<Teacher> findByActiveTrue();

    // προτιμότερο να χρησιμοποιούμε StartsWith γιατί είναι πιο γρήγορο από το Contains (χρησιμοποιεί index)
    List<Teacher> findByLastnameContainingIgnoreCase(String keyword);      // LIKE keyword
    List<Teacher> findByLastnameStartsWithIgnoreCase(String keyword);      // LIKE %keyword%
    List<Teacher> findByLastnameStartsWith(String keyword);                // without ignoring case

    boolean existsByLastname(String lastname);

    long countByActiveTrue();

    // Custom query using JPQL to find active teachers by lastname prefix
    @Query("SELECT t FROM Teacher t WHERE t.firstname LIKE %:prefix% AND t.active = true")
    List<Teacher> findActiveByPrefix(@Param("prefix") String prefix);

}
