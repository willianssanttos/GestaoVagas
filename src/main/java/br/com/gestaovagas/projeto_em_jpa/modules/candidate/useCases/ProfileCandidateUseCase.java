package br.com.gestaovagas.projeto_em_jpa.modules.candidate.useCases;

import br.com.gestaovagas.projeto_em_jpa.modules.candidate.CandidateRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.gestaovagas.projeto_em_jpa.modules.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate){
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

        return candidateDTO;
    }
}
