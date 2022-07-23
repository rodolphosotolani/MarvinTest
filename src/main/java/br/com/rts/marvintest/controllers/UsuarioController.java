package br.com.rts.marvintest.controllers;

import br.com.rts.marvintest.controllers.request.UsuarioRequest;
import br.com.rts.marvintest.controllers.responses.UsuarioResponse;
import br.com.rts.marvintest.domains.entity.Usuario;
import br.com.rts.marvintest.mappers.UsuarioMapper;
import br.com.rts.marvintest.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    @ApiOperation(value = "Buscar todos os Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de usuarios"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllUsuario() {

        List<Usuario> usuarioList = service.getAllUsuario();

        if (Objects.isNull(usuarioList) || usuarioList.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity
                .ok(mapper.entityToResponse(usuarioList));
    }

    @ApiOperation(value = "Buscar Usuario por Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Usuario selecionado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> getAllUsuario(@RequestParam Long idUsuario) {

        Usuario usuario = service.getUsuarioById(idUsuario);

        if (Objects.isNull(usuario))
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(mapper.entityToResponse(usuario));
    }

    @ApiOperation(value = "Cria um Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario criado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping()
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuario = mapper.requestToEntity(usuarioRequest);
        usuario = service.createUsuario(usuario);

        if (Objects.isNull(usuario))
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.entityToResponse(usuario));
    }

    @ApiOperation(value = "Atualiza um Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario atualizado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
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

    @ApiOperation(value = "Deleta um Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Usuario deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deleteUsuario(@RequestParam Long idUsuario) {

        service.deleteUsuario(idUsuario);

        return ResponseEntity
                .accepted()
                .build();
    }

}
