const salaCardContainer = document.getElementById('salaCardContainer');


async function getSalas(){
    
    let sala = window.localStorage.getItem('sala');
    let response = await fetch('http://127.0.0.1:8080/salasIcesi/salones/'+sala,{
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


getSalones();