# 개인 CI/CD 프로젝트

## 1. 코드 부분 
### 1.1 기본적인 골격
+ '스프링부트와 AWS로 혼자 구현하는 웹 서비스' 참고
### 1.2 추가한 내용
+ OAUTH 2.0 이용 카카오 페이스북 소셜 로그인 기능 추가

## 2. 아키텍처 부분 
### 2.1 AWS 구조도
![image](https://user-images.githubusercontent.com/66419215/167819938-49ff7a89-4370-42cf-912a-0b33a532af07.png)
### 2.2 특징
- 3 티어 아키텍처를 s3, private subnet, DB로 구성
- private subnet의 인스턴스들의 온라인 접속은 nat gateway를 통하고, bastion 서버를 public subnet에 따로 두어서 내외부의 게이트 역할을 수행
- 웹사이트 트래픽은 유저가 Route53 도메인으로 웹사이트를 접속하고, cloudfront를 통해서 정적데이터는 S3, Springboot와 같은 동적데이터는 EC2를 대상으로 하는 ELB를 통해 전송
  (해당 분류는 pathpattern으로 진행)
- 이중화 (AutoScaling group으로 ELB에 연결 , RDS는 Active StandBy방식) 
