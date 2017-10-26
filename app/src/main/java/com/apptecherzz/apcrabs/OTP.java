package com.apptecherzz.apcrabs;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import in.quagga.sdk.activity.ConsentActivity;

import static android.R.attr.id;
import static com.apptecherzz.apcrabs.R.layout.activity_otp;
import static in.quagga.sdk.utils.ConstantsUtil.DENY_REQUEST;
import static in.quagga.sdk.utils.ConstantsUtil.GATEWAY_TRANSACTION_ID;
import static in.quagga.sdk.utils.ConstantsUtil.KEY_ACTIVITY_RESULT;
import static in.quagga.sdk.utils.ConstantsUtil.KEY_REQUEST_TYPE;
import static in.quagga.sdk.utils.ConstantsUtil.OTP_IDENTIFICATION;
import static in.quagga.sdk.utils.ConstantsUtil.REQUEST_FOR_OTP;

import static in.quagga.sdk.utils.ConstantsUtil.RESULT_ERROR;
import static in.quagga.sdk.utils.EnumRequestType.OTP_AUTH;

import static in.quagga.sdk.utils.EnumRequestType.OTP_EKYC;
public class OTP extends AppCompatActivity {
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 30000;
    public static final int CONNECTION_TIMEOUT = 30000;
    TextView response;
    String requestType;
    String id;
    JSONObject obj;
    String trc;
    Button b;
    EditText adh1,adh2,adh3;
    Intent gatewayIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_otp);
b=(Button) findViewById(R.id.bt_submitform);
        adh1=(EditText) findViewById(R.id.n1);
        adh2=(EditText) findViewById(R.id.n2);
        adh3=(EditText) findViewById(R.id.n3);
adh1.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        System.out.println("i"+i+"i1"+i1+"i2"+i2);
        if(i==3){
            adh2.requestFocus();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
});
        adh2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i==3) {
adh3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Map<String, String> postData = new HashMap<>();
        postData.put("purpose", "demo");
        postData.put("ver", "2.1");
        postData.put("storeCode", "QUASUS00036");
        HttpPostRequest Generate_id=new HttpPostRequest(postData);
        String num=adh1.getText().toString()+adh2.getText().toString()+adh3.getText().toString();
        Generate_id.execute(num);
    }
});



        requestType= OTP_EKYC.getServiceName();


       // response.setText(trc);
System.out.println("checking id"+id);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == DENY_REQUEST) {
            String errorString = "Consent Denied";
            //handle error for otp_auth
           // response.setText(errorString);

        }
        /*
            Handle result for OTP
            - Remove if OTP is not being used
         */

        if (requestCode == REQUEST_FOR_OTP && null != data) {
            String requestType = data.getStringExtra(KEY_REQUEST_TYPE);

            /*
                Handle result for EKYC
                - Remove if only Auth is used in your App
             */
            if (requestType.equalsIgnoreCase(OTP_EKYC.getServiceName())) {

                if (resultCode == RESULT_OK) {
                    String responseString = data.getStringExtra(KEY_ACTIVITY_RESULT);
                    //handle success for otp_ekyc
//                    response.setText(responseString);
                    Intent io=new Intent(OTP.this,profil_view.class);
                    io.putExtra("data",responseString);
                    startActivity(io);

                    System.out.println("hello output"+responseString);
                }

                if (resultCode == RESULT_ERROR) {
                    JSONObject ki=new JSONObject();
                    String errorString = data.getStringExtra(KEY_ACTIVITY_RESULT);
                    try {
                         ki=new JSONObject(errorString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            OTP.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("TR CRABS");
                    try {
                        alertDialog.setMessage(ki.getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // Setting Icon to Dialog


                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            // Write your code here to execute after dialog closed
                            //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                    //handle error for otp_ekyc
                   // response.setText(errorString);
                }
            }

        }
    }
    public class HttpPostRequest extends AsyncTask<String, Void, String> {
        private ProgressDialog dialog;
        JSONObject postData;
        public HttpPostRequest(Map<String, String> postData) {
            dialog = new ProgressDialog(OTP.this);
            if (postData != null) {
                this.postData = new JSONObject(postData);
            }
        }
        @Override
        protected String doInBackground(String... params){
            String stringUrl = "http://34.214.58.80:3000/agents/EKYC/"+params[0];   //904617879924";
            String result = null;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                connection.setDoInput(true);
                connection.setDoOutput(true);

                connection.setRequestProperty("Content-Type", "application/json");

                if (this.postData != null) {
                    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                    writer.write(postData.toString());
                    writer.flush();
                }

                int statusCode = connection.getResponseCode();
System.out.println("lkk"+statusCode);
                if (statusCode ==  200) {
                    //Create a new InputStreamReader
                    InputStreamReader streamReader = new
                            InputStreamReader(connection.getInputStream());
                    //Create a new buffered reader and String Builder
                    BufferedReader reader = new BufferedReader(streamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    //Check if the line we are reading is not null
                    while ((inputLine = reader.readLine()) != null) {
                        stringBuilder.append(inputLine);
                    }
                    //Close our InputStream and Buffered reader
                    reader.close();
                    streamReader.close();
                    //Set our result equal to our stringBuilder
                    result = stringBuilder.toString();
                }
                else{

                    return null;
                }
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;

            //return null;
        }
        @Override
        protected void onPreExecute() {
            dialog.setMessage("please wait.");
            dialog.show();
        }
        @Override
        protected void onPostExecute(String result){
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            try {
                obj=new JSONObject(result);
                id=obj.getString("id");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            gatewayIntent = new Intent(OTP.this, ConsentActivity.class);
            gatewayIntent.putExtra(GATEWAY_TRANSACTION_ID, id);
            gatewayIntent.putExtra(KEY_REQUEST_TYPE, requestType);
            startActivityForResult(gatewayIntent, REQUEST_FOR_OTP);
            System.out.println("goy it"+result);
            super.onPostExecute(result);
        }
    }
}