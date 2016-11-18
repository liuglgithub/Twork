package com.liugl.alltest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liugl.alltest.R;

/**
 * 我想知道的碎片页面
 * @author wwj_748
 *
 */
public class IWantKnowFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	private static volatile IWantKnowFragment instance;
	
	public IWantKnowFragment(){}
	
	public static IWantKnowFragment getInstance(){
		if(instance == null){
			synchronized (IWantKnowFragment.class) {
				if(instance ==null){
					instance =new IWantKnowFragment();
				}
				
			}
		}
		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_tab2_fragment, container,
				false);
		return view;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "IWantKnowFragment instance "+ super.toString();

	}
	
}
