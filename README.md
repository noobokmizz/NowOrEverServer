# NowOrEver  

- 프로젝트 설명 : 학교 졸업프로젝트로 진행한 모바일 앱 제작 프로젝트 
- 프로젝트 기간 : 2021.03.01 ~ 2021.11.26 
- 맡은 파트 : Rest API 서버 개발

- 사용 기술
  - Spring Boot
  - JPA
  - AWS EC2
  - AWS RDS
  - MySQL
  - 

mermaid
classDiagram
      Animal <|-- Duck
      Animal <|-- Fish
      Animal <|-- Zebra
      Animal : +int age
      Animal : +String gender
      Animal: +isMammal()
      Animal: +mate()
      class Duck{
          +String beakColor
          +swim()
          +quack()
      }
      class Fish{
          -int sizeInFeet
          -canEat()
      }
      class Zebra{
          +bool is_wild
          +run()
      }
