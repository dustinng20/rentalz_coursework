package com.example.rentalz_coursework;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] items_property = {"House","Studio", "Flat", "Apartment", "Motel" };
    String[] items_bedroom = {"No bedroom","2 bedrooms", "3 bedrooms", "4 bedrooms" };
    String[] items_furniture = {"Furnished","Unfurnished", "Part Furnished"};


    AutoCompleteTextView tvproperty,tvbedroom, tvfurniture;
    EditText edtprice, edtdatetime, edtnote, edtreporter;
    Button btadd;
    TextInputLayout tilprice, tildatetime, tilreporter, tilproperty, tilnote, tilfurniture, tilbedroom ;


    ArrayAdapter<String> adapterItems_property;
    ArrayAdapter<String> adapterItems_bedroom;
    ArrayAdapter<String> adapterItems_furniture;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


        tvproperty = findViewById(R.id.tv_property);
        tvbedroom = findViewById(R.id.tv_bedroom);
        tvfurniture = findViewById(R.id.tv_furniture);
        btadd = findViewById(R.id.bt_add);
        tilprice = findViewById(R.id.til_price);
        tilnote = findViewById(R.id.til_note);
        tilreporter = findViewById(R.id.til_reporter);
        edtprice = findViewById(R.id.edt_price);
        edtdatetime = findViewById(R.id.edt_datetime);
        edtnote = findViewById(R.id.edt_note);
        edtreporter = findViewById(R.id.edt_reporter);


        adapterItems_property = new ArrayAdapter<>(this, R.layout.list_item, items_property);
        adapterItems_bedroom = new ArrayAdapter<>(this, R.layout.list_item, items_bedroom);
        adapterItems_furniture = new ArrayAdapter<>(this, R.layout.list_item, items_furniture);


        tvproperty.setAdapter(adapterItems_property);

        tvproperty.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });

        tvbedroom.setAdapter(adapterItems_bedroom);

        tvbedroom.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });

        tvfurniture.setAdapter(adapterItems_furniture);

        tvfurniture.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });

        //button controller
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!PriceCondition()|!ReporterCondition())
                {return;}
                edtprice.getText().clear();
                edtdatetime.getText().clear();
                edtnote.getText().clear();
                edtreporter.getText().clear();

            }
        });

    }
    public boolean PriceCondition (){
        String checknamne = edtprice.getText().toString().trim();
        if (checknamne.isEmpty() ){
            tilprice.setError("Required");
            return false;
        }
        else {
            tilreporter.setError(null);
            tilreporter.setErrorEnabled(false);
            return true;
        }
    }
    public boolean ReporterCondition (){
        String checknamne = edtreporter.getText().toString().trim();
        if (checknamne.isEmpty()){
            tilreporter.setError("Required");
            return false;
        }
        else {
            tilreporter.setError(null);
            tilreporter.setErrorEnabled(false);
            return true;
        }
    }
}