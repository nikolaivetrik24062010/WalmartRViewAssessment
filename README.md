
# Walmart Android Assessment – Secure Country List Viewer

A technical assessment for a **Mobile AppSec** role, demonstrating **Security-by-Design** principles in a modern Android environment.

---

## 🔐 Security Focus

- **Secure Networking:** Enforced **TLS (HTTPS)** via Retrofit2 to ensure data encryption in transit.
- **Data Integrity:** Used strictly-typed **GSON parsing** to mitigate type-confusion and malformed payload vulnerabilities.
- **Application Hardening:** Configured for **R8/ProGuard** obfuscation to protect business logic from static analysis.
- **Principle of Least Privilege:** Manifest restricted to the minimum required `INTERNET` permission.
- **Defensive Coding:** Robust error-handling layer to prevent stack trace leakage to the UI.

---

## 🧠 Architecture

The app follows a modular **MVVM** pattern to isolate sensitive data logic from the presentation layer.


- **Stack:** Kotlin, Coroutines, StateFlow, Retrofit2, Material3.
- **Design:** Layered approach (Data -> UI) for better testability and reduced attack surface.


```
* data/ (Encapsulated Data Layer)
* model/Country.kt
* network/ (Retrofit & API)

* ui/ (View & Logic Isolation)
* country/ (ViewModel & Adapter)

```

---

## ✅ Engineering Standards

- **Lifecycle-Aware:** StateFlow ensures stateless data handling and prevents memory leaks.
- **Scalability:** Designed for easy integration of **Android Keystore** or **Certificate Pinning**.
- **Clean UI:** Responsive Material3 design with orientation change support.

---

## 🚀 Getting Started

```bash
git clone [https://github.com/nikolaivetrik24062010/WalmartRViewAssessment.git](https://github.com/nikolaivetrik24062010/WalmartRViewAssessment.git)

```

1. Open in **Android Studio**.
2. Sync Gradle and build.
3. Run on an emulator/device with internet.

---

## 🤝 Author

**Nikolai Vetrik** *Senior Security Engineer & Android Developer* 📧 [devnikolaivetrik@gmail.com](mailto:devnikolaivetrik@gmail.com) | [LinkedIn](https://linkedin.com/in/nikolayvetrik24062010)

---
