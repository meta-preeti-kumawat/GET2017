package main.java.com.metacube.layeredArchitecture.dto;

public class Message {
	private String msg;

	public Message() {

	}

	public Message(String msg) {
		setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}