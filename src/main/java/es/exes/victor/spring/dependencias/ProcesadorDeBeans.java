package es.exes.victor.spring.dependencias;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Esta clase es un procesador de beans, recibe todos los que se crean en spring,
 * permitiendo editar sus propiedades, por eso recibe al bean como primer argumento
 * de ambas funciones. El segundo argumento es el nombre del bean, para permitir
 * discernir si se modifica o no. Debe retornar el objeto modificado.
 */
public class ProcesadorDeBeans implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object objeto, String nombre) throws BeansException {
        System.out.println("Creado objeto ("+nombre+") de tipo: "+objeto.getClass().getName());
        return objeto;
    }

    public Object postProcessAfterInitialization(Object objeto, String nombre) throws BeansException {
        System.out.println("Inicializado objeto ("+nombre+") de tipo: "+objeto.getClass().getName());
        return objeto;
    }
}
