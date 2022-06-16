# back-project

<table>
    <tr>
        <th colspan=5>💻🙎‍♂스터디원</th>
    </tr>
    <tr>
        <td><a href='https://github.com/qoqomi'>유승연</a></td>
        <td><a href='https://github.com/Lee-Kyung-Dong'>이경동</a></td>
        <td><a href='https://github.com/lky8967'>이정우</a></td>
        <td><a href='https://github.com/ParkSungGyu1'>박성규</a></td>
        <td><a href='https://github.com/puppyGugu'>이병수</a></td>
</table>

<br>


# W1_mountain_review

## 항해99 첫 미니프로젝트 (참가자 : 유승연, 이병수, 이경동, 박성규, 이정우)


## 프로젝트 정보

 - 혼자 코딩을 연습하며 til를 일기처럼 자유롭게 적는 서비스를 제공하는 웹 사이트입니다

 - 개발기간 : 22.6.10-6.16
---
## Stack

 - frontend : HTML, CSS, javascript

 - backend : Java , spring

 - db : mySql

 - react.js 
---
## 결과물
[https://youtu.be/VQh_d5hFMBw](https://youtu.be/VQh_d5hFMBw)
---
## 상세기능
### 메인페이지
1. 메인
 - 게시글 전체 조회
<!--  - modal 기능 
 - 사진 클릭 시 상세페이지
 - 검색기능 가능
<!--  - [전체목록 보기] button click 시 이벤트 발생  -->
2. modal 
 - 등록하기 button click시 이벤트 발생
 - 사진 클릭 시 상세페이지에 작성했던 정보 모달로 call -->

### 로그인,회원가입

 - 메인 페이지에서 로그인 페이지로 rendering 
 - JWT Token 이용 
<!--  - 회원가입 button 클릭 시 회원가입 button으로 toggle 
 - Bulma 사용 -->

### 등록페이지
1. 등록 종류
 - Url 등록, 제목, 내용 
<!--  - 사진 업로드 시 파일명 명시 -->
<!--  - 개선점 : 어떤 사진을 올렸는지 확인하기 위해 파일명을 명시하였지만 사진파일을 미리보기를 추가하여 사용자의 실수를 줄일 수 있을거 같다. -->
<!-- 2. 예외처리
 - 사진 또는 산이름을 미작성시 경고알람
 - 개선점 : 산이름, 코스 이름, 지역명, 소감을 작성시 욕설 또는 은어가 들어가는 경우를 예외처리 (자연어처리기능)  -->

### 게시물

 - 등록페이지로부터 받은 데이터를 메인페이지에 게시물로 나타냄
 - 게시물의 경우 사진만 보여지며 마우스가 사진으로 이동시 이벤트가 발생하여 산이름, 작성자, 편의시설이 보여짐
 - 사진 클릭시 사진, 산이름, 위치, 편의시설, 소감의 데이터가 모두 보여짐 (modal 기능 구현)
---
 
## API 구성

### 웹페이지의 메인페이지

*> - 메인페이지인 index.html 파일과 등록된 게시글의 정보를 mongoDB에서 가져와 rendering 해준다.*

```python
@app.route('/')
def home():
    return render_template('index.html', msg=msg) 
```   

*> - 로그인 후 보여지는 페이지로 로그인한 상태와 안한 상태를 구분하여 로그인한 상태일 경우 사용자 ID를 Client로 전달한다.*   
*> - DB에 저장되어있는 게시글의 데이터 리스트를 불러와 전달한다.* <br>
*> - 검색창에 단어를 검색할 경우, 검색어와 검색 상태를 함수 파라미터로 받아와 전달한다.* <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;검색기능을 실행하지 않았을 경우 임의로 status에는 'no', keyword에는 ''빈 값을 전달한다.

```python
@app.route('/login/home')
def home_():
    token_receive = request.cookies.get('mytoken')
    payload = jwt.decode(token_receive, SECRET_KEY, algorithms=['HS256'])
    user_id = payload["id"]
    posts = list(db.mountain_info.find({}, {'_id': False}))
    status = request.args.get("searched")
    keyword = request.args.get("keyword")
    
    if status is not None:
        return render_template('index.html', posts=posts, status=status, keyword=keyword, user_id=user_id)
    else:
        return render_template('index.html', posts=posts, status='no', keyword='', user_id=user_id)

```


### 로그인 api
<!-- 
*> 로그인페이지 rendering*

```python
@app.route('/login')
def home_login():
    return render_template('register.html', msg=msg)
``` -->

<!-- *> 로그인페이지 로그인 쿠키가 만료/ 존재하지 않을때 처리*

```python
@app.route('/login/login')
def login():
    
    return render_template('register.html')
    except jwt.ExpiredSignatureError:
        return redirect(url_for("login", msg="로그인 시간이 만료되었습니다."))
    except jwt.exceptions.DecodeError:
        return redirect(url_for("login", msg="로그인 정보가 존재하지 않습니다."))
``` -->

<!-- *> 로그인시 pw를 해쉬함수를 사용하여 DB에 저장*

```python
@app.route('/sign_in', methods=['POST'])
def sign_in():
    
         return jsonify({'result': 'success', 'token': token})
    # 찾지 못하면
    else:
        return jsonify({'result': 'fail', 'msg': '아이디/비밀번호가 일치하지 않습니다.'})
``` -->

*> 회원가입시 ID pw 확인*

```
    public Boolean login(LoginRequestDto loginRequestDto){
        Member member = memberRepository.findByUsername(loginRequestDto.getUsername())
                .orElse(null);
        if (member != null) {
            if (!passwordEncoder.matches(loginRequestDto.getPassword(), member.getPassword())) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
```

*> 로그인시 아이디 확인*

```python
@app.route('/sign_in', methods=['POST'])
def sign_in():
    
         return jsonify({'result': 'success', 'token': token})
    # 찾지 못하면
    else:
        return jsonify({'result': 'fail', 'msg': '아이디/비밀번호가 일치하지 않습니다.'})
```

*> 회원가입시 ID 중복확인*

```
// 회원 ID 중복 확인
        Optional<Member> found = memberRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
        }
```


*> 회원가입시 ID 비밀번호 확인 *

```
// 회원 ID 중복 확인
        if(!password.equals(passwordCk)){
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 같지않습니다 확인해주세요");
        }
```



### 등록 페이지

*> 등록페이지 rendering*

```python
@app.route('/register')
def register_page():
    return render_template("write.html")
```

*> 등록페이지에 들어오는 상세데이터 DB에 저장*

```python
@app.route('/register/save', methods=['POST'])
def register():
    
        return jsonify({"result": "success", 'msg': '포스팅 성공'})
    except (jwt.ExpiredSignatureError, jwt.exceptions.DecodeError):
        return redirect(url_for("/"))
```









## 진행방식
> 

<br>

## 진행상황


* 로그인 api
    - 로그인: POST/login
         - id
         - password
    - 로그인 뷰: GET/login
    - 로그아웃: POST/logout
* 회원가입 api
    - 회원가입 뷰: GET/register
    - 회원가입: POST/register
         - id
         - password
* 메인페이지 api
    - 메인페이지 뷰: GET/main
        * List
            - image
            - description
            - username(id)
            - like
* 게시글 작성 api
    - 게시글 작성 뷰: GET/main/write
    - 게시글 작성: POST/main/write
        - Title
        - description
        - File
        - username(id)
