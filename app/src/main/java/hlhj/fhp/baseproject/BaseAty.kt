package hlhj.fhp.baseproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vondear.rxtool.view.RxToast
import hlhj.fhp.baseproject.iview.BaseIView
import hlhj.fhp.baseproject.presenter.BasePresenter

/**
 * Created by Administrator on 2018\6\15 0015.
 */
abstract class BaseAty<P :BasePresenter> :AppCompatActivity() {
    open lateinit var presenter:P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentId())
        presenter=initPresenter()
        initView()
        initListener()
    }
    abstract fun initPresenter():P


    abstract fun initView()

    abstract fun initListener()


    abstract fun getContentId():Int
}