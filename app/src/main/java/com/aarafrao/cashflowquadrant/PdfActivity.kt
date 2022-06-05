package com.aarafrao.cashflowquadrant

import android.os.Bundle
import android.view.View
import com.aarafrao.cashflowquadrant.databinding.ActivityFirstBinding
import androidx.appcompat.app.AppCompatActivity
import com.aarafrao.cashflowquadrant.databinding.ActivityPdfBinding
import com.github.barteksc.pdfviewer.PDFView


class PdfActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdfBinding
    private var pagesNo: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pdfView.fromAsset("cashflow1.pdf").pages(pagesNo).load()





    }

    override fun onStop() {
        super.onStop()
        pagesNo = binding.pdfView.currentPage
    }

    override fun onPause() {
        super.onPause()
        pagesNo = binding.pdfView.currentPage
    }

}
