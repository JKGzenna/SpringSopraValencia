package com.valencia.sopra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/** 
Para Spring 5 y SpringBoot 2 o superiores implementamos o en este
caso extendemos 'WebMvcConfigurer' en lugar de implementar o extender 
'WebMvcConfigurerAdapter' (deprecada a partir de estas versiones citadas)
*/
/** descomentar este método para versiones superiores de SpringBoot 2 o Spring Framework 5 */
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** descomentar este método para versiones inferiores de SpringBoot 2 o Spring Framework 5 */
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.valencia.sopra.component.RequestTimeInterceptor;

/** Con esta anotación podemos usar la anotacion Scheduled del 
 *  modulo SpringBatch en clases con procesos repetitivos o por lotes */
@EnableScheduling
@Configuration

/** 
   Para Spring 5 y SpringBoot 2 o superiores implementamos o en este
   caso extendemos 'WebMvcConfigurer' en lugar de implementar o extender 
   'WebMvcConfigurerAdapter' (deprecada a partir de estas versiones citadas)
*/

/** descomentar este método para versiones superiores de SpringBoot 2 o Spring Framework 5 */
//public class WebMvcConfig implements WebMvcConfigurer {

/** descomentar este método para versiones inferiores de SpringBoot 2 o Spring Framework 5 */
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	//PARA ATRAPAR EN EL LOG EL TIEMPO DE LAS PETICIONES DE LAS VISTAS
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}
}