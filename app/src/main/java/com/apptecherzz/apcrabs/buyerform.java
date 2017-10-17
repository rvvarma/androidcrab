package com.apptecherzz.apcrabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

public class buyerform extends AppCompatActivity {
Spinner btype,state,STATE1;
    JSONObject obj;
    JSONObject mcm;
    JSONObject mcb;
    JSONObject mcxl;
    JSONObject mcxxl;
    JSONObject mcol;
    JSONObject rcl;
    JSONObject ssc;
    JSONObject cm;
    JSONObject sis;
    Button submit;
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
        obj=new JSONObject();
        sis=new JSONObject();
        mcm=new JSONObject();
        mcb=new JSONObject();
        mcxl=new JSONObject();
        mcxxl=new JSONObject();
        mcol=new JSONObject();
        rcl=new JSONObject();
        ssc=new JSONObject();
        cm=new JSONObject();
        submit=(Button) findViewById(R.id.bt_submitform);
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
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        try {
            obj.put("Company type",btype.getSelectedItem().toString());
            obj.put("Company name",company.getText().toString());
            obj.put("auth name",auth_name.getText().toString());
            obj.put("street",street.getText().toString());
            obj.put("City",city.getText().toString());
            obj.put("state",state.getSelectedItem().toString());
            obj.put("Country",country.getText().toString());
            obj.put("zipcode",zip.getText().toString());
            obj.put("Tax No",tax.getText().toString());
            obj.put("Pan No",pan.getText().toString());
            obj.put("GST No",gst.getText().toString());
            obj.put("Phone 1",ph1.getText().toString());
            obj.put("Phone 2",ph2.getText().toString());
            obj.put("Fax No",fax.getText().toString());

            mcm.put("Turn over",mcm_a.getText().toString());
            mcm.put("Trading from",mcm_y.getText().toString());
            mcm.put("per week",mcm_w.getText().toString());

            mcb.put("Turn over",mcb_a.getText().toString());
            mcb.put("Trading from",mcb_y.getText().toString());
            mcb.put("per week",mcb_w.getText().toString());

            mcxl.put("Turn over",mcxl_a.getText().toString());
            mcxl.put("Trading from",mcxl_y.getText().toString());
            mcxl.put("per week",mcxl_w.getText().toString());

            mcxxl.put("Turn over",mcxxl_a.getText().toString());
            mcxxl.put("Trading from",mcxxl_y.getText().toString());
            mcxxl.put("per week",mcxxl_w.getText().toString());

            mcol.put("Turn over",mcol_a.getText().toString());
            mcol.put("Trading from",mcol_y.getText().toString());
            mcol.put("per week",mcol_w.getText().toString());

            rcl.put("Turn over",rc_a.getText().toString());
            rcl.put("Trading from",rc_y.getText().toString());
            rcl.put("per week",rc_w.getText().toString());

            ssc.put("Turn over",sf_a.getText().toString());
            ssc.put("Trading from",sf_y.getText().toString());
            ssc.put("per week",sf_w.getText().toString());

            cm.put("Turn over",cr_a.getText().toString());
            cm.put("Trading from",cr_y.getText().toString());
            cm.put("per week",cr_w.getText().toString());

            obj.put("Mud Crab – M",mcm);
            obj.put("Mud Crab – Big",mcb);
            obj.put("Mud Crab – XL",mcxl);
            obj.put("Mud Crab – XXL",mcxxl);
            obj.put("Mud Crab – OL",mcol);
            obj.put("Red Crab – ALive",rcl);
            obj.put("Soft Shell Crab",ssc);
            obj.put("Crab Meat",cm);

            if(enable.isChecked()){
                sis.put("Company name",company1.getText().toString());
                sis.put("auth name",auth_name1.getText().toString());
                sis.put("street",street1.getText().toString());
                sis.put("City",city1.getText().toString());
                sis.put("state",STATE1.getSelectedItem().toString());
                sis.put("Country",country.getText().toString());
                sis.put("zipcode",zip1.getText().toString());
                sis.put("Tax No",tax1.getText().toString());
                sis.put("Pan No",pan1.getText().toString());
                sis.put("GST No",gst1.getText().toString());
                sis.put("Phone 1",ph11.getText().toString());
                sis.put("Phone 2",ph21.getText().toString());
                sis.put("Fax No",fax1.getText().toString());
            }
            obj.put("Sister company",sis);
            obj.put("ship type",ship_type.getSelectedItem().toString());
            obj.put("ship times",ship_time.getSelectedItem().toString());
            obj.put("rate card",rate.getSelectedItem().toString());
            obj.put("local grader",lg.getSelectedItem().toString());
            obj.put("local collector",lc.getSelectedItem().toString());
            obj.put("payment type",pttype.getSelectedItem().toString());
            obj.put("payment times",pttimes.getSelectedItem().toString());
            SharedPreferences.Editor editor = getSharedPreferences("collect", MODE_PRIVATE).edit();
            editor.putString("buyer1",obj.toString());
            editor.commit();

            System.out.println("revising "+obj.toString());
            Intent i=new Intent(buyerform.this,declaration.class);
            startActivity(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
});


    }
}
