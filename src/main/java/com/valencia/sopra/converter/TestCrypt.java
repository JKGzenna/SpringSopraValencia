package com.valencia.sopra.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {
	
	/** 
	 * CLASE PARA CREAR NUESTRAS CLAVES CIFRADAS A 128-256 BITS. INTRODUCIMOS LA 
	 * CLAVE QUE DESEAMOS ENCRIPTAR Y HACEMOS UN 'RUN AS JAVA APPLICATION, IREMOS 
	 * A LA CONSOLA DESPUES DE LA EJECUCION PARA VER Y COPIAR ESA CLAVE YA ENCRIPTADA
 	 * A CONTINUACION NOS VAMOS A BASE DE DATOS Y HACEMOS 2 INSERT, EL PRIMERO EN 
 	 * LA TABLA 'users' y EL SEGUNDO EN LA TABLA 'user_roles' .LOS INSERT PARA ESTA
 	 * TAREA DE REGISTRAR USUARIOS SE ENCUENTRAN EN LA HOJA DE SQL LLAMADA '
	 * 'script de creacion de usuarios y roles'  SUBIDA AL GIT DENTRO DE LA CARPETA DEL PROYECTO.  
	 * 
	 * @param args
	 * 
	 * @author jlGoldaracena
	 * 
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
				//AQUI EL PASSWORD QUE QUEREMOS CIFRAR 
				System.out.println(pe.encode("AQUI LA CLAVE A ENCRIPTAR"));

	}

}
