package paramount.com.androidproject.activities;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import paramount.com.androidproject.R;
import paramount.com.androidproject.utils.SharedPreferenceHelper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreen.this, Login_OptionPage.class);
                startActivity(i);
                finish();

                if (SharedPreferenceHelper.getSharedPreferenceString(getApplicationContext(), "user_id", null) == null ||
                        SharedPreferenceHelper.getSharedPreferenceString(getApplicationContext(), "user_id", null).isEmpty() ||
                        SharedPreferenceHelper.getSharedPreferenceString(getApplicationContext(), "user_id", null).length() < 0) {
                    TaskStackBuilder.create(getApplicationContext())
                            .addNextIntentWithParentStack(new Intent(getApplicationContext(), RegisterActivity.class))
                            .startActivities();
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        }, 3000);


    }
}
