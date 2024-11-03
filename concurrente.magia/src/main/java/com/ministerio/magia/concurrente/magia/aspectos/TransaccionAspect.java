package com.ministerio.magia.concurrente.magia.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class TransaccionAspect {

    private static final Logger logger = LoggerFactory.getLogger(TransaccionAspect.class);

    @Around("execution(* com.ministerio.magia.concurrente.magia.servicios.*.*(..))")
    public Object gestionarTransaccion(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Iniciando transacción para el método: " + joinPoint.getSignature().getName());

        Object result;
        try {
            result = joinPoint.proceed();
            logger.info("Transacción completada exitosamente para el método: " + joinPoint.getSignature().getName());
        } catch (Exception e) {
            logger.error("Error en la transacción del método: " + joinPoint.getSignature().getName(), e);
            throw e;
        }

        return result;
    }
}
