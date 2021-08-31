package com.estufa.estufa.validacoes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validador {

    public static <T> void validate(T obj) throws IllegalAccessException {

        Field[] fi = obj.getClass().getFields();

        for (Field f: fi) {
            f.setAccessible(true);
            if(f.getAnnotation(NotNull.class) != null){
                if(f.get(obj) == null)
                    throw new EstufaExceptions("Variável " + f.getName() + " Não pode ser nulo");
            }
            if(f.getAnnotation(MaiorZero.class) != null){
                if((int)f.get(obj) < 0)
                    throw new EstufaExceptions("Variável " + f.getName() + " Não pode ser menor que zero");
            }
            if(f.getAnnotation(EntreZeroUm.class) != null){
                if((int)f.get(obj) != 0 && (int) f.get(obj) != 1)
                    throw new EstufaExceptions("Variável " + f.getName() + " Não pode ser menor que zero e maior que um");
            }
            if(f.getAnnotation(MaxString.class) != null){
                String aux = (String)f.get(obj);
                if(f.getAnnotation(MaxString.class).value() < aux.length())
                    throw new EstufaExceptions("Variável " + f.getName() + " Contém Valor maior que o permitido");
            }
//            if(f.getAnnotation(RepetidosArray.class) != null){
//                 a = f.get(obj);
//                if((int)f.get(obj) != 0 && (int) f.get(obj) != 1)
//                    throw new EstufaExceptions("Variável " + f.getName() + " Não pode ser menor que zero e maior que um");
//            }
        }

    }
}
