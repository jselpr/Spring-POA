package es.exes.victor.spring.dependencias.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Llamadas {

    @Before("execution(* es.exes.victor.spring.dependencias.Logica.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        tabuladores++;
        imprimir(tabuladores,"before : " + joinPoint.getSignature().getName());
        tabuladores--;
    }
    
    @AfterReturning(pointcut="execution(* es.exes.victor.spring.dependencias.Logica.*(..)) &&"+
            "args(numero)")
    public void versuma(JoinPoint joinPoint,int numero){
        tabuladores++;
        imprimir(tabuladores,joinPoint.getSignature().getName()+" after returning escribo parametro de entrada: " + numero);
        tabuladores--;
    }
    
    @After("execution(* es.exes.victor.spring.dependencias.Logica.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        tabuladores++;
        imprimir(tabuladores,"after : " + joinPoint.getSignature().getName());
        tabuladores--;
    }

    @AfterReturning(
            pointcut = "execution(* es.exes.victor.spring.dependencias.Logica.*(..))",
            returning = "resultado")
    public void logAfterReturning(JoinPoint joinPoint, Object resultado) {
        tabuladores++;
        imprimir(tabuladores,"afterReturning : " + joinPoint.getSignature().getName()+" retorna : " + resultado);
        tabuladores--;
    }

    @AfterThrowing(
            pointcut = "execution(* es.exes.victor.spring.dependencias.Logica.*(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        tabuladores++;
        imprimir(tabuladores,"afterThrowing : " + joinPoint.getSignature().getName()+ " Exception : " + error);
        tabuladores--;
    }

    @Around("execution(* es.exes.victor.spring.dependencias.Logica.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        tabuladores++;
        imprimir(tabuladores,"around : " + joinPoint.getSignature().getName()+"(" + Arrays.toString(joinPoint.getArgs())+")");

        imprimir(tabuladores,"Ejecución antes del procesamiento del metodo!");
        Object resultado = joinPoint.proceed(); //continue on the intercepted method
        imprimir(tabuladores,"Ejecución después del procesamiento del metodo! Resultado: " + resultado);
        tabuladores--;
        return resultado;
    }

    private int tabuladores=0;
    public void imprimir(int tabActual,String mensaje){
        char [] buffer = new char[tabuladores];
        Arrays.fill(buffer, '\t');
        System.out.print(buffer);
        System.out.println(mensaje);
    }
}
