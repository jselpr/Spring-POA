package es.exes.victor.spring.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "objetoLogica")
@Scope(value = "prototype") // o singleton
public class Logica {
    
    @Autowired
    private Dao dao;
    
    @Autowired
    @Qualifier(value = "dao")
    private Dao dao2;
    
    @Autowired
    @Qualifier(value = "elServicio")
    private Servicio servicio;    
    
    
    public Integer getSuma(int base){
        System.out.println("----- DENTRO DE getSuma() -----");
        if(base>=1000) throw new RuntimeException("Mayor que 1000");
        return base + dao.contarRegistros() + dao2.contarRegistros() + servicio.getValor();
    }
    
}
