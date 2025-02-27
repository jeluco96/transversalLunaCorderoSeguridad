package acceso.gestor.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acceso.gestor.models.Usuario;
import acceso.gestor.services.UsuarioService;
import acceso.gestor.utiles.JwtUtil;

@RestController
@RequestMapping("/miweb/auth")
public class AuthController {
	private static final Logger logger = LogManager.getLogger(AuthController.class);
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtil jwtUtils; 

	@PostMapping("/login")
	public String login(@RequestBody Usuario usuario) {
		     UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getUsuario(), usuario.getClave());		
		Authentication authentication = authenticationManager.authenticate(token);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return jwtUtils.generateToken(userDetails.getUsername());
	}
	@PostMapping("/nuevousuario")
	   public String registerUser(@RequestBody Usuario user) {
			System.out.println("Entro en alta");
	       if (usuarioService.existsByUsuario(user.getUsuario())) {
	           return "Error: Username is already taken!";
	       }
	       // Create new user's account
	       Usuario newUser = new Usuario(null, user.getUsuario(), encoder.encode(user.getClave()));
	       usuarioService.saveUsuario(newUser);
	       return "User registered successfully!";
	   }
	

}