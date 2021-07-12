package com.kfthomas.orama.presenter;

public interface BackgroundObserver {
    interface Progress {
        void onProgress(int actual, int total);
    }

    interface Finish{
        void onFinish();
    }
}
