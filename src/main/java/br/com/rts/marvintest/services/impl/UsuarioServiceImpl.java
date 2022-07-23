package br.com.rts.marvintest.services.impl;

import br.com.rts.marvintest.controllers.request.UsuarioRequest;
import br.com.rts.marvintest.domains.entity.Usuario;
import br.com.rts.marvintest.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<Usuario> getAllUsuario() {
        return null;
    }

    @Override
    public Usuario getUsuarioById(Long idUsuario) {
        return null;
    }

    @Override
    public Usuario createUsuario(UsuarioRequest usuarioRequest) {
        return null;
    }

    @Override
    public Usuario updateUsuario(Long idUsuario, UsuarioRequest usuarioRequest) {
        return null;
    }

    @Override
    public void deleteUsuario(Long idUsuario) {

    }
}
