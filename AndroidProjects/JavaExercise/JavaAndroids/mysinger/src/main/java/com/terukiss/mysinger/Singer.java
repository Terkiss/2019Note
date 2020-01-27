package com.terukiss.mysinger;

public class Singer {

    private static  int total = 0;
    String name;
    String age;


    public Singer(String name, String age) {
        this.age = age;
        this.name = name;
        total++;


    }

    public void playSong()
    {
        MainActivity._this.ToastMessanger("안녕하세요 이번에 대뷔한 개인 가수  %s 라고 합니다. 나이는 %d 에요 ",name, age);

    }

    public void setTotal(int _data)
    {
        total = _data;
    }
    public int getTotal()
    {
        return total;
    }

}
