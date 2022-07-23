package br.com.rts.marvintest.mappers;

import br.com.rts.marvintest.controllers.responses.UsuarioResponse;
import br.com.rts.marvintest.domains.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    List<UsuarioResponse> entityToResponse(List<Usuario> usuarioList);

    UsuarioResponse entityToResponse(Usuario usuario);

}
