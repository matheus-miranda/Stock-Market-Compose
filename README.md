# Stock Market Compose

![app](https://user-images.githubusercontent.com/15269393/163015358-c9cfcce1-547c-41a7-8a6d-8fe2d201632c.gif)

## Steps required to run the app
Create a `apikey.properties` file in the root folder and add your alphavantage API key in the following format:

`API_KEY="xxxxxx"`


Get a free API key from [Alpha Vantage](https://www.alphavantage.co/support/#api-key)

## Dependencies used
```
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.1'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
    coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:1.1.5'

    // OpenCSV
    implementation 'com.opencsv:opencsv:5.5.2'

    // Compose dependencies
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    implementation "androidx.compose.material:material-icons-extended:$compose_version"
    implementation "androidx.activity:activity-compose:1.6.0-alpha01"
    implementation "com.google.accompanist:accompanist-swiperefresh:0.24.2-alpha"

    // Compose Nav Destinations
    implementation 'io.github.raamcosta.compose-destinations:core:1.1.2-beta'
    ksp 'io.github.raamcosta.compose-destinations:ksp:1.1.2-beta'

    // Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.40.5"
    kapt "com.google.dagger:hilt-android-compiler:2.40.5"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    kapt "androidx.hilt:hilt-compiler:1.0.0"
    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.3"
    implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3"

    // Room
    implementation "androidx.room:room-runtime:2.4.2"
    kapt "androidx.room:room-compiler:2.4.2"

    // Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:2.4.2"
```
