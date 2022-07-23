package br.com.rts.marvintest.services;

import br.com.rts.marvintest.controllers.request.UsuarioRequest;
import br.com.rts.marvintest.domains.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuario();

    Usuario getUsuarioById(Long idUsuario);

    Usuario createUsuario(UsuarioRequest usuarioRequest);

    Usuario updateUsuario(Long idUsuario, UsuarioRequest usuarioRequest);

    void deleteUsuario(Long idUsuario);
}
