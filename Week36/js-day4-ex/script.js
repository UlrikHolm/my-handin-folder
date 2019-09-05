const divs = document.getElementsByTagName('div');
console.log(divs);

for (var i = 0; i < divs.length; i++){
    divs[i].style.backgroundColor = "blue";
}

btn1.onclick = function(){
    document.getElementById('div1').style.backgroundColor = 'red';
    document.getElementById('div2').style.backgroundColor = 'green';
    document.getElementById('div3').style.backgroundColor = 'purple';
}
