# 🚗 Showroom Management System – Tugas 14 PBO

Project ini merupakan aplikasi desktop berbasis **Java Swing** dengan dukungan **JPA (Java Persistence API)** untuk melakukan pengelolaan data Showroom seperti:

- Data Mobil  
- Data Customer  
- Data Penjualan  
- Sistem Login & Register  
- Fitur Lupa Password dengan Verifikasi  
- Import & Export CSV

Aplikasi ini dibuat sebagai tugas praktikum PBO.

---

## ✨ Fitur Utama

### 🔐 1. Sistem Login & Register
- User dapat membuat akun baru (username & password).
- Saat registrasi, user wajib mengisi **“benda di meja”** sebagai *security question*.
- Sistem login memvalidasi username & password dari database.

### 🔑 2. Fitur Lupa Password (Password Recovery)
- User memasukkan username.
- User wajib mengisi **jawaban “benda di meja”** yang sesuai dengan data saat registrasi.
- Jika cocok → User diarahkan ke dialog baru untuk membuat password baru.

### 📦 3. CRUD Data Mobil
- Tambah data mobil
- Update data mobil
- Hapus data mobil
- Tabel mobil ditampilkan dalam GUI

### 👥 4. CRUD Data Customer
- Tambah, edit, hapus customer
- Menampilkan daftar customer di tabel GUI

### 🧾 5. Data Penjualan
- Input penjualan berdasarkan mobil & customer
- Menampilkan tanggal, total harga, mobil, dan customer

### 📤📥 6. Export & Import CSV
Semua tab (Mobil, Customer, Penjualan) memiliki fitur:
- **Export CSV** – menyimpan data ke file CSV
- **Upload CSV** – membaca file CSV dan menampilkan kembali ke tabel aplikasi

---

## 🗄 Entity / Database Structure

Aplikasi menggunakan 3 tabel utama:

### 1. `user_login`
| Field | Tipe | Keterangan |
|-------|------|------------|
| id | SERIAL | Primary key |
| username | VARCHAR | Username user |
| password | VARCHAR | Password user |
| barang_di_meja | VARCHAR | Security question |

### 2. `customer`
| Field | Tipe |
|--------|------|
| id | SERIAL |
| nama | VARCHAR |
| alamat | VARCHAR |
| no_telp | VARCHAR |
| email | VARCHAR |

### 3. `mobil`
| Field | Tipe |
|--------|------|
| id | SERIAL |
| merk | VARCHAR |
| model | VARCHAR |
| tahun | INTEGER |
| harga | NUMERIC |

---

## 🛠 Teknologi yang Digunakan

- **Java 8+ / 11**
- **Java Swing GUI**
- **Maven**
- **JPA (EclipseLink)**
- **PostgreSQL**
- **CSV Processing (FileReader / FileWriter)**

---

## 🏁 Cara Menjalankan Project

1. Clone repository:
   ```bash
   git clone https://github.com/RiskaAml/Tugas-14-PBO.git
