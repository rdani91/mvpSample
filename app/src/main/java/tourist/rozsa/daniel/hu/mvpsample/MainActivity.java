package tourist.rozsa.daniel.hu.mvpsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    void onLiveStreamStateChange(int newState) {

    }

    private void loadFragmentToTop(Fragment targetFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer1, targetFragment)
                .commit();

    }

    private void loadFragmentToBottom(Fragment targetFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer2, targetFragment)
                .commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragmentToTop(Fragment1.newInstance());

        loadFragmentToBottom(Fragment2.newInstance());
    }
}
