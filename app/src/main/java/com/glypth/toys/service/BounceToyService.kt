package com.glypth.toys.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.glypth.toys.model.Ball
import com.glypth.toys.physics.PhysicsEngine

class BounceToyService : Service() {

    private val balls = mutableListOf<Ball>()
    private val physics = PhysicsEngine()

    private val handler = Handler(Looper.getMainLooper())
    private val frameDelay = 40L

    private val loop = object : Runnable {
        override fun run() {
            physics.update(balls)
            handler.postDelayed(this, frameDelay)
        }
    }

    override fun onCreate() {
        super.onCreate()

        // spawn initial ball
        balls.add(Ball(12f, 0f, 0f, 0f))

        handler.post(loop)
    }

    override fun onBind(intent: Intent?) = null
}
