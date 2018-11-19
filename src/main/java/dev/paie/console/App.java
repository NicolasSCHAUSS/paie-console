package dev.paie.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.ihm.Menu;

public class App {
	
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
		
			Menu menu = context.getBean(Menu.class);
			menu.demarrer();
		}
	}
}
