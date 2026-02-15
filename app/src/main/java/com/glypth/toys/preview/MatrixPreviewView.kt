package com.glypth.toys.preview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.glypth.toys.model.Ball

class MatrixPreviewView(context: Context) : View(context) {

    private val paint = Paint()
    private val gridSize = 25
    init {
        setBackgroundColor(Color.BLACK)
    }

    var balls: List<Ball> = emptyList()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val cellWidth = width / gridSize.toFloat()
        val cellHeight = height / gridSize.toFloat()

        // Draw grid
        paint.style = Paint.Style.STROKE
        paint.color = Color.DKGRAY
        paint.strokeWidth = 1f

        for (i in 0..gridSize) {
            canvas.drawLine(i * cellWidth, 0f, i * cellWidth, height.toFloat(), paint)
            canvas.drawLine(0f, i * cellHeight, width.toFloat(), i * cellHeight, paint)
        }

        // Draw balls
        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE

        for (ball in balls) {
            val cx = ball.x * cellWidth + cellWidth / 2
            val cy = ball.y * cellHeight + cellHeight / 2
            canvas.drawCircle(cx, cy, cellWidth * 0.4f, paint)
        }
    }
}
