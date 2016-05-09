package es.exes.victor.spring.dependencias;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzadera {

    public static void main(String[] args) {
        ApplicationContext aplicacion = new ClassPathXmlApplicationContext("configuracion.xml");
        Logica logica = aplicacion.getBean("objetoLogica", Logica.class);
        System.out.println(logica.getSuma(800));
    }
}
