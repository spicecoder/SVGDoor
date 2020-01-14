package io.pronab.svgd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.graphics.Canvas


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import com.caverock.androidsvg.SVG


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Read an SVG from the assets folder
        val svg = SVG.getFromResource(resources, R.raw.pplane)

        if (svg.getDocumentWidth() !== -1F) {

            // set your custom height and width for the svg
            svg.documentHeight = 600F
            svg.documentWidth = 600F

            // create a canvas to draw onto
            val bitmap = Bitmap.createBitmap(700,700, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)

            // canvas - white background
            canvas.drawARGB(0,255, 255, 255)

            // Render our document onto our canvas
            svg.renderToCanvas(canvas)

            // set the bitmap to imageView
            imageV.background = BitmapDrawable(resources, bitmap)
        }
    }
}
