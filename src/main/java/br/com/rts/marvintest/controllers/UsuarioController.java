package br.com.rts.marvintest.controllers;

import br.com.rts.marvintest.controllers.request.UsuarioRequest;
import br.com.rts.marvintest.controllers.responses.UsuarioResponse;
import br.com.rts.marvintest.domains.entity.Usuario;
import br.com.rts.marvintest.mappers.UsuarioMapper;
import br.com.rts.marvintest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllUsuario() {

        List<Usuario> usuarioList = service.getAllUsuario();

        if (Objects.isNull(usuarioList) || usuarioList.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity
                .ok(mapper.entityToResponse(usuarioList));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> getAllUsuario(@RequestParam Long idUsuario) {

        Usuario usuario = service.getUsuarioById(idUsuario);

        if (Objects.isNull(usuario))
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(mapper.entityToResponse(usuario));
    }

    @PostMapping()
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuario = mapper.requestToEntity(usuarioRequest);
        usuario = service.createUsuario(usuario);

        if (Objects.isNull(usuario))
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(mapper.entityToResponse(usuario));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> updateUsuario(@RequestParam Long idUsuario,
                                                         @RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuario = mapper.requestToEntity(usuarioRequest);

        usuario = service.updateUsuario(idUsuario, usuario);

        if (Objects.isNull(usuario))
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(mapper.entityToResponse(usuario));
    }

}
