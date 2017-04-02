package com.gl.rxjava2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private TextView mTvShow;
    private Disposable mDisposableConsumer,mDisposableObserver;
    Observable<String> mObservable;
    Subject <String> stringSubject;
    Observer<String>mStringObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvShow = (TextView) findViewById(R.id.tvShow);

        mStringObserver=new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                mDisposableObserver=d;
            }

            @Override
            public void onNext(String s) {
                mTvShow.append(s);

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        stringSubject= PublishSubject.create();
        stringSubject.subscribe(mStringObserver);
        stringSubject.onNext("Hey");
        stringSubject.onNext("Whats Up");
        stringSubject.onComplete();



        mObservable = Observable.create(emitter -> {
            try {
                emitter.onNext("How");
                emitter.onNext("Are");
                emitter.onNext("You??");
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        Consumer<String> stringConsumer = s ->
                mTvShow.append(s);
        mDisposableConsumer = mObservable.subscribe(stringConsumer);
    }




    @Override
    protected void onDestroy() {
        if (!mDisposableConsumer.isDisposed()&&!mDisposableObserver.isDisposed()) {
            mDisposableObserver.dispose();
            mDisposableConsumer.dispose();
        }
        super.onDestroy();
    }
}

