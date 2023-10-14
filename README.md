# wanted-pre-onboarding-backend
wanted-pre-onboarding-backend 제출 과제

## ERD
![preonboarding_erd](https://github.com/Minji-Sohn2/wanted-pre-onboarding-backend/assets/130354169/38fec50b-5e43-4d24-9097-cd568b7b6c46)


## API 명세
- request/response는 요구사항에서 확인
  
|기능|Method|Url|
|------|---|---|
|채용공고 전체 조회|GET|/posts|
|채용공고 등록|POST|/posts|
|채용공고 상세 조회|GET|/posts/{postId}|
|채용공고 수정|PUT|/posts/{postId}|
|채용공고 삭제|DELETE|/posts/{postId}|
|채용공고 키워드 검색|GET|/posts/search?search=keyword|
|채용공고 지원|POST|/apply|

## 요구사항
- Company, User는 DB에 직접 입력 후 진행
**1. 채용공고 등록**
- PostRequestDto 안의 companyId로 새로운 Post의 Company 필드 연결 후 DB에 저장
- 존재하지 않는 회사일 경우 -> NullPointerException
```
입력 예시
{
  "companyId":1,
  "position":"프론트엔드 주니어 개발자",
  "reward":500000,
  "details":"서울에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skills":"Vue"
}
```

**2. 채용공고 수정**
- 채용공고 id(IDENTITY)로 채용공고 확인 후 수정
- 회사 id를 제외한 모든 내용 수정 가능
- 존재하지 않는 채용공고일 경우 -> NullPointerException
```
입력 예시
{
  "position":"백엔드 주니어 개발자2",
  "reward":1000000,
  "details":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skills":"Python"
}
```

**3. 채용공고 삭제**
- 채용공고 id로 채용공고 확인 후 삭제
- 존재하지 않는 채용공고일 경우 -> NullPointerException
```
출력 예시
{
    "message": "공고 삭제 성공",
    "statusCode": 200
}
```

**4. 채용공고 조회**
**4-1. 전체 조회**
- 전체 채용공고 조회
```
출력 예시
{
    "postList": [
        {
            "postId": 1,
            "companyName": "서울회사",
            "country": "대한민국",
            "region": "서울",
            "position": "백엔드 주니어 개발자",
            "reward": 1000000,
            "skills": "Python"
        },
        {
            "postId": 2,
            "companyName": "부산회사",
            "country": "대한민국",
            "region": "부산",
            "position": "프론트엔드 주니어 개발자",
            "reward": 500000,
            "skills": "React"
        },
        .
        .
    ]
}
```

**4-2. 키워드 조회**
- 회사 이름, 채용 포지션, 상세 내용, 기술 스택에 검색 키워드가 포함되어 있는 채용공고 출력
```
출력 예시 (keyword : 백)
{
    "postList": [
        {
            "postId": 1,
            "companyName": "서울회사",
            "country": "대한민국",
            "region": "서울",
            "position": "백엔드 주니어 개발자",
            "reward": 1000000,
            "skills": "Python"
        },
        {
            "postId": 3,
            "companyName": "성남회사",
            "country": "대한민국",
            "region": "성남",
            "position": "백엔드 주니어 개발자",
            "reward": 2000000,
            "skills": "Java"
        }
    ]
}
```
**5. 채용공고 상세 조회**
- 채용 내용, 해당 회사가 올린 다른 채용공고 id 리스트(postIdList) 출력
- 채용공고의 company 필드 속 postList에서 현재 조회중인 채용공고의 id 제외한 나머지 id 출력
```
출력 예시
{
    "postId": 1,
    "companyName": "서울회사",
    "country": "대한민국",
    "region": "서울",
    "position": "백엔드 주니어 개발자",
    "reward": 1000000,
    "skills": "Python",
    "details": "서울에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "postIdList": [
        4
    ]
}
```

**6. 채용공고 지원**
- UserApply 라는 엔티티로 지원현황 저장
- User, Post(채용공고)와 각각 1:N 관계
- User와 Post를 함께 검색해 이미 지원해 객체가 존재하는 경우 지원할 수 없음
```
입력 예시
{
    "userId":1,
    "postId":1
}
```
