package acceso.gestor.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import acceso.gestor.models.Usuario;

public interface UsuarioService {
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
public boolean existsByUsuario(String username);
public void saveUsuario(Usuario u);
}