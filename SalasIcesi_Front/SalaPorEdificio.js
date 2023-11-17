var salaCardContainer = document.getElementById('salaCardContainer');
var salones = document.getElementById('salones') ;



if(window.localStorage.getItem('user') === null){

    window.location.href = "/Registro.html" ;

}else{

    var user = JSON.parse(window.localStorage.getItem('user')) ;

}

console.log(user); 



async function getSalas(){
    
    let edificio = window.localStorage.getItem('Edificio');
    if(edificio === "Ver Salones Disponibles del E"){
        var edificioId = 'E' ;
    }else if(edificio === "Ver Salones Disponibles del B"){

        var edificioId = 'B' ;

    }
    let response = await fetch('http://127.0.0.1:8080/Salasicesi/salones/'+ edificioId,{
        method: 'GET',
        headers: {
            'Authorization': '123'
        }
    });
    if(response.status ===200){



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
