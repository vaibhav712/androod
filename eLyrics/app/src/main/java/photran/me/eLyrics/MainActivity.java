package photran.me.eLyrics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;

import com.parse.Parse;

import java.util.ArrayList;

import photran.me.fragments.ListSongFragment;
import photran.me.fragments.ListVideoFragment;
import photran.me.customviews.navigationdrawer.NavigationDrawerFragment;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private DrawerLayout mDrawerLayout;
    private CharSequence mTitle;
    private ArrayList<Fragment> listFragments = new ArrayList<>();
    private ArrayList<String> listTitleFragment = new ArrayList<>();
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_below);

        mTitle = getTitle();

        // Set the ActionBar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        // init fragment
        //initInsideFragment();
        //initTitleFragment();

        // Setup the menu drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, mDrawerLayout, mToolbar);


        settingParser();
    }

    private void initInsideFragment() {
        if (listFragments.size() == 0) {
            fragmentManager = getSupportFragmentManager();
            listFragments.add(0, new ListSongFragment());
            listFragments.add(1, new ListVideoFragment());
        }
    }

    private void initTitleFragment() {
        if (listTitleFragment.size() == 0) {
            listTitleFragment.add(getString(R.string.title_section2));
            listTitleFragment.add(getString(R.string.title_section1));
        }
    }

    private void settingParser() {
        String appID = getResources().getString(R.string.appID);
        String clientID = getResources().getString(R.string.clientID);
        Parse.initialize(this, appID, clientID);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        initInsideFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.container, listFragments.get(position))
                .commit();

        onSectionAttached(position);
        setTitle(mTitle);
    }

    public void onSectionAttached(int number) {
        initTitleFragment();
        mTitle = listTitleFragment.get(number % listTitleFragment.size());
    }

    public void restoreActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            restoreActionBar();
            return false;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
}
