package com.labas.bozidar.foi.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by bozidar on 29.03.15..
 */
public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview, container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                updateDetail();
            }
        });
        return view;
    }

    public interface OnItemSelectedListener{
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener) activity;
        }else{
            throw new ClassCastException(activity.toString()
            + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail(){
        String newTime = String.valueOf(System.currentTimeMillis());
        listener.onRssItemSelected(newTime);
    }

}
