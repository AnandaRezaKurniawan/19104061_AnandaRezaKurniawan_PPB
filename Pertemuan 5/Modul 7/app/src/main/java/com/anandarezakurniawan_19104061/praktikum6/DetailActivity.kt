package com.anandarezakurniawan_19104061.praktikum6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.anandarezakurniawan_19104061.praktikum6.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.content_scrolling.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var extraData : MyData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myData by getParcelableExtra<MyData>(DetailActivity.EXTRA_MYDATA)

        //extraData = intent.getParcelableExtra<MyData>(EXTRA_MYDATA)!!

        supportActionBar?.title = myData?.name.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_detail_description.text = myData?.description.toString()
        binding.ivDetailPhoto.load(myData?.photo)


        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Go to ${myData?.name}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val moveWithObjectIntent = Intent(this, MapsActivity::class.java)
            moveWithObjectIntent.putExtra(MapsActivity.EXTRA_MYDATA, myData)
            startActivity(moveWithObjectIntent)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }

    inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }
}