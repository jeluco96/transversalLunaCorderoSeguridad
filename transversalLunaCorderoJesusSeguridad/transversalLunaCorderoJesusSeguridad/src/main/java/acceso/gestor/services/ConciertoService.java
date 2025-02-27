package acceso.gestor.services;

import java.util.List;
import java.util.Set;

import acceso.gestor.models.Banda;
import acceso.gestor.models.Concierto;

public interface ConciertoService {
    List<Concierto> findAll();
    Set<Concierto> findByLugar(String lugar);
    public Concierto createConcierto(Concierto concierto);
    public Concierto findConciertoByIdConcierto(Long idConcierto);
}