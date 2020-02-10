package com.dotge.self10_2;

import android.widget.EditText;

public class SelfEditText extends SelfObject  {

    private EditText editText;

    public SelfEditText()
    {

    }
    public SelfEditText(String id)
    {
        super(id);
    }

    public String getID() {
        return ID;
    }

    public void setId(String id) {
        ID = id;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public EditText getEditText() {
        return editText;
    }
}
