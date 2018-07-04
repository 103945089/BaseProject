package hlhj.fhp.baseproject.iview

import hlhj.fhp.baseproject.presenter.BasePresenter

/**
 * Created by Administrator on 2018\6\15 0015.
 */
interface BaseIView<P:BasePresenter> {
    fun setPresenter(presenter:P)
}