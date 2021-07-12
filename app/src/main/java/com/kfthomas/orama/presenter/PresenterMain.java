package com.kfthomas.orama.presenter;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.kfthomas.orama.ActivityMain;
import com.kfthomas.orama.view.FragmentSplash;

public final class PresenterMain {

    public void onActivitySaveInstance(@NonNull ActivityMain activity,
                                       @NonNull Bundle outState){
    }

    public void onActivityCreate(@NonNull ActivityMain activity, Bundle savedInstanceState){
        if(savedInstanceState != null)
            return;

        activity.changeFragment(new FragmentSplash());
    }

    public void onActivityResume(@NonNull ActivityMain activity){}

    public void onActivityPause(@NonNull ActivityMain activity){}

    public void onActivityDestroy(@NonNull ActivityMain activity) {
    }

    public PresenterMain() {
    }
}
