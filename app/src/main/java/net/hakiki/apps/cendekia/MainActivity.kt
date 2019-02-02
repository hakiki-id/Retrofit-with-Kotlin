package net.hakiki.apps.cendekia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import net.hakiki.apps.cendekia.Services.NetworkAPI

class MainActivity : AppCompatActivity() {
    val TAG = "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoad.setOnClickListener {
            checkMail(edtMail.text.toString())
        }


    }

    fun checkMail(mail: String) {
        NetworkAPI.retrofit.checkAvailableMail(mail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({it ->
                Log.d(TAG, "success to check ed the respnose")
                Log.d(TAG, "response is \n ${it.message}")
            },
                {
                    Log.e(TAG, "error response \n ${it.localizedMessage}")
                })
    }
}
