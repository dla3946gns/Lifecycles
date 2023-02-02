package com.example.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyLifeCycleObserver())
    }
}

class MyLifeCycleObserver: DefaultLifecycleObserver, LifecycleEventObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(owner.toString(), "onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(owner.toString(), "onResume")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(owner.toString(), "onStart")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(owner.toString(), "onDestroy")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(owner.toString(), "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(owner.toString(), "onStop")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(source.toString(), "onCreateEvent")
            }
            Lifecycle.Event.ON_START -> {
                Log.d(source.toString(), "onStartEvent")
            }
            else -> {}
        }
    }

}