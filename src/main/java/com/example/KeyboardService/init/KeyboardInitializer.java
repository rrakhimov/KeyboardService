package com.example.KeyboardService.init;

import com.example.KeyboardService.model.MyKeyboard;
import com.example.KeyboardService.repository.KeyboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class KeyboardInitializer {

    private final KeyboardRepository keyboardRepository;

    @Autowired
    public KeyboardInitializer(KeyboardRepository keyboardRepository) {
        this.keyboardRepository = keyboardRepository;
    }

    @PostConstruct
    public void init(){
        saveKeyboard("Привет!", "Hi!");
        saveKeyboard("Как дела?", "Хорошо. У тебя?");
        saveKeyboard("Ты кто?", "Я чат-бот");
    }

    private void saveKeyboard(String text, String responce){
        keyboardRepository.save(new MyKeyboard(text, responce));
    }
}