# 💫 취업문JAVA조 (코테 스터디)

---

## 🗓️ 스터디 일정

- **매주 화요일**: 18:00 ~ 19:00 - 알고리즘 스터디
- **매주 목요일**: 코드 리뷰 및 TIL 작성 공유

## 🎯 목표

- 바킹독 알고리즘 강의의 `0x11강 - 그리디` 파트까지 완강
- 매주 **WIL (Week I Learned)** 작성하여 배운 알고리즘 정리
- 매주 **Github Repository**에 문제 풀이 코드 업로드 및 PR 후 코드 리뷰 후 종합 코드리뷰 작성

## 📚 진행 방식

1. **강의 시청 및 문제 선정**
    - 매주 모여서 바킹독 알고리즘 강의를 듣고, 다음 주에 풀 **연습 2, 기본 2, 응용 1 문제**를 선정합니다.
    - 문제는 [워크북](https://github.com/encrypted-def/basic-algo-lecture/blob/master/workbook.md)에서 선택합니다.
2. **문제 풀이 및 PR**
    - 각자 [바킹독 레포지토리](https://github.com/encrypted-def/basic-algo-lecture/tree/master)를 fork하여 자신의 저장소로 가져옵니다.
    - 선정된 문제 5개를 풀고, 자신의 저장소에 코드 업로드 후 PR을 생성합니다.
    - 서로의 PR에 대해 [우테코 코드리뷰 가이드](https://github.com/woowacourse/woowacourse-docs/blob/main/reviewer/review-guide.md)를 참고하여 코드 리뷰를 진행합니다.
3. **TIL 작성 및 공유**
    - 매주 `목` 학습한 내용을 정리하여 **WIL (Week I Learned)** 형식으로 작성합니다.
    - 작성한 WIL은 스터디 모임 때 공유하여 서로의 학습 내용을 확인하고 피드백합니다.

## **📊 문제 정보**

**📚 [바킹독 문제집 (github)](https://github.com/encrypted-def/basic-algo-lecture/tree/master)**

## **💻 커밋 규칙**

- `master` 는 대표자 1명이 관리하고 코드 리뷰가 끝나면 `master`로 merge한다.
- 각자 이름(이니셜 ex. ljr)을 `branch`로 생성하여 파일을 commit 및 PR한다.
- 커밋 규칙
    - 파일 추가
        - `add : 240510 boj_1234 Solved`
        - `add : 240510 boj_1234 Failed`
        - `add : 240510 programmers_N개의 최소공배수 Solved`
    - 파일 수정
        - `fix : 220707 boj_1234 Solved`
    - 플랫폼 이름
        - 백준 : `boj`
        - 프로그래머스 : `prm`
- 코드 리뷰 이후 `master` branch에 merge

## **🍴 PR 규칙**

- 매주 `금` 스터디 종료 시 PR
- PR 제목
    
    예시 : `240510 이름 문제집 풀이` (240510 이준렬 0x02 풀이)
    
- PR 내용 → 제목과 동일
- PR 승인할 때 Comment 하나씩 달아주기 (칭찬하기)

## **💻 디렉토리 및 파일 구조**

`/문제집이름/본인이름/문제` 형식

예시 1 : `/0x02/이준렬/X보다_작은_수.java`

- 각 OS에서 사용 불가능한 특수문자를 파일명에 넣지 말것!

예시 2 : <br>
❌ `/0x0B_0x0C/이준렬/재귀함수가_뭔가요?.java` <br>
⭕️️ `/0x0B_0x0C/이준렬/재귀함수가_뭔가요.java`<br> (`재귀함수가_뭔가요?` 에서 `?` 는 윈도우에서 사용 불가)

### _사용 불가 특수문자 목록._ 

| 문자 | 이유 |
|----| --- |
| \  | 디렉터리의 구분자로 쓰인다. |
| /  | 디렉터리 및 URL 경로 구분에 사용된다. |
| :  | 경로의 시작과 끝을 나타내는 구분자로 사용된다. |
| *  | 와일드카드 문자로, 파일 및 디렉터리 검색 시 사용된다. |
| ?  | 한 글자를 대체하는 와일드카드 문자로 사용된다. |
| "  | 경로의 시작과 끝을 나타낸다. |
| <  | 리다이렉트 및 특수 문법에 사용된다. |
| \> | 리다이렉트 및 특수 문법에 사용된다. |

## **🧐 COC(Code of Conduct, 행동 규칙)**

- 알고리즘 문제 해결에만 집착하지 않고 **원리와 패턴**을 익히는 데 목적을 둔다.
- 절대 풀지 못할 것 같은 문제는 **적당한 시점**에 포기하고 다른 사람의 풀이를 통해 영감을 얻고 배우자.
- 문제가 잘 풀리지 않는다고 스스로를 비하하지 않는다.
- 가급적 불참은 지양하며, 피치 못할 사정으로 인해 불참하게 된다면 스터디원들과 날짜 조율하도록 한다.

## **⏰ 타임 테이블**

| 시간 | 내용 |
| --- | --- |
| 18:00 ~ 19:00 | 알고리즘 문제 풀이(단체) |

### **💦 참고**

[fork해서 Pull Request 보내는 법](https://wayhome25.github.io/git/2017/07/08/git-first-pull-request-story/)

[fork된 Repository 최신상태 유지하는 법](https://jybaek.tistory.com/775)

[바킹독의 실전 알고리즘 강의 자료](https://github.com/encrypted-def/basic-algo-lecture)