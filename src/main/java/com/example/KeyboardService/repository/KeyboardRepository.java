package com.example.KeyboardService.repository;

import com.example.KeyboardService.model.MyKeyboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<MyKeyboard,Long> {
    MyKeyboard findKeyboardById(Long keyboardId);

    MyKeyboard findKeyboardByText(String text);

    void deleteKeyboardById(Long keyboardId);
}
