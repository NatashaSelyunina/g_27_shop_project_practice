package de.aittr.g_27_shop_project_practice.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectLogging {
    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);


//    @Pointcut("execution(* de.aittr.g_27_shop_project_practice.services.jpa." +
//            "JpaProductService.getAllActiveProducts(..))")
//    public void getProducts() {}
//
//    @Before("getProducts()")
//    public void beforeGetProduct(JoinPoint joinPoint) {
//        logger.info("Вызван метод getAllActiveProducts");
//    }
//
//    @Pointcut("execution(* de.aittr.g_27_shop_project_practice.services.jpa." +
//            "JpaProductService.restoreById(..))")
//    public void restore() {}
//
//    @After("restore()")
//    public void afterRestore(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        logger.info(String.format("Метод restoreById вызван с параметром %s", args[0]));
//    }
//
//    @Pointcut("execution(* de.aittr.g_27_shop_project_practice.services.jpa." +
//            "JpaProductService.getActiveProductById(..))")
//    public void getProduct() {}
//
//    @AfterReturning(
//            pointcut = "getProduct()",
//            returning = "result"
//    )
//    public void afterReturningProduct(Object result) {
//        logger.info(String.format("Метод getActiveProductById успешно вернул объект %s", result));
//    }
//
//    @AfterThrowing(
//            pointcut = "getProduct()",
//            throwing = "e"
//    )
//    public void afterThrowing(Exception e) {
//        logger.info(String.format("Метод getActiveProductById выбросил исключение %s", e.getMessage()));
//    }




    // Логирование всех методов сервиса продуктов

//    @Pointcut("execution(* de.aittr.g_27_shop_project_practice.services.jpa.JpaProductService.*(..))")
//    public void logJpaProductService() {}
//
//    @Before("logJpaProductService()")
//    public void before(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        logger.info(String.format("Вызван метод %s с параметрами" + args, name));
//    }
//
//    @After("logJpaProductService()")
//    public void after(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        logger.info(String.format("Метод %s завершил работу", name));
//    }



    // Логирование всех сервисов
    @Pointcut("execution(* de.aittr.g_27_shop_project_practice.services..*.*(..))")
    public void logServices() {}

    @Before("logServices()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info(String.format("Вызван метод %s класса %s с параметрами" + args, name, className));
    }

    @After("logServices()")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String name = joinPoint.getSignature().getName();
        logger.info(String.format("Метод %s класса %s завершил работу", name, className));
    }

    @AfterReturning(
            pointcut = "logServices()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String name = joinPoint.getSignature().getName();
        logger.info(String.format("Метод %s класса %s успешно вернул результат - объект %s", name, className, result));
    }

    @AfterThrowing(
            pointcut = "logServices()",
            throwing = "e"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String name = joinPoint.getSignature().getName();
        logger.info(String.format("Метод %s класса %s вызвал ошибку - выбросил исключение '%s'",
                name, className, e.getMessage()));
    }
}