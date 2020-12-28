package yg.android.qod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import yg.android.api.GetQODUseCase
import yg.android.model.QOD

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val remote = GetQODUseCase()
        remote.execute({
            Log.e("Yogesh","QOD : $it")
            processResponse(it)
        },{
            Log.e("Yogesh","error : $it")

        })

    }

    private fun processResponse(qod: QOD) {
        text_view.text = qod.contents.quotes[0].quote
    }
}