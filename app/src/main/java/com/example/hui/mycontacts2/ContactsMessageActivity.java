package com.example.hui.mycontacts2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.Menu;
import android.widget.Toast;

/**
 * Created by hui on 2016/11/4.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private TextView name;
    private TextView mobile;
    private TextView qq;
    private TextView danwei;
    private TextView address;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_contacts_message);
        setTitle("联系人信息");
        name=(TextView)findViewById(R.id.name);
        mobile=(TextView)findViewById(R.id.mobile);
        qq=(TextView)findViewById(R.id.qq);
        danwei=(TextView)findViewById(R.id.danwei);
        address=(TextView)findViewById(R.id.address);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("User_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserByID(id);
        name.setText("姓名："+user.getName());
        mobile.setText("电话："+user.getMobile());
        qq.setText("qq："+user.getQq());
        danwei.setText("单位："+user.getDanwei());
        address.setText("地址："+user.getAddress());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
