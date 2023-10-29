package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.CaptureMessage;
import com.example.demo.service.SessionManager;

@Controller
public class CaptureController {
    @Autowired
    private SessionManager sessionManager;

    @MessageMapping("/setNickname")
    public void setNicknameForSession(String sessionId, String nickname) {
        sessionManager.setNicknameForSession(sessionId, nickname);
    }

    @MessageMapping("/capture")
    @SendTo("/topic/capture")
    public CaptureMessage captureOptionsForSession(String sessionId, String options) {
        sessionManager.captureOptionsForSession(sessionId, options);
        String nickname = sessionManager.getNicknameForSession(sessionId);
        return new CaptureMessage(nickname, options);
    }
    
    @MessageMapping("/captureImm")
    @SendTo("/topic/captureImm")
    public CaptureMessage captureImmForSession(String sessionId, String imm) {
        sessionManager.captureOptionsForSession(sessionId, imm);
        String nickname = sessionManager.getNicknameForSession(sessionId);
        return new CaptureMessage(nickname, imm);
    }
    
    @GetMapping("/getLiquidColor")
    @ResponseBody
    public CaptureMessage getLiquidColor(String sessionId) {
        // Calculate the average color and return it
        CaptureMessage averageColorMessage = sessionManager.calculateAverageColor(sessionId);
        return averageColorMessage;
    }
}
