package acceso.gestor.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.gestor.models.Banda;
import acceso.gestor.models.Concierto;
import acceso.gestor.repositories.ConciertoRepository;

@Service
public class ConciertoServiceImpl implements ConciertoService {

	@Autowired
	private ConciertoRepository conciertoRepository;
	
	@Override
	public List<Concierto> findAll() {
return conciertoRepository.findAll();
	}

	@Override
	public Set<Concierto> findByLugar(String lugar) {
	return conciertoRepository.findByLugar(lugar);
	}

	@Override
	public Concierto createConcierto(Concierto concierto) {
	return conciertoRepository.save(concierto);
	}

	@Override
	public Concierto findConciertoByIdConcierto(Long idConcierto) {
		  Optional<Concierto> optionalProduct = conciertoRepository.findById(idConcierto);
	        return optionalProduct.orElseThrow();
	}



	}



