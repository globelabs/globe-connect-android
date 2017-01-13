package ph.com.globe.connect.sample;

import android.app.Activity;
import android.content.Intent;
import ph.com.globe.connect.AuthenticationActivity;

public class GlobeAuthActivity extends AuthenticationActivity {
    @Override
    public void onSuccess(String code) {
        // start the code intent
        Intent codeIntent = new Intent();
        // put the code result
        codeIntent.putExtra("code", code);

        // now set activity result
        setResult(Activity.RESULT_OK, codeIntent);
    }
}
