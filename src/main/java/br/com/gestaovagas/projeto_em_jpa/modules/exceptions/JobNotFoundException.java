package br.com.gestaovagas.projeto_em_jpa.modules.exceptions;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(){
        super("Job not found");
    }
}
