const bcrypt=require('bcrypt');

async function myFunction(){
    let password='Red1223';
    console.log(password);
    let hashedpassword=await bcrypt.hash(password,8);
    console.log(hashedpassword);
    let flag=await bcrypt.compare(password,hashedpassword);
    console.log(flag);
}
myFunction();