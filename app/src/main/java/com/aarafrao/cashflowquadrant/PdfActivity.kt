package com.aarafrao.cashflowquadrant

import android.content.SharedPreferences
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.aarafrao.cashflowquadrant.databinding.ActivityPdfBinding
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy


class PdfActivity : AppCompatActivity(), OnPageChangeListener, View.OnClickListener {

    private lateinit var binding: ActivityPdfBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    var nightMode: Boolean = false
    private lateinit var nightBtn: ImageView
    private lateinit var page: ImageView
    private var pg: Int = 0

    //    private val gson: Gson? = null
    private var matchedQuestionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)


        nightBtn = findViewById(R.id.nightMode)
        page = findViewById(R.id.page)


//        setSupportActionBar(binding.toolbar)
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var pagesNo = sharedPref.getInt("page", 1)
        binding.nightMode.setOnClickListener(this)
        binding.page.setOnClickListener(this)

        binding.pdfView.fromAsset("cashflow1.pdf")
            .defaultPage(pagesNo)
            .onPageChange(this)
//            .nightMode()
            .swipeHorizontal(true)
            .pageSnap(true)
            .scrollHandle(DefaultScrollHandle(this,true))
            .autoSpacing(true)
            .enableAnnotationRendering(false)
            .pageFling(true)
            .pageFitPolicy(FitPolicy.BOTH)
            .nightMode(nightMode)
            .load()

    }


    override fun onPageChanged(page: Int, pageCount: Int) {
        editor = sharedPref.edit()
        editor.putInt("page", page)
        editor.apply()

        Toast.makeText(this@PdfActivity, "$page of $pageCount", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.nightMode ->
                if (nightMode) {
                    // Turn off PDF night mode
                    binding.pdfView.setNightMode(false)
                    binding.pdfView.requestLayout()
                    nightMode = false
                    nightBtn.setImageResource(R.drawable.ic_moon)
                    Toast.makeText(this, "Day Mode Activated", Toast.LENGTH_SHORT).show()
                } else {
                    binding.pdfView.setNightMode(true)
                    nightMode = true
                    binding.pdfView.requestLayout()
                    nightBtn.setImageResource(R.drawable.ic_moonfilled)
                    Toast.makeText(this, "Night Mode Activated", Toast.LENGTH_SHORT).show()
                }

            R.id.page ->
                showCustomDialog()
        }


    }

    private fun showCustomDialog() {

        val builderSingle = AlertDialog.Builder(this@PdfActivity)
        builderSingle.setTitle("Chapters")
        val arrayAdapter = ArrayAdapter<String>(this@PdfActivity, R.layout.itemlist, R.id.textView1)
        arrayAdapter.add("Why Don’t You Get a Job?")
        arrayAdapter.add("Different Quadrants, Different People")
        arrayAdapter.add("Security over Freedom")
        arrayAdapter.add("The Three Kinds of Business Systems")
        arrayAdapter.add("The Five Levels of Investors")
        arrayAdapter.add("You Cannot See Money with Your Eyes")
        arrayAdapter.add("Becoming Who You Are")
        arrayAdapter.add("How Do I Get Rich?")
        arrayAdapter.add("Be the Bank, Not the Banker")
        arrayAdapter.add("Take Baby Steps")
        arrayAdapter.add("Steps to Find Your Financial Fast Track")
        arrayAdapter.add("Step 1: Time to Mind Own Business")
        arrayAdapter.add("Step 2: Take Control of Your Cash Flow")
        arrayAdapter.add("Step 3: Diff BW Risk and Risky")
        arrayAdapter.add("Step 4: What Kind of Investor You r?")
        arrayAdapter.add("Step 5: Seek Mentors")
        arrayAdapter.add("Step 6: Disappointments, Your Strength")
        arrayAdapter.add("Step 7: The Power of Faith")
        arrayAdapter.add("In Summary")

        builderSingle.setNegativeButton("cancel") { dialog, which ->
            dialog.dismiss()
        }

        builderSingle.setAdapter(arrayAdapter) { dialog, which ->
            //TODO: Logic to send on chapter

            val strName = arrayAdapter.getItem(which)
            Toast.makeText(this@PdfActivity, "$strName", Toast.LENGTH_SHORT).show()
            shiftChapters(arrayAdapter.getPosition(strName).toString())
        }
        builderSingle.show()
    }

    private fun shiftChapters(chapterName: String) {

    }
}