package sti.bibleresources;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BibleStudyDetailActivity extends AppCompatActivity {

    private ArrayList<BibleStudy> mBibleStudyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_study_detail);

        mBibleStudyList = this.getIntent().getParcelableArrayListExtra("BibleStudies");
        int startingPosition = this.getIntent().getIntExtra("StartingPosition", 0);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter
                = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(startingPosition);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bible_study_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_BIBLE_STUDY = "bible_study";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment.
         */
        public static PlaceholderFragment newInstance(BibleStudy bibleStudy) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ARG_BIBLE_STUDY, bibleStudy);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bible_study_detail, container
                    , false);

            Bundle arguments = getArguments();
            if (arguments != null) {
                BibleStudy bibleStudy = arguments.getParcelable(ARG_BIBLE_STUDY);
                LoadBibleStudy(rootView, bibleStudy);
            }
            return rootView;
        }

        private void LoadBibleStudy(View rootView, BibleStudy bibleStudy) {
            ImageView imageView = rootView.findViewById(R.id.bible_study_image);
            imageView.setImageResource(bibleStudy.getLogoId());
            TextView nameView = rootView.findViewById(R.id.bible_study_name);
            nameView.setText(bibleStudy.getTitle());
            TextView descriptionView = rootView.findViewById(R.id.bible_study_description);
            descriptionView.setText(bibleStudy.getDescription());
            TextView emailView = rootView.findViewById(R.id.bible_study_email);
            emailView.setText(bibleStudy.getEmail());
            TextView phoneView = rootView.findViewById(R.id.bible_study_phone);
            phoneView.setText(bibleStudy.getPhone());
            TextView webView = rootView.findViewById(R.id.bible_study_web);
            webView.setText(bibleStudy.getWebAddress());
            TextView locationView = rootView.findViewById(R.id.bible_study_location);
            locationView.setText(bibleStudy.getLocation());
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(mBibleStudyList.get(position));
        }

        @Override
        public int getCount() {
            return mBibleStudyList.size();
        }
    }
}
