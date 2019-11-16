package com.chanhee.makertone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ResistActivity extends AppCompatActivity {
    ArrayList<String> name;
    ArrayList<String> year;
    ArrayList<String> locate;
    String namestr,yearstr,locatestr;
    EditText editname,edityear,editlocate;
    Button signbutton;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resist);
        name=new ArrayList<String>();
        year=new ArrayList<String>();
        locate=new ArrayList<String>();
        name=getStringArrayPref(getApplicationContext(),"name");
        year=getStringArrayPref(getApplicationContext(),"year");
        locate=getStringArrayPref(getApplicationContext(),"loacte");
        editname=findViewById(R.id.res_nametxt);
        edityear=findViewById(R.id.res_yeartxt);
        editlocate=findViewById(R.id.res_locate);
        signbutton=findViewById(R.id.signin);
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               namestr=editname.getText().toString();
               yearstr=edityear.getText().toString();
               locatestr=editlocate.getText().toString();
               name.add(namestr);
               year.add(yearstr);
               locate.add(locatestr);
               setStringArrayPref(getApplicationContext(),"name",name);
               setStringArrayPref(getApplicationContext(),"year",year);
               setStringArrayPref(getApplicationContext(),"locate",locate);
                Toast.makeText(ResistActivity.this, "저장 되었습니다", Toast.LENGTH_SHORT).show();
                intent=new Intent(ResistActivity.this,MainActivity.class);
                intent.putExtra("name",namestr);
                intent.putExtra("year",yearstr);
                intent.putExtra("locate",locatestr);
                startActivity(intent);
            }
        });

    }
    private void setStringArrayPref(Context context, String key, ArrayList<String> values){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor= prefs.edit();
        JSONArray a= new JSONArray();
        for(int i=0;i<values.size();i++){
            a.put(values.get(i));

        }
        if(!values.isEmpty()){
            editor.putString(key,a.toString());

        }
        else{
            editor.putString(key,null);

        }

    }


    private ArrayList<String> getStringArrayPref(Context applicationContext, String key) {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String json=preferences.getString(key,null);
        ArrayList<String> urls=new ArrayList<>();
        if(json !=null){
            try{
                JSONArray a= new JSONArray(json);
                for(int i=0;i<a.length();i++){
                    String url= a.optString(i);
                    urls.add(url);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }



}
