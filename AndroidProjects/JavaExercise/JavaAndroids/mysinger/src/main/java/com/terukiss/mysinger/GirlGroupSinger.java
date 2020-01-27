package com.terukiss.mysinger;

import android.content.Context;
import android.widget.Toast;

public class GirlGroupSinger extends Singer {

    public GirlGroupSinger(String name, String age)
    {
        super(name, age);
    }
    public void playSong()
    {
        MainActivity._this.ToastMessanger("안녕하세요 이번에 대뷔한 그룹 %s 라고 합니다. 나이는 %d 에요 ",name, age);
    }
}
