package com.example.KeyboardService;

import com.example.KeyboardService.model.MyKeyboard;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
public class KeyboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyboardServiceApplication.class, args);
	}
}
