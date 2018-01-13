 [ ![Download](https://api.bintray.com/packages/alexfacciorusso/DaggerViewModel/daggerviewmodel/images/download.svg) ](https://bintray.com/alexfacciorusso/DaggerViewModel/daggerviewmodel/_latestVersion)

# DaggerViewModel

An integration Module for injecting Google Architecture Components' [ViewModel][viewmodel] into
[Dagger2][dagger2]-injected Android activities and fragments.

This library was inspired by the official [GithubBrowserSample][GithubBrowserSample] example.

## Installation

Add one of the following lines depending to your Gradle Android plugin version in your
`dependencies` section:

    // For plugin version < 3.x
    compile 'com.alexfacciorusso:daggerviewmodel:0.1.2'
    
    // For plugin version >= 3.x
    implementation 'com.alexfacciorusso:daggerviewmodel:0.1.2'

## Usage

Install the library, then bind your `ViewModel`s into an abstract `@Module`-annotated class 
annotating your binding method with `@IntoMap` and `@ViewModelKey`, giving to the latter
annotation your custom `ViewModel` class as parameter.
For example:

     @Module
     abstract class ViewModelModule {
         @Binds
         @IntoMap
         @ViewModelKey(MyViewModel::class)
         abstract fun bindsMainViewModel(myViewModel: MyViewModel): ViewModel
         
         // other binds...
     }
 
Add the `DaggerViewModelModule` and the module containing your `ViewModel`s (in our example `ViewModelModule`) to your Application Component:

#### Kotlin

    @Singleton
    @Component(modules = arrayOf(AndroidSupportInjectionModule::class, DaggerViewModelInjectionModule::class,
            your other modules...))
    interface ApplicationComponent {
        // your component definitions ...
    }

#### Java
        
    @Singleton
    @Component(modules = {AndroidSupportInjectionModule.class, DaggerViewModelInjectionModule.class, 
        your other modules...})
    public interface ApplicationComponent {
        // your component definitions ...
    }
    
And finally you can `@Inject` a `ViewModelProvider.Factory` into your Activity/Fragment and use it
to create your ViewModel.
 
#### Kotlin
    
    class MainActivity : AppCompatActivity() {
        @Inject
        lateinit var viewModelFactory: ViewModelProvider.Factory
        
        private lateinit var viewModel: MyViewModel
        
        override fun onCreate(savedInstanceState: Bundle?) {
            AndroidInjection.inject(this)
            super.onCreate(savedInstanceState)
            
            setContentView(R.layout.activity_main)
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(MyViewModel::class.java)
            
            // ...
        }
        
        // ...
    }
    
#### Java

    public class MainActivity extends AppCompatActivity {
        @Inject
        ViewModelProvider.Factory viewModelFactory;
            
        private MyViewModel viewModel;
        
        
        void onCreate(Bundle savedInstanceState) {
            AndroidInjection.inject(this);
            super.onCreate(savedInstanceState);
            
            setContentView(R.layout.activity_main);
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(MyViewModel.class);
            
            // ...
        }
        
        // ...
    }

## License

Copyright 2017 Alex Facciorusso.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


[viewmodel]: https://developer.android.com/topic/libraries/architecture/viewmodel.html
[dagger2]: https://google.github.io/dagger/
[GithubBrowserSample]: https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample
