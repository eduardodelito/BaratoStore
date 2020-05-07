package dependencies

// Object that is used for dependency version
object Versions {

    //package
    const val applicationId = "com.enaz.baratostore"

    const val jvmTarget = "1.8"

    //version
    const val versionCode = 1
    const val versionName = "1.0"

    // build
    const val minSdk = 23
    const val compileSdk = 29
    const val targetSdk = 29
    const val buildTools = "29.0.3"

    // kotlin
    const val kotlin_version = "1.3.72"

    // Android
    const val androidGradle = "4.0.0-beta05"
    const val navigation = "2.2.2"
    const val appcompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val lifecycle = "2.2.0-alpha02"
    const val coreKtx = "1.2.0"
    const val room = "2.2.3"
    const val multidex = "1.0.3"
    const val swipeRefreshLayout = "1.0.0"

    // google
    const val materialDesign = "1.2.0-alpha03"
    const val dagger = "2.25.3"
    const val googleServices = "4.3.3"
    const val firebaseAnalytics = "17.4.0"
    const val firebase = "19.3.1"
    const val firebaseDatabase = "19.3.0"
    const val playServicesAuth = "18.0.0"

    //network
    const val retrofit = "2.5.0"
    const val fresco = "2.0.0"

    // third parties
    const val rxJavaVersion = "2.2.12"
    const val rxAndroidVersion = "2.1.1"
}

// Object that contains libraries needed by the app
object Libs {

    private object Android {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui:${Versions.navigation}"
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val lifecycleViewModelktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomRxJava = "androidx.room:room-rxjava2:${Versions.room}"
        const val roomGuava = "androidx.room:room-guava:${Versions.room}"
        const val roomTesting = "androidx.room:room-testing:${Versions.room}"

        const val multiDexSupport = "com.android.support:multidex:${Versions.multidex}"
    }

    private object Kotlin {
        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
        const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    }

    private object Firebase {
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
        const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebase}"
        const val firebaseDatabase = "com.google.firebase:firebase-database-ktx:${Versions.firebaseDatabase}"
        const val playServicesAuth = "com.google.android.gms:play-services-auth:${Versions.playServicesAuth}"
    }

    private object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.dagger}"
        const val android = "com.google.dagger:dagger-android:${Versions.dagger}"
        const val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    // Section for third-party dependencies
    private object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGSONConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val fresco = "com.facebook.fresco:fresco:${Versions.fresco}"
    }

    private object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    }
}
