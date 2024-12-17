package br.com.gestaovagas.projeto_em_jpa.candidate.useCase;

import br.com.gestaovagas.projeto_em_jpa.modules.candidate.entity.ApplyJobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.entity.CandidateEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.repository.ApplyJobRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.repository.CandidateRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.useCases.ApplyJobCandidateUseCase;
import br.com.gestaovagas.projeto_em_jpa.modules.company.entities.JobEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.company.repositories.JobRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.exceptions.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply for a job if candidate does not found")
    public void should_not_be_apply_jon_with_candidate_not_found(){
        try {
            applyJobCandidateUseCase.execute(null, null );
        } catch (Exception e){
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    public void should_be_able_to_create_a_new_apply_job(){
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder().candidateId(idCandidate).jobId(idJob).build();
        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

        when(applyJobRepository.save(applyJob)).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
