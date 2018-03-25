package android.elviera.com.elvieraharis_202152335_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Add_to_do extends AppCompatActivity {

    //deklarasi variable
    EditText ToDo, Description, Priority;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);


        //mengakses id edit text pada layout
        ToDo = (EditText) findViewById(R.id.editTodo);
        Description = (EditText) findViewById(R.id.editDesc);
        Priority = (EditText) findViewById(R.id.editPriority);
        db = new database(this);
    }

    @Override
    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(Add_to_do.this, ListToDo.class);

        //memulai intent
        startActivity(intent);

        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    //method yang dijalanan ketika tombol tambah to do di klik
    public void tambah(View view) {
        //jika data todo, deskripsi, prioritas diisi
        if (db.inputdata(new AddData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){

            //toast akan menampilkan data berhasil ditambahkan pada list
            Toast.makeText(this, "To Do List ditambahkan!", Toast.LENGTH_SHORT).show();

            //berpindah dari add to do ke list to do
            startActivity(new Intent(Add_to_do.this, ListToDo.class));

            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();

        }else {

            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "Cannot add the list", Toast.LENGTH_SHORT).show();

            //set semua edit text menjadi kosong
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }

}
