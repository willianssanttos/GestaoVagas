package br.com.gestaovagas.projeto_em_jpa.modules.company.repositories;

import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    List<JobEntity> findByDescriptionContainingIgnoreCase(String title);

    List<JobEntity> findByCompanyId(UUID companyId);
}
