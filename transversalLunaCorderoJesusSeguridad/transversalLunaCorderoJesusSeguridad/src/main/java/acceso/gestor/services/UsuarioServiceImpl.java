package acceso.gestor.services;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import acceso.gestor.models.Usuario;
import acceso.gestor.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean existsByUsuario(String nombre) {
        return usuarioRepository.existsByUsuario(nombre);
    }

    @Override
    public void saveUsuario(Usuario u) {
        usuarioRepository.save(u);
        System.out.println("Usuario guardado correctamente.");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario en la base de datos
        Usuario usuario = usuarioRepository.findByUsuario(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        return new User(
                usuario.getUsuario(),
                usuario.getClave(),
                Collections.emptyList()
        );
    }
}