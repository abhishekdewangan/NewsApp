package news_category.view

import constants.DependencyInjectionConstants.Companion.SCOPE_ACTIVITY
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

class NewsCategoryViewModule {
    companion object {
        val viewModule = Kodein.Module("NewsCategoryViewModule") {
            bind<NewsCategoryVMMapper>() with provider { NewsCategoryVMMapper() }
            bind<NewsCategoriesVMMapper>() with provider { NewsCategoriesVMMapper(instance()) }
            bind<NewsCategoryContract.Presenter>() with provider { NewsCategoryPresenter(instance(SCOPE_ACTIVITY), instance(), instance()) }
        }
    }
}