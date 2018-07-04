package hlhj.fhp.baseproject.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

@SuppressLint("StaticFieldLeak")
/**
 * Created by Administrator on 2018\7\2 0002.
 */
object ToastUtil  {
    private lateinit var context:Context
    fun init(context: Context){
        this.context=context
    }
    fun toast(str:String){
        Toast.makeText(context,"fhp",Toast.LENGTH_SHORT).show()
    }

}