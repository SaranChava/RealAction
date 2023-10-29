package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.CaptureMessage;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionManager {
    private Map<String, CaptureMessage> sessionData = new HashMap<>();

    public void setNicknameForSession(String sessionId, String nickname) {
        CaptureMessage captureMessage = sessionData.get(sessionId);
        if (captureMessage == null) {
            captureMessage = new CaptureMessage();
            sessionData.put(sessionId, captureMessage);
        }
        captureMessage.setNickname(nickname);
    }

    public String getNicknameForSession(String sessionId) {
        CaptureMessage captureMessage = sessionData.get(sessionId);
        if (captureMessage != null) {
            return captureMessage.getNickname();
        }
        return null;
    }

    public void captureOptionsForSession(String sessionId, String options) {
        CaptureMessage captureMessage = sessionData.get(sessionId);
        if (captureMessage != null) {
            captureMessage.setOptions(options);
        }
    }
    public void captureImmForSession(String sessionId, String imm) {
        CaptureMessage captureMessage = sessionData.get(sessionId);
        if (captureMessage != null) {
            captureMessage.setOptions(imm);
            if(imm=="good") {
            	captureMessage.setColor("green");
            }
            else if(imm=="ok") {
            	captureMessage.setColor("yellow");
            }
            if(imm=="bad") {
            	captureMessage.setColor("red");
            }
        }
    }
    
    public CaptureMessage calculateAverageColor(String sessionId) {
        // Calculate the average color based on attendees' votes
        int totalVotes = sessionData.size(); // Total number of attendees
        int red = 0;
        int green = 0;
        int blue = 0;

        for (CaptureMessage message : sessionData.values()) {
            // Parse the color and sum up the RGB components
            int[] rgb = hexToRgb(message.getColor());
            red += rgb[0];
            green += rgb[1];
            blue += rgb[2];
        }

        // Calculate the average RGB values
        red /= totalVotes;
        green /= totalVotes;
        blue /= totalVotes;

        // Convert the average RGB values back to an RGB string
        String averageColor = String.format("#%02X%02X%02X", red, green, blue);

        // Create a CaptureMessage object to represent the average color
        CaptureMessage averageColorMessage = new CaptureMessage();
        averageColorMessage.setColor(averageColor);

        return averageColorMessage;
    }

    private int[] hexToRgb(String color) {
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        return new int[]{r, g, b};
    }
}
