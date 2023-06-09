let name = 'username'

const value = `; ${document.cookie}`;
const parts = value.split(`; ${name}=`);
if (parts.length === 2){

    let us =  parts.pop().split(';').shift();
    console.log(us);
    document.getElementById("us").innerText = us;

}