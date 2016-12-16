# Globe Connect for Android

## Introduction
Globe Connect for Android platform provides an implementation of Globe APIs e.g Authentication, Amax,
Sms etc. that is easy to use and can be integrated in your existing Android application. Below shows
some samples on how to use the API depending on the functionality that you need to integrate in your
application.

## Basic Usage

###### Figure 1. Authentication

```java
import ph.com.globe.connect.Authentication;

String appId = "[app_id]";
String appSecret = "[app_secret]";

Authentication auth = new Authentication(appId, appSecret);

String dialogUrl = auth.getDialogUrl();

EditText out = (EditText) findViewById(R.id.output);
out.setText(dialogUrl);

try {
    auth.getAccessToken("[code]",
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
```

###### Figure 2. Amax

```java
import ph.com.globe.connect.Amax;

String appId = "[app_id]";
String appSecret = "[app_secret]";

Amax amax = new Amax(appId, appSecret);

try {
    amax
            .setRewardsToken("[rewards_token]")
            .setAddress("[subscriber_number]")
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
```

###### Figure 3. Binary SMS

```java
import ph.com.globe.connect.BinarySms;

BinarySms sms = new BinarySms("[short_code]", "[access_token]");

try {
    sms
        .setUserDataHeader("0605040B8423")
        .setDataCodingScheme(1)
        .setReceiverAddress("[subscriber_number]")
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
```

###### Figure 4. Location

```java
Location location = new Location("[access_token]");

try {
    location
            .setAddress("[subscriber_number]")
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
```

###### Figure 5. Payment (Send Payment Request)

```java
import ph.com.globe.connect.Payment;

try {
    Payment payment = new Payment("[access_token]");

    payment
            .setAmount(0.00)
            .setDescription("My Description")
            .setEndUserId("[subscriber_number]")
            .setReferenceCode("[reference_code]")
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
} catch(ApiException e) {
} catch(HttpResponseException e) {
}
```

###### Figure 6. Payment (Get Last Reference ID)

```java
import ph.com.globe.connect.Payment;

try {
    Payment payment = new Payment("[access_token]");

    payment
            .setAppId("[app_id]")
            .setAppSecret("[app_secret]")
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
```

###### Figure 7. Sms

```java
import ph.com.globe.connect.Sms;

Sms sms = new Sms("[short_code]", "[access_token]");

try {
    sms
        .setClientCorrelator("12345")
        .setReceiverAddress("[subscriber_number]")
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
```

###### Figure 8. Subscriber (Get Balance)

```java
import ph.com.globe.connect.Subscriber;

try {
    Subscriber subscriber = new Subscriber("[access_token]");

    subscriber
            .setAddress("[subscriber_number]")
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

    Subscriber subscriber2 = new Subscriber("[access_token]");

    subscriber2
            .setAddress("[subscriber_number]")
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
```

###### Figure 9. Subscriber (Get Reload Amount)

```java
import ph.com.globelabs.Subscriber;

try {
    Subscriber subscriber = new Subscriber("[access_token]");

    subscriber
            .setAddress("[subscriber_number]")
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
```

###### Figure 10. USSD (Send)

```java
import ph.com.globe.connect.Ussd;

try {
    Ussd ussd = new Ussd("[access_token]");

    ussd
            .setSenderAddress("[short_code]")
            .setUssdMessage("Simple USSD Message\n1: Hello \n2: Hello")
            .setAddress("[subscriber_number]")
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
} catch(ApiException e) {
} catch(HttpResponseException e) {
}
```

###### Figure 11. USSD (Reply)

```java
import ph.com.globe.connect.Ussd;

Ussd ussd = new Ussd("[access_token]");

ussd
        .setSessionId("[session_id]")
        .setAddress("[subscriber_number]")
        .setSenderAddress("[short_code]")
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
```
