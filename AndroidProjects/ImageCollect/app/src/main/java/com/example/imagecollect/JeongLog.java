package com.example.imagecollect;

import android.content.Context;
import android.util.Log;

public class JeongLog {
    private Context context;
    private String tag = "Jeong";
    public JeongLog(Context _context)
    {
        context = _context;
    }
    public JeongLog()
    {

    }
    public void logD(String str,Object...param)
    {
        Log.d(tag,String.format(str, param));
    }

    public void logD(String str)
    {
        Log.d(tag, str);
    }
}
