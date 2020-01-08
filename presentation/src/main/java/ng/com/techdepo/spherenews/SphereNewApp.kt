package ng.com.techdepo.spherenews


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ng.com.techdepo.spherenews.di.DaggerAppComponent

class SphereNewApp:DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

            return DaggerAppComponent.builder().application(this).build()
    }
}