var salaCardContainer = document.getElementById('salaCardContainer');
var salones = document.getElementById('salones') ;



if(window.localStorage.getItem('user') === null){

    window.location.href = "/Registro.html" ;

}else{

    var user = JSON.parse(window.localStorage.getItem('user')) ;

}

console.log(user); 



async function getSalas(){
    
    let sala = window.localStorage.getItem('sala');
    let response = await fetch('http://127.0.0.1:8080/Salasicesi/salones/E',{
        method: 'GET',
        headers: {
            'Authorization': '123'
        }
    });
    if(response.status ===200){

        /*let json = await response.json();
        console.log(json);
        var card = new RoomCard(json);
        console.log(card.render());
        roomDetail.appendChild(card.render());    */

        let json = await response.json();    
        json.forEach(salon => {
            var card = new SalaCard( salon );
            salaCardContainer.appendChild(card.render());    
        });


    } else{
        alert(await response.text())
    }
   
}

getSalas();
