package paramount.com.androidproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import paramount.com.androidproject.R;
import paramount.com.androidproject.utils.DiavloBoldTextView;
import paramount.com.androidproject.utils.DominoBoldTextView;

public class Login_OptionPage extends AppCompatActivity {


    DominoBoldTextView iv_exitUser , iv_newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__option_page);

        iv_exitUser = (DominoBoldTextView)  findViewById(R.id.tv_exitsuser);

        iv_newUser = (DominoBoldTextView) findViewById(R.id.tv_newuser);


        iv_exitUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login_OptionPage.this, LoginActivity.class);
                startActivity(i);
            }
        });


        iv_newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_OptionPage.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
