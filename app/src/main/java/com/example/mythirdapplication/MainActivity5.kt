package com.example.mythirdapplication

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity5 : AppCompatActivity() {
    lateinit var imageUrl: URL
    var `is`: InputStream? = null
    var bmImg: Bitmap? = null
    lateinit var imageView: ImageView
    lateinit var progressDialog: ProgressDialog
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        imageView = findViewById(R.id.imageView)
        val downloadBtn = findViewById<Button>(R.id.downloadBtn)
        downloadBtn.setOnClickListener {
            val asyncTask: AsyncTaskExample = AsyncTaskExample()
//            sending async task request to the server to get the response
            asyncTask.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg")
        }


    }
    private inner class AsyncTaskExample: AsyncTask<String?,String?,Bitmap?>() {
        override fun doInBackground(vararg params: String?): Bitmap? {
            try {
                imageUrl = URL(params[0])
                val conn: HttpURLConnection = imageUrl.openConnection() as HttpURLConnection
                conn.setDoInput(true)
                conn.connect()
                `is` = conn.getInputStream()
                val options = BitmapFactory.Options()
                options.inPreferredConfig = Bitmap.Config.RGB_565
                bmImg = BitmapFactory.decodeStream(`is`, null, options)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return bmImg
        }

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(this@MainActivity5)
            progressDialog.setMessage("Please wait... It is downloading")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            if(imageView != null) {
                progressDialog.hide()
                imageView.setImageBitmap(result)
            }
            else {
                progressDialog.show()
            }
        }
    }
}