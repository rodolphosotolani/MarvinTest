package br.com.rts.marvintest.controllers.responses;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {

    @ApiModelProperty(
            value = "Código do Usuario",
            example = "1")
    private Long identificador;

    @ApiModelProperty(
            value = "Nome do Usuario",
            example = "Rodolpho Teixeira Sotolani")
    private String nome;

    @ApiModelProperty(
            value = "Documento do Usuario",
            example = "018.648.521-27")
    private String documento;

}
