package adarsh.com.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* adarsh.com.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* adarsh.com.learnspringaop.aopexample.*.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* adarsh.com.learnspringaop.aopexample.*.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(adarsh.com.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
