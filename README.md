![image](https://github.com/user-attachments/assets/e97029db-c091-46c1-a4b1-8f215ec894bd)# :hotel: JavaGUIProject
<div align="center">
<p align="left"><img src="https://github.com/user-attachments/assets/40b8e2bf-71db-4f8d-a41c-03410d118fc3" width="700" height="500"></p>
</div>
<br>

# :loudspeaker: 프로젝트 소개 
<div>
순수 객체 지향언어 기반 프로젝트로 Gui기반 인터페이스를 구축하고 데이터베이스와 연동하여 고객관리(추가,삭제,수정,검색)를 하는 호텔 예약 프로그램입니다.

<b>프로젝트 명</b> : 호텔 예약 프로그램<br>
<b>기술 Stack</b> : Java, DAO&DTO, Oracle<br>
<b>목적</b> : 순수 객체 지향언어 기반 프로젝트<br>
<b>주요기능</b> : 고객관리(추가,삭제,수정,검색)<br>
<b>성과</b> : 객체생성 및 소멸이해, 객체지향 언어 특징 이해와 활용<br>
</div>


<br>

## :sunglasses: 팀원 구성
<div align="left">

| **문형욱** |
| :------: |
|  [<img src="https://github.com/user-attachments/assets/ea99c1d6-a08a-4edd-8af0-87aec4cf351a" height=150 width=150> <br/> @ssamjagod](https://github.com/ssamjagod) | 
</div>

<br>

## :date: 개발 기간
*2024.04.15 ~ 2024.04.22*

<br>

## :computer: 개발 환경

<div>
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat&logo=eclipseide&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-F80000?style=flat&logoColor=white"/>
<img src="https://img.shields.io/badge/JavaSwing-F13000?style=flat&logoColor=white"/>
<img src="https://img.shields.io/badge/Oracle-F80000?style=flat&logo=oracle&logoColor=white"/>
</div>

<br>

## :pencil2: 주요 기능
**호텔홈페이지**
- 자바 스윙을 통해 호텔GUI를 구성하고 콤보박스와 텍스트필드를 이용하여 정보를 오라클 데이터베이스와 주고 받는다.

<br>

**회원가입 기능**
- 사용자가 예약정보를 입력하고 예약을 할 수 있는 페이지에 접근하기 위한 로그인 정보를 오라클 데이터베이스 Guest 테이블에 저장한다.
<br>

**로그인 기능**
- 오라클 데이터베이스에 있는 저장해 놓은 로그인 정보들과 내가 입력한 
아이디와 패스워드 정보를 비교하여 일치하면 예약페이지에 접근 할 수 있게 한다.
<br>

**예약 기능**
- 예약자 정보를 입력하고 예약하기 버튼을 누르면 오라클 데이터베이스의 Guest 테이블의 해당 아이디의 튜플의 정보를 업데이트한다. 
Room 테이블의 해당 룸넘버의 사용가능 변수를 변경시켜 다른 예약자가 접근 할 수 없게 한다.
<br>
  


## ERD
<div>
  <img src="https://github.com/user-attachments/assets/a3d905be-60b2-459f-85c4-c816bd3c8983">
</div>

