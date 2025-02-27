package acceso.gestor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import acceso.gestor.models.Banda;
import acceso.gestor.models.Concierto;
import acceso.gestor.services.BandaService;
import acceso.gestor.services.ConciertoService;

@Controller
@RequestMapping("/miweb")public class WebController {

    @Autowired
    private BandaService bandaService;
    
    @Autowired
    private ConciertoService conciertoService;

    //  Página principal
    @RequestMapping("/") 
    public String index() {
        return "index"; 
    }

    //  Crear una Banda 
    @PostMapping("/banda")
    @ResponseBody 
    public ResponseEntity<Banda> addBanda(@RequestBody Banda banda) {
        Banda addedBanda = bandaService.createBanda(banda);
        return new ResponseEntity<>(addedBanda, HttpStatus.CREATED);
    }

    //  Obtener todas las Bandas (GET)
    @GetMapping("/bandalista")
    @ResponseBody
    public ResponseEntity<List<Banda>> getAllBandas() {
        List<Banda> bandas = bandaService.findAll();
        return ResponseEntity.ok(bandas);
    }

    //  Obtener Banda por ID 
    @GetMapping("/banda/{id}")
    @ResponseBody
    public ResponseEntity<Banda> getBandaById(@PathVariable Long id) {
        Banda banda = bandaService.findBandaByIdBanda(id);
        return ResponseEntity.ok(banda);
    }

    //  Crear Concierto (POST)
    @PostMapping("/concierto")
    @ResponseBody 
    public ResponseEntity<Concierto> addConcierto(@RequestBody Concierto concierto) {
        Concierto addedConcierto = conciertoService.createConcierto(concierto);
        return new ResponseEntity<>(addedConcierto, HttpStatus.CREATED);
    }

    //  Obtener todos los Conciertos 
    @GetMapping("/concierto")
    @ResponseBody
    public ResponseEntity<List<Concierto>> getAllConciertos() {
        List<Concierto> conciertos = conciertoService.findAll();
        return ResponseEntity.ok(conciertos);
    }

    //  Obtener Concierto por ID 
    @GetMapping("/concierto/{id}")
    @ResponseBody
    public ResponseEntity<Concierto> getConciertoById(@PathVariable Long id) {
        Concierto concierto = conciertoService.findConciertoByIdConcierto(id);
        return ResponseEntity.ok(concierto);
    }
    


    @RequestMapping("/lista")
    public String catalog(Model model) {
        List<Banda> bandas = bandaService.findAll();
        model.addAttribute("bandas", bandas);
        return "lista";
	}
    
    @PutMapping("/banda/{id}")
    @ResponseBody
    public ResponseEntity<Banda> updateBanda(@PathVariable Long id, @RequestBody Banda banda) {
        try {
            Banda updatedBanda = bandaService.updateBanda(id, banda);
            return new ResponseEntity<>(updatedBanda, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    
    
}