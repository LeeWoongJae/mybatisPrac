<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signup.jsp)</h3>
<form action="signup.do" name="signForm" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId" required></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName" required></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>
<script>
let check = false;
document.forms.signForm.addEventListener('submit',function(e){
	if(!check){
		e.preventDefault();
		alert("입력값 확인!");
		return;
	}
	this.submit();
});

document.querySelector('input[name="userId"]').addEventListener('change',function(e){
console.log(this);
let user = e.target.value;
console.log("user:"+user);
	// fetch로 넘겨받을 파라메터를 지정하여서 java단 서버에서 값을 처리하고 데이터를 리턴
	fetch('checkId.do?id='+user)
	.then(memberData=>memberData.json())
	.then(result=>{
		console.log(result);
		if(result.retCode=='Exist'){
			alert("존재하는 아이디");
		}else{
			alert("사용가능 아이디");
		}
	})
	.catch(err=>console.log(err));
	// 비밀번호까지 중복여부 해보기
	document.querySelector('input[name="userPw"]').addEventListener('change',function(ev){
		console.log(this);
		let password = ev.target.value;
		console.log("pw:"+password+" id : "+user);
			// fetch로 넘겨받을 파라메터를 지정하여서 java단 서버에서 값을 처리하고 데이터를 리턴
			fetch('checkId.do?id='+user)
			.then(memberData=>memberData.json())
			.then(result=>{
				console.log(result.password);
				if(result.retCode=='Exist'){
					alert("사용불가 password");
				}else{
					alert("사용가능 password");
				}
			})
			.catch(err=>console.log(err))
			
		});
	
});



</script>