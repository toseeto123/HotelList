/**
 * 
 */
// ID & password 찾기 전용 script
 function searchID(){
	 if(frm.name.value.length==0){
		alert("이름을 입력하세요");
		return false;
	}
	if(frm.email.value.length==0){
		alert("이메일을 입력하세요");
		return false;
	}
	//이름과 이메일이 같지않을때
	var _name=document.getElementsByName("name").value;
	var _email=document.getElementsByName("name").getAttribute("email");
	//입력아이디와 데이터에있는 아이디가 다른경우
	if(frm.name.value.length!=_name){
		alert("해당하는 이름이 없습니다.")
		return false;
	}else{
		alert(_name);
	}
	if(frm.email.value.length != _email){
		alert("해당하는 이메일이 없습니다.")
		return false;
	}else{
		alert(_email);
	}
	
}

 function passCheck() {
	if (frm.id2.value.length == 0) {
		alert("아이디를 입력해 주세요.")
		return false;
	}
	if (frm.name2.value.length == 0) {
		alert("이름을 입력해 주세요.")
		return false;
	}
	if (frm.email2.value.length ==0) {
		alert("이메일을 입력해 주세요")
		return false;
	}
	return true;
}