package com.valencia.sopra.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** Clase para calcular el tiempo en ms de las peticiones de las vistas
 * 
 * @author jlGoldaracena
 *
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	//PRIMERO
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
		throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	//SEGUNDO
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("URL to: '" + request.getRequestURL().toString() + "' in: '" + (System.currentTimeMillis() - startTime) + "ms'");
	}
}
