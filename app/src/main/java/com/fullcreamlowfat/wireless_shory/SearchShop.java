package com.fullcreamlowfat.wireless_shory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class SearchShop extends AppCompatActivity {

    private ListView searchShopListVIew;
    private EditText searchShopEditText;
    private shopDBHandler shopDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.search_bottom_panel, new fragmentBottomPanel());
        fragmentTransaction.commit();

        Spinner spinner = (Spinner) findViewById(R.id.search_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.search_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //listViewTest();
    }

    public void naviHome (View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void naviSearch (View view){
        Intent intent = new Intent(this, SearchShop.class);
        startActivity(intent);
    }

    public void naviEvent (View view) {
        Intent intent = new Intent(this, EventList.class);
        startActivity(intent);
    }

    public void listViewTest () {
        String[] listViewItem = {"kiva", "miva", "jiva", "dava", "kaba"};
        ListAdapter listViewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listViewItem);
        ListView mainPageListView = (ListView) findViewById(R.id.search_shop);
        mainPageListView.setAdapter(listViewAdapter);

        mainPageListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        /*
                        String testItem = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(MainPage.this, testItem, Toast.LENGTH_LONG).show();
                        */
                        Intent intent = new Intent(SearchShop.this, ShopDetail.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
