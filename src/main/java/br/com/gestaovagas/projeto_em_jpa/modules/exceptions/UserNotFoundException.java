package br.com.gestaovagas.projeto_em_jpa.modules.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found");
    }
}
