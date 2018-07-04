package hlhj.fhp.baseproject.fragments

import hlhj.fhp.baseproject.BaseFragment
import hlhj.fhp.baseproject.R
import hlhj.fhp.baseproject.presenter.MainPresenter

/**
 * Created by Never Fear   on 2018\7\2 0002.
Never More....
 */
class MainFgm :BaseFragment<MainPresenter>() {
    override fun initPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun getContentId(): Int {
        return R.layout.activity_matisse
    }

    override fun pause() {

    }
}