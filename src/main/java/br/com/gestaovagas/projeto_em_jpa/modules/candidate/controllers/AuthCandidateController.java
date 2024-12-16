//package br.com.gestaovagas.projeto_em_jpa.modules.candidate.controllers;
//
//import br.com.gestaovagas.projeto_em_jpa.modules.candidate.dto.AuthCandidateRequestDTO;
//import br.com.gestaovagas.projeto_em_jpa.modules.candidate.useCases.AuthCandidateUseCase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/candidate")
//public class AuthCandidateController {
//
//    @Autowired
//    private AuthCandidateUseCase authCandidateUseCase;
//
//    @PostMapping("/auth")
//    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO){
//        try {
//            var token = this.authCandidateUseCase.execute(authCandidateRequestDTO);
//
//            return ResponseEntity.ok().body(token);
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//        }
//    }
//}
