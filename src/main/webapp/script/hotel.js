/**
 * 
 */
function hotelCheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 입력해 주세요");
		return false;
	}
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력해 주세요");
		return false;
	}
	return true;
}
function idok(){
		//opener는 회원가입창이 부모
	opener.frm.id.value=document.frm.id.value;
	opener.frm.reid.value=document.frm.id.value;
	self.close();
}