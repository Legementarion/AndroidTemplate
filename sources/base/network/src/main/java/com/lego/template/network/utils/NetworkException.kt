package com.lego.template.network.utils

import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException

class NetworkException private constructor(
        message: String?,
        /**
         * The request URL which produced the error.
         */
        val url: String? = null,
        /**
         * Response object containing status code, headers, body, etc.
         */
        val response: Response<*>? = null,
        /**
         * The event kind which triggered this error.
         */
        val kind: Kind,
        exception: Throwable?
) : RuntimeException(message, exception) {
    private val gson: Gson = Gson()

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.
     *
     * @throws IOException if unable to convert the body to the specified `type`.
     */
//    val errorBody: ServerErrorModel?
//        @Throws(IOException::class)
//        get() = gson.fromJson(response?.errorBody()!!.string(), ServerErrorModel::class.java)

    /**
     * Identifies the event kind which triggered a [RetrofitException].
     */
    enum class Kind {
        /**
         * An [IOException] occurred while communicating to the server.
         */
        NETWORK,
        /**
         * A non-200 HTTP status code was received from the server.
         */
        HTTP,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }

    companion object {

        fun httpError(url: String, response: Response<*>): NetworkException {
            val message = "${response.code()} ${response.message()}"
            return NetworkException(message, url, response, Kind.HTTP, null)
        }

        fun networkError(exception: IOException): NetworkException {
            return NetworkException(message = exception.message, kind = Kind.NETWORK, exception = exception)
        }

        fun unexpectedError(exception: Throwable): NetworkException {
            return NetworkException(message = exception.message, kind = Kind.UNEXPECTED, exception = exception)
        }
    }
}