package com.apptecherzz.apcrabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
Button b;
EditText user,pass;
    JSONObject dummy;
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 30000;
    public static final int CONNECTION_TIMEOUT = 30000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.user);
        pass=(EditText) findViewById(R.id.input_password);
        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dummy=new JSONObject();
                try {
                    dummy.put("username",user.getText().toString());
                    dummy.put("password",pass.getText().toString());
                    HttpPostRequest fire =new HttpPostRequest();
                    fire.execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Intent i=new Intent(MainActivity.this,mainscreen.class);
                //startActivity(i);
            }
        });
    }

    public class HttpPostRequest extends AsyncTask<String, Void, String> {
        private ProgressDialog dialog;

        @Override
        protected String doInBackground(String... params){
            String stringUrl = "http://34.214.58.80:3001/auth";
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

                if (dummy != null) {
                    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                    writer.write(dummy.toString());
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
            dialog=new ProgressDialog(MainActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(String result){
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            JSONObject rres;
            System.out.println("goy it"+result);
            try {
                rres=new JSONObject(result);
                AlertDialog alertDialog = new AlertDialog.Builder(
                        MainActivity.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("TR CRABS");
                if(rres.getBoolean("success")) {
                    SharedPreferences.Editor editor = getSharedPreferences("token", MODE_PRIVATE).edit();
                    editor.putString("token",rres.getString("token"));
                    editor.commit();

                            Intent i=new Intent(MainActivity.this,OTP.class);
                            startActivity(i);
                            // Write your code here to execute after dialog closed
                            //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();


                    // Showing Alert Message
                   // alertDialog.show();
                }
                else{



                    // Setting Dialog Title




                    // Setting Dialog Message
                    alertDialog.setMessage(rres.getString("message"));

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
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            super.onPostExecute(result);
        }
    }

}
