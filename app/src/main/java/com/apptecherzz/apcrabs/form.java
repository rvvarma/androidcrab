package com.apptecherzz.apcrabs;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class form extends AppCompatActivity {
    TextView name, email, phn;
    EditText mobile_num;
    EditText fis_acres, fish_years, mudcrab_acres, mudcrab_years, shrimp_acres, shrimp_years;
    EditText total_farming_area, ownd_in_acres, leased_in_acres;
    EditText total_farming_num, owned_seed_num, sponcerd_seed_num;
    EditText village, mandal, district, state, pincode;
    EditText min_salinity, max_salinity;
    Spinner select_state, select_water_type, select_moter_type, select_occupation, farming_capcity;
    Button take_farmer_photo, take_id, submit;
    ImageView user_img;
    RadioGroup radioGroup;
    RadioButton seeds;
    RadioButton bags;
    String tempVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mobile_num= (EditText)findViewById(R.id.et_mobileno);
        //   org_ocupation= (EditText)findViewById(R.id.et_occupation);
        farming_capcity= (Spinner) findViewById(R.id.et_capacity);
        fis_acres= (EditText)findViewById(R.id.et_fc_acres);
        fish_years= (EditText)findViewById(R.id.et_fc_years);
        mudcrab_acres= (EditText)findViewById(R.id.et_md_acres);
        mudcrab_years= (EditText)findViewById(R.id.et_md_years);
        shrimp_acres= (EditText)findViewById(R.id.et_sh_acres);
        shrimp_years= (EditText)findViewById(R.id.et_sh_years);
        total_farming_area= (EditText)findViewById(R.id.et_total_farmingacres);
        ownd_in_acres= (EditText)findViewById(R.id.et_ownedacres);
        leased_in_acres= (EditText)findViewById(R.id.et_leasedacres);
        total_farming_num= (EditText)findViewById(R.id.et_total_farmingnumber);
        total_farming_num.setFocusable(false);
        total_farming_num.setFocusableInTouchMode(false); // user touches widget on phone with touch screen
        total_farming_num.setClickable(false);


        owned_seed_num= (EditText)findViewById(R.id.et_ownseednumbner);
        owned_seed_num.setFocusable(false);
        owned_seed_num.setFocusableInTouchMode(false); // user touches widget on phone with touch screen
        owned_seed_num.setClickable(false);
        sponcerd_seed_num= (EditText)findViewById(R.id.et_sponseredseednumber);
        sponcerd_seed_num.setFocusable(false);
        sponcerd_seed_num.setFocusableInTouchMode(false); // user touches widget on phone with touch screen
        sponcerd_seed_num.setClickable(false);
        village= (EditText)findViewById(R.id.et_village);
        mandal= (EditText)findViewById(R.id.et_mandal);
        district= (EditText)findViewById(R.id.et_district);
        state= (EditText)findViewById(R.id.et_state);
        pincode= (EditText)findViewById(R.id.et_pincode);
        min_salinity= (EditText)findViewById(R.id.et_minsalinity);
        max_salinity= (EditText)findViewById(R.id.et_maxsalinity);
        select_water_type= (Spinner)findViewById(R.id.sp_water_types);
        select_moter_type= (Spinner)findViewById(R.id.sp_motor_types);
        select_occupation = (Spinner)findViewById(R.id.et_occupation);
        take_farmer_photo = (Button)findViewById(R.id.bt_farmerphoto);
        take_id = (Button)findViewById(R.id.bt_uploadgovid);
        submit = (Button)findViewById(R.id.bt_submitform);
        radioGroup =(RadioGroup)findViewById(R.id.id_seed_bag);
        seeds =(RadioButton)findViewById(R.id.id_num_seeds);
        bags = (RadioButton)findViewById(R.id.id_num_bags);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId) {
                    case R.id.id_num_seeds:
                        total_farming_num.setHint("Total Number Of Seeds");
                        owned_seed_num.setHint("Own Invested Seed Num");
                        sponcerd_seed_num.setHint("Sponcerd Seed Num");
                        total_farming_num.setFocusable(true);
                        total_farming_num.setFocusableInTouchMode(true);
                        total_farming_num.setClickable(true);
                        owned_seed_num.setFocusable(true);
                        owned_seed_num.setFocusableInTouchMode(true);
                        owned_seed_num.setClickable(true);
                        sponcerd_seed_num.setFocusable(true);
                        sponcerd_seed_num.setFocusableInTouchMode(true);
                        sponcerd_seed_num.setClickable(true);
                        tempVal = "seeds";
                        Log.d("madhuval", tempVal);

                        break;
                    case R.id.id_num_bags:
                        total_farming_num.setHint("Toatal Number od Bags");
                        owned_seed_num.setHint("Own Invested Bag Num");
                        sponcerd_seed_num.setHint("Sponcerd Seed Num");
                        total_farming_num.setFocusable(true);
                        total_farming_num.setFocusableInTouchMode(true);
                        total_farming_num.setClickable(true);
                        owned_seed_num.setFocusable(true);
                        owned_seed_num.setFocusableInTouchMode(true);
                        owned_seed_num.setClickable(true);
                        sponcerd_seed_num.setFocusable(true);
                        sponcerd_seed_num.setFocusableInTouchMode(true);
                        sponcerd_seed_num.setClickable(true);
                        tempVal= "bags";
                        Log.d("madhuval", tempVal);
                        break;
//                    case R.id.radio3:
//                        RadioButton value = Integer.parseInt(((RadioButton) findViewById(R.id.radio3).getText()) * 3);
//                        break;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                 String st =select_state.getSelectedItem().toString();
//                  int pos =s.getSelectedItemPosition()
              if(mobile_num.getText().toString().isEmpty()){
                        mobile_num.setError("This Field Required");
                        showToast("Some fields are incomplete");
//                  }else if(org_ocupation.getText().toString().isEmpty()){
//                      org_ocupation.setError("This Field Required");
//                      showToast("Some fields are incomplete");
                    }else if(select_occupation.getSelectedItemPosition()==0) {
                        showToast("Select Occupation");
                    }else if(farming_capcity.getSelectedItemPosition()==0){
                        showToast("Select Farming Capacity");
                    }else if(fis_acres.getText().toString().isEmpty()){
                        fis_acres.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    } else if(fish_years.getText().toString().isEmpty()){
                        fish_years.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(mudcrab_acres.getText().toString().isEmpty()){
                        mudcrab_acres.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(mudcrab_years.getText().toString().isEmpty()){
                        mudcrab_years.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(shrimp_acres.getText().toString().isEmpty()){
                        shrimp_acres.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(shrimp_years.getText().toString().isEmpty()){
                        shrimp_years.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(total_farming_area.getText().toString().isEmpty()){
                        total_farming_area.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(ownd_in_acres.getText().toString().isEmpty()){
                        ownd_in_acres.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(leased_in_acres.getText().toString().isEmpty()){
                        leased_in_acres.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(total_farming_num.getText().toString().isEmpty()){
                        total_farming_num.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(owned_seed_num.getText().toString().isEmpty()){
                        owned_seed_num.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    } else if(sponcerd_seed_num.getText().toString().isEmpty()){
                        sponcerd_seed_num.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    } else if(village.getText().toString().isEmpty()){
                        village.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(mandal.getText().toString().isEmpty()){
                        mandal.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(district.getText().toString().isEmpty()){
                        district.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(state.getText().toString().isEmpty()){
                        state.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(pincode.getText().toString().isEmpty()){
                        pincode.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(min_salinity.getText().toString().isEmpty()){
                        min_salinity.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(max_salinity.getText().toString().isEmpty()) {
                        max_salinity.setError("This Field Required");
                        showToast("Some fields are incomplete");
                    }else if(select_water_type.getSelectedItemPosition()==0) {
                        showToast("Select water type");
                    }else if(select_moter_type.getSelectedItemPosition()==0) {
                        showToast("Select moter type");
//                  }else if(select_state.getItemAtPosition(0).toString().equals("Select Water Type")) {
//                      showToast("Select water type");
//                  }else if(select_state.getItemAtPosition(0).toString().equals("Select Motor Type")) {
//                      showToast("Select moter type");


                    } else{

                                                                      mobile_num.getText().toString();
                                        select_occupation.getSelectedItem().toString();
                                        farming_capcity.getSelectedItem().toString();
                                        fis_acres.getText().toString();
                                        fish_years.getText().toString();
                                        mudcrab_acres.getText().toString();
                                        mudcrab_years.getText().toString();
                                        shrimp_acres.getText().toString();
                                        shrimp_years.getText().toString();
                                        total_farming_area.getText().toString();
                                        ownd_in_acres.getText().toString();
                                        leased_in_acres.getText().toString();
                                        total_farming_num.getText().toString();
                                        owned_seed_num.getText().toString();//add bags for above and beloew
                                        sponcerd_seed_num.getText().toString();
                                        village.getText().toString();
                                        mandal.getText().toString();
                                        district.getText().toString();
                                        state.getText().toString();
                                        pincode.getText().toString();
                                        min_salinity.getText().toString();
                                        max_salinity.getText().toString();
                                        select_water_type.getSelectedItem().toString();
                                        select_moter_type.getSelectedItem().toString();

                            }




                }

        });
    }
    public void showToast(String message) {
        Toast.makeText(form.this, message, Toast.LENGTH_LONG).show();
    }


}
