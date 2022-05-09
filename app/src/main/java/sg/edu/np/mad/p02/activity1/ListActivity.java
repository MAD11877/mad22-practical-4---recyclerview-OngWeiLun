package sg.edu.np.mad.p02.activity1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sg.edu.np.mad.p02.activity1.MainActivity.User;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<User> userList = new ArrayList<>();


        for( int i = 0; i < 20; i++){
            Random rand = new Random();
            int followRand = rand.nextInt(2);
            boolean followed;
            if(followRand == 1){
                followed = true;
            }
            else{
                followed = false;
            }
            int userId = rand.nextInt(1000000000);
            String desc = Integer.toString(rand.nextInt(1000000000));
            User newUser = new User("Name","Description - " + desc, userId, followed);
            userList.add(newUser);
        }

        AlertDialog.Builder profile = new AlertDialog.Builder(this);
        profile.setTitle("Profile");
        profile.setMessage("MADness");
        profile.setCancelable(true);
        profile.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent MainActivity = new Intent(ListActivity.this,
                        MainActivity.class);
                Random rand = new Random();
                int random = rand.nextInt(1000000);
                String num = Integer.toString(random);
                MainActivity.putExtra("number",num);
                startActivity(MainActivity);
            }
        });
        profile.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        findViewById(R.id.listImage).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                        AlertDialog alert = profile.create();
                        alert.show();
            }
        }
        );
    }



}