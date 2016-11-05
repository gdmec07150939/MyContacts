package com.example.hui.mycontacts2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
public class AddContactsActivity extends AppCompatActivity {
    private EditText name;
    private EditText mobile;
    private EditText qq;
    private EditText danwei;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("添加联系人");
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        qq=(EditText)findViewById(R.id.qq);
        danwei=(EditText)findViewById(R.id.danwei);
        address=(EditText)findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if (!name.getText().toString().equals("")) {
                    User user=new User();
                    user.setName(name.getText().toString());
                    user.setMobile(mobile.getText().toString());
                    user.setDanwei(danwei.getText().toString());
                    user.setQq(qq.getText().toString());
                    user.setAddress(address.getText().toString());

                    ContactsTable ct =new ContactsTable(AddContactsActivity.this);

                    if(ct.addDate(user)){
                        Toast.makeText(AddContactsActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(AddContactsActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
        }
        return super.onOptionsItemSelected(item);
    }
}