package alan.jymjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Login extends AppCompatActivity {

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

//    CallbackManager callbackManager;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        callbackManager = CallbackManager.Factory.create();
//        LoginButton loginButton = (LoginButton) view.findViewById(R.id.usersettings_fragment_login_button);
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() { ... });
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText(
                        "User ID: "
                                + loginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + loginResult.getAccessToken().getToken()
                );
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

//    public static class LoginFragment extends Fragment {
//        @Override
//        public View onCreateView(
//                LayoutInflater inflater,
//                ViewGroup container,
//                Bundle savedInstanceState) {
//            View view = inflater.inflate(R.layout.splash, container, false);
//
//            loginButton = (LoginButton) view.findViewById(R.id.login_button);
//            loginButton.setReadPermissions("email");
//            // If using in a fragment
//            loginButton.setFragment(this);
//            // Other app specific specialization
//
//            // Callback registration
//            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//                @Override
//                public void onSuccess(LoginResult loginResult) {
//                    // App code
//                }
//
//                @Override
//                public void onCancel() {
//                    // App code
//                }
//
//                @Override
//                public void onError(FacebookException exception) {
//                    // App code
//                }
//            });
//        }
//    }

}
