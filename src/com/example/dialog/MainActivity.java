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
            build.setTitle("标题").setMessage("简单消息框")
                    .setPositiveButton("确定", null);
            build.show();
            break;
        case R.id.confirm:
            new AlertDialog.Builder(this).setTitle("确认").setMessage("确定吗？")
                    .setPositiveButton("是", null).setNegativeButton("否", null)
                    .show();
            break;
        case R.id.input:
            new AlertDialog.Builder(this).setTitle("请输入")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setView(new EditText(this)).setPositiveButton("确定", null)
                    .setNegativeButton("取消", null).show();
            break;
        case R.id.radio:
            new AlertDialog.Builder(this)
                    .setTitle("请选择")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setSingleChoiceItems(
                            new String[] { "选项1", "选项2", "选项3", "选项4" }, 0,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int which) {
                                    dialog.dismiss();
                                }
                            }).setNegativeButton("取消", null).show();
            break;
        case R.id.checkbox:
            new AlertDialog.Builder(this)
                    .setTitle("多选框")
                    .setMultiChoiceItems(
                            new String[] { "选项1", "选项2", "选项3", "选项4" }, null,
                            null).setPositiveButton("确定", null)
                    .setNegativeButton("取消", null).show();
            break;
        case R.id.list:
            new AlertDialog.Builder(this).setTitle("列表框")
                    .setItems(new String[] { "列表项1", "列表项2", "列表项3" }, null)
                    .setNegativeButton("确定", null).show();
            break;
        case R.id.photo:
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.ic_launcher);
            new AlertDialog.Builder(this).setTitle("图片框").setView(img)
                    .setPositiveButton("确定", null).show();
            break;

        default:
            break;
        }
    }

}
