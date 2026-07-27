# Ubau: Techno Thief - Mobile Presskit Application

A modern, native Android presskit application developed for **Ubau: Techno Thief** by **Absent Mind Studio**. This application is designed to streamline game promotion by providing media outlets, influencers, and reviewers with exclusive, structured early access to game details, promotional media, and developer insights.

The project demonstrates a complete mobile development lifecycle, implementing robust frontend UI patterns, localized local database management, and structured version control.

## 🚀 Key Features

- **Exclusive Early Access:** Streamlined delivery of core game details, lore, and mechanics before official public release.
- **Media Kit Hub:** Dedicated sections for high-resolution imagery, concept art, logos, and trailer links optimized for promotional use.
- **Dynamic Content Delivery:** Clean UI architecture built to display rich text, credits, and studio updates smoothly.
- **Offline Capabilities:** Leverages localized storage to ensure press materials remain accessible without an active internet connection.

## 🛠️ Tech Stack & Architecture

- **IDE:** Android Studio
- **Frontend / UI:** Java (App Logic) & XML (Layouts & UI Design)
- **Database:** SQLite (Local data persistence for offline access)
- **Version Control:** GitHub

---

## 📂 Project Structure

```text
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/absentmindstudio/ubaupresskit/
│   │   │   │   ├── data/          # SQLite database helpers and models
│   │   │   │   ├── ui/            # Activities, Fragments, and Adapters
│   │   │   │   └── utils/         # Helper functions and constants
│   │   │   └── res/
│   │   │       ├── layout/        # XML UI layouts
│   │   │       ├── drawable/      # Game assets, icons, and branding
│   │   │       └── values/        # Strings, styles, and color palettes
└── README.md
