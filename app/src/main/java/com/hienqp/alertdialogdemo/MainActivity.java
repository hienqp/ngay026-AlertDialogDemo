package com.hienqp.alertdialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview_name);
        dataSource = new ArrayList<>();
        addNameToArrayNameDataSource();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dataSource);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                confirmDelete(position);
                return false;
            }
        });
    }

    private void confirmDelete(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Thông Báo !!!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có muốn xóa môn học [ " + dataSource.get(position) + " ] hay không ???");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dataSource.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }

    private void addNameToArrayNameDataSource() {
        dataSource.add("Android");
        dataSource.add("PHP");
        dataSource.add("IOS");
        dataSource.add("JAVA");
        dataSource.add("C++");
        dataSource.add("Kotlin");
        dataSource.add(".NET");
        dataSource.add("JavaScript");
        dataSource.add("C#");
        dataSource.add("Unity3D");
        dataSource.add("NodeJS");
    }
}