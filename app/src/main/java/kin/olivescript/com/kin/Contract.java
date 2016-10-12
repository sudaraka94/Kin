package kin.olivescript.com.kin;

import android.provider.BaseColumns;

/**
 * Created by sudaraka on 10/12/16.
 */
public final class Contract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Contract(){}

    public static class Items implements BaseColumns{
        public static final String TABLE_NAME = "items";
        public static final String COLUMN_NAME_ID = "item_id";
        public static final String COLUMN_NAME_LIST = "list_id";
        public static final String COLUMN_NAME_ITEM = "item";
        public static final String COLUMN_NAME_QUANTITY="quantity";
        public static final String COLUMN_NAME_SYNCED="synced";
        public static final String COLUMN_NAME_DELETED="deleted";
        public static final String COLUMN_NAME_DELETEREQUESTED="del_requested";
    }


}