package br.com.gestaovagas.projeto_em_jpa.modules.company.useCases;

import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListAllJobsByCompanyUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(UUID companyId){
        return this.jobRepository.findByCompanyId(companyId);
    }
}
