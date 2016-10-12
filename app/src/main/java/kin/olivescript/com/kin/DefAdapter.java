package kin.olivescript.com.kin;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by sudaraka on 10/12/16.
 */
public class DefAdapter extends CursorAdapter {

    public DefAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView quantity = (TextView) view.findViewById(R.id.quantity);
        // Extract properties from cursor
        String cName = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Items.COLUMN_NAME_ITEM));
        String cQuantity = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Items.COLUMN_NAME_QUANTITY));
        // Populate fields with extracted properties
        name.setText(cName);
        quantity.setText(cQuantity);
    }
}