function DataObject(type, age, color) {
    this.pet_id = "pets_pet_id_seq.nextval",
    this.pet_type = type, 
    this.pet_age = age,
    this.pet_color = color
};

const petColors = ['orange', 'blue', 'Green', 'grey', 'black', 'brown', 'gold', 'brindle'];
const petType = ['Dog','Cat','horse','Lizard','Pony','Whale','Bird','Zebra','Fish','Dinosaur','Hamster'];

let max = 15;
let min = 1;
let n = 15;
const DataArray = [];

for(let i = 0; i < n; i++){
    DataArray[i] = new DataObject;
    DataArray[i].pet_type = petType[Math.floor(Math.random() * petType.length)];
    DataArray[i].pet_color = petColors[Math.floor(Math.random() * petColors.length)];
    DataArray[i].pet_age =  Math.floor(Math.random() * (max - min) + min);
    DataArray.push(DataArray[i]);
}

console.log(DataArray.length);
for(i=0;i<2;i++){
console.log("insert into pets values(pets_pet_id_seq.nextval,'" + DataArray[i].pet_type 
            + "'," + DataArray[i].pet_age + ",'" + DataArray[i].pet_color + "');")};

