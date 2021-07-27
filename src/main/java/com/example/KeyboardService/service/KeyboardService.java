package com.example.KeyboardService.service;

import com.example.KeyboardService.model.MyKeyboard;

import java.util.List;

public interface KeyboardService {
    void save(MyKeyboard myKeyboard);
    MyKeyboard getById(int id);
    List<MyKeyboard> getAllKeyboards();

}
