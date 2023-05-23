package com.example.bancodedados;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    public FeedReaderContract(){}

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "Cadastro";
        public static final String COLUMN_NAME_CODIGO = "CPF";
        public static final String COLUMN_NAME_NAME_MARCA = "Nome";
        public static final String COLUMN_NAME_MODELO = "Email";
        public static final String COLUMN_NAME_ANO = "Telefone";


        public static final String TEXT_TYPE = "TEXT";
        public static final String COMMA_SEP = ",";


        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA+ " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_ANO + " TEXT)";



        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    }

}
