package com.aarafrao.cashflowquadrant

import android.content.SharedPreferences
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.aarafrao.cashflowquadrant.databinding.ActivityPdfBinding
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.util.FitPolicy


class PdfActivity : AppCompatActivity(), OnPageChangeListener, View.OnClickListener {

    private lateinit var binding: ActivityPdfBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    var nightMode: Boolean = false
    private lateinit var nightBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nightBtn = findViewById(R.id.nightMode)


//        setSupportActionBar(binding.toolbar)
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var pagesNo = sharedPref.getInt("page", 1)

        binding.nightMode.setOnClickListener(this)

        binding.pdfView.fromAsset("cashflow1.pdf")
            .defaultPage(pagesNo)
            .onPageChange(this)
//            .nightMode()
            .swipeHorizontal(true)
            .pageSnap(true)
            .autoSpacing(true)
            .pageFling(true)
            .pageFitPolicy(FitPolicy.BOTH)
            .nightMode(nightMode)
            .load()

    }


    override fun onPageChanged(page: Int, pageCount: Int) {
        editor = sharedPref.edit()
        editor.putInt("page", page)
        editor.apply()
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.nightMode ->
                // Check PDF night mode is on or off
                if (nightMode) {
                    // Turn off PDF night mode
                    binding.pdfView.setNightMode(false)
                    binding.pdfView.requestLayout()
                    nightMode = false
                } else {
                    // Turn on PDF Night Mode
                    binding.pdfView.setNightMode(true)
                    nightMode = true
                    binding.pdfView.requestLayout()
                }
        }


    }

}
