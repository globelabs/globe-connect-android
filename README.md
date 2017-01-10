# Globe Connect for Android

## Introduction
Globe Connect for Android platform provides an implementation of Globe APIs e.g Authentication, Amax,
Sms etc. that is easy to use and can be integrated in your existing Android application. Below shows
some samples on how to use the API depending on the functionality that you need to integrate in your
application.

## Installation
There are two ways to install the sdk, manual or via the central repository, please refer to the links below for installation instructions.

- For manual installation (via SDK Builder) click [here](https://github.com/globelabs/globe-connect-android/tree/master/instructions/manual-installation.md)
- For installation via Maven Central, Gradle click [here](https://github.com/globelabs/globe-connect-android/tree/master/instructions/installation-via-maven.md)

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
            .setAddress("[+63 subscriber_number]")
            .setPromo("[promo]")
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
        .setUserDataHeader("[header]")
        .setDataCodingScheme([scheme])
        .setReceiverAddress("[+63 subscriber_number]")
        .setBinaryMessage("[message]")
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
            .setAddress("[+63 subscriber_number]")
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
            .setAmount("[amount]")
            .setDescription("[description]")
            .setEndUserId("[+63 subscriber_number]")
            .setReferenceCode("[reference_code]")
            .setTransactionOperationStatus("[status]")
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
        .setClientCorrelator("[client_correlator]")
        .setReceiverAddress("[+63 subscriber_number]")
        .setMessage("[message]")
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
            .setAddress("[+63 subscriber_number]")
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
            .setAddress("[+63 subscriber_number]")
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
            .setAddress("[+63 subscriber_number]")
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
            .setUssdMessage("[message]")
            .setAddress("[+63 subscriber_number]")
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
        .setAddress("[+63 subscriber_number]")
        .setSenderAddress("[short_code]")
        .setUssdMessage("[message]")
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
