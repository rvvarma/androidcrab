package com.apptecherzz.apcrabs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class profil_view extends AppCompatActivity {
ImageView image;
    String im;
    String name;
    String sex;
    String address;
    String DOB;
    EditText n,s,d,a;
    CheckBox famer,supplier,buyer;
    Button b;
    JSONObject jsonObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_profil_view);
        jsonObj = new JSONObject();
        famer=(CheckBox) findViewById(R.id.checkBox) ;
        supplier=(CheckBox) findViewById(R.id.checkBox2);
        buyer=(CheckBox) findViewById(R.id.checkBox3);
        b=(Button) findViewById(R.id.bt_submitform);
        image=(ImageView) findViewById(R.id.imageView);

        n=(EditText) findViewById(R.id.editText2);
        s=(EditText) findViewById(R.id.editText3);
        d=(EditText) findViewById(R.id.editText4);
        a=(EditText) findViewById(R.id.editText5);
        /*String responceData= intent.getStringExtra("data");

        JSONObject jObject = null;
        try {
            jObject = new JSONObject(responceData);
            JSONObject categoryObject = jObject.getJSONObject("e_Kyc");
            JSONObject categoryObject1 = categoryObject.getJSONObject("Poi");
            JSONObject categoryObject2 = categoryObject.getJSONObject("Poa");
            im=categoryObject.getString("Photo");
            name=categoryObject1.getString("Name");
            DOB=categoryObject1.getString("Dob");
            sex=categoryObject1.getString("Gender");
            address=categoryObject2.getString("co")+","+categoryObject2.getString("house")+","+categoryObject2.getString("street")+","+categoryObject2.getString("loc")+","+categoryObject2.getString("vtc")+","+categoryObject2.getString("dist")+","+categoryObject2.getString("state")+","+categoryObject2.getString("pc")+","+categoryObject2.getString("po");
        } catch (JSONException e) {
            e.printStackTrace();
        }

n.setText(name);
        s.setText(sex);
        d.setText(DOB);
        a.setText(address);
        byte[] decodedString = Base64.decode(im, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        image.setImageBitmap(decodedByte);*/
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    jsonObj.put("Name",name);

                    jsonObj.put("DOB",DOB);
                    jsonObj.put("Gender",sex);
                    jsonObj.put("address",address);
                    jsonObj.put("photo",im);
                    if(famer.isChecked()) {
                        Intent far = new Intent(profil_view.this, form.class);
                        startActivity(far);
                    }
                       else if(supplier.isChecked()) {
                        Intent sup = new Intent(profil_view.this, supplier.class);
                        startActivity(sup);
                    }
                           else if(buyer.isChecked()) {
                        Intent buy = new Intent(profil_view.this, buyerform.class);
                        startActivity(buy);
                    }



                   // System.out.println("full data"+jsonObj.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
