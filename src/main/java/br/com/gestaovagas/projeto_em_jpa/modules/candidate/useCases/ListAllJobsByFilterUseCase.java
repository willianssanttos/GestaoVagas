package br.com.gestaovagas.projeto_em_jpa.modules.candidate.useCases;

import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter){
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
