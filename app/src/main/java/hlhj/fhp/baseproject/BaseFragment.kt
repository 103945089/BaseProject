package hlhj.fhp.baseproject

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hlhj.fhp.baseproject.presenter.BasePresenter

/**
 * Created by Never Fear   on 2018\7\2 0002.
Never More....
 */
abstract class BaseFragment<P:BasePresenter> :Fragment() {
    lateinit var rootView:View
    lateinit var presenter:BasePresenter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView=inflater?.inflate(getContentId(),null)!!
        presenter=initPresenter()
        initView()
        initListener()
        return rootView


    }

    abstract fun initPresenter() :P

    abstract  fun initView()


    abstract  fun initListener()


    abstract fun getContentId(): Int


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser&&isResumed){
            onResume()
        }else if (!isVisibleToUser){
            onPause()
        }
    }

    override fun onResume() {
        super.onResume()
        if (userVisibleHint){
            resume()
        }
    }

    override fun onPause() {
        super.onPause()
        if (!userVisibleHint){
            pause()
        }
    }
     open fun pause() {

    }

   open fun resume(){

    }
}