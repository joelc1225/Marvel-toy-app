![alt_text](https://s2-cdn.greenhouse.io/external_greenhouse_job_boards/logos/400/173/100/resized/Onramp_final_logo_for_twitter___instagram.jpg?1548972880 "image_tooltip")

# Marvel Toy App 

## Overview 🤖

In honor of the last Avengers movie which is coming out soon, I decided to make a small app involving the first Avengers introduced to us in the Marvel Cinimatic Universe 10 years ago. It's a relatively simple app, but it was fun to make and I'll most likely keep adding to this project and use it as a sandbox to try new things.

## Built with:

- Picasso - Handles image loading and caching
- Parceler - Made working with parcelable objects easier
- Timber - For simple logging convenience
- Lottie - Used for 'favorite' animation
- MVVM architecture 
- Material Design components
- Repository pattern for further abstraction and seperation of concerns 
- ROOM - Abstraction layer over SQLite
- Databinding - Basic usage to minimize 'findviewbyid' calls

## Description and Details 🔎


#### UI Design

Android users expect your application to look and behave in a way that's consistently intuitive. Your Android application should utilize thoughtful [animations](https://material.io/design/motion/), [patterns](https://material.io/design/), [style](https://material.io/design/color/), [components](https://material.io/design/components/) and [layouts](https://material.io/design/layout/understanding-layout.html) to create a highly usable user interface.

#### Architecture Pattern

An architecture pattern enables you to define a guide for how a piece of software should function, such that it can be scalable, maintainable, and testable. Common patterns for Android applications include [MVC](https://medium.com/upday-devs/android-architecture-patterns-part-1-model-view-controller-3baecef5f2b6) (Model View Controller), [MVP](https://android.jlelse.eu/architectural-guidelines-to-follow-for-mvp-pattern-in-android-2374848a0157) (Model View Presenter) and [MVVM](https://medium.com/@husayn.hakeem/android-by-example-mvvm-data-binding-introduction-part-1-6a7a5f388bf7) (Model View ViewModel). **Note that it is required that you leverage the MVVM pattern within your Android app.**


#### Core Android Components

[Activities](https://developer.android.com/guide/components/activities), [Services](https://developer.android.com/guide/components/services), [Broadcast Receivers](https://developer.android.com/reference/android/content/BroadcastReceiver.html), and [Content Providers](https://developer.android.com/guide/topics/providers/content-providers.html) are four types of Android Application components, which are the essential building blocks of an Android app. Each serves a distinct purpose and has a distinct lifecycle that defines how the component is created and destroyed. 

The usage of Activities and Services are extremely common when implementing Android apps and are therefore **mandatory** to include in your project, however, the usage of a Broadcast Receiver and/or Content Provider is optional, depending on the app design.

#### Android Development Best Practices

It's important to subscribe to a set of best practices when designing and implementing an Android app. Be mindful of these widely accepted principles:

*   [DRY](https://code.tutsplus.com/tutorials/3-key-software-principles-you-must-understand--net-25161) (don't repeat yourself)
*   Maintain a [separation of concerns](https://developer.android.com/jetpack/docs/guide#separation-of-concerns) within your Android components
*   Specify good [project structure](https://developer.android.com/studio/intro)

Using these principles will result in a high quality user experience while efficiently utilizing phone hardware resources and ensuring other developers can easily navigate through your code.

#### Android Application Description

As detailed above, each project submission must include a README file, which provides an overview of the Android application and details the app's overall MVVM architecture as well as your design decisions.. Screenshots of the Android app taken from the Android Studio emulator are also required. This task assesses the critical competency of communicating and documenting technical concepts.

**Note: Testing frameworks and strategies are intentionally NOT included within the rubric because we want you to dedicate your time to building a functional application (We do realize that UI and Android component testing are critical practices of Android Development, but this take home project prioritizes a focus on surfacing Java/Android development proficiency).**

## Submission Information 🚀

#### Submission Format

This repository will be your starting point. Please clone (not fork) this Github repository ([onramp-android-take-home](https://github.com/onramp-io/onramp-android-take-home)) and commit to your master branch for the project. Once the Android application has been completed, you'll be submitting a link to the repository. Prior to submitting your project, you should update the README file to provide the following information:

*   A high level architectural overview of your Android application. e.g. names, relationships and purposes of all components, including Activities, Services, Content Providers, Broadcast Receivers, etc. 
*   A brief description of any design patterns that you leveraged.
*   [Screenshots](https://developer.android.com/studio/debug/am-screenshot) of each Activity View and descriptions of the overall user flow.

#### Submission Deadline + Process

You must submit your project at **11:59pm PST, the night before your interview**. Your project will be considered complete when you email [submissions@onramp.io](mailto:engineering@onramp.io) with a link to your repository. 

## Additional Resources 📚

*   [Android Studio](https://developer.android.com/studio)
*   [Android Application Fundamentals](https://developer.android.com/guide/components/fundamentals)
*   [Design for Android Developers](https://developer.android.com/design)
*   [Android Material Design Component Library](https://material.io/design/components/bottom-navigation.html)
*   [Basic concepts of software architecture patterns in Android](https://android.jlelse.eu/basic-concepts-of-software-architecture-patterns-in-android-c76e53f46cba)
*   [Wake up to Pandora with the Clock app from Google](https://engineering.pandora.com/wake-up-to-pandora-with-the-clock-app-from-google-7859fe7743aa) (Pandora Engineering Blog post)
