package kin.olivescript.com.kin;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class addItem extends AppCompatActivity {
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            username=extras.getString("login.username");
        }
    }

    public void addInput(View v){
        EditText text= (EditText) findViewById(R.id.editText3);
        EditText quantity= (EditText) findViewById(R.id.editText4);
        String jItem=text.getText().toString();
        String quantityVal=quantity.getText().toString();
        Log.d("AddInput", "ok");
        // Gets the data repository in write mode
        DB_Helper dbHelper=new DB_Helper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Contract.Items.COLUMN_NAME_ITEM, jItem);
        values.put(Contract.Items.COLUMN_NAME_QUANTITY, quantityVal);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Contract.Items.TABLE_NAME, null, values);
        back();
    }

    protected void back(){
        Intent intent1 = new Intent(this, List.class);
        intent1.putExtra("login.username", username);
        Log.d("Back", "ok");
        startActivity(intent1);
    }
}
