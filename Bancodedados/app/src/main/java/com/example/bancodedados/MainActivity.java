package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CarroAdapter carroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printar();

    }

    public void ADD(View view) {
        EditText CODIGO = findViewById(R.id.editText01);
        EditText MARCA = findViewById(R.id.editText02);
        EditText MODELO = findViewById(R.id.editText03);
        EditText ANO = findViewById(R.id.editText04);


        String CODIGO1 = CODIGO.getText().toString();
        String MARCA1 = MARCA.getText().toString();
        String MODELO1 = MODELO.getText().toString();
        String ANO1 = ANO.getText().toString();


        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());

        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO, CODIGO1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA, MARCA1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO, MODELO1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ANO, ANO1);

        long newRowId = db.insert(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                null,
                values
        );



         CODIGO.getText().clear();
         MARCA.getText().clear();
         MODELO.getText().clear();
         ANO.getText().clear();



        printar();
    }

    public void Consultardados(View view) {
        EditText CPF = findViewById(R.id.editText01);
        String CPF1 = CPF.getText().toString();
        TextView textView = findViewById(R.id.textView02);

        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());
        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO,
                FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA,
                FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO,
                FeedReaderContract.FeedEntry.COLUMN_NAME_ANO

        };

        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO + " = ?";
        String[] selectionArgs = { CPF1 };

        String sortOrder = FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA + " DESC";

        Cursor c = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        if (c.getCount() == 0) {
            textView.setText("CPF não encontrado");
            return;
        }

        c.moveToFirst();
        String item1 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO)
        );

        String item2 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA)
        );

        String item3 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO)
        );

        String item4 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_ANO)
        );


        CPF.getText().clear();
        textView.setText("CODIGO: "+item1+"\nMARCA: "+item2+"\nMODELO: "+item3+"\nANO: "+item4);
    }


    public void Alterardados(View view) {
        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());

        SQLiteDatabase db = mDbHealper.getWritableDatabase();

//
        EditText CPF = findViewById(R.id.editText01);

        EditText Tipo1 = findViewById(R.id.editText777);
        String tipo = Tipo1.getText().toString().toUpperCase();
//

        String title = "";




        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO + " = ?";
        String[] selectionArgs = { CPF.getText().toString() };




        if(tipo.equals("CODIGO")){
            EditText CPF1 = findViewById(R.id.editText01);
            title = CPF1.getText().toString();

            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );

        }

        else if (tipo.equals("MARCA")) {
            EditText NOME = findViewById(R.id.editText02);
            title = NOME.getText().toString();
            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }


        else if (tipo.equals("MODELO")) {
            EditText EMAIL = findViewById(R.id.editText03);
            title = EMAIL.getText().toString();
            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }


        else if (tipo.equals("ANO")) {
            EditText tel = findViewById(R.id.editText04);
            title = tel.getText().toString();

            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ANO, title);

            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }




    }

    public void deletar(View view) {


        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());

        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        EditText CPF = findViewById(R.id.editText01);
        String cpf1 = CPF.getText().toString();

        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO + " = ?";
        String[] selectionArgs = { cpf1 };

        int rowsDeleted = db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection, selectionArgs);

        if(rowsDeleted > 0){
            Toast.makeText(getApplicationContext(), "Registro deletado com sucesso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Erro ao deletar registro", Toast.LENGTH_SHORT).show();
        }
        printar();
    }


    public void printar(){


        ArrayList<Carro> listaCarro = new ArrayList<>();

        EditText CPF = findViewById(R.id.editText01);
        String CPF1 = CPF.getText().toString();
        TextView textView = findViewById(R.id.textView02);

        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());
        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO,
                FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA,
                FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO,
                FeedReaderContract.FeedEntry.COLUMN_NAME_ANO
        };

        String sortOrder = FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA + " DESC";

        Cursor c = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        if (c.getCount() == 0) {
            textView.setText("Nenhum registro encontrado");
            return;
        }

        StringBuilder resultBuilder = new StringBuilder();

        while (c.moveToNext()) {
            String item1 = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_CODIGO));
            String item2 = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_MARCA));
            String item3 = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_MODELO));
            String item4 = c.getString(c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_ANO));


            Carro p1 = new Carro(item1,item2,item3,item4);
            listaCarro.add(p1);

        }

        ListView listView1 = findViewById(R.id.listView01);
        carroAdapter = new CarroAdapter(MainActivity.this,listaCarro);
        listView1.setAdapter(carroAdapter);

        c.close();
        db.close();

        if (resultBuilder.length() > 0) {
            textView.setText(resultBuilder.toString());
        } else {
            textView.setText("Nenhum registro encontrado");
        }






    }







}