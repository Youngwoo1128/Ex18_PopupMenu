package com.mac_available.ex18popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn2=findViewById(R.id.btn2);

        //버튼이 롤클릭되는 것을 듣는 리스너 생성 및 설정
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //Toast.makeText(MainActivity.this, "longclick", Toast.LENGTH_SHORT).show();

                //PopupMenu 객체 생성
                PopupMenu popup = new PopupMenu(MainActivity.this, btn2);//2 번째 파라터 : 팝업메뉴가 붙을 뷰를 지정
                //xml로 메뉴 설계하여 popup에 붙이기
                Menu menu = popup.getMenu();

                MenuInflater inflater = getMenuInflater();

                inflater.inflate(R.menu.popup, menu);

                //팝업메뉴의 메뉴 아이탬을 클릭하는 것을
                //듣는 리스너 객체 생성 및 추가
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.menu_info:
                                Toast.makeText(MainActivity.this, "information", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_delete:
                                Toast.makeText(MainActivity.this, "delete", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_modify:
                                Toast.makeText(MainActivity.this, "modify", Toast.LENGTH_SHORT).show();
                                    break;
                        }
                        return false;
                    }
                });

                //보여주기
                popup.show();

                return true;
            }
        });
    }

    public void clickBtn(View view) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }
}