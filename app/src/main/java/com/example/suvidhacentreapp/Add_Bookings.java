package com.example.suvidhacentreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Add_Bookings extends AppCompatActivity {
    EditText name_et , account_et , ifsc_et , amount_et , details_et ;
    RadioButton dd_btn ;
    RadioButton check_btn;
    RadioButton yes_btn ;
    RadioButton no_btn;
    Button ref1_btn;
    Button ref2_btn;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__bookings);

        name_et= (EditText)findViewById(R.id.bank_name);
        account_et= (EditText)findViewById(R.id.bank_account);
        ifsc_et= (EditText)findViewById(R.id.ifsc_code);
        amount_et= (EditText)findViewById(R.id.amount);
        details_et= (EditText)findViewById(R.id.payment);
        check_btn= (RadioButton)findViewById(R.id.check);
        dd_btn= (RadioButton)findViewById(R.id.DD);
        yes_btn= (RadioButton)findViewById(R.id.yes);
        no_btn= (RadioButton)findViewById(R.id.no);
        ref1_btn =(Button)findViewById(R.id.ref1);
        ref2_btn =(Button)findViewById(R.id.ref2);
        submit_btn =(Button)findViewById(R.id.submit);


    }

    public void submit(View view) {


        String name = name_et.getText().toString();
        String account = account_et.getText().toString();
        String ifsc = name_et.getText().toString();
        String amount = name_et.getText().toString();
        String details = name_et.getText().toString();

        Boolean DD = dd_btn.isChecked();
        Boolean check = check_btn.isChecked();
        Boolean yes = yes_btn.isChecked();
        Boolean no = no_btn.isChecked();

        if (name.equals("")) {
            Toast.makeText(Add_Bookings.this, "enter the name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (account.length() < 15) {
            Toast.makeText(Add_Bookings.this, " account no should not be less than 15 digits", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ifsc.length() < 11) {
            Toast.makeText(Add_Bookings.this, " ifsc code should not be less than 11 digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if (amount.length() >0) {
            Toast.makeText(Add_Bookings.this, " amount  should  be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }

        if (details.equals("")) {
            Toast.makeText(Add_Bookings.this, "enter the details", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!DD&&!check){
            Toast.makeText(Add_Bookings.this, "select the option", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!yes&&!no) {
            Toast.makeText(Add_Bookings.this, "select the option", Toast.LENGTH_SHORT).show();
            return;
        }



    }

    public void submitt(View view) {
    }
}
