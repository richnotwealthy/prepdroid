package com.yolasite.rivyze.prepdroid;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class WebFragment extends Fragment {
	private View v = null;
	private WebView ww;
	private Bundle webViewBundle;

	private static final String powerSchoolURL = "https://spprep.powerschool.com/public/";
	private static final String calendarURL = "https://www.google.com/calendar/embed?title=Saint%20Peter's%20Prep%20Calendar&height=600&wkst=1&bgcolor=%23FFFFFF&src=144grand%40gmail.com&color=%23A32929&src=j2u1oqdhka8e0v1o4p5t6avcjk%40group.calendar.google.com&color=%236E6E41&src=j62aodeshq58d2u3la7pi9b8os%40group.calendar.google.com&color=%230D7813&src=4pjksvuk9if0th7fa6tp1ainoo%40group.calendar.google.com&color=%2329527A&ctz=America%2FNew_York";
	private static final String spprepURL = "http://www.spprep.org/";
	private static final String bellURL = "file:///android_asset/13-14_time_sched_reg.html";
	private static final String navianceURL = "https://connection.naviance.com/family-connection/auth/login/?hsid=spprep";
	private static final String smURL = "file:///android_asset/Prep%20Social%20Media%20-%20Select%20a%20Page.htm";
	private static final String libURL = "https://wbb48701.follettshelf.com/shelf/servlet/presentshelfform.do?site=48701";
	private static final String gmailURL = "https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&service=mail&sacu=1&hd=spprep.org";

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_URL = "url_to_load";
	private static final String PREF_MY_SCHED_URL = "my_sched_url";
	public static final String MY_PREFS = "prepdroid_prefs";
	private static Context appContext;
	private static int section;

	public static SharedPreferences sp;

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static WebFragment newInstance(int sectionNumber) {
		WebFragment fragment = new WebFragment();
		Bundle args = new Bundle();
		section = sectionNumber;

		switch (sectionNumber) {
		case 1:
			args.putString(ARG_URL, powerSchoolURL);
			break;
		case 2:
			args.putString(ARG_URL, gmailURL);
			break;
		case 3:
			args.putString(ARG_URL, bellURL);
			break;
		case 5:
			args.putString(ARG_URL,
					"http://intranet.spprep.org/calendar/announcements/"
							+ formattedDate() + ".html");
			break;
		case 6:
			args.putString(ARG_URL, calendarURL);
			break;
		case 7:
			args.putString(ARG_URL, navianceURL);
			break;
		case 8:
			args.putString(ARG_URL, smURL);
			break;
		case 9:
			args.putString(ARG_URL, libURL);
			break;
		case 10:
			args.putString(ARG_URL, spprepURL);
			break;
		}

		fragment.setArguments(args);
		return fragment;
	}

	@SuppressLint("SimpleDateFormat")
	private static String formattedDate() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(c.getTime());
		Toast.makeText(appContext, date, Toast.LENGTH_LONG).show();
		return date;
	}

	public WebFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		appContext = activity.getApplicationContext();
		sp = this.getActivity().getSharedPreferences(MY_PREFS,
				Context.MODE_PRIVATE);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.fragment_main, container, false);
		this.ww = (WebView) v.findViewById(R.id.browser_Web_View);
		this.ww.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView v, String url) {
				v.loadUrl(url);
				return true;
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(appContext, "Oh no! " + description,
						Toast.LENGTH_SHORT).show();
			}

		});
		this.ww.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				if (view.isShown())
					getActivity().setProgress(newProgress * 100);
			}
		});
		this.ww.getSettings().setJavaScriptEnabled(true);
		if (section != 4)
			this.ww.getSettings().setBuiltInZoomControls(true);
		this.ww.getSettings().setDisplayZoomControls(false);
		this.ww.getSettings().setLoadWithOverviewMode(true);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (this.webViewBundle != null) {
			this.ww.restoreState(this.webViewBundle);
			return;
		}
		if (section == 4) {
			this.ww.loadUrl(sp.getString(PREF_MY_SCHED_URL, "empty"));
			return;
		}
		this.ww.loadUrl(getArguments().getString(ARG_URL));
	}

	@Override
	public void onPause() {

		if (this.ww.isShown() == false) {
			this.ww.stopLoading();
		}
		this.webViewBundle = new Bundle();
		this.ww.saveState(this.webViewBundle);
		super.onPause();
	}

	public void loadUrl(String url) {
		this.ww.loadUrl(url);
	}

	public boolean canGoBack() {
		return this.ww.canGoBack();
	}

	public boolean canGoForward() {
		return this.ww.canGoForward();
	}

	public void goBack() {
		this.ww.goBack();
	}

	public void goForward() {
		this.ww.goForward();
	}

	public void reload() {
		this.ww.reload();
	}

	public boolean isShown() {
		return this.ww.isShown();
	}
}