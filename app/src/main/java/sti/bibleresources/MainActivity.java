// Package or namespace
package sti.bibleresources;

// Other packages or namespaces
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// Class is main code organization; represents an object
// Extends or inherits code from a base class
// Implements an interface
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Classes contain function or methods that are called and executed
    // Override means the function or method is already defined in a base class
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Logging Example
        Log.d("MainActivity", "onCreate");

        // Call to base class with the same method name as this class.
        // Without super, inifinite loop is created
        super.onCreate(savedInstanceState);

        // Set the content within the activity with the item
        setContentView(R.layout.activity_main);

        // Set a variable that contains the Bible study list
        mBibleStudyList = CreateBibleStudyList();

        CreateLayoutView();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*@ Internal function that separates a particular operation */
    private void CreateLayoutView() {

        // Get a reference to an object within a view
        LinearLayout baseLayout = findViewById(R.id.layout_content);

        // Loops through all of the list
        for (int i = 0; i < mBibleStudyList.size(); i++) {

            // Get the i item in the list
            BibleStudy bibleStudy = mBibleStudyList.get(i);

            // Start a linear layout and note the position
            // Passing position do not use the loop index
            final int bibleStudyPosition = i;
            LinearLayout linearLayout = new LinearLayout(this);

            // Start an image
            ImageView imageView = new ImageView(this);

            // Put the bible study logo in the image
            imageView.setImageResource(bibleStudy.getLogoId());

            // Set a variable with image size information and add settings to the image
            LinearLayout.LayoutParams layoutParams
                    = new LinearLayout.LayoutParams(300, 300);
            layoutParams.setMargins(30, 30, 30, 0);
            imageView.setLayoutParams(layoutParams);

            // Listen for a click event
            // The parameter is a method that is declared in the parameter
            imageView.setOnClickListener(new View.OnClickListener() {

                // Override the base class click for each image
                @Override
                public void onClick(View view) {
                    // Each image calls this with the particular position index
                    bibleStudyOnClick(bibleStudyPosition);
                }
            });

            // Start a linear layout and add the image
            linearLayout.addView(imageView);

            // Start text item for title
            TextView nameView = new TextView(this);
            nameView.setText(bibleStudy.getTitle());
            nameView.setTextSize(30);

            // Make the text clickable just like the image
            nameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bibleStudyOnClick(bibleStudyPosition);
                }
            });
            linearLayout.addView(nameView);

            // Add the linear layout to the mainlayout; shows items in order
            baseLayout.addView(linearLayout);
        }
    }

    // Private variable that stores information that can be used in each function
    private ArrayList<BibleStudy> mBibleStudyList;

    // Internal function to create the bible study list and return it
    // THis should be changed to be database driven; the list should be its own object probably
    private ArrayList<BibleStudy> CreateBibleStudyList() {

        // Create a list with a capacity of 3
        ArrayList<BibleStudy> bibleStudyList = new ArrayList<>(3);

        // Create new items with information filled out for each item
        BibleStudy bibleStudy = new BibleStudy();
        bibleStudy.setLanguage(Language.Romanian);
        bibleStudy.setLogoId(R.drawable.bible_study_1);
        bibleStudy.setTitleRo(getString(R.string.bible_study_1_name));
        bibleStudy.setTitleRu("Господь, я хочу знать Тебя");
        bibleStudy.setTitleEn("Lord, I Want To Know You");
        bibleStudy.setDescriptionRo(getString(R.string.bible_study_1_description));
        bibleStudy.setPhone(getString(R.string.bible_study_1_phone));
        bibleStudy.setWebAddress(getString(R.string.bible_study_1_webaddress));
        bibleStudy.setEmail(getString(R.string.bible_study_1_email));
        bibleStudy.setLocation(getString(R.string.bible_study_1_location));
        bibleStudyList.add(bibleStudy);

        bibleStudy = new BibleStudy();
        bibleStudy.setLanguage(Language.Romanian);
        bibleStudy.setLogoId(R.drawable.bible_study_2);
        bibleStudy.setDescriptionRo(getString(R.string.bible_study_2_description));
        bibleStudy.setTitleRo(getString(R.string.bible_study_2_name));
        bibleStudy.setTitleRu("Небеса, ад и жизнь после смерти");
        bibleStudy.setPhone(getString(R.string.bible_study_2_phone));
        bibleStudy.setWebAddress(getString(R.string.bible_study_2_webaddress));
        bibleStudy.setEmail(getString(R.string.bible_study_2_email));
        bibleStudy.setLocation(getString(R.string.bible_study_2_location));
        bibleStudyList.add(bibleStudy);

        bibleStudy = new BibleStudy();
        bibleStudy.setLanguage(Language.Romanian);
        bibleStudy.setLogoId(R.drawable.bible_study_3);
        bibleStudy.setDescriptionRo(getString(R.string.bible_study_3_description));
        bibleStudy.setTitleRo(getString(R.string.bible_study_3_name));
        bibleStudy.setPhone(getString(R.string.bible_study_3_phone));
        bibleStudy.setWebAddress(getString(R.string.bible_study_3_webaddress));
        bibleStudy.setEmail(getString(R.string.bible_study_3_email));
        bibleStudy.setLocation(getString(R.string.bible_study_3_location));
        bibleStudyList.add(bibleStudy);

        return bibleStudyList;
    }

    /* Encaspulates the sending of email */
    private void sendEmail() {

        // Set up an intent object to send email and fill it out
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        // An array of string addresses
        String[] toAddress = new String[]{getString(R.string.email_company_contact)};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, toAddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_default_text));

        // Error handler, try to execute code
        try {
            // Starts a new screen to send email
            startActivity(Intent.createChooser(emailIntent, getString(R.string.email_prompt)));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            // An error occurred trying to use the activity
            Toast.makeText(this,
                    getString(R.string.error_send_email), Toast.LENGTH_SHORT).show();
            // Missing a finally that closes the activity?
        }
    }

    // Class recognizes the back button and this overrides what happens when it is hit
    @Override
    public void onBackPressed() {

        // Looks for a drawer layout in the view
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        // If started then close
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // Use the original command
            super.onBackPressed();
        }
    }

    // Class has function for menu options that are overriden
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Handles when an option is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Overrides when a navigation item is selected
    // Can not take a null value
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Use a case statement
        if (id == R.id.nav_camera) {
            // Bible Resource 1
        } else if (id == R.id.nav_gallery) {
            // Bible Resource 2
        } else if (id == R.id.nav_slideshow) {
            // Bible Resource 3
        } else if (id == R.id.nav_manage) {
            // Bible Resource 4
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            sendEmail();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Internal command used when an item is clicked
    private void bibleStudyOnClick(int startingPosition) {

        // New intent is to create a new activity
        Intent intent = new Intent(this, BibleStudyDetailActivity.class);
        intent.putParcelableArrayListExtra("BibleStudies", mBibleStudyList);
        intent.putExtra("StartingPosition", startingPosition);

        // Start the activity
        startActivity(intent);
    }
}
