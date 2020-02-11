package com.dotge.self10_2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class SelfJavaView {

    /*
        안드로이드 UI 생성 클래스 목록

        변수 필드 항목

        생성자

        레이아웃 기능들

        위젯 생성자

        // 위젯 겟터 세터
     */

    // 필드 항목 시작
    private ArrayList<SelfButton> btn = new ArrayList<SelfButton>();
    private ArrayList<SelfTextView> tv = new ArrayList<SelfTextView>();
    private ArrayList<SelfEditText> et = new ArrayList<SelfEditText>();
    private ArrayList<SelfImageVIew> imageVIews = new ArrayList<SelfImageVIew>();
    private ArrayList<SelfLiearLayout> selfLiearLayouts =new ArrayList<SelfLiearLayout>();
    private ArrayList<SelfViewFlipper> selfViewFlippers = new ArrayList<SelfViewFlipper>();

    // 테스트중인 필드 항목
    private ArrayList<SelfObject> selfObjects = new ArrayList<SelfObject>();

    private LinearLayout ll;
    private Context _context;

    // 필드 항목 끝

    /**
     *
     * @param a : 컨텍트
     * @param orientation : 오리엔테이션
     */
    public SelfJavaView(Context a,int orientation )
    {
        ll = new LinearLayout(a);
        _context = a;

        ll.setOrientation( orientation);
        ll.setPadding(10,10,10,10);
    }
    public SelfJavaView(Context a, LinearLayout aa)
    {
        ll = aa;
        _context =a;
    }




    // 레이아웃 기능 구역 시작

    /**
     * 레이아웃 파람을 만든다.
     * @param a MATCH 입력시 MATCH_PARENT이며 WRAP 입력시 WRAP_CONTENT 이고 숫자를 입력 시 그 숫자만큼 레이아웃 파람을 배정한다
     * @return 구해진 파람값을 리턴 한다
     */
    public int genParams(String a)
    {
        if(a.equals("MATCH")||(Integer.parseInt(a) == -1))
        {
            return LinearLayout.LayoutParams.MATCH_PARENT;
        }
        else if(a.equals("WRAP")||(Integer.parseInt(a) == -2))
        {
            return LinearLayout.LayoutParams.WRAP_CONTENT;
        }
        else
        {
            return Integer.parseInt(a);
        }
    }

    //레이아웃 기능 구역 끝

    //레이아웃 객체 생성 시작

    /**
     * 자식 리니어 레이아웃 을 생성 합니다.
     * @param id 아이디
     * @param backgroundColor 백그라운드 컬러
     * @param width  가로 크기
     * @param height 새로 크기
     */
    public void linearLayoutGenerator(String id, int orientation, int backgroundColor, int width, int height)
    {
        LinearLayout ev_Temp = new LinearLayout(_context);
        SelfLiearLayout _Set = new SelfLiearLayout(id);


        _Set.setID(id);
        _Set.setLinearLayout(ev_Temp);

        ev_Temp.setBackgroundColor(backgroundColor);
        ev_Temp.setOrientation(orientation);
        selfLiearLayouts.add(_Set);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(_Set.getLinearLayout(), _param);
    }

    //레이아웃 객체 생성 끝


    //텍스트뷰 객체 생성 시작

    /**
     * 텍스트 뷰를 생성하고 최상위 부모 레이아웃 객체에
     * 자동 으로 붙입니다.
     * @param id 구분 아이디
     * @param text  컨텐츠 텍스트
     * @param width 가로 크기
     * @param height 새로 크기
     */
    public void textViewGenerator(String id, String text, int width, int height)
    {
        TextView tv_Temp = new TextView(_context);
        SelfTextView _Stv = new SelfTextView();
        _Stv.setID(id);
        _Stv.setTextView(tv_Temp);
        tv_Temp.setText(text);
        tv_Temp.setTextColor(Color.BLACK);
        tv.add(_Stv);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(_Stv.getTextView(), _param);
    }

    /**
     * 텍스트 뷰를 생성하고 최상위 부모 레이아웃 객체에
     * 자동 으로 붙입니다.
     * @param id 객체 아이디
     * @param text 텍스트 뷰 내용
     * @param parent 부모 레이아웃
     * @param width 레이아웃
     * @param height 레이아웃
     */
    public void textViewGenerator(String id, String text, LinearLayout parent, int width, int height)
    {
        TextView tv_Temp = new TextView(_context);
        SelfTextView _Stv = new SelfTextView();
        _Stv.setID(id);
        _Stv.setTextView(tv_Temp);
        tv_Temp.setText(text);

        tv.add(_Stv);
        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        parent.addView(_Stv.getTextView(),_param);
    }


    //텍스트뷰 객체 생성 끝


    //에디트텍스트뷰 객체 생성 시작


    public void editTextViewGenerator(String id, String hint, int width, int height)
    {
        EditText ev_Temp = new EditText(_context);
        SelfEditText _Set = new SelfEditText();

        _Set.setID(id);
        _Set.setEditText(ev_Temp);

        if(hint.length() > 0 )
        {
            ev_Temp.setHint(hint);
        }


        et.add(_Set);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(_Set.getEditText(), _param);
    }

    public void editTextViewGenerator(String id, String hint, LinearLayout parent, int width, int height)
    {
        EditText ev_Temp = new EditText(_context);
        SelfEditText _Set = new SelfEditText();

        _Set.setID(id);
        _Set.setEditText(ev_Temp);

        if(hint.length() > 0 )
        {
            ev_Temp.setHint(hint);
        }

        et.add(_Set);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        parent.addView(_Set.getEditText(), _param);
    }

    //에디트텍스트뷰 객체 생성 끝

    //버튼 객체 생성 시작

    public void buttonGenerator(String Id, int width, int height, String txtName, View.OnClickListener _Onclick)
    {
        Button btn_Temp = new Button(_context);

        btn_Temp.setText(txtName);

        btn_Temp.layout(10,10,10,10);
        btn_Temp.setOnClickListener(_Onclick);

        SelfButton sbtn = new SelfButton();
        sbtn.setID(Id);
        sbtn.setButton(btn_Temp);

        btn.add(sbtn);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(sbtn.getButton(), _param);
    }

    public void buttonGenerator(String Id, String text, LinearLayout parrent, int width, int height, View.OnClickListener _Onclick)
    {
        Button btn_Temp = new Button(_context);

        btn_Temp.setText(text);

        btn_Temp.layout(10,10,10,10);
        btn_Temp.setOnClickListener(_Onclick);

        SelfButton sbtn = new SelfButton();
        sbtn.setID(Id);
        sbtn.setButton(btn_Temp);

        btn.add(sbtn);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        parrent.addView(sbtn.getButton(), _param);
    }

    //버튼 객체 생성 끝

    //이미지뷰 객체 생성 시작
    public void imageViewGenerator(String Id, int width, int height, int imageNumber)
    {
        ImageView imageView_Temp = new ImageView(_context);

        imageView_Temp.setImageResource(imageNumber);

        SelfImageVIew Siv = new SelfImageVIew();
        Siv.setID(Id);
        Siv.setImageView(imageView_Temp);

        imageVIews.add(Siv);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        ll.addView(Siv.getImageView(), _param);
    }

    public void imageViewGenerator(String Id, LinearLayout parrent, int width, int height, int imageNumber)
    {
        ImageView imageView_Temp = new ImageView(_context);

        imageView_Temp.setImageResource(imageNumber);

        SelfImageVIew Siv = new SelfImageVIew();
        Siv.setID(Id);
        Siv.setImageView(imageView_Temp);

        imageVIews.add(Siv);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        parrent.addView(Siv.getImageView(), _param);
    }
    public void imageViewGenerator(String Id, ViewFlipper parrent, int width, int height, int imageNumber)
    {
        ImageView imageView_Temp = new ImageView(_context);

        imageView_Temp.setImageResource(imageNumber);

        SelfImageVIew Siv = new SelfImageVIew();
        Siv.setID(Id);
        Siv.setImageView(imageView_Temp);

        imageVIews.add(Siv);

        LinearLayout.LayoutParams _param =new LinearLayout.LayoutParams(width, height);
        parrent.addView(Siv.getImageView(), _param);
    }
    //이미지뷰 객체 생성 끝

    //뷰플리퍼 객체 생성 시작
    public void viewFlipperGenerator(String id, int width, int height)
    {
        ViewFlipper viewFlipper = new ViewFlipper(_context);

        SelfViewFlipper sVF = new SelfViewFlipper();
        sVF.setID(id);
        sVF.setViewFlipper(viewFlipper);
        selfViewFlippers.add(sVF);

        LinearLayout.LayoutParams _param = new LinearLayout.LayoutParams(width, height);
        ll.addView(sVF.getViewFlipper(), _param);

    }
    public void viewFlipperGenerator(String id, LinearLayout parrent, int width, int height)
    {
        ViewFlipper viewFlipper = new ViewFlipper(_context);

        SelfViewFlipper sVF = new SelfViewFlipper();
        sVF.setID(id);
        sVF.setViewFlipper(viewFlipper);
        selfViewFlippers.add(sVF);

        LinearLayout.LayoutParams _param = new LinearLayout.LayoutParams(width, height);
        parrent.addView(sVF.getViewFlipper(), _param);
    }
    //뷰플리퍼 객체 생성 끝














    /*
    위젯 게터 세터 순서
    레이아웃
    텍스트뷰
    에디트 텍스트 뷰
    버튼
     */

    // findViewBy
    public <T extends SelfObject> T findViewBy(String id)
    {
        for(int i = 0 ; i < selfObjects.size(); i++)
        {
            String chk = selfObjects.get(i).getID();
            if(chk.equals(id))
            {
                return (T)selfObjects.get(i);
            }
        }
        return null;
    }




    /**
     * 파라메터에 아무것도 입력하지 않았을시
     * 최상위 부모 객체를 가져옵니다.
     * @return
     */
    public LinearLayout getLinearLayout()
    {
        if(ll == null )
        {
            Toast.makeText(_context, "레이아웃이 비엇음", Toast.LENGTH_LONG).show();
            return null;
        }
        return ll;
    }

    /**
     * 파라메터에 아이디를 입력시
     * 해당 아이디를 가진 리니어 레이아웃을
     * 가져옵니다.
     * @param id 아이디
     * @return
     */
    public LinearLayout getLinearLayout(String id)
    {
        for(int i = 0; i < selfLiearLayouts.size(); i++)
        {
            if(selfLiearLayouts.get(i).getID().equals(id) )
            {
                return selfLiearLayouts.get(i).getLinearLayout();
            }
        }
        return null;
    }

    /**
     * 텍스트뷰를 가져 옵니다.
     * @param id 아이디
     * @return 텍스트 뷰
     */
    public TextView textViewGet(String id)
    {
        for(int i = 0 ; i < tv.size(); i++)
        {
            if(tv.get(i).getID().equals(id))
            {
                return tv.get(i).getTextView();
            }
        }
        return null;
    }


    /**
     * 에디터 텍스트 뷰를 가져옵니다.
     * @param id 아이디
     * @return 에디터 텍스트 뷰
     */
    public EditText editTextGet(String id)
    {
        for(int i = 0 ; i < et.size(); i++)
        {
            if(et.get(i).getID().equals(id))
            {
                return et.get(i).getEditText();
            }
        }
        return null;
    }

    /**
     * 버튼 을 가져 옵니다.
     * @param id 아이디
     * @return 버튼
     */
    public Button buttonGet(String id)
    {
        for(int i = 0 ; i < btn.size(); i++)
        {
            if(btn.get(i).getID().equals(id))
            {
                return btn.get(i).getButton();
            }
        }
        return null;
    }

    /**
     * 뷰플리퍼를 가져옵니다.
     * @param id
     * @return
     */
    public ViewFlipper viewFlipperGet(String id)
    {
        for(int i  = 0 ; i < selfViewFlippers.size(); i++)
        {
            if( selfViewFlippers.get(i).getID().equals(id) )
            {
                return selfViewFlippers.get(i).getViewFlipper();
            }
        }
        return null;
    }



















/*

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
    }*/


}
