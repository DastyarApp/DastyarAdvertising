# DastyarAdvertising
Dastyar in-app advertising library

# Installation
in your build.gradle (project level)
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
add code below in your build.gradle (module app)
```
dependencies {
    implementation 'com.github.DastyarApp:DastyarAdvertising:ad-v1.0.0'
}
```

# Example
### * activity_main.xml

put the code below in your Fragment or Activity layout file
```xml
    <ir.drmazhabi.dastyaradvertisingsample.MediumAdView
        android:id="@+id/mediumAd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent" />

    <ir.drmazhabi.dastyaradvertisingsample.SmallAdView
        android:id="@+id/smallAd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent" />
```

### * MainActivity.java
put the code below in your Fragment or Activity calss
```java
   SmallAdView smallAdView = findViewById(R.id.smallAd);
   MediumAdView mediumAdView = findViewById(R.id.mediumAd);
   DastyarAdView.getInstance()
           .initialize(MainActivity.this)   // initilizing is necessury
           .loadBanner(smallAdView, AdSize.SMALL)   // shows small banner
           .loadBanner(mediumAdView, AdSize.MEDIUM);    // shows medium banner
           .loadFullScreenBanner();   // shows full screen banner
```
