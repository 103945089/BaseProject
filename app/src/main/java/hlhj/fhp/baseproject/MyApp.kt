package hlhj.fhp.baseproject

import android.app.Application
import com.lzy.okgo.OkGo
import com.vondear.rxtool.RxTool

/**
 * Created by Administrator on 2018\7\2 0002.
 */
class MyApp :Application() {
    override fun onCreate() {
        super.onCreate()
        OkGo.getInstance().init(this)
        RxTool.init(this)
    }
}