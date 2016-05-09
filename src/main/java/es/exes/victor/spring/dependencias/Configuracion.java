package es.exes.victor.spring.dependencias;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
    @Bean(name = "elServicio")
    public Servicio getServicio(){
        return new Servicio();
    }
    @Bean
    public ProcesadorDeBeans getProcesadorDeBeans(){
        return new ProcesadorDeBeans();
    }
}
