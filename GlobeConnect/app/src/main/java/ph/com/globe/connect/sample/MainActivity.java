package ph.com.globe.connect.sample;

import ph.com.globe.connect.*;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(ph.com.globe.connect.sample.R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if request code is = 1
        if(requestCode == 1) {
            // and is activity result ok
            if(resultCode == Activity.RESULT_OK) {
                // parse string
                try {
                    JSONObject response = new JSONObject(data.getStringExtra("auth_response"));

                    EditText out = (EditText) findViewById(R.id.output);
                    out.setText(response.toString(5));
                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void authFlow(View view) {
        Intent intent = new Intent(getApplicationContext(), GlobeAuthActivity.class);

        intent.putExtra("app_id", "5ozgSgeRyeHzacXo55TR65HnqoAESbAz");
        intent.putExtra("app_secret", "3dbcd598f268268e13550c87134f8de0ec4ac1100cf0a68a2936d07fc9e2459e");

        startActivityForResult(intent, 1);
    }

    public void sendSms(View view) throws ApiException, HttpRequestException {
        Sms sms = new Sms("21584130", "JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

        try {
            sms
                .setClientCorrelator("12345")
                .setReceiverAddress("+639065272450")
                .setMessage("Hello World")
                .sendMessage(new AsyncHandler() {
                    @Override
                    public void response(HttpResponse response) throws HttpResponseException {
                        try {
                            JSONObject json = new JSONObject(response.getJsonResponse().toString());
                            EditText out = (EditText) findViewById(R.id.output);
                            out.setText(json.toString(5));
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        } catch(ApiException e) {
        } catch(HttpResponseException e) {
        }
    }

    public void sendBinarySms(View view) throws ApiException, HttpRequestException {
        BinarySms sms = new BinarySms("21584130", "JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

        try {
            sms
                .setUserDataHeader("0605040B8423")
                .setDataCodingScheme(1)
                .setReceiverAddress("9065272450")
                .setBinaryMessage("02056A0045C60C037777772E6465762E6D6F62692F69735F66756E2E68746D6C0")
                .sendBinaryMessage(new AsyncHandler() {
                    @Override
                    public void response(HttpResponse response) throws HttpResponseException {
                        try {
                            JSONObject json = new JSONObject(response.getJsonResponse().toString());
                            EditText out = (EditText) findViewById(R.id.output);
                            out.setText(json.toString(5));
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        } catch(ApiException e) {
        } catch(HttpResponseException e) {
        }
    }

    public void getLocation(View view) throws ApiException, HttpRequestException {
        Location location = new Location("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

        try {
            location
                    .setAddress("9065272450")
                    .setRequestedAccuracy(10)
                    .getLocation(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.setText(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch(ApiException e) {
        } catch(HttpResponseException e) {
        }
    }

    public void sendPayment(View view) throws ApiException, HttpRequestException {
        try {
            Payment payment = new Payment("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

            payment
                    .setAmount(0.00)
                    .setDescription("My Description")
                    .setEndUserId("9065272450")
                    .setReferenceCode("41301000221")
                    .setTransactionOperationStatus("Charged")
                    .sendPaymentRequest(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.setText(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            Payment payment2 = new Payment("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

            payment2
                    .setAppId("5ozgSgeRyeHzacXo55TR65HnqoAESbAz")
                    .setAppSecret("3dbcd598f268268e13550c87134f8de0ec4ac1100cf0a68a2936d07fc9e2459e")
                    .getLastReferenceCode(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.append(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch(ApiException e) {
        } catch(HttpResponseException e) {
        }
    }

    public void getSubscriber(View view) throws ApiException, HttpRequestException {
        try {
            Subscriber subscriber = new Subscriber("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

            subscriber
                    .setAddress("639065272450")
                    .getSubscriberBalance(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.setText(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            Subscriber subscriber2 = new Subscriber("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

            subscriber2
                    .setAddress("639065272450")
                    .getSubscriberReloadAmount(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.append(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch(ApiException e) {
        } catch(HttpResponseException e) {
        }
    }

    public void sendUssd(View view) throws ApiException, HttpRequestException {
        try {
            Ussd ussd = new Ussd("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

            ussd
                    .setSenderAddress("21584130")
                    .setUssdMessage("Simple USSD Message\n1: Hello \n2: Hello")
                    .setAddress("9065272450")
                    .setFlash(false)
                    .sendUssdRequest(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.setText(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            Ussd ussd2 = new Ussd("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

            ussd2
                    .setSessionId("12345")
                    .setAddress("9065272450")
                    .setSenderAddress("21584130")
                    .setUssdMessage("Simple USSD Message\n1: Foo\n2: Foo")
                    .setFlash(false)
                    .replyUssdRequest(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.append(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch(ApiException e) {
        } catch(HttpResponseException e) {
        }
    }

    public void sendAmax(View view) throws ApiException, HttpRequestException {
        String appId = "5ozgSgeRyeHzacXo55TR65HnqoAESbAz";
        String appSecret = "3dbcd598f268268e13550c87134f8de0ec4ac1100cf0a68a2936d07fc9e2459e";

        Amax amax = new Amax(appId, appSecret);

        try {
            amax
                    .setRewardsToken("w7hYKxrE7ooHqXNBQkP9lg")
                    .setAddress("9065272450")
                    .setPromo("FREE10MB")
                    .sendRewardRequest(new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.setText(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch(HttpResponseException e) {
        }
    }

    public void sendAuth(View view) throws ApiException, HttpRequestException {
        String appId = "5ozgSgeRyeHzacXo55TR65HnqoAESbAz";
        String appSecret = "3dbcd598f268268e13550c87134f8de0ec4ac1100cf0a68a2936d07fc9e2459e";

        Authentication auth = new Authentication(appId, appSecret);

        String dialogUrl = auth.getDialogUrl();

        EditText out = (EditText) findViewById(R.id.output);
        out.setText(dialogUrl);

        try {
            auth.getAccessToken("G4HBMexKfaM9E7SG4LpkHRBoLGf9Go6qSnBno8HRKXnes7doqEukgq4bCq59nKfR7KX6Uorknysa8EXyHoxEaRhzGo57tLn4gduLkaE7S9ke9RtpBjgauaeRKpu4RcoX6y4cRaxuGzjkKuyzedXtkra8qSbe47LueyonxtgoEorhpkEoaHLkkResXyKR4U4K996f4EqB7CRLoKGuBjXorsAxnrpH9poqrSAEo6ef7XLGXHyK9R9SLregxfaM6XxH",
            new AsyncHandler() {
                        @Override
                        public void response(HttpResponse response) throws HttpResponseException {
                            try {
                                JSONObject json = new JSONObject(response.getJsonResponse().toString());
                                System.out.println(json.toString());
                                EditText out = (EditText) findViewById(R.id.output);
                                out.setText(json.toString(5));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch(HttpResponseException e) {
        }
    }
}
