const item1 = document.getElementById('item1');
const item2 = document.getElementById('item2');
const item3 = document.getElementById('item3');
const imagenSalon = document.getElementById('imagenSalon') ;
const roomDetail = document.getElementById('roomDetail');



if(window.localStorage.getItem('user') === null){

    window.location.href = "/signin.html" ;

}else{

    var user = JSON.parse(window.localStorage.getItem('user')) ;

}

console.log(user); 

async function getInformation(){
    let sala = window.localStorage.getItem('sala');
    
    let response = await fetch('http://127.0.0.1:8080/salasIcesi/informacion/'+sala,{
        method: 'GET',headers: {
            'Authorization': '123'
        }
    });
    if(response.status ===200){

        let json = await response.json();
        console.log(json);
        var card = new RoomCard(json);
        console.log(card.render());
        roomDetail.appendChild(card.render());    


    } else{
        alert(await response.text())
    }
   
}

getInformation();

