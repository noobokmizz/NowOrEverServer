# *Project Name* : **NowOrEver** 📝  
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
  
   
   
 ## Spring Boot Project 구조
 ![Spring Boot 구조](./image/springboot_structure.png)  
 
  
```bash
├── noobokmizz.noworever
│   ├── controller
│   │   ├── BucketlistController
│   │   ├── MemberController
│   ├── domain
│   │   ├── BKcontents
│   │   ├── Category_info
│   │   ├── Location
│   │   ├── Members
│   │   ├── Recommend_location
│   │   └── Review
│   ├── dto
│   │   ├── Bucketlist
│   │   ├── CategoryAndLocationList
│   │   ├── Data
│   │   ├── DefaultResponse
│   │   ├── Location_info
│   │   ├── LocationData
│   │   ├── LocationResponse
│   │   └── User
│   ├── repository
│   │   ├── BucketlistRepository
│   │   ├── JpaBucketlistRepository
│   │   ├── MemberRepository
│   │   └── JpaMemberRepository
│   └── service
│   │   ├── BucketlistService
│   │   └── MemberService
└── run.sh
``` 
