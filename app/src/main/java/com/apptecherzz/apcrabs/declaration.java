package com.apptecherzz.apcrabs;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class declaration extends AppCompatActivity {
Button submit;
    CheckBox c;
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 30000;
    public static final int CONNECTION_TIMEOUT = 30000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaration);
        submit=(Button) findViewById(R.id.bt_submitform1);
        c=(CheckBox)findViewById(R.id.accept);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.isChecked()){

                }
                else{
                    Toast.makeText(getApplicationContext(), "PLease agree with the terms and conditions.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public class HttpPostRequest extends AsyncTask<String, Void, String> {
        private ProgressDialog dialog;
        JSONObject postData;
        public HttpPostRequest(Map<String, String> postData) {
            dialog = new ProgressDialog(declaration.this);
            if (postData != null) {
                this.postData = new JSONObject(postData);
            }
        }
        @Override
        protected String doInBackground(String... params){
            String stringUrl = "http://34.214.58.80:3000/agents/EKYC/904617879924";
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
