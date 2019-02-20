package creativeminds.mvp

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter(var lifecycleData: Lifecycle) : LifecycleObserver {

    protected var mCompositeDisposable = CompositeDisposable()


    init {
        //initializing life cycle observer
        lifecycleData.addObserver(this@BasePresenter)
    }


    fun getLifecycle(): Lifecycle {
        return lifecycleData
    }

    protected val mApiService: AdminwalaAPI by lazy {
        ApiService.create()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        //clearing all ongoing requests
        mCompositeDisposable.dispose()

        //unregister life cycle observer
        lifecycleData.removeObserver(this)

    }
}