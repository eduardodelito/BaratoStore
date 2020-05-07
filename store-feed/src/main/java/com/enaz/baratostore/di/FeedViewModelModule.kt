package com.enaz.baratostore.di

import androidx.lifecycle.ViewModel
import com.enaz.baratostore.common.viewmodel.ViewModelKey
import com.enaz.baratostore.feed.FeedViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
class FeedViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    fun provideFeedViewModel(): ViewModel = FeedViewModel()
}
