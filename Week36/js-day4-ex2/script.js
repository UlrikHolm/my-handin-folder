const persons = ["Henrik","Helge","Hans","Holger"];
const list = document.getElementById('list');
const input1 = document.getElementById('input1');
const p = persons.map(el=>'<li>'+ el + '</li>');
list.innerHTML = '<ul>' + p.join(""); + '</ul>'
btn1.onclick = function(){
const inputValue = input1.value;    
    //console.log(inputValue);
    persons.push(inputValue);
    const pUpdated = persons.map(el=>'<li>'+ el + '</li>');
    //console.log(persons);
list.innerHTML = '<ul>' + pUpdated.join(""); + '</ul>'

}
btn2.onclick = function(){ 
        persons.shift()
        const pUpdated = persons.map(el=>'<li>'+ el + '</li>');
        //console.log(persons);
    list.innerHTML = '<ul>' + pUpdated.join(""); + '</ul>'
}

btn3.onclick = function(){ 
    persons.pop()
    const pUpdated = persons.map(el=>'<li>'+ el + '</li>');
    //console.log(persons);
list.innerHTML = '<ul>' + pUpdated.join(""); + '</ul>'
}