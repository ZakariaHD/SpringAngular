package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAngularApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		
		contactRepository.save(new Contact("Ziari", "tarik", df.parse("12/01/1990"), "z.tarik@gmail.com", 066112523, "tarik.jpeg"));
		contactRepository.save(new Contact("Abba", "khalid", df.parse("25/01/1991"), "z.khalid@gmail.com", 12560, "khalid.jpeg"));
		contactRepository.save(new Contact("Bartal", "hamid", df.parse("01/01/1992"), "z.bartal@gmail.com", 06221, "hamids.jpeg"));
		
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}
