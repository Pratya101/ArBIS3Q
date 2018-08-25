package bis.kkc.rmuti.hongmoonmang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
    public  void ShowMach(View V){

        Intent intent=new Intent(ActivityIntro.this,Test.class);
        startActivity(intent);
    }

    public  void ShowKrakKai(View V){

        Intent intent=new Intent(ActivityIntro.this,KrakKai.class);
        startActivity(intent);
    }

    public  void ShowKan(View V){

        Intent intent=new Intent(ActivityIntro.this,Kan.class);
        startActivity(intent);
    }

    public  void ShowTor(View V){

        Intent intent=new Intent(ActivityIntro.this,Tor.class);
        startActivity(intent);
    }

    public  void ShowFather(View V){

        Intent intent=new Intent(ActivityIntro.this,Father.class);
        startActivity(intent);
    }
}
