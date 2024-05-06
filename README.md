# Automation API Testing using Rest Assured

## OVERVIEW PROJECT
Program ini berisi Skrip untuk melakukan pengujian yang dirancang untuk dapat menguji API dari situs DummyAPI. Dimana disini diperintahkan untuk mengecek CRUD dari API yang telah disediakan. Program ini menggunakan berbagai macam teknologi seperti Maven, Rest Assured, dan juga JUnit.

## Project Structure
Berikut adalah struktur project yang kelompok kami buat

```
api-testing/
├── src/
├   ├── main/java/com/a3/api_testing/
├   ├   └── App.java
├   └── test/
├       ├── java/com/a3/api_testing/
├       └── AppTest.java
├       └── CreateMethod.java
├       └── GetMethod.java
├       └── UpdateTest.java
├── target/
├── .gitignore
├── pom.xml
└── README.md
```
* Terdapat program testing pada bagian src->test>java->a3->api_testing-> dengan 4 program testing utama yaitu AppTest.java, CreateMethod.java, GetMethod.java, UpdateTest.java

## Cara Penggunaan
1. Clone repository.
    ```
   git clone https://github.com/MaolanaF/automation-api-testing.git
   ```
2. Buka project menggunakan Visual Studio Code atau Java IDE lainnya.
 
#AUTOMATION TESTING   
## Prequisites
1. Install Java (JDK)
2. Install Maven
3. Install IDE (example: Visual Studio Code)

## Run Automation Test
1. Jalankan perintah berikut pada terminal:
   a. Bila ingin melakukan test pada semua modul, masukan perintah berikut :
   ```
   mvn test
   ```

   b. Bila ingin melakukan test pada hanya 1 class saja, masukan perintah berikut :
   ```
   mvn test -Dtest=NamaFileTest test
   ```

   c. Bila ingin melakukan test pada hanya 1 modul saja, masukan perintah berikut :
   ```
   mvn test -Dtest=NamaFileTest#namaModul test
   ```

3. Untuk melihat hasil report testing jalankan perintah berikut pada terminal:
    ```
   mvn site
   ```

4. Buka hasil report pada file `\target\site\surefire-report.html` dalam browser.

