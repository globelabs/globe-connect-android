# Setting up Authentication Activity.

Below are the step by step procedure on how to implement the authentication activity for android, the authentication
activity is the easiest way to authenticate your users and get the authentication access token without having to deal
with some complex process.

### Step 1. Create your GlobeAuthActivity.java

We need to create a new activity file that extends the original Authentication Activity class, after you create your
new activity class you need to put this code.

```java
...

package ph.com.globe.connect.sample;

import android.content.Intent;
import org.json.JSONObject;
import ph.com.globe.connect.AuthenticationActivity;

public class GlobeAuthActivity extends AuthenticationActivity {
    @Override
    public void onSuccess(JSONObject results) {
        // create new intent for response
        Intent response = new Intent();

        // put auth response string
        response.putExtra("auth_response", results.toString());

        // now set activity result
        setResult(this.RESULT_OK, response);
    }
}

```

### Step 2. Add the activity to your app's AndroidManifest.xml

For us to be able to use the activity we need to add the activity on our app's AndroidManifest.xml file.

```xml
...

<activity android:name=".GlobeAuthActivity"></activity>
```


### Step 3. Go to the your main activity or the activity where you are going to use the Authentication Activity.

Now let's add some snippets on our activity class where we are going to execute the authentication activity that we created.

First we need to override somethings...
```java
...

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // if request code is = 1
    if(requestCode == 1) {
        // and is activity result ok
        if(resultCode == Activity.RESULT_OK) {
            // parse string
            try {
                JSONObject response = new JSONObject(data.getStringExtra("auth_response"));

                System.out.println(response.toString()); // <-- will return the access token
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Then let's create an intent then start our Authentication Activity...

```java
...

Intent intent = new Intent(getApplicationContext(), GlobeAuthActivity.class);

intent.putExtra("app_id", "[app_id]");
intent.putExtra("app_secret", "[app_secret]");

startActivityForResult(intent, 1);
```


That's it! Every time we execute the intent a WebView should show an OAuth Dialog where it will ask for the subscriber's phone number and will automatically close whenever the authentication process is successful, the authentication process result will then be returned and processed on the `onActivityResult` method.
