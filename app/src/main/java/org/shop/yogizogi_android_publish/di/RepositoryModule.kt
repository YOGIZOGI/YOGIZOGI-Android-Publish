package org.shop.yogizogi_android_publish.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.shop.yogizogi_android.repository.AuthRepositoryImpl
import org.shop.yogizogi_android_publish.repository.AuthRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}