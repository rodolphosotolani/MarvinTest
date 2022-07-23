package br.com.rts.marvintest.services.impl;

import br.com.rts.marvintest.domains.entity.Usuario;
import br.com.rts.marvintest.repositories.UsuarioRepository;
import br.com.rts.marvintest.services.UsuarioService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> getAllUsuario() {
        return repository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long idUsuario) {
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        if (!usuarioOptional.isEmpty())
            return usuarioOptional.get();

        return null;
    }

    @Override
    public Usuario createUsuario(Usuario usuarioNew) {
        usuarioNew.setDataCriacao(LocalDate.now());
        return repository.save(usuarioNew);
    }

    @Override
    public Usuario updateUsuario(Long idUsuario, Usuario usuarioNew) {
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            if (!Strings.isNullOrEmpty(usuarioNew.getDocumento()))
                usuario.setDocumento(usuarioNew.getDocumento());

            if (!Strings.isNullOrEmpty(usuarioNew.getNome()))
                usuario.setNome(usuarioNew.getNome());

            usuario.setDataAtualizacao(LocalDate.now());

            return repository.save(usuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long idUsuario) {

        if (repository.existsById(idUsuario))
            repository.deleteById(idUsuario);

    }
}
