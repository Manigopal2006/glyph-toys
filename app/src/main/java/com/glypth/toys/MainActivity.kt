package com.glypth.toys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import com.glypth.toys.model.Ball
import com.glypth.toys.physics.PhysicsEngine
import com.glypth.toys.preview.MatrixPreviewView
import com.glypth.toys.render.FrameRenderer

class MainActivity : AppCompatActivity() {

    private lateinit var preview: MatrixPreviewView

    private val balls = mutableListOf<Ball>()
    private val physics = PhysicsEngine()
    private val renderer = FrameRenderer()


    private val handler = Handler(Looper.getMainLooper())

    private val loop = object : Runnable {
        override fun run() {
            physics.update(balls)
            renderer.buildMatrix(balls)
            preview.balls = balls
            preview.invalidate()

            handler.postDelayed(this, 40)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preview = MatrixPreviewView(this)
        setContentView(preview)

        balls.add(Ball(12f, 0f, 0f, 0f))

        handler.post(loop)

        preview.setOnClickListener {
            balls.add(Ball(12f, 0f, (-1..1).random().toFloat(), 0f))
        }
    }
}
