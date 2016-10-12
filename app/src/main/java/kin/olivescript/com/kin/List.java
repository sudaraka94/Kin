package kin.olivescript.com.kin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class List extends AppCompatActivity {

    private ProgressDialog pDialog;
    private ListView lv;
    private String username;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            username=extras.getString("login.username");
        }
        lv= (ListView) findViewById(R.id.list);
        getList();
        lv.setClickable(true);
    }


    private void getList(){
        pDialog=new ProgressDialog(List.this);
        pDialog.setMessage("Please Wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        DB_Helper dbHelp=new DB_Helper(this);
        SQLiteDatabase db = dbHelp.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                Contract.Items._ID,
                Contract.Items.COLUMN_NAME_ITEM,
                Contract.Items.COLUMN_NAME_QUANTITY
        };

        Cursor c = db.query(
                Contract.Items.TABLE_NAME,                     // The table to query
                projection,
//                selection,                                // The columns for the WHERE clause
//                selectionArgs,                            // The values for the WHERE clause
                null,
                null,
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
//                sortOrder                                 // The sort order
                null
        );

        //Attaching an adapter
        DefAdapter adapter=new DefAdapter(this,c);
        lv.setAdapter(adapter);

        pDialog.dismiss();

    }

    public void addItem(View v){
        Intent intent1 = new Intent(this, addItem.class);
        intent1.putExtra("login.username", username);
        startActivity(intent1);
    }
}
