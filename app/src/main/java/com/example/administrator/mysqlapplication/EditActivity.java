package com.example.administrator.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final TodoList edit = (TodoList) getIntent().getSerializableExtra("editTodoList");

        final EditText editext = (EditText) findViewById(R.id.edit_editText);
        editext.setText(edit.getTaskname());

        Button editbtn = (Button) findViewById(R.id.edit_button);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList edittodo = new TodoList();
                edittodo.setTaskid(edit.getTaskid());
                edittodo.setTaskname(String.valueOf(editext.getText()));

                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.update(edittodo);
                todoListDAO.close();
                finish();

            }
        });
        Button delbtn = (Button) findViewById(R.id.del_button);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoListDAO todoListDAOdel = new TodoListDAO(getApplicationContext());
                todoListDAOdel.open();
                todoListDAOdel.delete(edit);
                todoListDAOdel.close();
                finish();
            }
        });
    }

}
