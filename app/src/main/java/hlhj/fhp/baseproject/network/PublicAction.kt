package hlhj.fhp.baseproject.network

import rx.Observer

/**
 * Created by Administrator on 2018\7\2 0002.
 */
class PublicAction<T> :Observer<T> {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {

    }
}