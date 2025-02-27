package acceso.gestor.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.gestor.models.Banda;

@Repository
public interface BandaRepository extends JpaRepository<Banda, Long> {
    List<Banda> findAll();
    Set<Banda> findByTipo(String tipo);
    Banda findBandaByIdBanda(Long idBanda);



}