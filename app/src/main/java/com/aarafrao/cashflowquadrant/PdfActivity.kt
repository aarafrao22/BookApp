package com.aarafrao.cashflowquadrant

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aarafrao.cashflowquadrant.databinding.ActivityFirstBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import com.aarafrao.cashflowquadrant.databinding.ActivityPdfBinding
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.util.FitPolicy


class PdfActivity : AppCompatActivity(), OnPageChangeListener,View.OnClickListener {

    private lateinit var binding: ActivityPdfBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var pagesNo = sharedPref.getInt("page", 1)
        var nightMode:Boolean= false

//        if ()
        binding.pdfView.fromAsset("cashflow1.pdf")
            .defaultPage(pagesNo)
            .onPageChange(this)
//            .nightMode()
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

        when(p0?.id){
            R.id.nightMode ->    onNightModeChanged(MODE_NIGHT_YES)
        }


    }

}
