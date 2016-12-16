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
```

###### Figure 2. Amax

```java
import ph.com.globe.connect.Amax;

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
```

###### Figure 3. Binary SMS

```java
import ph.com.globe.connect.BinarySms;

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
```

###### Figure 4. Location

```java
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
```

###### Figure 5. Payment (Send Payment Request)

```java
import ph.com.globe.connect.Payment;

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
} catch(ApiException e) {
} catch(HttpResponseException e) {
}
```

###### Figure 6. Payment (Get Last Reference ID)

```java
import ph.com.globe.connect.Payment;

try {
    Payment payment = new Payment("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

    payment
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
```

###### Figure 7. Sms

```java
import ph.com.globe.connect.Sms;

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
```

###### Figure 8. Subscriber (Get Balance)

```java
import ph.com.globe.connect.Subscriber;

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
```

###### Figure 9. Subscriber (Get Reload Amount)

```java
import ph.com.globelabs.Subscriber;

try {
    Subscriber subscriber = new Subscriber("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

    subscriber
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
```

###### Figure 10. USSD (Send)

```java
import ph.com.globe.connect.Ussd;

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
} catch(ApiException e) {
} catch(HttpResponseException e) {
}
```

###### Figure 11. USSD (Reply)

```java
import ph.com.globe.connect.Ussd;

Ussd ussd = new Ussd("JO3SpcC-AFiC461wgOxUPDmsOTc5YiMayoK1GnQcduc");

ussd
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
```
