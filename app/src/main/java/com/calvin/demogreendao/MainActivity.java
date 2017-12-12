package com.calvin.demogreendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button btn_Read;
    private Button btn_Create;
    private Button btn_Update;
    private Button btn_Delete;
    private Button btn_DeleteAll;
    private EditText et_Note;
    private EditText et_Id;
    private String tmpNote, tmpId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

    }

    private void initView() {

        et_Note = findViewById(R.id.et_Note);
        et_Id = findViewById(R.id.et_Id);

        //讀取
        btn_Read = findViewById(R.id.btn_Read);
        btn_Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dev", "btn_Read +++");

                List<Note> note_List = DBHelper.getInstance().getAllNote();
                if (note_List != null && note_List.size() >= 1) {
                    for (Note data : note_List) {
                        Log.d("dev", "id: " + data.getId() + " , note: " + data.getText());
                    }
                } else {
                    Log.d("dev", "無任何資料");
                }

            }
        });

        //新增
        btn_Create = findViewById(R.id.btn_Create);
        btn_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dev", "btn_Create +++");
                tmpNote = et_Note.getText().toString();
                if (!tmpNote.isEmpty()) {
                    DBHelper.getInstance().addNote(tmpNote);
                    et_Note.setText("");
                } else {
                    Log.d("dev", "輸入資料，不能為空");
                }

            }
        });

        //修改
        btn_Update = findViewById(R.id.btn_Update);
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dev", "btn_Update +++");
                tmpId = et_Id.getText().toString();
                tmpNote = et_Note.getText().toString();
                if (!tmpId.isEmpty()) {
                    DBHelper.getInstance().updateNote(tmpId, tmpNote);
                    et_Id.setText("");
                    et_Note.setText("");
                } else {
                    Log.d("dev", "輸入id資料，不能為空");
                }
            }
        });

        //刪除
        btn_Delete = findViewById(R.id.btn_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dev", "btn_Delete +++");
                tmpId = et_Id.getText().toString();
                if (!tmpId.isEmpty()) {
                    DBHelper.getInstance().deleteNote(Long.parseLong(tmpId));
                    et_Id.setText("");
                    et_Note.setText("");
                } else {
                    Log.d("dev", "輸入id資料，不能為空");
                }
            }
        });

        //刪除全部資料
        btn_DeleteAll = findViewById(R.id.btn_DeleteAll);
        btn_DeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dev", "btn_DeleteAll +++");
                DBHelper.getInstance().deleteAllTable();
            }
        });


    }


}