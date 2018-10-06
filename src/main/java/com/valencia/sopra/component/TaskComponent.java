package com.valencia.sopra.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/** 
 *  EJEMPLO DE UN PROCESO SPRING BATCH USANDO LAS ANOTACIONES
 *  ESPECIFICAS 'Scheduled' A NIVEL DE COMPONENTE Y 'EnableScheduling' 
 * 	A NIVEL DE LA CLASE CONFIGURACION DE SPRING, SI LAS QUITAMOS
 *  DESACTIVAMOS EL PROCESO BATCH, BASTA CON QUITAR EL 'EnableScheduling' 
 *  DE LA CLASE DE CONFIGURACIÓN DE SPRING
 *  
 *  @author jlGoldaracena
 *  
 */
@Component("taskComponent")
public class TaskComponent {
	
	private static final Log LOG = LogFactory.getLog(TaskComponent.class);
	
		@Scheduled(fixedDelay=15000)
		public void doTask() {
			LOG.info("Fecha, Hora y Año actuales: "  + new Date ());
		}
	
	
	

}
