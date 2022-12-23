
let room2 = document.getElementById("room2");
let myImg = document.getElementById("myImg");

function changeImage(){
    let index = room2.selectedIndex;
    myImg.src = room2.options[index].value;
}

changeImage();
room2.onchange = changeImage;


// 객실 타입 선택시 자동으로 호실번호 선택되는 함수
/* 
function categoryChange(e) {
	var aa = ["201호", "202호", "301호", "302호","401호", "402호", "501호", "502호", "601호", "602호"];
	var bb = ["203호", "204호", "303호", "304호","403호", "404호", "503호", "504호", "603호", "604호"];
	var cc = ["205호", "305호", "405호", "505호", "605호"];
	var target = document.getElementById("room_num2");

	if(e.value == "./images/standard.jpg") var d = aa;
	else if(e.value == "./images/deluxe.jpg") var d = bb;
	else if(e.value == "./images/suite.jpg") var d = cc;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}	
}
*/

function categoryChange(e) {
	var aa = ["200000"];
	var bb = ["250000"];
	var cc = ["300000"];
	
	var target = document.getElementById("payment2");

	if(e.value == "./images/standard.jpg") var d = aa;
	else if(e.value == "./images/deluxe.jpg") var d = bb;
	else if(e.value == "./images/suite.jpg") var d = cc;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}	
}



/*
$('select[name=room]').change(function(){
  var $this = $(this).val();
  $(this).closest('.form-row').find('select[name=' + $this +']').siblings().hide(); // 보여야 할 select박스를 제외한 select를 가림
  $(this).closest('.form-row').find('select[name=' + $this +']').show();
});
*/


