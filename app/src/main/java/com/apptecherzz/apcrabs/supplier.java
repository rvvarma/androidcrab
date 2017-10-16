package com.apptecherzz.apcrabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class supplier extends AppCompatActivity {
    Button btnDisplay;
    ImageButton btnAdd;
    ImageButton btnAdd1;
    EditText mobile,company,marks,phone1,phone2,pan,gst;
    EditText bankname,account,ifsc;
    Spinner paytems,shipmenttype,shipdays,rate;
    EditText mcg_a,mcg_y,mcg_w;

    EditText mcw_a,mcw_y,mcw_w;
    EditText rcl_a,rcl_y,rcl_w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnAdd1 = (ImageButton) findViewById(R.id.btnAdd1);

        //form assign
        mobile=(EditText) findViewById(R.id.et_mobileno);
        company=(EditText) findViewById(R.id.et_company_name);
        marks=(EditText) findViewById(R.id.marks);
        phone1=(EditText) findViewById(R.id.phone_1);
        phone2=(EditText) findViewById(R.id.phone_2);
        pan=(EditText) findViewById(R.id.pan);
        gst=(EditText) findViewById(R.id.gst);
        paytems=(Spinner) findViewById(R.id.pay_terms);

        bankname=(EditText) findViewById(R.id.bank_name);
        account=(EditText) findViewById(R.id.account_name);
        ifsc =(EditText) findViewById(R.id.ifsc);


        shipmenttype=(Spinner) findViewById(R.id.shipment_type);
        shipdays=(Spinner) findViewById(R.id.shipment_days);

        rate=(Spinner) findViewById(R.id.Ratecard);


        mcg_a=(EditText) findViewById(R.id.et_fc_acres);
        mcg_y=(EditText) findViewById(R.id.et_fc_years);
        mcg_w=(EditText) findViewById(R.id.et_fc_week);

        mcw_a=(EditText) findViewById(R.id.et_md_acres);
        mcw_y=(EditText) findViewById(R.id.et_md_years);
        mcw_w=(EditText) findViewById(R.id.et_md_per_week);

        rcl_a=(EditText) findViewById(R.id.et_sh_acres);
        rcl_y=(EditText) findViewById(R.id.et_sh_years);
        rcl_w=(EditText) findViewById(R.id.et_sh_week);
        // btnDisplay = (Button) findViewById(R.id.btnDisplay);

        MyLayoutOperation.add(this, btnAdd);
        MyLayoutOperation.add1(this, btnAdd1);
       // MyLayoutOperation.display(this, btnDisplay);
        /*LinearLayout scrollViewlinerLayout = (LinearLayout) activity.findViewById(R.id.linearLayoutForm);

        java.util.ArrayList<String> msg = new ArrayList<String>();

        for (int i = 0; i < scrollViewlinerLayout.getChildCount(); i++)
        {
            LinearLayout innerLayout = (LinearLayout) scrollViewlinerLayout.getChildAt(i);
            EditText edit = (EditText) innerLayout.findViewById(R.id.editDescricao);
            EditText edit1 = (EditText) innerLayout.findViewById(R.id.editDescricao1);

            msg.add(edit.getText().toString()+'/'+edit1.getText().toString());

        }*/
    }
}
