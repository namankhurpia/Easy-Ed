package com.namankhurpia.easyed.easyed;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import android.widget.TextView;

/**
 * Created by Naman Khurpia on 18-03-2018.
 */

public class listviewadapter  {
    Context mContext;
    LayoutInflater inflater;
    ArrayList<PersonalDetails> arraylist;
    private static final String TAG = "ListViewAdapter";

    public listviewadapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<PersonalDetails>();
        this.arraylist.addAll(search.personDetailsArrayList);
    }

    public class ViewHolder {
        TextView name;
        TextView age;
    }


}