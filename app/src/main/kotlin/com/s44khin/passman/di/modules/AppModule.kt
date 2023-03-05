package com.s44khin.passman.di.modules

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.room.Room
import com.s44khin.passman.common.data.dataBase.CodesDataBase
import com.s44khin.passman.core.AppRouter
import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.core.AppViewModelFactory
import com.s44khin.passman.di.AppScope
import com.s44khin.passman.navigation.ScreenRouter
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class AppModule {

    companion object {
        private const val SETTINGS = "settings"
    }

    @AppScope
    @Provides
    fun provideAppVieModelFactory(
        creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): AppViewModelFactory {
        return AppViewModelFactory(creators)
    }

    @AppScope
    @Provides
    fun provideAppStorage(context: Context) = AppStorage(
        sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)
    )

    @AppScope
    @Provides
    fun provideCodesDataBase(context: Context): CodesDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = CodesDataBase::class.java,
            name = "codesDataBase"
        ).build()
    }
}
