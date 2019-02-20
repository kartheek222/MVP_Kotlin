package creativeminds.mvp

import io.reactivex.observers.DisposableSingleObserver


abstract class NetworkSingleCallBack<T>(var baseView: BaseView, var request: Int) :
        DisposableSingleObserver<T>() {


    init {
        baseView.showProgress()
    }

    override fun onSuccess(t: T) {
        baseView.dismissProgress()
        onSuccess(t, request)
    }

    //network api success
    abstract fun onSuccess(t: T, request: Int)

    //api failure
    abstract fun onFailure(e: Throwable, request: Int)


    //handling error response
    override fun onError(e: Throwable) {
        baseView.dismissProgress()
        onFailure(e, request)
    }
}