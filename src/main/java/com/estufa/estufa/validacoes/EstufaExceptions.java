package com.estufa.estufa.validacoes;

public class EstufaExceptions extends RuntimeException{

    public EstufaExceptions(String msg){
        super(msg);
    }
    public EstufaExceptions(Throwable thro){
        super(thro);
    }
}
