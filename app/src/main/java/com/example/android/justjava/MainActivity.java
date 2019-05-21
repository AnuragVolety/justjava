package com.example.android.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=2;
    int pricePerCup = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate: ", "We have entered Main Activity" );
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view){
        createOrderSummary(quantity);
    }

    private void createOrderSummary(int number) {
        EditText name = (EditText) findViewById(R.id.editText);
        String message = "Name: "+ name.getText() + "\n";
        CheckBox check1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        if(check1.isChecked()) {
            message+="Whipped Cream is added!!..\n";
            pricePerCup+=1;
        }
        else{
            message+="Whipped Cream is not added.. \n";
        }
        if(check2.isChecked()){
            message+="Chocolate is added!!..\n";
            pricePerCup+=2;
        }
        else{
            message+="Chocolate is not added.. \n";
        }
        message += "Quantity: "+ number + "\nTotal: $" + calculatePrice(number) + "\n" + getString(R.string.thank_you)+"!!";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hi! Order of "+ name.getText() +" is ready!!");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void increment(View view){
        if(quantity<100){
        quantity=quantity+1;}
        else{
            Toast.makeText(this,"You cannot have more than 100 coffees.",Toast.LENGTH_LONG).show();
        }
        displayQuantity(quantity);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void decrement(View view){
        if(quantity>1){
        quantity=quantity-1;}
        else{
            Toast.makeText(this,"You cannot have less than 1 coffee.",Toast.LENGTH_LONG).show();
        }
        displayQuantity(quantity);
    }

    private int calculatePrice(int num){
        return num * pricePerCup;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.price_text_view);
        orderSummaryTextView.setText(message);
    }
}