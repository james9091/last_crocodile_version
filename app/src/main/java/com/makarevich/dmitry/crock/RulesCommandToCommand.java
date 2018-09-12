package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RulesCommandToCommand extends AppCompatActivity {

    private Button btn_skip_rules_comandcomand;
    private ImageView ic_rules_comandcomand;
    private TextView txt_rules_comandcomand,txt_comand_vs_comand,txt_rules_comandcomand_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules__command_to_command);
        btn_skip_rules_comandcomand=findViewById(R.id.btn_skip_rules_comandcomand);
        ic_rules_comandcomand=findViewById(R.id.ic_rules_comandcomand);
        txt_rules_comandcomand=findViewById(R.id.txt_rules_comandcomand);
        txt_comand_vs_comand=findViewById(R.id.txt_comand_vs_comand);
        txt_rules_comandcomand_main=findViewById(R.id.txt_rules_comandcomand_main);
        btn_skip_rules_comandcomand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dictionary = new Intent(RulesCommandToCommand.this , DictionaryAll.class);
                startActivity(dictionary);
            }
        });
        PushImage();
        Font();
    }
    @Override
    public void onBackPressed() {
        Intent back = new Intent(RulesCommandToCommand.this , Play_Mode.class);
        startActivity(back);
    }
    public void PushImage() {
        int first = R.drawable.rules;
        Glide
                .with(this)
                .load(first)
                .into(ic_rules_comandcomand);
    }
    public void Font() {
        txt_rules_comandcomand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_comand_vs_comand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_rules_comandcomand_main.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_skip_rules_comandcomand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
