package com.akudreams.marvel.injection

import com.akudreams.marvel.Helper
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    val BASE_URL = "https://gateway.marvel.com"
    val PUBLIC_KEY_PARAMETER = "apikey"
    val TIMESTAMP_PARAMETER = "ts"
    val HASH_PARAMETER = "hash"
    val PUBLIC_KEY = "2e00c0b9f4bcf313096b4e6c16b71b8b"
    val PRIVATE_KEY = "bc2a4797e83226e0fb1140317f322c0c202070d7"

    @Provides
    @Singleton
    fun provideOkhttpClient(interceptor: Interceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY;
        val client = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(loggingInterceptor)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->

            val timestamp = System.currentTimeMillis()/1000
            val hash = Helper.md5(timestamp.toString() + PRIVATE_KEY + PUBLIC_KEY)
            val newUrl = chain
                    .request()
                    .url()
                    .newBuilder()
                    .addQueryParameter(PUBLIC_KEY_PARAMETER, PUBLIC_KEY)
                    .addQueryParameter(HASH_PARAMETER, hash)
                    .addQueryParameter(TIMESTAMP_PARAMETER, timestamp.toString())
                    .build()

            val newRequest = chain.request()
                    .newBuilder()
                    .url(newUrl)
                    .build()

            chain.proceed(newRequest)
        }
    }

}