let changeimg = document.getElementById("changeImg");
let myImg = document.getElementById("myImg");

function changeImage(){
    let index = changeimg.selectedIndex;
    myImg.src = changeimg.options[index].value;
}

changeImage();
changeimg.onchange = changeImage;