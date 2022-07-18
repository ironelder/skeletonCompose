package com.ironelder.skeletoncompose.data

import com.ironelder.skeletoncompose.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder().apply {
            url(
                original.url.newBuilder().apply {
                    addHeader("X-Naver-Client-Id", BuildConfig.API_KEY)
                    addHeader("X-Naver-Client-Secret", BuildConfig.CLIENT_KEY)
                }.build()
            )
        }.method(original.method, original.body).build()
        return chain.proceed(request)
    }

}