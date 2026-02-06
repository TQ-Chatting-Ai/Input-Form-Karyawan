<samp>
 
# Cara menjalankan

### 1. Cek paket JDK apakah sudah tersedia dalam sistem

```Bash
javac -version

# Jika muncul output seperti javac 17.x.x atau 21.x.x, artinya pkg sudah tersedia.
```

<details close>
 <summary><h3>2. Kompilasi & Build</h3></summary>

Jalankan perintah ini jika mau mengcompile ulang file .jar:
 
```bash
javac Main.java
# Code akan di compile dan membuat file Main.class & Main$1.class
```
 
```bash
jar cfe TUGAS2_PBO_MSalmanRamadhanAlfadhlih_220401010280.jar Main *.class
# Buat file JAR
```

</details>

### 3. Tes running aplikasi
```bash
java -jar TUGAS2_PBO_MSalmanRamadhanAlfadhlih_220401010280.jar
```
> GUI akan muncul sebagai aplikasi window

<img width="1287" height="726" alt="image" src="https://github.com/user-attachments/assets/861f0b8b-1266-4742-ab65-cbe64f32947d" />
</samp>
