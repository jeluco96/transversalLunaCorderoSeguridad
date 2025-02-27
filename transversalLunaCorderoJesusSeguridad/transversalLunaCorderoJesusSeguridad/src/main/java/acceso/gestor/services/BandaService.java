package acceso.gestor.services;

import java.util.List;
import java.util.Set;

import acceso.gestor.models.Banda;

public interface BandaService {
    List<Banda> findAll();
    Set<Banda> findByTipo(String tipo);
    public Banda createBanda(Banda banda);
    public Banda findBandaByIdBanda(Long idBanda);
    Banda updateBanda(Long idBanda, Banda banda);
}