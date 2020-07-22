package us.erlang.android_fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
    }

    public void showAndroidFragment(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment fragment = new AndroidFragment();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        switchButtonBackgroundColor(true);
    }

    public void showJavaFragment(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        JavaFragment fragment = new JavaFragment();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        switchButtonBackgroundColor(false);
    }

    private void switchButtonBackgroundColor(boolean isAndroid) {
        Button btnAndroid = (Button) findViewById(R.id.android);
        Button btnJava = (Button) findViewById(R.id.java);
        int selectedColor = btnAndroid.getContext().getResources().getColor(R.color.selected);
        int unselectedColor = btnAndroid.getContext().getResources().getColor(R.color.unselected);

        if(isAndroid) {
            btnAndroid.setBackgroundColor(selectedColor);
            btnJava.setBackgroundColor(unselectedColor);
        } else {
            btnAndroid.setBackgroundColor(unselectedColor);
            btnJava.setBackgroundColor(selectedColor);
        }
    }
}