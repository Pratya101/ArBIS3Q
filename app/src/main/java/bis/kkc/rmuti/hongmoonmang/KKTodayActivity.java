package bis.kkc.rmuti.hongmoonmang;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class KKTodayActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private   PlaceAdapter adapter;
    private List<Place> placeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kktoday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setupView();
        initPlace();
    }

    public void setupView() {

        placeList=new ArrayList<>();
        recyclerView=findViewById(R.id.recycle_view);
        adapter=new PlaceAdapter(KKTodayActivity.this,placeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
            }

    public void initPlace() {
        int [] covers = {
                R.drawable.tannamo,R.drawable.image_kk3,R.drawable.image_kk4,R.drawable.image_kk4,R.drawable.image_kk4};
        String [] title= {
                "มาร์ชราชมงคล", "ราชมงคลเกริกไกร", "เสียงเเคนราชมงคลม","ไม่มีวันท้อ","ต้นไม้ของพ่อ"
        };

        for (int j=0;j<1;j++){
            for (int i=0;i<title.length;i++){
                Place place = new Place(i+1,title[i],covers[i],"");
                placeList.add(place);
                Log.v("Test","place"+1);

            }

        }
       }

    }





