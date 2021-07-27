package com.example.KeyboardService.service;

import com.example.KeyboardService.model.MyKeyboard;
import com.example.KeyboardService.repository.KeyboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KeyboardServiceImp implements KeyboardService{

    private final KeyboardRepository keyboardRepository;

    @Autowired
    public KeyboardServiceImp(KeyboardRepository keyboardRepository) {
        this.keyboardRepository = keyboardRepository;
    }


    @Override
    @Transactional
    public void save(MyKeyboard myKeyboard) {
        keyboardRepository.save(myKeyboard);
    }

    @Override
    @Transactional
    public MyKeyboard getById(int id) {
        return keyboardRepository.findKeyboardById((long) id);
    }

    @Override
    @Transactional
    public List<MyKeyboard> getAllKeyboards() {
        return keyboardRepository.findAll();
    }


}
