package creativeminds.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.json.JSONObject

class MainActivity : AppCompatActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = LoginPresenter(this, this, lifecycle)
        presenter.doLogin(email = "some email", password = "user password")

    }

    override fun onLoginSuccess(login: JSONObject) {

        //handing user login success
    }

    override fun showProgress() {

        //show progress dialog to user
    }

    override fun dismissProgress() {

        //dismiss progress dialog
    }

    override fun showInternetError() {

        //show internet connection not available message to user
    }

    override fun onFailure(t: Throwable, request: Int) {
    //handing failure scenario
    }

}
