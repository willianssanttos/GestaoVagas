package br.com.gestaovagas.projeto_em_jpa.modules.candidate.useCases;

import br.com.gestaovagas.projeto_em_jpa.modules.candidate.entity.CandidateEntity;
import br.com.gestaovagas.projeto_em_jpa.modules.candidate.repository.CandidateRepository;
import br.com.gestaovagas.projeto_em_jpa.modules.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
                candidateEntity.getEmail()).ifPresent(user -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);
    }
}
