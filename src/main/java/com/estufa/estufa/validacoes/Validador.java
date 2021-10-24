package com.estufa.estufa.validacoes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Validador {

    public static <T> void validate(T obj) throws IllegalAccessException {

        Field[] fi = obj.getClass().getDeclaredFields();

        for (Field f: fi) {
            f.setAccessible(true);
            if(f.getAnnotation(NotNull.class) != null){
                if(f.get(obj) == null)
                    throw new EstufaExceptions("Variável " + f.getName() + " Não pode ser nulo");
            }
            if(f.getAnnotation(MaiorZero.class) != null){
                if((int)f.get(obj) <= 0)
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
            if(f.getAnnotation(RepetidosArray.class) != null){
                List<Map> a = (List<Map>) f.get(obj);
                List<Map> c = new ArrayList<>(a);
                boolean ret = false;
                int iContem = 0;
                ObjectMapper oMapper = new ObjectMapper();

                for (T mp : (List<T>)a){
                    Map ob = oMapper.convertValue(mp,Map.class);
                    iContem = 0;
                    if(ret)
                        break;
                    for (T ma : (List<T>)c) {
                        Map oc = oMapper.convertValue(ma,Map.class);
                        if (ob.equals(oc)){
                            iContem++;
                        }
                        if(iContem > 1){
                            ret = true;
                            break;
                        }
                    }
                }
                if(ret)
                    throw new EstufaExceptions("Array List Não pode Conter valores Repetidos");
            }
        }

    }
}
