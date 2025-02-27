package acceso.gestor.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.gestor.models.Concierto;

@Repository
public interface ConciertoRepository extends JpaRepository<Concierto, Long> {
    List<Concierto> findAll();
    Set<Concierto> findByLugar(String lugar);
    Concierto findConciertoByIdConcierto(Long idConcierto);
}
