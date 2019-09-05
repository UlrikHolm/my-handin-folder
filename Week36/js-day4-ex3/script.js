var cars = [
    { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
    { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
    { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
    { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
    { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
  ];

  const table= document.getElementById("table"); 

  function mapper(array){

  const c = array.map(el=>'<tr><td>'+el.id+'</td>\n\
  <td>'+el.year+'</td>\n\
  <td>'+el.make+'</td>\n\
  <td>'+el.model+'</td>\n\
  <td>'+el.price+'</td></tr>');
  return c;
  }

 function insertRows(el){
  for (i = 0; i < el.length; i++) { 
    tableRow = table.insertRow();
    tableRow.innerHTML = mapper(el)[i];
  }
}

function deleteRows(){
    for (var i = table.rows.length - 1; i > 0; i--) {
        table.deleteRow(i);
    }
}

insertRows(cars);

btn1.onclick = function(){
    const inputValue = input1.value;  

    const filteredcars = cars.filter(function(el){return el.price < inputValue});
    console.log(filteredcars);
    const mappedfc = mapper(filteredcars);
    deleteRows();

    tableRow.innerHTML = "<th>Id</th>";

    insertRows(filteredcars);

    }
    
