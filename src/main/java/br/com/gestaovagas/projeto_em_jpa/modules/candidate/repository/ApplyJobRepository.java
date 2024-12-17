package br.com.gestaovagas.projeto_em_jpa.modules.candidate.repository;

import br.com.gestaovagas.projeto_em_jpa.modules.candidate.entity.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
