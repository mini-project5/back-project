# back-project

로그인 api
 -로그인: POST/login
   -id
   -password
 -로그인 뷰: GET/login
 -로그아웃: POST/logout
회원가입 api
 -회원가입 뷰: GET/register
 -회원가입: POST/register
   -id
   -password
메인페이지 api
 -메인페이지 뷰: GET/main
   List
   -image
   -description
   -username(id)
   -like
게시글 작성 api
 -게시글 작성 뷰: GET/main/write
 -게시글 작성: POST/main/write
  -Title
  -description
  -File
  -username(id)
