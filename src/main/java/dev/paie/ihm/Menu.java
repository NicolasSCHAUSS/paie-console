package dev.paie.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Menu {
	
	private Map<Integer, OptionMenu> options = new HashMap<>();
	@Autowired
	private Scanner scanner;

	public Menu(Scanner scanner, ApplicationContext context) {
		init(scanner, context);
		this.scanner = scanner;
	}

	private void init(Scanner scanner, ApplicationContext context) {
		Map<String, OptionMenu> optionMenuBeans = context.getBeansOfType(OptionMenu.class);
		AtomicInteger index = new AtomicInteger();
		
		optionMenuBeans.forEach((cle,val)-> {
			this.options.put(index.incrementAndGet(), val);
		});
	}
	
	public void demarrer() {
		
		while(true)
		{
			// Afficher les libellés des options
			this.options.forEach((key, option) -> {
				System.out.println(key + ". " + option.getLibelle());
			});
			
			int optionMenuChoisie = this.scanner.nextInt();
			
			this.options.get(optionMenuChoisie).executer();
		}
		
	}

}
