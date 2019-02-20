package creativeminds.mvp

import io.reactivex.Single
import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Ramesh on 11/11/2017.
 */
interface AdminwalaAPI {

    companion object {
        private const val LOGIN: String = "/login"
    }

    @POST(LOGIN)
    fun login(@Body payload: JSONObject): Single<JSONObject>


}