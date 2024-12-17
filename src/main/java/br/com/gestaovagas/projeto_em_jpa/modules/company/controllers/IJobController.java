package br.com.gestaovagas.projeto_em_jpa.modules.company.controllers;

import br.com.gestaovagas.projeto_em_jpa.modules.company.dto.CreateJobDTO;
import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IJobController {


    @Tag(name = "Vagas", description = "Informações das vagas")
    @Operation(summary = "Cadastro de vaga", description = "Essa função é responsável por cadastrar as vagas dentro da empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = JobEntity.class))
            })
    })
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request);

    @Tag(name = "Vagas", description = "Listagem das vagas")
    @Operation(summary = "Listagem de vaga", description = "Essa função é responsável por listar as vagas da empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = JobEntity.class))
            })
    })
    public ResponseEntity<Object> listByCompany(HttpServletRequest request);
}
