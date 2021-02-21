package com.eaubrie314.controller.about;

public class AboutResponseDTO {
    private String message;

    public AboutResponseDTO() {

    }
    public AboutResponseDTO(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}