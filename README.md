# Spring Boot API Learning Boilerplate

Proyek ini adalah contoh *boilerplate* (kerangka dasar) sederhana menggunakan Spring Boot untuk membantu Anda belajar bagaimana membuat REST API dari awal. 

Aplikasi ini mengimplementasikan operasi dasar CRUD (Create, Read, Update, Delete) untuk entitas `User`.

## 🛠️ Teknologi yang Digunakan
- **Java 17**
- **Spring Boot 3.x**
  - **Spring Web** (untuk membuat endpoint REST API)
  - **Spring Data JPA** (untuk berinteraksi dengan database secara mudah)
- **H2 Database** (Database *in-memory* yang ringan dan cocok untuk proses belajar dan testing)
- **Lombok** (Library untuk mengurangi boilerplate code Java, seperti Getter, Setter, Constructors)
- **Maven** (Tools untuk _build_ dan manajemen depedensi)

## 📁 Struktur Utama Proyek
```
src/main/java/com/example/api/
  ├── model/
  │    └── User.java                 # Representasi tabel database
  ├── repository/
  │    └── UserRepository.java       # Penghubung aplikasi dengan database H2
  ├── controller/
  │    └── UserController.java       # Menangani request HTTP dari client
  └── SpringApiLearnApplication.java # File utama untuk menjalankan aplikasi
```

## 🚀 Cara Menjalankan Aplikasi

Anda bisa menjalankan aplikasi menggunakan Maven Wrapper atau lebih mudah dengan **Makefile** yang sudah disediakan:

### Menggunakan Makefile (Direkomendasikan)
- **Jalankan aplikasi**: `make run`
- **Jalankan test**: `make test`
- **Build (JAR)**: `make build`
- **Bersihkan build**: `make clean`
- **Lihat semua perintah**: `make help`

### Menggunakan Maven Wrapper Langsung
- Di **Mac/Linux**: `./mvnw spring-boot:run`
- Di **Windows**: `mvnw.cmd spring-boot:run`

Server akan berjalan di port `8080`. Anda bisa mengaksesnya melalui `http://localhost:8080`.

## 📖 Dokumentasi API (Swagger)
Proyek ini sudah dilengkapi dengan **Swagger UI** agar Anda bisa mengetes API secara interaktif langsung dari browser:
- **URL Swagger**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Lihat panduan lengkapnya di [SWAGGER_GUIDE.md](./SWAGGER_GUIDE.md).

## 📝 Daftar Endpoint API (Rute)

Gunakan aplikasi seperti **Postman**, **Insomnia**, atau `curl` di terminal untuk mencoba endpoint ini. Base URL aplikasi adalah `http://localhost:8080`.

| Method   | Endpoint                  | Deskripsi                                  | Body Request (JSON) |
| -------- | ------------------------- | ------------------------------------------ | ------------------- |
| `GET`    | `/api/users`              | Mengambil semua data user                 | -                   |
| `GET`    | `/api/users/{id}`         | Mengambil 1 data user berdasarkan ID       | -                   |
| `POST`   | `/api/users`              | Menambahkan user baru                     | `{"name": "...", "email": "..."}` |
| `PUT`    | `/api/users/{id}`         | Memperbarui data user berdasarkan ID       | `{"name": "...", "email": "..."}` |
| `DELETE` | `/api/users/{id}`         | Menghapus data user berdasarkan ID         | -                   |

### Contoh Penggunaan dengan cURL

**1. Create User (POST)**
```bash
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{"name": "Budi", "email": "budi@example.com"}'
```

**2. Get All Users (GET)**
```bash
curl http://localhost:8080/api/users
```

## 🗄️ Mengakses Database H2

Karena menggunakan database *in-memory* (H2), data yang Anda masukkan tidak akan disimpan permanen (akan hilang ketika server direstart).

Untuk melihat tabel dan isi data secara visual melalui browser:
1. Pastikan aplikasi sedang berjalan.
2. Buka URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
3. Masukkan konfigurasi berikut:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: *(biarkan kosong)*
4. Klik tombol **Connect**. Anda dapat mengeksekusi sintaks SQL langsung di sini (seperti `SELECT * FROM users;`).

## 💡 Apa Selanjutnya?
Setelah berhasil menjalankan kode ini, Anda dapat mencoba tantangan berikut untuk menguji pemahaman Anda:
1. Tambahkan properti baru di entitas `User`, misalnya `String phone` atau `String address`.
2. Buat REST API baru (Model, Repository, & Controller), misalnya untuk data `Product`.
3. Tambahkan validasi pada controller agar nama dan email tidak boleh kosong (menggunakan `@Valid` dan library `spring-boot-starter-validation`).

Selamat belajar! 🎉
