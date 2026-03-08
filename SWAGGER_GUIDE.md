# 📖 Panduan Swagger / OpenAPI

## Apa itu Swagger/OpenAPI?
**Swagger** (sekarang bagian dari spesifikasi **OpenAPI**) adalah alat yang digunakan untuk mendokumentasikan API secara otomatis. Tanpa Swagger, Anda harus menulis dokumentasi manual (seperti Word atau Markdown) setiap kali ada perubahan endpoint. 

Dengan Swagger, dokumentasi dibuat langsung dari kode Java Anda.

## Bagaimana Cara Kerjanya di Spring Boot?

Di proyek ini, kita menggunakan library bernama **SpringDoc OpenAPI**. Berikut prosesnya:

1.  **Scanning**: Saat aplikasi berjalan, SpringDoc "mengintip" semua kelas dengan anotasi `@RestController` (seperti `UserController`).
2.  **Mapping**: Ia melihat method `@GetMapping`, `@PostMapping`, dll., lalu mencatat:
    - Path (URL).
    - Method (GET/POST/..).
    - Parameter yang dibutuhkan.
    - Format data (JSON) yang dikirim dan diterima.
3.  **UI Generation**: Hasil catatan tersebut dikonversi menjadi file JSON/YAML dan ditampilkan secara visual melalui halaman web yang interaktif.

## Cara Menggunakan Swagger UI

1. Jalankan aplikasi (`make run`).
2. Buka browser dan pergi ke:  
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Fitur Utama:
- **Visualisasi Endpoint**: Melihat semua daftar API yang tersedia.
- **Try it out**: Anda bisa langsung mengetes API tanpa perlu Postman. Klik tombol "Try it out", isi data, lalu klik "Execute".
- **Schema**: Melihat struktur data (Model) yang digunakan dalam request dan response.

## Keuntungan Menggunakan Swagger
- **Selalu Update**: Jika Anda menambah endpoint baru di Java, Swagger akan otomatis mengupdate halamannya.
- **Standar Industri**: OpenAPI adalah standar global dalam pembuatan API.
- **Interaktif**: Memudahkan tim Frontend atau pihak ketiga untuk mencoba API Anda tanpa penjelasan lisan.
