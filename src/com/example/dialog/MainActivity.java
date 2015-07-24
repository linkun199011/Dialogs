package com.example.dialog;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {
    private Button normal;
    private Button confirm;
    private Button input;
    private Button radio;
    private Button checkbox;
    private Button list;
    private Button photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    private void initView() {
        // TODO Auto-generated method stub
        normal = (Button) findViewById(R.id.normal);
        confirm = (Button) findViewById(R.id.confirm);
        input = (Button) findViewById(R.id.input);
        radio = (Button) findViewById(R.id.radio);
        checkbox = (Button) findViewById(R.id.checkbox);
        list = (Button) findViewById(R.id.list);
        photo = (Button) findViewById(R.id.photo);
        normal.setOnClickListener(this);
        confirm.setOnClickListener(this);
        input.setOnClickListener(this);
        radio.setOnClickListener(this);
        checkbox.setOnClickListener(this);
        list.setOnClickListener(this);
        photo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.normal:
            AlertDialog.Builder build = new AlertDialog.Builder(this);
            build.setTitle("����").setMessage("����Ϣ��")
                    .setPositiveButton("ȷ��", null);
            build.show();
            break;
        case R.id.confirm:
            new AlertDialog.Builder(this).setTitle("ȷ��").setMessage("ȷ����")
                    .setPositiveButton("��", null).setNegativeButton("��", null)
                    .show();
            break;
        case R.id.input:
            new AlertDialog.Builder(this).setTitle("������")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setView(new EditText(this)).setPositiveButton("ȷ��", null)
                    .setNegativeButton("ȡ��", null).show();
            break;
        case R.id.radio:
            new AlertDialog.Builder(this)
                    .setTitle("��ѡ��")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setSingleChoiceItems(
                            new String[] { "ѡ��1", "ѡ��2", "ѡ��3", "ѡ��4" }, 0,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int which) {
                                    dialog.dismiss();
                                }
                            }).setNegativeButton("ȡ��", null).show();
            break;
        case R.id.checkbox:
            new AlertDialog.Builder(this)
                    .setTitle("��ѡ��")
                    .setMultiChoiceItems(
                            new String[] { "ѡ��1", "ѡ��2", "ѡ��3", "ѡ��4" }, null,
                            null).setPositiveButton("ȷ��", null)
                    .setNegativeButton("ȡ��", null).show();
            break;
        case R.id.list:
            new AlertDialog.Builder(this).setTitle("�б��")
                    .setItems(new String[] { "�б���1", "�б���2", "�б���3" }, null)
                    .setNegativeButton("ȷ��", null).show();
            break;
        case R.id.photo:
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.ic_launcher);
            new AlertDialog.Builder(this).setTitle("ͼƬ��").setView(img)
                    .setPositiveButton("ȷ��", null).show();
            break;

        default:
            break;
        }
    }

}
