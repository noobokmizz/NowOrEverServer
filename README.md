# *Project Name* : **NowOrEver** ๐  
![์ฑ ์ด๋ฏธ์ง](./image/app_images.png)
- ํ๋ก์ ํธ ๊ฐ์ : ๐โโ๏ธํ๋ถ ์กธ์ํ๋ก์ ํธ๋ก ์งํํ ๋ชจ๋ฐ์ผ ์ฑ ์ ์ ํ๋ก์ ํธ  
- ํ๋ก์ ํธ ์ค๋ช :  
   1. ์ฌ์ฉ์๊ฐ ๋ฐฉ๋ฌธํ๊ณ  ์ถ์ ์ฅ์๋ ๊ฒฝํํ๊ณ  ์ถ์ ํ๋์ ์ฑ์ ์ ์ฅ ๐  
   2. ๊ธฐ์กด์ ์ ์ฅํด๋ ์ฅ์์ ํ๋ ์ค ์ฌ์ฉ์์ ํ์ฌ ์์น์ ๊ทผ์ ํ ์ปจํ์ธ ๋ฅผ ์ถ์ฒ ๋ฐ ์ ๋ณด ์ถ๋ ฅ ๐ฉ    
   3. ์ ์ฌํ ์ปจํ์ธ ๋ฅผ ํจ๊ป ์ถ์ฒ(ํ์ํํฐ๋ง ๊ธฐ๋ฐ ์ถ์ฒ ์์คํ) ๐ฅณ  
- ํ๋ก์ ํธ ๊ตฌ์กฐ
![ํ๋ก์ ํธ ๊ตฌ์กฐ](./image/project_structure_v2.png)  
- ํ์ : 3๋ช
- ํ๋ก์ ํธ ๊ธฐ๊ฐ : 2021.03.01 ~ 2021.11.26 
- ๋งก์ ํํธ : ๋ฐ์ดํฐ๋ฒ ์ด์ค ์ค๊ณ ๋ฐ ๊ตฌ์ถ, API ์๋ฒ ๊ฐ๋ฐ, ์คํ๋ง๋ถํธ ํ๋ก์ ํธ ๋ฆฌํฉํ ๋ง
- ๊ธฐ์  ์คํ  
   - Used Language
      - Java
      - MySQL
   - Used Tech
      - Spring Boot
      - JPA
      - Gradle
   - Infra
      - AWS EC2
      - AWS RDS  
  
   
   
 # Spring Boot Project ๊ตฌ์กฐ
 ![Spring Boot ๊ตฌ์กฐ](./image/springboot_structure.png)  
 
  
  
# Project tree
 * [controller](/src/main/java/noobokmizz/noworever/controller) : Member์ ๋ํ ์์ฒญ๊ณผ Bucketlist์ ๋ํ ์์ฒญ์ ๋ถ๋ฆฌํด์ ์ฒ๋ฆฌ 
   * [BucketlistController](/src/main/java/noobokmizz/noworever/controller/BucketlistController.java) : Bucketlist์ ๊ดํ ์์ฒญ์ ์ฒ๋ฆฌ
   * [MemberController](/src/main/java/noobokmizz/noworever/controller/MemberController.java) : Member์ ๊ดํ ์์ฒญ์ ์ฒ๋ฆฌ
*************
 * [service](/src/main/java/noobokmizz/noworever/service) : DB๋ก๋ถํฐ ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ ธ์์ ์์ฒญ์ ๋ง๊ฒ ์ฒ๋ฆฌ
   * [BucketlistService](/src/main/java/noobokmizz/noworever/service/BucketlistService.java) : Bucketlist์ ๊ดํ ๋ก์ง
   * [MemberService](/src/main/java/noobokmizz/noworever/service/MemberService.java) : Member์ ๊ดํ ๋ก์ง
*************
 * [repository](/src/main/java/noobokmizz/noworever/repository) : ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ก๋ถํฐ ํ์ํ ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ ธ์ด
   * [BucketlistRepository](/src/main/java/noobokmizz/noworever/repository/BucketlistRepository.java) : Bucketlist์ ๊ดํ Repostrory(Interface)
   * [JpaBucketlistRepository](/src/main/java/noobokmizz/noworever/repository/JpaBucketlistRepository.java) : Bucketlist์ ๊ดํ Repostrory(๊ตฌํ๋ถ)
   * [MemberRepository](/src/main/java/noobokmizz/noworever/repository/MemberRepository.java) : Member์ ๊ดํ Repostrory(Interface)
   * [JpaMemberRepository](/src/main/java/noobokmizz/noworever/repository/JpaMemberRepository.java) : Member์ ๊ดํ Repostrory(๊ตฌํ๋ถ)
*************
 * [domain](/src/main/java/noobokmizz/noworever/domain) : ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ํ์ด๋ธ๊ณผ 1๋1 ๋งตํ
   * [BKcontents](/src/main/java/noobokmizz/noworever/domain/Bkcontents.java) : Bucketlist ๋ชฉ๋ก ์ ๋ณด
   * [Category_info](/src/main/java/noobokmizz/noworever/domain/Category_info.java) : ํ๋๊ณผ ์ฅ์๋ฅผ ๋ถ๋ฅํ ์นดํ๊ณ ๋ฆฌ ์ ๋ณด
   * [Location](/src/main/java/noobokmizz/noworever/domain/Location.java) : ์ฅ์์ ๊ดํ ์ ๋ณด
   * [Recommend_location](/src/main/java/noobokmizz/noworever/domain/Recommend_location.java) : (์ด๋ค ์ฅ์์ ์ ์ฌํ) ์ถ์ฒ ์ฅ์
   * [Review](/src/main/java/noobokmizz/noworever/domain/Review.java) : ์ฅ์์ ๊ดํ ๋ฆฌ๋ทฐ ์ ๋ณด
   * [Members](/src/main/java/noobokmizz/noworever/domain/Members.java) : ํ์์ ๊ดํ ์ ๋ณด
*************
 * [dto](/src/main/java/noobokmizz/noworever/dto) : domain์์ ํ์ํ ์นผ๋ผ๋ง ๊ฐ์ ธ์จ๋ค, ๊ณ์ธต๊ฐ ์ ์ก ํน์ ํด๋ผ์ด์ธํธ์ ๋ฐํํ  ๋ ์ฌ์ฉ
   * [Bucketlist](/src/main/java/noobokmizz/noworever/dto/Bucketlist.java)
   * [BucketlistInfo](/src/main/java/noobokmizz/noworever/dto/BucketlistInfo.java)
   * [CategoryAndLocationList](/src/main/java/noobokmizz/noworever/dto/CategoryAndLocationLIst.java)
   * [DefaultResponse](/src/main/java/noobokmizz/noworever/dto/DefaultResponse.java)
   * [Location_info](/src/main/java/noobokmizz/noworever/dto/Location_info.java)
   * [LocationResponse](/src/main/java/noobokmizz/noworever/dto/LocationResponse.java)

