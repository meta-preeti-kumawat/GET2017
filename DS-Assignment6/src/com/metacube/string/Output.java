package com.metacube.string;

public class Output {
    private String message = "";
    private int data;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "\nMessage: "+getMessage()+"\nOutput: "+data;
    }
}
