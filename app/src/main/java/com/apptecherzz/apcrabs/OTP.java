package com.apptecherzz.apcrabs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import in.quagga.sdk.activity.ConsentActivity;

import static android.R.attr.id;
import static com.apptecherzz.apcrabs.R.layout.activity_otp;
import static in.quagga.sdk.utils.ConstantsUtil.GATEWAY_TRANSACTION_ID;
import static in.quagga.sdk.utils.ConstantsUtil.KEY_REQUEST_TYPE;
import static in.quagga.sdk.utils.ConstantsUtil.REQUEST_FOR_OTP;

import static in.quagga.sdk.utils.EnumRequestType.OTP_AUTH;

import static in.quagga.sdk.utils.EnumRequestType.OTP_EKYC;
public class OTP extends AppCompatActivity {
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_otp);

        /*Intent gatewayIntent = new Intent(OTP.this, ConsentActivity.class);
        gatewayIntent.putExtra(GATEWAY_TRANSACTION_ID, id);
        gatewayIntent.putExtra(KEY_REQUEST_TYPE, requestType);
        startActivityForResult(gatewayIntent, REQUEST_FOR_OTP);*/

        Map<String, String> postData = new HashMap<>();
        postData.put("purpose", "demo");
        postData.put("ver", "2.1");
        postData.put("storeCode", "QUASUS00036");
       HttpPostRequest Generate_id=new HttpPostRequest(postData);
        Generate_id.execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


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
            String stringUrl = "http://34.214.58.80:3000/agents/ekyc/904617879924";
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
            System.out.println("goy it"+result);
            super.onPostExecute(result);
        }
    }
}