package com.example.myfirstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveTextToFileActivity extends AppCompatActivity {

    private String fileName = "content.txt";
    private File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_text_to_file);
    }

    public void buttonSaveClick(View view)
    {
        try
        {
            EditText textBox = (EditText) findViewById(R.id.input_text);
            String text = textBox.getText().toString();

            FileOutputStream fos;
            fos = openFileOutput(fileName, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            textBox.setText("");
            Toast.makeText(this, "Текстовый файл успешно сохранён!", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Файл не найден!", Toast.LENGTH_SHORT).show();
        } catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка сохранения файла!", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonOpenClick(View view)
    {
        try
        {
            FileInputStream fin;
            fin = openFileInput(fileName);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            EditText textBox = (EditText) findViewById(R.id.input_text);
            textBox.setText(text);
            fin.close();
        } catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}