package bis.kkc.rmuti.hongmoonmang;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import eu.kudan.kudan.ARActivity;
import eu.kudan.kudan.ARAPIKey;
import eu.kudan.kudan.ARAlphaVideoNode;
import eu.kudan.kudan.ARImageNode;
import eu.kudan.kudan.ARImageTrackable;
import eu.kudan.kudan.ARImageTrackableListener;
import eu.kudan.kudan.ARImageTracker;
import eu.kudan.kudan.ARMeshNode;
import eu.kudan.kudan.ARModelImporter;
import eu.kudan.kudan.ARModelNode;
import eu.kudan.kudan.ARTexture2D;
import eu.kudan.kudan.ARTextureMaterial;
import eu.kudan.kudan.ARVideoNode;
import eu.kudan.kudan.ARVideoTexture;

public class MyARActivity extends ARActivity implements ARImageTrackableListener {
   
    public static final String api_key = "d0y32WhZwpYWgzcWZwTtCgE10pexGr9K7gCIofQvkVW+frj1/7Wlsi6IN7/9S069jhLUWXIF+hZ/fuaIX8ooUUJp8Fm1qreBUbGqOJLDTP2ETzDeQKo1T47aJKXYu+4XvqdiOxZJG9m/4b1brxAFiPQJRGNs9J2dzib67WYRg9pYfmp+eC4A3fhNpxruBw9EBFdUqwBjuoCezeCaqJQK4F+khTKtBqj8PaXtdJ5Vr7E12yRjD+HaF2kHRSTUkj5sYGOyBd6ugoSYpbRrVzidQNto5IQ/CsUQgvanRvIwHAO/p4BKYkZLoPZYBvewReXZjNJQaLGbG9ijU5Uv2z6G/DnOHFGMDg4DPaIPQyaiC8ohJSeIT+NsN9m+JIZ5AK6sb1DFHJdQ3ju20n7pC4z9RBaObta13kJpbzl/h1MsjIxgT3IG7qozBQ4b/KWCOHYy2hbxh/FeDi2B1cIETwr0pzaH90sELIxOLBm8laS5ewAJO8Od0QZg7q8maZrgLBnW+VL0q3BfcgwBDdRlJzlfkfw796sO8tfyIGg3QBO2/3WcIER0EPoUrSeHi7K2cAxzfSbueVmR67gIVyiFPaeb32KTkweqPuNPWIZc4WEFKflZfANRq8tTWaRGX+d6MwhTID8M6jOSHyZ8YFG5eelDPhqu8rcIHfWyOUNWy0bg/LU=\n";
    ARImageTracker arImageTracker;
    public LinearLayout title_box;
    public LinearLayout tool_box;
    public TextView title_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcamera_view);
        ARAPIKey key = ARAPIKey.getInstance();
        key.setAPIKey(api_key);
        title_box = findViewById(R.id.title_box);
        tool_box = findViewById(R.id.toolbox);
        title_text = findViewById(R.id.title_text);
        hideUI();

    }
    public  void showUI(){
        tool_box.setVisibility(View.VISIBLE);
        title_box.setVisibility(View.VISIBLE);

    }
    public  void hideUI(){
        tool_box.setVisibility(View.INVISIBLE);
        title_box.setVisibility(View.INVISIBLE);

    }
    @Override
    public void setup() {
        super.setup();
        arImageTracker = ARImageTracker.getInstance();
        arImageTracker.initialise();
        //trackimage();
        trackVideo();
       // trackAlphaVideo();
        //track3DModel();
        }
    public  void  trackVideo(){
        int N = 31;
        String[] track_img = {"001-7.PNG","002-7.PNG","003-7.PNG","004-7.PNG","010-5.PNG","011-5.PNG","013-5.PNG","015-5.PNG","016-5.PNG","019-5.PNG","021-3.PNG","023-3.PNG","025-3.PNG","026-3.PNG","028-3.PNG","031-1.PNG","038-1.PNG","043-9.PNG","044-9.PNG","045-9.PNG","049-9.PNG","051-6.PNG","053-6.PNG","056-6.PNG","057-6.PNG","060-4.PNG","061-4.PNG","062-4.PNG","067-4.PNG","068-4.PNG","078-2.PNG"};
        String[] track_name = {"marker1","marker2","marker3","marker4","marker5","marker6","marker7","marker8","marker9","marker10","marker11","marker12","marker13","marker14","marker15","marker16","marker17","marker18","marker19","marker20","marker21","marker22","marker23","marker24","marker25","marker26","marker27","marker28","marker29","marker30","marker31"};
        String[] node_img = {"re001-7.mp4","re002-7.mp4","re003-7.mp4","re004-7.mp4","re010-5.mp4","re011-5.mp4","re013-5.mp4","re015-5.mp4","re016-5.mp4","re019-5.mp4","re021-3.mp4","re023-3.mp4","re025-3.mp4","re026-3.mp4","re028-3.mp4","re031-1.mp4","re038-1.mp4","re043-9.mp4","re044-9.mp4","re045-9.mp4","re049-9.mp4","re051-6.mp4","re053-6.mp4","re056-6.mp4","re057-6.mp4","re060-4.mp4","re061-4.mp4","re062-4.mp4","re067-4.mp4","re068-4.mp4","re078-2.mp4"};
        for (int i = 0; i < N; i++) {

            ARImageTrackable trackable = new ARImageTrackable(track_name[i]);
            trackable.loadFromAsset(track_img[i]);

            arImageTracker.addTrackable(trackable);
            ARVideoTexture videoTexture = new ARVideoTexture();
            videoTexture.loadFromAsset(node_img[i]);
            ARVideoNode videoNode = new ARVideoNode(videoTexture);

            trackable.getWorld().addChild(videoNode);
        }
    }
    public  void  trackimage(){

        /*    ARImageTrackable trackable= new ARImageTrackable("Maker1");
        trackable.loadFromAsset("image_kk1.jpg");
ARImageTracker tracableManager = ARImageTracker.getInstance();
tracableManager.initialise();
tracableManager.addTrackable(trackable);

        ARImageNode imageNode = new ARImageNode("dino_orange.png");
        trackable.getWorld().addChild(imageNode);*/
        ARImageTracker tracker = ARImageTracker.getInstance();
        tracker.initialise();
        int N = 2;
        String[] track_img = {"image_kk1.jpg", "image_kk2.jpg"};
        String[] track_name = {"marker1", "marker2"};
        String[] node_img = {"dino_green.png", "dino_orange.png"};

        for (int i = 0; i < N; i++) {

            ARImageTrackable trackable = new ARImageTrackable(track_name[i]);
            trackable.loadFromAsset(track_img[i]);

            trackable.addListener(this);

            arImageTracker.addTrackable(trackable);

            ARImageNode imageNode = new ARImageNode(node_img[i]);
            trackable.getWorld().addChild(imageNode);
        }
    }
    public  void  trackAlphaVideo(){

        ARImageTrackable trackable = new ARImageTrackable("marker3");
        trackable.loadFromAsset("image_kk3.jpg");

        arImageTracker.addTrackable(trackable);
        ARVideoTexture videoTexture = new ARVideoTexture();
        videoTexture.loadFromAsset("kaboom.mp4");
        ARAlphaVideoNode videoNode= new ARAlphaVideoNode(videoTexture);

        trackable.getWorld().addChild(videoNode);
    }
    public  void  track3DModel(){
        ARImageTrackable trackable = new ARImageTrackable("marker3");
        trackable.loadFromAsset("image_kk3.jpg");
                arImageTracker.addTrackable(trackable);
trackable.addListener(this);

                ARModelImporter modelImporter = new ARModelImporter();
        modelImporter.loadFromAsset("model/andy.armodel");
        ARModelNode modelNode = modelImporter.getNode();


        ARTexture2D texture2D = new ARTexture2D();
        texture2D.loadFromAsset("model/andy.png");
            ARTextureMaterial textureMaterial = new ARTextureMaterial(texture2D);
        for(ARMeshNode meshNode : modelImporter.getMeshNodes() ){
            meshNode.setMaterial(textureMaterial);
        }
        modelNode.scaleByUniform(700.0f);
        modelNode.rotateByDegrees(90,1,0,0);
        trackable.getWorld().addChild(modelNode);
        modelNode.setVisible(true);
    }

    @Override
    public void didDetect(ARImageTrackable arImageTrackable) {
        showUI();
    }

    @Override
    public void didTrack(ARImageTrackable arImageTrackable) {

    }

    @Override
    public void didLose(ARImageTrackable arImageTrackable) {

        hideUI();
    }
}
