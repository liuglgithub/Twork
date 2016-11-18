package com.liugl.alltest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.liugl.alltest.R;

import org.w3c.dom.Text;

/**
 * 知道碎片界面
 * @author wwj_748
 *
 */
public class ZhidaoFragment extends Fragment {

	TextView tv;
	EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	private static volatile ZhidaoFragment instance;
	
	public ZhidaoFragment(){}
	
	public static ZhidaoFragment getInstance(){
		if(instance == null){
			synchronized (ZhidaoFragment.class) {
				if(instance ==null){
					instance =new ZhidaoFragment();
				}
				
			}
		}
		return instance;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		Bundle bd = new Bundle();
		if (!TextUtils.isEmpty(editText.getText())){
			bd.putString("con",editText.getText().toString());
		}
		outState.putBundle("bd",bd);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_tab1_fragment, container,
				false);
		
		tv = (TextView) view.findViewById(R.id.tv1);
		editText = (EditText) view.findViewById(R.id.tvcontent);
		if (savedInstanceState!=null){
			editText.setText(savedInstanceState.getBundle("bd").getString("con"));
		}

		new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					Thread.sleep(1000);
//					Log.e("thread" + Thread)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();

		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "111111", Toast.LENGTH_SHORT).show();
			}
		});
		
		return view;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ZhidaoFragment instance"+ super.toString();
	}
	
}
