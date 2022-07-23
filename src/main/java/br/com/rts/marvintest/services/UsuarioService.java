package br.com.rts.marvintest.services;

import br.com.rts.marvintest.controllers.request.UsuarioRequest;
import br.com.rts.marvintest.domains.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuario();

    Usuario getUsuarioById(Long idUsuario);

    Usuario createUsuario(Usuario usuarioNew);

    Usuario updateUsuario(Long idUsuario, Usuario usuarioNew);

    void deleteUsuario(Long idUsuario);
}
