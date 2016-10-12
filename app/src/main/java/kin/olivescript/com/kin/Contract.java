package kin.olivescript.com.kin;

import android.provider.BaseColumns;

/**
 * Created by sudaraka on 10/13/16.
 */
public class Contract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Contract(){}

    public static class Items implements BaseColumns {
        public static final String TABLE_NAME = "items";
        public static final String COLUMN_NAME_ID = "item_id";
        public static final String COLUMN_NAME_LIST = "list_id";
        public static final String COLUMN_NAME_ITEM = "item";
        public static final String COLUMN_NAME_QUANTITY="quantity";
    }
}
