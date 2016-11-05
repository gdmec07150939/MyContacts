package com.example.hui.mycontacts2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;


public class ContactsTable {
    private final static String TABLENAME = "contactsTable";
    private MyDB db;

    public ContactsTable(Context context) {
        db = new MyDB(context);
        if (!db.isTableExits(TABLENAME)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS" + TABLENAME +
                    "(id_DB integer" + "primary key AUTOINCREMENT," +
                    User.Name + "VARCHAR," +
                    User.MOBILE + "VARCHAR," +
                    User.QQ + "VARCHAR," +
                    User.DANWEI + "VARCHAR," +
                    User.ADDRESS + "VARCHAR)";
            db.createTable(createTableSQL);
        }
    }

    public boolean addDate(User user) {
        ContentValues values = new ContentValues();
        values.put(User.Name, user.getName());
        values.put(User.MOBILE, user.getMobile());
        values.put(User.DANWEI, user.getDanwei());
        values.put(User.QQ, user.getQq());
        values.put(User.ADDRESS, user.getAddress());
        return db.save(TABLENAME, values);
    }

    public User getUserByID(int id) {
        Cursor cursor = null;
        User temp = new User();
        try {

            cursor=db.find("select * from "+TABLENAME+"where"+"id_DB=?",new String[]{id+""});
            cursor.moveToNext();
            temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
            temp.setName(cursor.getString(cursor.getColumnIndex(User.Name)));
            temp.setMobile(cursor.getString(cursor.getColumnIndex(User.MOBILE)));
            temp.setDanwei(cursor.getString(cursor.getColumnIndex(User.DANWEI)));
            temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
            temp.setAddress(cursor.getString(cursor.getColumnIndex(User.ADDRESS)));
            Log.d("aa",temp.getName());
            return temp;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
            db.closeConnection();
        }
        return  null;
    }
    public boolean updateUser(User user){
        ContentValues values=new ContentValues();
        values.put(User.Name,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.update(TABLENAME,values,"id_DB=?",new String[]{user.getId_DB()+""});
    }
}
