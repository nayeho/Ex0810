package com.example.ex0810;

public class ChatVO {

    private int img;
    private String name;
    private String msg;
    private String time;

    // 생성자, Getter & Setter 만들기!!
    // FireBase Realtime DB로부터 VO형식으로 값을 받기 위해서는
    // 기본 생성자가 만들어져야 있어햐 한다.

    public ChatVO(){

    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ChatVO(int img, String name, String msg, String time) {
        this.img = img;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }
}
