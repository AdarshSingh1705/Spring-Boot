package adarsh.com.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//1.  Configuration
@Configuration
// 2. AOP
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());


    // PointCut - when ?
    // execution(* PACKAGE.*.*(..))
    @Before("adarsh.com.learnspringaop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()") // WHEN
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        logger.info("Before Aspect - {} is called with arguments: {}", joinPoint, joinPoint.getArgs()); // WHAT

    }

    @After("adarsh.com.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After Aspect - {} has executed}", joinPoint);
        // Logic - What ?
    }

    @AfterThrowing(
            pointcut =  "adarsh.com.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception){

        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
        // Logic - What ?
    }

    @AfterReturning(
            pointcut =  "adarsh.com.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue){

        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
        // Logic - What ?
    }


}
