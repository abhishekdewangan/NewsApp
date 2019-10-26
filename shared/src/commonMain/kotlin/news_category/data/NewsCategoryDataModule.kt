package news_category.data

import constants.DependencyInjectionConstants.Companion.SCOPE_APPLICATION
import news_category.domain.NewsCategoryRepo
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

class NewsCategoryDataModule {
    companion object {
        val dataModule = Kodein.Module("NewsCategoryDataModule") {
            bind<NewsCategoryRepo>() with singleton { NewsCategoryRepoImpl(instance(), instance(SCOPE_APPLICATION)) }
        }
    }
}