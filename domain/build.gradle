plugins {
    id 'java-library'
    id 'org.jetbrains.kotlin.jvm'
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
test{
    useJUnitPlatform()
}
dependencies {
    //Coroutine
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'

    //Inject
    implementation 'javax.inject:javax.inject:1'

    //Test
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
    testImplementation "org.mockito:mockito-core:4.0.0"
    testImplementation "org.mockito.kotlin:mockito-kotlin:4.0.0"
}