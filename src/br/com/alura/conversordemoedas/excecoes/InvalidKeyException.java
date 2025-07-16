package br.com.alura.conversordemoedas.excecoes;

public class InvalidKeyException extends RuntimeException {
    public InvalidKeyException(String message) {
        super(message);
    }
}
