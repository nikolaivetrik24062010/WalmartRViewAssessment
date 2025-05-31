# Walmart Android Assessment – Country List Viewer

This is a technical assessment project for the Android Developer position at Walmart. The goal is to fetch a list of countries from a remote JSON and display them in a scrollable list using clean, testable, and scalable architecture.

---

## 📱 Features

- Fetch country data from remote JSON API
- Display countries in a clean card layout with:
  - Name, Region (left aligned)
  - Code (right aligned)
  - Capital (bottom)
- MVVM architecture
- Retrofit for networking
- Kotlin Coroutines + StateFlow
- Robust error handling
- Orientation change support

---

## 🧠 Architecture

This app follows the MVVM architecture and a layered approach:

```
- data
  - model/Country.kt
  - network/CountryApi.kt
  - network/RetrofitInstance.kt

- ui
  - MainActivity.kt
  - country/ViewModel.kt
  - country/CountryAdapter.kt

```

---

## 🚀 Getting Started

Clone the repo and open the project in Android Studio:

```bash
git clone https://github.com/<your-github>/WalmartRViewAssessment.git
```

### Dependencies
- Retrofit2
- GSON
- Kotlin Coroutines
- Material3

---

## ▶️ How to run

1. Open the project in Android Studio.
2. Sync Gradle and build.
3. Run the app on an emulator or real device with internet.

---

## ✅ Things to Note

- No third-party architecture libraries were used to keep it simple and self-contained.
- Code is modular and easy to test or extend, for a larger project, ViewBinding could be introduced to improve type safety and reduce boilerplate.
- UI is clean and adaptive to screen size.

---

## 🤝 Author

**Nikolay Vetrik**  
📧 nikolaivetrikdev@gmail.com  
📱 (916) 595-7260  

---

## 📄 License

This project is for educational and hiring evaluation purposes.

