package creativeminds.mvp

import android.arch.lifecycle.Lifecycle
import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class LoginPresenter(var context: Context, var view: LoginContract.View, var lifeCycle: Lifecycle) :
        BasePresenter(lifeCycle), LoginContract.Presenter {


    override fun doLogin(email: String, password: String) {

        //after validation and network checks

        mCompositeDisposable.add(mApiService.login(payload = JSONObject())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : NetworkSingleCallBack<JSONObject>(view, 51) {
                    override fun onSuccess(t: JSONObject, request: Int) {
                        view.onLoginSuccess(t)
                    }

                    override fun onFailure(e: Throwable, request: Int) {
                        view.onFailure(e, request)
                    }

                }))

    }

}