package com.example.KeyboardService.init;

import com.example.KeyboardService.model.MyKeyboard;
import com.example.KeyboardService.service.KeyboardService;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class KeyboardSender {
    private final KeyboardService keyboardService;
    private final KafkaTemplate<Long, List<MyKeyboard>> kafkaTemplate;

    public KeyboardSender(KeyboardService keyboardService, KafkaTemplate<Long, List<MyKeyboard>> kafkaTemplate) {
        this.keyboardService = keyboardService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostConstruct
    public void init(){
        kafkaTemplate.send("all_keyboards",  keyboardService.getAllKeyboards());
    }

    @EventListener
    public void handleContextRefreshEvent(ContextStartedEvent ctxStartEvt) {
        System.out.println("Context Start Event received.");
    }
}
