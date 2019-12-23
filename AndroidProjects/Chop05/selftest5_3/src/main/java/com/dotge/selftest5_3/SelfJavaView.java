package com.dotge.selftest5_3;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SelfJavaView {

    private ArrayList<SelfButton> btn = new ArrayList<SelfButton>();
    private ArrayList<SelfTextView> tv = new ArrayList<SelfTextView>();
    private ArrayList<SelfEditText> et = new ArrayList<SelfEditText>();

    private String[] callSquence = new String[100];
    private int count =0;
    private LinearLayout ll;
    private Context _context;
    private LinearLayout.LayoutParams btnParam = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );
    private LinearLayout.LayoutParams tvParam = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );
    private LinearLayout.LayoutParams etParam = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );
    public SelfJavaView(Context a)
    {
        ll = new LinearLayout(a);
        _context = a;
        ll.setOrientation( LinearLayout.VERTICAL);
        LinearLayout.LayoutParams inputParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        ll.setPadding(10,10,10,10);

        for(int i = 0 ;  i <callSquence.length; i++ )
        {
            callSquence[i] = "";
        }
    }
    public int LinearParm(String a)
    {
        if(a.equals("Match"))
        {
            return LinearLayout.LayoutParams.MATCH_PARENT;
        }
        else  {
            return LinearLayout.LayoutParams.WRAP_CONTENT;
        }

    }
    public EditText editTextGet(String id)
    {
        for(int i = 0 ; i < et.size(); i++)
        {
            if(et.get(i).getId().equals(id))
            {
                return et.get(i).getEditText();
            }
        }
        return null;
    }
    public TextView textViewGet(String id)
    {
        for(int i = 0 ; i < tv.size(); i++)
        {
            if(tv.get(i).getId().equals(id))
            {
                return tv.get(i).getTextView();
            }
        }
        return null;
    }
    public Button buttonGet(String id)
    {
        for(int i = 0 ; i < tv.size(); i++)
        {
            if(tv.get(i).getId().equals(id))
            {
                return btn.get(i).getButton();
            }
        }
        return null;
    }




    public void btnGenerator(String Id, String txtName, View.OnClickListener _Onclick)
    {
        Button btn_Temp = new Button(_context);

        btn_Temp.setText(txtName);

        btn_Temp.layout(10,10,10,10);
        btn_Temp.setOnClickListener(_Onclick);

        SelfButton sbtn = new SelfButton();
        sbtn.setId(Id);
        sbtn.setButton(btn_Temp);

        btn.add(sbtn);

        callSquence[count] = "btn";
        count++;
    }

    public void btnGenerator(String Id, int width, int height, String txtName, View.OnClickListener _Onclick)
    {
        Button btn_Temp = new Button(_context);

        btn_Temp.setText(txtName);

        btn_Temp.layout(10,10,10,10);
        btn_Temp.setOnClickListener(_Onclick);

        SelfButton sbtn = new SelfButton();
        sbtn.setId(Id);
        sbtn.setButton(btn_Temp);

        btn.add(sbtn);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(sbtn.getButton(), _param);
    }



    public void tvGenerator(String id)
    {
       TextView tv_Temp = new TextView(_context);
       SelfTextView _Stv = new SelfTextView();
       _Stv.setId(id);
       _Stv.setTextView(tv_Temp);
       tv.add(_Stv);
       callSquence[count] = "tv";
       count++;
    }
    public void tvGenerator(String id, int width, int height)
    {
        TextView tv_Temp = new TextView(_context);
        SelfTextView _Stv = new SelfTextView();
        _Stv.setId(id);
        _Stv.setTextView(tv_Temp);
        tv.add(_Stv);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(_Stv.getTextView(), _param);
    }




    public void etGenerator(String id)
    {
        EditText ev_Temp = new EditText(_context);
        SelfEditText _Set = new SelfEditText();

        _Set.setId(id);
        _Set.setEditText(ev_Temp);
        et.add(_Set);
        callSquence[count] = "et";
        count++;
    }
    public void etGenerator(String id, int width, int height)
    {
        EditText ev_Temp = new EditText(_context);
        SelfEditText _Set = new SelfEditText();

        _Set.setId(id);
        _Set.setEditText(ev_Temp);
        et.add(_Set);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(_Set.getEditText(), _param);
    }






    public LinearLayout linearLayoutAddWidget()
    {
        int indexOfTextView=0;
        int indexOfButton=0;
        int indexOfEditView=0;

        for(int i = 0 ; i < callSquence.length; i++)
        {
            if(callSquence[i].equals("tv"))
            {
                TextView _tv = tv.get(indexOfTextView).getTextView();
                indexOfTextView++;
                ll.addView(_tv,tvParam);
            }
            else if(callSquence[i].equals("et") )
            {
                EditText _et = et.get(indexOfEditView).getEditText();
                indexOfEditView++;
                ll.addView(_et, etParam);
            }
            else if(callSquence[i].equals("btn") )
            {
                Button _btn = btn.get(indexOfButton).getButton();
                indexOfButton++;
                ll.addView(_btn, btnParam);
            }
        }

        return ll;
    }

}
