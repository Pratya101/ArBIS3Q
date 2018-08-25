package bis.kkc.rmuti.hongmoonmang;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by I Am Coffee on 3/20/2018.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/NamMool.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
    }
}
