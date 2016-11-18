package com.liugl.alltest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liugl on 2016/11/10.
 */

public class MyFragment extends Fragment{

    @BindView(R.id.testbtn)
      Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.containt_fragments_layout,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.testbtn})
    public void click(View view){
        switch (view.getId()){
            case R.id.testbtn:
                Toast.makeText(getActivity(),"this is toast in fragment",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
