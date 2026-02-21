package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.datafaker.Faker;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MicroserviceApplication.class, args);

		//test();
	}

	private static void test() throws IOException {
		Faker faker = new Faker();
		Random random = new Random();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("d:/employees_100k.csv"))) {
			writer.write("id,name,salary\n");

			for (int i = 1; i <= 100000; i++) {
				String name = faker.name().fullName();
				int salary = 30000 + random.nextInt(220001); // 30k-250k
				writer.write(i + "," + name + "," + salary + "\n");
			}
		}
		System.out.println("Generated employees_100k.csv with 100k records");
	}
}
