package br.com.gestaovagas.projeto_em_jpa.modules.exceptions;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
        super("Company not found");
    }
}
