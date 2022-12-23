/**
 * 
 */

 function searchId() {
	 if(frm.name.value.length==0){
		 alert("이름을 입력해 주세요")
		 return false;
	 }
	 if(frm.email.value.length==0){
		 alert("이메일을 입력해 주세요")
		 return false;
	 }
     return true;
}
 
 function passCheck() {
	 if(frm.name.value.length==0){
		 alert("이름을 입력해 주세요")
		 return false;
	 }
	 if(frm.email.value.length==0){
		 alert("이름을 입력해 주세요")
		 return false;
	 }
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