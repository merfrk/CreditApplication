# CreditApplication

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/8c4c066db97afaf13ff1?action=collection%2Fimport)

Uygulamayı çalıştırmanız için application.yml dosyasının içindeki username ve password değerlerini kendi değerlerinizle değiştirmeniz gerek. Database olarak localimde postgresql kullandım. Postgresql de boş bir veritabanı oluşturmanız lazım ismini postgres yerine başka bir şey koyacaksanız application.yml dosyasının içindeki url'in sonundaki postgres kısmını değiştirmelisiniz. Uygulamayı denemek için yukardaki Run in Postman butonuna tıklayıp benim koleksiyonumu import edebilirsiniz. Register isteği gönderip login olduğunuzda bir token dönecek , o token'ı sonraki istekleri(credit , update, delete) yaparken Authorization header'ının içinde göndermelisiniz. Benim postman koleksiyonumdaki tokenlar expire olmuştur. 


Projede Layered Architecture'ı tercih ettim, yaygın kullanılan bir mimari olduğu için. User ile Credit arasında OneToOne ilişki kurmuştum fakat insert ederken hata alıyordum, düzeltmeye çalıştığımda bu sefer fazladan kayıt atılıyordu yada foreign key değeri yazılmıyordu o yüzden tablolar arası ilişki kurmadan devam etmek zorunda kaldım.

Security olduğundan Integration testde Header'a token geçmem lazımdı fakat uzun süreli bir token oluşturamadığım için CreditControllerTest'i çalıştırmadan önce SecurityConfiguration' da ```.antMatchers("/credit").permitAll()``` kısmını comment'ten çıkarmak gerekiyor.
