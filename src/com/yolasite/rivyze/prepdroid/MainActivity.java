package com.yolasite.rivyze.prepdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yolasite.rivyze.prepdroid.R;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	public static Context appContext;
	public static int positionForNavDrawer;
	public static FragmentManager fragmentManager;
	private static final String bellURL = "file:///android_asset/13-14_time_sched_reg.html";
	public static final String PREF_MY_SCHED_URL = "my_sched_url";
	public static final String MY_PREFS = "prepdroid_prefs";

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private static WebFragment mWebFragment1 = null;
	private static WebFragment mWebFragment2 = null;
	private static WebFragment mWebFragment3 = null;
	private static WebFragment mWebFragment4 = null;
	private static WebFragment mWebFragment5 = null;
	private static WebFragment mWebFragment6 = null;
	private static WebFragment mWebFragment7 = null;
	private static WebFragment mWebFragment8 = null;
	private static WebFragment mWebFragment9 = null;
	private static WebFragment mWebFragment10 = null;
	private static SetScheduleFragment mySchedFragment = null;
	public static SharedPreferences sp;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_main);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
				Window.PROGRESS_VISIBILITY_ON);
		appContext = this;

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// set up saved settings
		sp = this.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		positionForNavDrawer = position + 1;
		fragmentManager = getSupportFragmentManager();

		switch (positionForNavDrawer) {
		case 1:
			if (mWebFragment1 == null) {
				mWebFragment1 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment1).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment1).commit();
			}
			break;
		case 2:
			if (mWebFragment2 == null) {
				mWebFragment2 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment2).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment2).commit();
			}
			break;
		case 3:
			if (mWebFragment3 == null) {
				mWebFragment3 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment3).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment3).commit();
			}
			break;
		case 4:
			if (sp.getString(PREF_MY_SCHED_URL, null) == null) {
				if (mySchedFragment == null) {
					mySchedFragment = SetScheduleFragment.newInstance();
					fragmentManager.beginTransaction()
							.replace(R.id.container, mySchedFragment).commit();
				} else {
					fragmentManager.beginTransaction()
							.replace(R.id.container, mySchedFragment).commit();
				}
			} else {
				mWebFragment4 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment4).commit();
			}
			break;
		case 5:
			if (mWebFragment5 == null) {
				mWebFragment5 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment5).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment5).commit();
			}
			break;
		case 6:
			if (mWebFragment6 == null) {
				mWebFragment6 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment6).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment6).commit();
			}
			break;
		case 7:
			if (mWebFragment7 == null) {
				mWebFragment7 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment7).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment7).commit();
			}
			break;
		case 8:
			if (mWebFragment8 == null) {
				mWebFragment8 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment8).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment8).commit();
			}
			break;
		case 9:
			if (mWebFragment9 == null) {
				mWebFragment9 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment9).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment9).commit();
			}
			break;
		case 10:
			if (mWebFragment10 == null) {
				mWebFragment10 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment10).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment10).commit();
			}
			break;
		}
		onSectionAttached(positionForNavDrawer);
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
			break;
		case 6:
			mTitle = getString(R.string.title_section6);
			break;
		case 7:
			mTitle = getString(R.string.title_section7);
			break;
		case 8:
			mTitle = getString(R.string.title_section8);
			break;
		case 9:
			mTitle = getString(R.string.title_section9);
			break;
		case 10:
			mTitle = getString(R.string.title_section10);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			if (positionForNavDrawer == 5) {
				getMenuInflater().inflate(R.menu.menu_with_dates, menu);
				restoreActionBar();
				return true;
			}
			if (positionForNavDrawer == 8) {
				getMenuInflater().inflate(R.menu.menu_with_sm, menu);
				restoreActionBar();
				return true;
			}
			if (positionForNavDrawer == 3) {
				getMenuInflater().inflate(R.menu.menu_bell, menu);
				restoreActionBar();
				return true;
			}
			if (positionForNavDrawer == 6) {
				getMenuInflater().inflate(R.menu.menu_refresh, menu);
				restoreActionBar();
				return true;
			}
			if (positionForNavDrawer == 4) {
				getMenuInflater().inflate(R.menu.menu_my_sched, menu);
				restoreActionBar();
				return true;
			}
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_about:
			startActivity(new Intent("com.yolasite.rivyze.prepdroid.ABOUT"));
			return true;
		case R.id.action_browser_back:
			if (getCurrentWV().canGoBack())
				getCurrentWV().goBack();
			return true;
		case R.id.action_browser_forward:
			if (getCurrentWV().canGoForward())
				getCurrentWV().goForward();
			return true;
		case R.id.action_browser_reload:
			getCurrentWV().reload();
			return true;
		case R.id.action_select_date:
			getCurrentWV()
					.loadUrl(
							"http://intranet.spprep.org/calendar/announcements_list.asp");
			return true;
		case R.id.action_sm_facebook_prep:
			getCurrentWV().loadUrl("https://www.facebook.com/spprep");
			return true;
		case R.id.action_sm_facebook_student_life:
			getCurrentWV().loadUrl("https://www.facebook.com/PrepStudents");
			return true;
		case R.id.action_sm_facebook_ignatians:
			getCurrentWV().loadUrl(
					"https://www.facebook.com/groups/ignatianscholars/");
			return true;
		case R.id.action_sm_facebook_kairos:
			getCurrentWV().loadUrl(
					"https://www.facebook.com/groups/16121536489/");
			return true;
		case R.id.action_sm_facebook_emmaus:
			getCurrentWV().loadUrl(
					"https://www.facebook.com/groups/2211411712/");
			return true;
		case R.id.action_sm_facebook_marauders:
			getCurrentWV().loadUrl("https://www.facebook.com/maraudernation");
			return true;
		case R.id.action_sm_twitter_prep:
			getCurrentWV().loadUrl("https://twitter.com/spprep");
			return true;
		case R.id.action_sm_twitter_student_life:
			getCurrentWV().loadUrl("https://twitter.com/PrepStudents");
			return true;
		case R.id.action_sm_twitter_guidance:
			getCurrentWV().loadUrl("https://twitter.com/PrepGuidance");
			return true;
		case R.id.action_sm_twitter_ministry:
			getCurrentWV().loadUrl("https://twitter.com/prepministry");
			return true;
		case R.id.action_sm_twitter_athletics:
			getCurrentWV().loadUrl("https://twitter.com/SPPAthletics");
			return true;
		case R.id.action_sm_twitter_marauders:
			getCurrentWV().loadUrl("https://twitter.com/TheNation15");
			return true;
		case R.id.action_bell_reg:
			getCurrentWV().loadUrl(bellURL);
			return true;
		case R.id.action_bell_assem:
			getCurrentWV().loadUrl(
					"file:///android_asset/13-14_time_sched_assem.html");
			return true;
		case R.id.action_bell_late:
			getCurrentWV().loadUrl(
					"file:///android_asset/13-14_time_sched_late.html");
			return true;
		case R.id.action_bell_xy:
			getCurrentWV().loadUrl(
					"file:///android_asset/13-14_time_sched_xy.html");
			return true;
		case R.id.action_reset_my_sched:
			if (mySchedFragment == null) {
				mySchedFragment = SetScheduleFragment.newInstance();
				fragmentManager.beginTransaction()
						.replace(R.id.container, mySchedFragment).commit();
			} else {
				fragmentManager.beginTransaction()
						.replace(R.id.container, mySchedFragment).commit();
			}
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		if (getCurrentWV().canGoBack() && getCurrentWV().isShown()) {
			getCurrentWV().goBack();
			return;
		} else {
			AlertDialog.Builder exitAlert = new AlertDialog.Builder(appContext,
					2)
					.setIcon(R.drawable.ic_action_alerts_and_states_warning)
					.setTitle(
							Html.fromHtml("<font color='#FFFFFF'>Closing</font>"))
					.setMessage(R.string.closing_message)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									finish();
								}
							}).setNegativeButton("No", null);
			AlertDialog showExitAlert = exitAlert.show();

			final Resources res = getResources();
			final int titleDividerId = res.getIdentifier("titleDivider", "id",
					"android");
			final View titleDivider = showExitAlert
					.findViewById(titleDividerId);
			titleDivider.setBackgroundColor(res.getColor(R.color.maroon));

			Button negButton = showExitAlert
					.getButton(DialogInterface.BUTTON_NEGATIVE);
			negButton
					.setBackgroundResource(R.drawable.selectable_background_marooncompat);
			Button posiButton = showExitAlert
					.getButton(DialogInterface.BUTTON_POSITIVE);
			posiButton
					.setBackgroundResource(R.drawable.selectable_background_marooncompat);
		}

	}

	public static WebFragment getCurrentWV() {

		switch (positionForNavDrawer) {
		case 1:
			return mWebFragment1;
		case 2:
			return mWebFragment2;
		case 3:
			return mWebFragment3;
		case 4:
			return mWebFragment4;
		case 5:
			return mWebFragment5;
		case 6:
			return mWebFragment6;
		case 7:
			return mWebFragment7;
		case 8:
			return mWebFragment8;
		case 9:
			return mWebFragment9;
		case 10:
			return mWebFragment10;
		}

		return null;
	}

	/*
	 * setting up a schedule fragment is done here this comment is really just a
	 * divider lol
	 */

	public static class SetScheduleFragment extends Fragment {

		private static EditText etYear;
		private static EditText etIDnum;
		private static Button bSetMySched;
		private static final String gdocpdfURL = "http://docs.google.com/gview?embedded=true&url=";
		private static final String mySchedURL = "http://intranet.spprep.org/images/pdf/Student_Schedules/";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static SetScheduleFragment newInstance() {
			SetScheduleFragment fragment = new SetScheduleFragment();
			return fragment;
		}

		public SetScheduleFragment() {

		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.set_my_sched, container,
					false);

			etYear = (EditText) rootView.findViewById(R.id.editTextYear);
			etIDnum = (EditText) rootView.findViewById(R.id.editTextIDnum);
			bSetMySched = (Button) rootView.findViewById(R.id.buttonFinishID);

			etIDnum.setImeActionLabel("Enter", KeyEvent.KEYCODE_ENTER);

			getActivity().setProgress(10000);
			return rootView;
		}

		@Override
		public void onPause() {
			super.onPause();
		}

		@Override
		public void onStart() {
			super.onStart();

			etIDnum.setOnEditorActionListener(new TextView.OnEditorActionListener() {

				@Override
				public boolean onEditorAction(TextView v, int actionId,
						KeyEvent event) {
					if (event != null
							&& (event.getAction() != KeyEvent.ACTION_DOWN || event
									.getKeyCode() != KeyEvent.KEYCODE_ENTER)) {
						return false;
					}
					if (actionId == EditorInfo.IME_NULL
							&& (event.getAction() == KeyEvent.ACTION_DOWN || event
									.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
						setAndOpenMySched();
						return true;
					}
					return false;
				}

			});

			bSetMySched.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					setAndOpenMySched();
				}

			});

		}

		protected void setAndOpenMySched() {
			if (etYear.getText().toString() == null
					|| etYear.getText().toString().isEmpty()
					|| etYear.getText().toString().length() != 9
					|| etIDnum.getText().toString() == null
					|| etIDnum.getText().toString().isEmpty()
					|| etIDnum.getText().toString().length() != 6) {

				Toast.makeText(appContext,
						"Please enter values in both fields, following the given examples. (Year: \"2013-2014\", ID: \"151730\")",
						Toast.LENGTH_LONG).show();
				return;

			} else {
				String schoolYear = etYear.getText().toString();
				String idNum = etIDnum.getText().toString();
				String finishedMySchedURL = gdocpdfURL + mySchedURL
						+ schoolYear + "/Sem1/" + idNum + ".pdf";

				sp.edit().putString(PREF_MY_SCHED_URL, finishedMySchedURL)
						.apply();

				mWebFragment4 = WebFragment.newInstance(positionForNavDrawer);
				fragmentManager.beginTransaction()
						.replace(R.id.container, mWebFragment4).commit();
			}

		}
	}

}
