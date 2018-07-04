package hlhj.fhp.baseproject.utils

import android.content.Context
import android.util.Log

/**
 * Created by Administrator on 2018\7\2 0002.
 */
object LogUtil {
    private val LOG_MAXLENGTH = 2000
    fun log(str:String){
        e("fhp",str)
    }
    fun log(context: Context, str:String){
        Log.e(context.packageCodePath,str)
    }
    fun logi(str:String){
        Log.i("okgo",str)
    }

    fun e(TAG: String, msg: String) {
        val strLength = msg.length
        var start = 0
        var end = LOG_MAXLENGTH
        for (i in 0..99) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                Log.e(TAG + i, msg.substring(start, end))
                start = end
                end = end + LOG_MAXLENGTH
            } else {
                Log.e(TAG, msg.substring(start, strLength))
                break
            }
        }
    }
}