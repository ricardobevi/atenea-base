package org.squadra.atenea.base;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.google.gson.Gson;

@Aspect
public class AspectLogger  {

	@Around("execution(* org.squadra.atenea..*(..))")
	public Object tracelog(ProceedingJoinPoint joinpoint) 
	throws Throwable {
		
		
		Gson gson = new Gson();
		
		 Logger log = Logger.getLogger( joinpoint.getSignature().getClass() );
		
		 log.debug( "llamada a metodo: " + joinpoint.getSignature().getName() + " - parametros: "  +  gson.toJson( joinpoint.getArgs()) );
		 
	     Object response = joinpoint.proceed();

	     if( response.equals(null))
	     {
	    	 log.debug( "retorno de metodo: " + joinpoint.getSignature().getName() + " - valor de retorno: null "  );
	     }
	     else
	     {
	    	 log.debug( "retorno de metodo: " + joinpoint.getSignature().getName() + " - valor de retorno: "  +  gson.toJson( response ) ); 
	     }
	     
	     
	     return response;
	     
	}
	
}




