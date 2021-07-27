package com.example.KeyboardService.controller;

import com.example.KeyboardService.model.MyKeyboard;
import com.example.KeyboardService.service.KeyboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import java.util.List;
@Api(value = "API для работы с клаиватурами",
        description = "API предоставляет возможность работы с клавиатурами", produces = "application/json")
@RestController
public class KeyboardRestController {
    private final KeyboardService keyboardService;
    private final KafkaTemplate<Long, List<MyKeyboard>> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public KeyboardRestController(KeyboardService keyboardService, KafkaTemplate<Long, List<MyKeyboard>> kafkaTemplate) {
        this.keyboardService = keyboardService;
        this.kafkaTemplate = kafkaTemplate;
    }
    @ApiOperation(value = "Метод возвращает список клавиатур", produces = "application/json")
    @GetMapping("api/keyboard/all")
    public ResponseEntity<?> getAllKeyboards(){

        try {
            kafkaTemplate.send("all_keyboards",  keyboardService.getAllKeyboards());
        }catch (Exception ex){
            logger.error("Ошибка при закзрузке списка клавиатур", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(keyboardService.getAllKeyboards(), HttpStatus.OK);
    }
}
