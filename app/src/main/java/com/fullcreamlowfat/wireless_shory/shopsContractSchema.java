package com.fullcreamlowfat.wireless_shory;

import android.provider.BaseColumns;

/**
 * Created by user on 11/8/2016.
 */
public class shopsContractSchema {

    public shopsContractSchema() {
    }

    public static abstract class shopsEntry implements BaseColumns{
        public static final String TABLE_NAME = "SHOPS_DETAIL";
        public static final String COLUMN_SHOPNAME = "SHOP_NAME";
        public static final String COLUMN_ABOUT = "SHOP_ABOUT";
        public static final String COLUMN_PHONENO = "PHONE_NO";
        public static final String COLUMN_FLOOR = "FLOOR";
        public static final String COLUMN_WEBSITE = "WEBSITE";
        public static final String COLUMN_CATEGORY = "CATEGORY";
    }
}
