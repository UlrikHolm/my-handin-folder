var buttons = document.getElementById('buttons');
var calculate = document.getElementById('calculate');
var tempPara = [];
for(var i = 0; i < buttons.children.length; i++) {
  buttons.children[i].onclick = function() {
      const para = document.getElementById('para');
      tempPara.push(this.textContent);
      para.innerHTML = tempPara.join("");
  }
}
calculate.onclick = function(){
var c = eval(tempPara.join(""));
para.innerHTML = tempPara.join("") + '=' + c;
tempPara = [c];
}