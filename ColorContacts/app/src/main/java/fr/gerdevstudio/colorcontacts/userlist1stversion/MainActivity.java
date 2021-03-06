package fr.gerdevstudio.colorcontacts.userlist1stversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.gerdevstudio.colorcontacts.R;

public class MainActivity extends AppCompatActivity implements DetailsFragment.CallBacks{

    @Override
    public void onUserModified(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            DetailsFragment detailsFragment = new DetailsFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            detailsFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, detailsFragment).commit();
        }
    }
}

