buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.4")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
    }
}

//task clean(type: Delete) {
//    delete rootProject.buildDir
//}

//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//    }
//}