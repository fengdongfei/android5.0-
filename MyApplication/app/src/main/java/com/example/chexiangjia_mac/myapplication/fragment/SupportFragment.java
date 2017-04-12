package com.example.chexiangjia_mac.myapplication.fragment;


import android.view.View;

import com.example.chexiangjia_mac.myapplication.R;


//适配兼容
public class SupportFragment extends BaseFragment{
	protected View initView(){
		return View.inflate(getActivity(), R.layout.fragment_support,null);
	}
	@Override
	public String getUrl() {
		return "file:///android_asset/support.html";
	}
}
