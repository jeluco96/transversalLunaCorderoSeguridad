package acceso.gestor.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.gestor.models.Banda;
import acceso.gestor.repositories.BandaRepository;
import exceptions.BandaNotFoundException;

@Service
public class BandaServiceImpl implements BandaService {

	@Autowired
	private BandaRepository bandaRepository;

	@Override
	public List<Banda> findAll() {
		return bandaRepository.findAll();
	}

	@Override
	public Set<Banda> findByTipo(String tipo) {
		return bandaRepository.findByTipo(tipo);
	}

	@Override
	public Banda createBanda(Banda banda) {
		return bandaRepository.save(banda);
	}

	@Override
	public Banda findBandaByIdBanda(Long idBanda) {
		Optional<Banda> optionalProduct = bandaRepository.findById(idBanda);
		return optionalProduct.orElseThrow();
	}

	@Override
	public Banda updateBanda(Long idBanda, Banda banda) {
		Banda bandaModificada = bandaRepository.findById(idBanda)
				.orElseThrow(() -> new BandaNotFoundException(idBanda));

		bandaModificada.setNombre(banda.getNombre());
		bandaModificada.setTipo(banda.getTipo());
		bandaModificada.setNumComponentes(banda.getNumComponentes());

		return bandaRepository.save(bandaModificada);
	}

}
