const msg = "msg 1"; // const : can't change value, have to be initialized
let msg2; // variable : can change value
msg2 = "msg 2";
alert(msg2);
msg2 = "msg 2 change";
alert(msg2)

// variable name must be unique
let var1 = "string", var2 = 25; 
let var3 = "string 3";

var msg3 = "msg 3" //old variable format

/*
variable name format
- char, number, $, _
- first character can't be number
- Upper and Lower char are different  
*/
let $;
let _;

// HW 1
let admin;
let name;
name = "John";
admin = name;
alert(admin);

// HW 2
const PLANET = "Earth";
let currentUserName;