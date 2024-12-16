package br.com.gestaovagas.projeto_em_jpa.modules.company.useCases;

import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.company.repositories.CompanyRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.company.repositories.JobRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.exceptions.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity){
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
