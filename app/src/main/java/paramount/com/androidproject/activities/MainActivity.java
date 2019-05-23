package paramount.com.androidproject.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import paramount.com.androidproject.R;
import paramount.com.androidproject.fragments.AboutFragment;
import paramount.com.androidproject.fragments.ChangeLocationFragment;
import paramount.com.androidproject.fragments.ContactFragment;
import paramount.com.androidproject.fragments.FAQ_Fragment;
import paramount.com.androidproject.fragments.ViewPackages;
import paramount.com.androidproject.models.OrderDetail;
import paramount.com.androidproject.utils.SharedPreferenceHelper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                drawer.bringChildToFront(drawerView);
                drawer.requestLayout();
            }


        };


        toggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable

        // final Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icn_menu, mContext.getTheme());
        toggle.setHomeAsUpIndicator(R.drawable.icn_menu);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {

                    drawer.closeDrawer(GravityCompat.START);
                    toggle.setHomeAsUpIndicator(R.drawable.ic_navigate_next_white_36dp);
                } else {
                    toggle.setHomeAsUpIndicator(R.drawable.icn_menu);
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });


        toggle.syncState();
        //drawer.setHomeAsUpIndicator(R.drawable.icn_menu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            // applyFontToMenuItem(mi);
        }


        navigationView.setNavigationItemSelectedListener(this);
        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_changeLocation);


        mContext = this;

    }

    /* private void applyFontToMenuItem(MenuItem mi) {
         Typeface font = Typeface.createFromAsset(getAssets(), "Avenir_45_Book.ttf");
         SpannableString mNewTitle = new SpannableString(mi.getTitle());
        // mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
         mi.setTitle(mNewTitle);
     }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:
                int arraySize = AddToCartActivity.getArrayOrderList().size();
                if(arraySize > 0){
                Intent i = new Intent(MainActivity.this, AddToCartActivity.class);
                i.putExtra("order_list",AddToCartActivity.getArrayOrderList());
                startActivity(i);
                break;
                }
                else {
                    Toast.makeText(mContext,"Cart is empty",Toast.LENGTH_LONG).show();
                }
            default:
                break;
        }
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        FragmentManager fragments = getSupportFragmentManager();
        FragmentTransaction ft = fragments.beginTransaction();
        fragments.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        ft.commit();


        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_about:
                fragment = new AboutFragment();
                break;
            case R.id.nav_viewPackage:
                fragment = new ViewPackages();

                break;
            case R.id.nav_changeLocation:
                fragment = new ChangeLocationFragment();

                break;

            case R.id.nav_orderHistory:
                fragment = new ChangeLocationFragment();

                break;


            case R.id.nav_contactus:
                  fragment = new ContactFragment();
                break;

            case R.id.nav_faq:
                fragment = new FAQ_Fragment();

                break;

            case R.id.nav_logout:
                logout();
                break;

        }

        if (fragment != null) {

            final FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();

            // put the fragment in place
            transaction.replace(R.id.content_frame, fragment);

            // this is the part that will cause a fragment to be added to backstack,
            // this way we can return to it at any time using this tag
            transaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void logout() {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:

                        FirebaseAuth.getInstance().signOut();
                        SharedPreferenceHelper.setSharedPreferenceString(getApplicationContext(), "user_id", "");
                        SharedPreferences settings = getApplicationContext().getSharedPreferences("user_id", Context.MODE_PRIVATE);
                        settings.edit().remove("user_id").commit();
                        startActivity(new Intent(mContext, LoginActivity.class));
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedScreen(item.getItemId());

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {

        FragmentManager fragments = getSupportFragmentManager();

        if (fragments.getBackStackEntryCount() > 1) {
            //  fragments.popBackStack(null,fragments.);

            if (!fragments.popBackStackImmediate()) {
                finish();
            }

        } else {
            // supportFinishAfterTransition();
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();


            }
        }
    }


}
