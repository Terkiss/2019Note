package com.cyberkyj.chap12;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class DialogFragment extends androidx.fragment.app.DialogFragment{

    public Dialog onCreateDialog(Bundle save )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setIcon(android.R.drawable.ic.dialog.aLert);
        builder.setTitle("Dialog fragment");

        builder.setMessage("Dialog fragment 테스트중");
        builder.setpositivebutton("확인" ,null);


    }

}
