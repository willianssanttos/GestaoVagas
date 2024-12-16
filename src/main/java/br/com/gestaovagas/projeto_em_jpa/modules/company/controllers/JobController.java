package br.com.gestaovagas.projeto_em_jpa.modules.company.controllers;

import br.com.gestaovagas.projeto_em_jpa.modules.company.dto.CreateJobDTO;
import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.company.useCases.CreateJobUseCase;
import br.com.gestaovagas.projeto_em_jpa.modules.company.useCases.ListAllJobsByCompanyUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @Autowired
    private ListAllJobsByCompanyUseCase listAllJobsByCompanyUseCase;

    @PostMapping("/")
    //@PreAuthorize("hasRole('COMPANY')")
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request){
        var companyId = request.getAttribute("company_id");

        try {
            var jobEntity = JobEntity.builder()
                    .benefits(createJobDTO.getBenefits())
                    .companyId(UUID.fromString(companyId.toString()))
                    .description(createJobDTO.getDescription())
                    .level(createJobDTO.getLevel())
                    .build();

            var result = this.createJobUseCase.execute(jobEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
   // @PreAuthorize("hasRole('COMPANY')")
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> listByCompany(HttpServletRequest request){
        var companyId = request.getAttribute("company_id");
        var result = this.listAllJobsByCompanyUseCase.execute(UUID.fromString(companyId.toString()));
        return ResponseEntity.ok().body(result);
    }
}
