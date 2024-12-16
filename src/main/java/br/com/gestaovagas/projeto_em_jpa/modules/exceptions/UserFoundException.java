package br.com.gestaovagas.projeto_em_jpa.modules.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe");
    }
}
