const para = document.getElementById("para");
function myDiv(clicked_id){
    console.log('Hello from: '+ clicked_id);
    para.innerHTML = clicked_id;
}
