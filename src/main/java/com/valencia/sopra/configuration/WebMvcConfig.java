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

/** 
 * CON ESTA ANOTACION 'EnableScheduling' PODEMOS USAR LA ANOTACION 
 * 'Scheduled' DEL MODULO DE SPRING BATCH EN CLASES CON PROCESOS
 * REPETITIVOS O POR LOTES
 * 
 * @author jlGoldaracena
 * 
 */
@EnableScheduling
@Configuration

/** Para Spring 5 y SpringBoot 2 o superiores implementamos o en este
    caso extendemos 'WebMvcConfigurer' en lugar de implementar o extender 
    'WebMvcConfigurerAdapter' (deprecada a partir de estas versiones citadas) */

/** descomentar este método para versiones superiores de SpringBoot 2 o Spring Framework 5 */
//public class WebMvcConfig implements WebMvcConfigurer {

/** descomentar este método para versiones inferiores de SpringBoot 2 o Spring Framework 5 */
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	
	/** CONFIGURACION DEL EVENTO 'RequestTimeInterceptor' */
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}
}