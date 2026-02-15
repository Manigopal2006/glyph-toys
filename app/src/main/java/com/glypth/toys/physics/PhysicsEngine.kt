package com.glypth.toys.physics

import com.glypth.toys.model.Ball

class PhysicsEngine {

    private val bounds = 24f   // 25x25 grid (0–24)
    var gravityX = 0f
    var gravityY = 0.5f

    fun update(balls: MutableList<Ball>) {

        for (ball in balls) {

            ball.vx += gravityX
            ball.vy += gravityY

            ball.x += ball.vx
            ball.y += ball.vy

            // Bounce on walls
            if (ball.x < 0) {
                ball.x = 0f
                ball.vx *= -1
            }

            if (ball.x > bounds) {
                ball.x = bounds
                ball.vx *= -1
            }

            if (ball.y < 0) {
                ball.y = 0f
                ball.vy *= -1
            }

            if (ball.y > bounds) {
                ball.y = bounds
                ball.vy *= -0.9f   // slight energy loss
            }
        }
    }
}
