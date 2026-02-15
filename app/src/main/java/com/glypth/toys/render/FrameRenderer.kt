package com.glypth.toys.render

import com.glypth.toys.model.Ball

class FrameRenderer {

    fun buildMatrix(balls: List<Ball>): Array<IntArray> {

        val matrix = Array(25) { IntArray(25) }

        for (ball in balls) {

            val x = ball.x.toInt().coerceIn(0,24)
            val y = ball.y.toInt().coerceIn(0,24)

            matrix[y][x] = 1
        }

        return matrix
    }
}
