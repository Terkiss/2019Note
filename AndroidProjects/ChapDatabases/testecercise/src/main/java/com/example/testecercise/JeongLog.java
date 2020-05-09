package com.example.testecercise;

import android.content.Context;
import android.util.Log;

public class JeongLog {
    public static JeongLog log ;
    private Context context;
    private String tag = "Jeong";
    public JeongLog(Context _context)
    {
        context = _context;
    }
    public JeongLog()
    {
        log = this;
    }
    public void logD(String str,Object...param)
    {
        Log.d(tag,String.format(str, param));
    }

    public void logD(String str)
    {
        Log.d(tag, str);
    }

    public void logLongD(String str)
    {
        while( str.length() > 0 )
        {
            if( str.length() > 4000 )
            {
                Log.d(tag, str.substring( 0, 4000 ));
                str = str.substring( 4000 );
            }
            else
            {
                Log.d(tag, str);
            }
        }
    }
}
