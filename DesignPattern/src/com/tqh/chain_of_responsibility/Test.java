package com.tqh.chain_of_responsibility;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 10:59
 */
public class Test {
    public static void main(String[] args){
        AbstractLogger logger=getLoggerChain();
        logger.logMessage("there is an error",AbstractLogger.ERROR);
        System.out.println("--------------------");
        logger.logMessage("debug message",AbstractLogger.DEBUG);
        System.out.println("--------------------");
        logger.logMessage("normal information",AbstractLogger.INFO);
    }

    private static AbstractLogger getLoggerChain(){
        ErrorLogger errorLogger=new ErrorLogger(AbstractLogger.ERROR);
        DebugLogger debugLogger=new DebugLogger(AbstractLogger.DEBUG);
        InfoLogger infoLogger=new InfoLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);
        return errorLogger;
    }
}
