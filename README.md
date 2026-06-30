<img width="274" height="240" alt="image" src="https://github.com/user-attachments/assets/15711ae5-b6d2-4309-88b4-9eebe2992e55" />


# 일정 관리 API 명세서

## 1. 일정 생성

### Request

- Method : `POST`
- URL : `/agendas`

#### Request Body

```json
{
  "title": "Spring 공부",
  "content": "JPA 학습",
  "username": "홍길동",
  "password": "1234"
}
```

### Response

- Status : `201 Created`

```json
{
  "id": 1,
  "title": "Spring 공부",
  "content": "JPA 학습",
  "username": "홍길동",
  "createdAt": "2026-07-01T10:00:00",
  "modifiedAt": "2026-07-01T10:00:00"
}
```

---

# 2. 일정 단건 조회

### Request

- Method : `GET`
- URL : `/agendas/{agendaId}`

### Response

- Status : `200 OK`

```json
{
  "id": 1,
  "title": "Spring 공부",
  "content": "JPA 학습",
  "username": "홍길동",
  "createdAt": "2026-07-01T10:00:00",
  "modifiedAt": "2026-07-01T10:00:00"
}
```

---

# 3. 일정 목록 조회

### Request

- Method : `GET`
- URL : `/agendas`
- Query Parameter


```
GET /agendas?username=홍길동
```

### Response

- Status : `200 OK`

```json
[
  {
    "id": 1,
    "title": "Spring 공부",
    "content": "JPA 학습",
    "username": "홍길동",
    "createdAt": "2026-07-01T10:00:00",
    "modifiedAt": "2026-07-01T10:00:00"
  }
]
```

---

# 4. 일정 수정

### Request

- Method : `PUT`
- URL : `/agendas/{agendaId}`

#### Request Body

```json
{
  "title": "Spring Boot 공부",
  "username": "김철수",
  "password": "1234"
}
```

### Response

- Status : `200 OK`

```json
{
  "id": 1,
  "title": "Spring Boot 공부",
  "content": "JPA 학습",
  "username": "김철수"
}
```

---

# 5. 일정 삭제

### Request

- Method : `DELETE`
- URL : `/agendas/{agendaId}`

#### Request Body

```json
{
  "password": "1234"
}
```

### Response

- Status : `204 No Content`

```

---
```


# 프로젝트 구조

```
src
├── controller
│   └── AgendaController
├── service
│   └── AgendaService
├── repository
│   └── AgendaRepository
├── entity
│   ├── Agenda
│   └── BaseEntity
└── dto
    ├── CreateAgendaRequest
    ├── CreateAgendaResponse
    ├── GetOneAgendaResponse
    ├── UpdateAgendaRequest
    ├── UpdateAgendaResponse
    └── DeleteAgendaRequest
```

# 기능 목록

- 일정 생성
- 선택한 일정 조회
- 작성자명 기준 일정 조회
- 일정 수정
    - 일정 제목 수정
    - 작성자명 수정
    - 비밀번호 검증
- 일정 삭제
    - 비밀번호 검증
- 작성일(createdAt) 자동 저장
- 수정일(modifiedAt) 자동 갱신
