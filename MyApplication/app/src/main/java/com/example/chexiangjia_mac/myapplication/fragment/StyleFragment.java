package com.example.chexiangjia_mac.myapplication.fragment;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chexiangjia_mac.myapplication.MainActivity;
import com.example.chexiangjia_mac.myapplication.R;

//主题样式
public class StyleFragment extends BaseFragment implements MenuItem.OnMenuItemClickListener {

	public static final int NONE_THEME = 0;
	public static final int DEFAULT_THEME = 1;
	public static final int DEFAULT_LIGHT_THEME = 2;
	public static final int DEFAULT_LIGH_DARK_THEME = 3;
	public static final int RED_THEME = 4;
	public static final int PINK_THEME = 5;
	public static final int PURPLE_THEME = 6;
	public static final int DEEP_PURPLE_THEME = 7;
	public static final int INDIGO_THEME = 8;
	public static final int BLUE_THEME = 9;
	public static final int LIGHT_BLUE_THEME = 10;
	public static final int CYAN_THEME = 11;
	public static final int TEAL_THEME = 12;
	public static final int GREEN_THEME = 13;
	public static final int LIGHT_THEME = 14;
	public static final int LIME_THEME = 15;
	public static final int YELLOW_THEME = 16;
	public static final int AMBER_THEME = 17;
	public static final int ORANGE_THEME = 18;
	public static final int DEEP_ORANGE_THEME = 19;
	public static final int BROWN_THEME = 20;
	public static final int GREY_THEME = 21;
	public static final int BLUE_GREY_THEME = 22;

	private String[] menuTitles;
	private ProgressBar pbwx;
	private WebView webView;
	private class WebViewClient extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			pbwx.setProgress(newProgress);
			if(newProgress==100){
				pbwx.setVisibility(View.GONE);
			}
			super.onProgressChanged(view, newProgress);
		}

	}
	protected View initView(){
		View view = View.inflate(getActivity(), R.layout.fragment_style,null);
		pbwx=(ProgressBar)view.findViewById(R.id.pbwx);
		webView=(WebView)view.findViewById(R.id.wv);
		webView.loadUrl("https://hao.360.cn/?src=lm&ls=n2617fc3494");
		Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
		String[] array = getActivity().getResources().getStringArray(R.array.style_names);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,array);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (position != NONE_THEME) {
					setTheme(position);
					reload();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		return view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (menuTitles == null) {
			menuTitles = getActivity().getResources().getStringArray(R.array.style_names);
		}

		for (String name : menuTitles){
			MenuItem menuItem = menu.add(name);
			menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
			menuItem.setOnMenuItemClickListener(this);
		}

		return true;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		for (int i = 0; i < menuTitles.length; i++) {

			if (item.getTitle().equals(menuTitles[i])) {
				Toast.makeText(getActivity(),item.getTitle(),Toast.LENGTH_SHORT).show();
				setTheme(i);
				reload();
				return true;
			}


		}
		return false;
	}

	private void setTheme(int index) {
		switch (index) {
			case DEFAULT_THEME:
				MainActivity.mTheme = R.style.DefaultTheme;
				break;
			case DEFAULT_LIGHT_THEME:
				MainActivity.mTheme = R.style.DefaultLightTheme;
				break;
			case DEFAULT_LIGH_DARK_THEME:
				MainActivity.mTheme = R.style.DefaultLightDarkTheme;
				break;
			case RED_THEME:
				MainActivity.mTheme = R.style.RedTheme;
				break;
			case PINK_THEME:
				MainActivity.mTheme = R.style.PinkTheme;
				break;
			case PURPLE_THEME:
				MainActivity.mTheme = R.style.PurpleTheme;
				break;
			case DEEP_PURPLE_THEME:
				MainActivity.mTheme = R.style.DeepPurpleTheme;
				break;
			case INDIGO_THEME:
				MainActivity.mTheme = R.style.IndigoTheme;
				break;
			case BLUE_THEME:
				MainActivity.mTheme = R.style.BlueTheme;
				break;
			case LIGHT_BLUE_THEME:
				MainActivity.mTheme = R.style.LightBlueTheme;
				break;
			case CYAN_THEME:
				MainActivity.mTheme = R.style.CyanTheme;
				break;
			case TEAL_THEME:
				MainActivity.mTheme = R.style.TealTheme;
				break;
			case GREEN_THEME:
				MainActivity.mTheme = R.style.GreenTheme;
				break;
			case LIGHT_THEME:
				MainActivity.mTheme = R.style.LightGreenTheme;
				break;
			case LIME_THEME:
				MainActivity.mTheme = R.style.LimeTheme;
				break;
			case YELLOW_THEME:
				MainActivity.mTheme = R.style.YellowTheme;
				break;
			case AMBER_THEME:
				MainActivity.mTheme = R.style.AmberTheme;
				break;
			case ORANGE_THEME:
				MainActivity.mTheme = R.style.OrangeTheme;
				break;
			case DEEP_ORANGE_THEME:
				MainActivity.mTheme = R.style.DeepOrangeTheme;
				break;
			case BROWN_THEME:
				MainActivity.mTheme = R.style.BrownTheme;
				break;
			case GREY_THEME:
				MainActivity.mTheme = R.style.GreyTheme;
				break;
			case BLUE_GREY_THEME:
				MainActivity.mTheme = R.style.BlueGreyTheme;
				break;
			default:
				break;
		}
	}

	protected void reload() {
		Intent intent = getActivity().getIntent();
		getActivity().overridePendingTransition(0, 0);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		getActivity().finish();
		FragmentFactory.clear();
		getActivity().overridePendingTransition(0, 0);
		startActivity(intent);
	}

	@Override
	public String getUrl() {
		return "file:///android_asset/theme.html";
	}
}
