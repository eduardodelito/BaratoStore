package com.enaz.baratostore.di

import androidx.lifecycle.ViewModelProvider
import com.enaz.baratostore.feed.FeedFragment
import com.enaz.baratostore.feed.FeedViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
abstract class FeedBindingModule {

    @ContributesAndroidInjector(modules = [InjectFeedViewModelModule::class])
    abstract fun bindFeedFragment(): FeedFragment

    @Module
    class InjectFeedViewModelModule {
        @Provides
        internal fun provideFeedViewModel(
            factory: ViewModelProvider.Factory,
            target: FeedFragment
        ) = ViewModelProvider(target, factory).get(FeedViewModel::class.java)
    }
}
