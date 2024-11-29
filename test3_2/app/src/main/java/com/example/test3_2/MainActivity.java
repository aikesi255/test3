package com.example.test3_2;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建 AlertDialog.Builder 对象
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        // 获取自定义布局的实例
        LayoutInflater inflater = this.getLayoutInflater();

        ViewGroup dialogView =(ViewGroup) inflater.inflate(R.layout.test3_2, null);


        // 将自定义布局添加到对话框中
        builder.setView(dialogView);

        Button cancelButton = dialogView.findViewById(R.id.dialogButtonNegative);
        Button confirmButton = dialogView.findViewById(R.id.dialogButtonPositive);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理取消按钮点击事件

            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理确定按钮点击事件
                // 可以在这里添加你的逻辑
            }
        });


        // 显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}