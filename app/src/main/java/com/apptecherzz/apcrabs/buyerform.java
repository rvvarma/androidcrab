package com.apptecherzz.apcrabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class buyerform extends AppCompatActivity {
Spinner btype,state,STATE1;
    EditText company,auth_name,street,city,country,zip,tax,pan,gst,ph1,ph2,fax;
    EditText company1,auth_name1,street1,city1,country1,zip1,tax1,pan1,gst1,ph11,ph21,fax1;
    EditText mcm_a,mcm_y,mcm_w;
    EditText mcb_a,mcb_y,mcb_w;
    EditText mcxl_a,mcxl_y,mcxl_w;
    EditText mcxxl_a,mcxxl_y,mcxxl_w;
    EditText mcol_a,mcol_y,mcol_w;
    EditText rc_a,rc_y,rc_w;
    EditText sf_a,sf_y,sf_w;
    EditText cr_a,cr_y,cr_w;
    CheckBox enable;
    EditText bank_name,bank_acc,bank_ifsc;
    Spinner ship_type,ship_time,rate,lg,lc;
    Spinner pttype,pttimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerform);
        btype=(Spinner)findViewById(R.id.buyer_type);
        company=(EditText) findViewById(R.id.company_legal_name);
        auth_name=(EditText) findViewById(R.id.auth_persom_name);
        street=(EditText) findViewById(R.id.street_address);
        city=(EditText) findViewById(R.id.city);
        country=(EditText) findViewById(R.id.country);
        zip=(EditText) findViewById(R.id.zipcode);
        tax=(EditText) findViewById(R.id.TAX_ID);
        pan=(EditText) findViewById(R.id.pan);
        gst=(EditText) findViewById(R.id.GST);
        ph1=(EditText) findViewById(R.id.PH1);
        ph2=(EditText) findViewById(R.id.PH2);
        fax=(EditText) findViewById(R.id.FAX);
        state=(Spinner) findViewById(R.id.state);

        mcm_a=(EditText) findViewById(R.id.mc_a);
        mcm_y=(EditText) findViewById(R.id.mc_y);
        mcm_w=(EditText) findViewById(R.id.mc_w);

        mcb_a=(EditText) findViewById(R.id.mcb_a);
        mcb_y=(EditText) findViewById(R.id.mcb_y);
        mcb_w=(EditText) findViewById(R.id.mcb_w);

        mcxl_a=(EditText) findViewById(R.id.mcxl_a);
        mcxl_y=(EditText) findViewById(R.id.mcxl_y);
        mcxl_w=(EditText) findViewById(R.id.mcxl_w);

        mcxxl_a=(EditText) findViewById(R.id.mcxxl_a);
        mcxxl_y=(EditText) findViewById(R.id.mcxxl_y);
        mcxxl_w=(EditText) findViewById(R.id.mcxxl_w);

        mcol_a=(EditText) findViewById(R.id.mcol_a);
        mcol_y=(EditText) findViewById(R.id.mcol_y);
        mcol_w=(EditText) findViewById(R.id.mcol_w);

        rc_a=(EditText) findViewById(R.id.rca_a);
        rc_y=(EditText) findViewById(R.id.rca_y);
        rc_w=(EditText) findViewById(R.id.rca_w);

        sf_a=(EditText) findViewById(R.id.ssc_a);
        sf_y=(EditText) findViewById(R.id.ssc_y);
        sf_w=(EditText) findViewById(R.id.ssc_w);

        cr_a=(EditText) findViewById(R.id.cr_a);
        cr_y=(EditText) findViewById(R.id.cr_y);
        cr_w=(EditText) findViewById(R.id.cr_w);


        company1=(EditText) findViewById(R.id.company_legal_name1);
        auth_name1=(EditText) findViewById(R.id.auth_persom_name1);
        street1=(EditText) findViewById(R.id.street_address1);
        city1=(EditText) findViewById(R.id.city1);
        country1=(EditText) findViewById(R.id.country1);
        zip1=(EditText) findViewById(R.id.zipcode1);
        tax1=(EditText) findViewById(R.id.TAX_ID1);
        fax1=(EditText) findViewById(R.id.FAX1);
        ph11=(EditText) findViewById(R.id.PH11);
        ph21=(EditText) findViewById(R.id.PH21);
        pan1=(EditText) findViewById(R.id.pan1);
        gst1=(EditText) findViewById(R.id.GST1);
        STATE1=(Spinner) findViewById(R.id.state1);

        bank_name=(EditText) findViewById(R.id.bank_name);
        bank_acc=(EditText) findViewById(R.id.account_name);
        bank_ifsc=(EditText) findViewById(R.id.ifsc);


            ship_type=(Spinner) findViewById(R.id.shipment_type);
        ship_time=(Spinner) findViewById(R.id.times);
        rate=(Spinner) findViewById(R.id.Ratecard);
        lg=(Spinner) findViewById(R.id.lg);
        lc=(Spinner) findViewById(R.id.lc);

        pttype=(Spinner) findViewById(R.id.pttype);
        pttimes=(Spinner) findViewById(R.id.pttimes);


        //disbaling elements for second company
        company1.setEnabled(false);
        auth_name1.setEnabled(false);
        street1.setEnabled(false);
        city1.setEnabled(false);
        country1.setEnabled(false);
        zip1.setEnabled(false);
        tax1.setEnabled(false);
        fax1.setEnabled(false);
        ph11.setEnabled(false);
        ph21.setEnabled(false);
        gst1.setEnabled(false);
        pan1.setEnabled(false);
       STATE1.setEnabled(false);
        enable=(CheckBox) findViewById(R.id.chkIos);
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enable.isChecked()){
                    company1.setEnabled(true);
                    auth_name1.setEnabled(true);
                    street1.setEnabled(true);
                    city1.setEnabled(true);
                    country1.setEnabled(true);
                    zip1.setEnabled(true);
                    tax1.setEnabled(true);
                    fax1.setEnabled(true);
                    ph11.setEnabled(true);
                    ph21.setEnabled(true);
                    gst1.setEnabled(true);
                    pan1.setEnabled(true);
                    STATE1.setEnabled(true);
                }
                else{
                    company1.setEnabled(false);
                    auth_name1.setEnabled(false);
                    street1.setEnabled(false);
                    city1.setEnabled(false);
                    country1.setEnabled(false);
                    zip1.setEnabled(false);
                    tax1.setEnabled(false);
                    fax1.setEnabled(false);
                    ph11.setEnabled(false);
                    ph21.setEnabled(false);
                    gst1.setEnabled(false);
                    pan1.setEnabled(false);
                    STATE1.setEnabled(false);
                }
            }
        });



    }
}
