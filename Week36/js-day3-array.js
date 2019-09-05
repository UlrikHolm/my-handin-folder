var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];

var all = boys.concat(girls);

console.log(all.join());
console.log(all.join("-"));

all.push("Lone", "Gitte");
all.unshift("Hans","Kurt");

console.log(all);

all.shift();
all.pop();
console.log(all);

all.splice(3,2);
console.log(all);
all.reverse();
console.log(all);
