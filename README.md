# *Project Name* : **NowOrEver** 📝  
![앱 이미지](./image/app_images.png)
- 프로젝트 개요 : 🙋‍♂️학부 졸업프로젝트로 진행한 모바일 앱 제작 프로젝트  
- 프로젝트 설명 :  
   1. 사용자가 방문하고 싶은 장소나 경험하고 싶은 활동을 앱에 저장 📂  
   2. 기존에 저장해둔 장소와 활동 중 사용자의 현재 위치와 근접한 컨텐츠를 추천 및 정보 출력 🚩    
   3. 유사한 컨텐츠를 함께 추천(협업필터링 기반 추천 시스템) 🥳  
- 프로젝트 구조
![프로젝트 구조](./image/project_structure.png)  
- 팀원 : 3명
- 프로젝트 기간 : 2021.03.01 ~ 2021.11.26 
- 맡은 파트 : Rest API 서버 개발
- 시연 영상 : youtube 링크걸기
- 기술 스택  
   - Used Language
      - Java
      - MySQL
   - Used Tech
      - Spring Boot
      - JPA
   - Infra
      - AWS EC2
      - AWS RDS  
  
   
   
 # Spring Boot Project 구조
 ![Spring Boot 구조](./image/springboot_structure.png)  
 
  
  
# Project tree
.
 * [controller](/src/main/java/noobokmizz/noworever/controller)
   * [BucketlistController](/src/main/java/noobokmizz/noworever/controller/BucketlistController.java)
   * [MemberController](/src/main/java/noobokmizz/noworever/controller/MemberController.java)
 * [domain](/src/main/java/noobokmizz/noworever/domain)
   * [BKcontents](/src/main/java/noobokmizz/noworever/domain/Bkcontents.java)
   * [Category_info](/src/main/java/noobokmizz/noworever/domain/Category_info.java)
   * [Location](/src/main/java/noobokmizz/noworever/domain/Location.java)
   * [Recommend_location](/src/main/java/noobokmizz/noworever/domain/Recommend_location.java)
   * [Review](/src/main/java/noobokmizz/noworever/domain/Review.java)
   * [Members](/src/main/java/noobokmizz/noworever/domain/Members.java)
 * [dto](/src/main/java/noobokmizz/noworever/dto)
   * [Bucketlist](/src/main/java/noobokmizz/noworever/dto/Bucketlist.java)
   * [BucketlistInfo](/src/main/java/noobokmizz/noworever/dto/BucketlistInfo.java)
   * [CategoryAndLocationList](/src/main/java/noobokmizz/noworever/dto/CategoryAndLocationLIst.java)
   * [DefaultResponse](/src/main/java/noobokmizz/noworever/dto/DefaultResponse.java)
   * [Location_info](/src/main/java/noobokmizz/noworever/dto/Location_info.java)
   * [LocationResponse](/src/main/java/noobokmizz/noworever/dto/LocationResponse.java)
 * [repository](/src/main/java/noobokmizz/noworever/repository)
    * [BucketlistRepository](/src/main/java/noobokmizz/noworever/repository/BucketlistRepository.java)
    * [JpaBucketlistRepository](/src/main/java/noobokmizz/noworever/repository/JpaBucketlistRepository.java)
    * [MemberRepository](/src/main/java/noobokmizz/noworever/repository/MemberRepository.java)
    * [JpaMemberRepository](/src/main/java/noobokmizz/noworever/repository/JpaMemberRepository.java)
 * [service](/src/main/java/noobokmizz/noworever/service)
    * [BucketlistService](/src/main/java/noobokmizz/noworever/service/BucketlistService.java)
    * [MemberService](/src/main/java/noobokmizz/noworever/service/MemberService.java)
