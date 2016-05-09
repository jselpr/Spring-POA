package es.exes.victor.spring.dependencias;

import org.springframework.stereotype.Repository;

@Repository(value = "dao")
public class Dao {

    public int contarRegistros() {
        return 25;
    }
    
}
