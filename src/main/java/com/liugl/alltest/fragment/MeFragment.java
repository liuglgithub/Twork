package com.liugl.alltest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liugl.alltest.R;

/**
 * “我的”碎片页面
 * @author wwj_748
 *
 */
public class MeFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	private static volatile MeFragment instance;
	
	public MeFragment(){}
	
	public static MeFragment getInstance(){
		if(instance == null){
			synchronized (MeFragment.class) {
				if(instance ==null){
					instance =new MeFragment();
				}
				
			}
		}
		return instance;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_tab3_fragment, container,
				false);
		return view;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MeFragment instance" + super.toString();

	}
}
