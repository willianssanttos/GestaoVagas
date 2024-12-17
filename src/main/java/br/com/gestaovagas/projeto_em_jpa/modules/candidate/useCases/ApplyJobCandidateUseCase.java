package br.com.gestaovagas.projeto_em_jpa.modules.candidate.useCases;

import br.com.gestaovagas.projeto_em_jpa.modules.candidate.repository.CandidateRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.entity.ApplyJobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.repository.ApplyJobRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.company.repositories.JobRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.exceptions.JobNotFoundException;
import br.com.gestaovagas.projeto_em_jpa.modules.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}
